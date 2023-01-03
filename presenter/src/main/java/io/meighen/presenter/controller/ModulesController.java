package io.meighen.presenter.controller;

import java.time.LocalDateTime;
import java.util.*;

import io.meighen.presenter.dto.CountPagesDto;
import io.meighen.presenter.entity.User;
import io.meighen.presenter.entity.objects.Module;
import io.meighen.presenter.exception.UserNotFoundExeption;
import io.meighen.presenter.repository.ModuleRepository;
import io.meighen.presenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/modules")
public class ModulesController {
    @Autowired
    UserService userService;

    private User getAuthentificatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userService.findByUsername(currentUserName).orElseThrow(
                () -> {throw new UserNotFoundExeption("");}
        );

        return currentUser;
    }
    @Autowired
    ModuleRepository moduleRepository;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getModulesByPage(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        try {
            List<Module> tutorials = new ArrayList<Module>();
            Pageable paging = PageRequest.of(page, size);

            Page<Module> pageTuts;
            if (name == null)
                pageTuts = moduleRepository.findAll(paging);
            else
                pageTuts = moduleRepository.findAllByNameContaining(name, paging);

            tutorials = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("objects", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byModifier")
    public ResponseEntity<Map<String, Object>> getModulesByLastModifier(
            @RequestParam String fname,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        try {
            List<Module> tutorials = new ArrayList<Module>();
            Pageable paging = PageRequest.of(page, size);

            Page<Module> pageTuts;
            pageTuts = moduleRepository.findAllByLastModifier_FirstName(fname, paging);

            tutorials = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("objects", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byDateCreation")
    public ResponseEntity<Map<String, Object>> getModulesByDateCreation(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        try {
            List<Module> tutorials = new ArrayList<Module>();
            Pageable paging = PageRequest.of(page, size);

            Page<Module> pageTuts;

            if (name == null)
                pageTuts = moduleRepository.findAllByOrderByDateCreation(paging);
            else
                pageTuts = moduleRepository.findAllByNameContainingOrderByDateCreation(name, paging);


            tutorials = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("objects", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/byDateModification")
    public ResponseEntity<Map<String, Object>> getModulesByDateModification(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        try {
            List<Module> tutorials = new ArrayList<Module>();
            Pageable paging = PageRequest.of(page, size);

            Page<Module> pageTuts;

            if (name == null)
                pageTuts = moduleRepository.findAllByOrderByDateModification(paging);
            else
                pageTuts = moduleRepository.findAllByNameContainingOrderByDateModification(name, paging);


            tutorials = pageTuts.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("objects", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/count_pages")
    public ResponseEntity<?> getPagesCount(@RequestParam Integer onOnePage) {
        if (onOnePage == 0) { throw new ArithmeticException(); }

        return ResponseEntity.ok(new CountPagesDto(moduleRepository.count()/onOnePage));
    }

    @GetMapping("/info")
    public ResponseEntity<?> getModuleInfo(@RequestParam String uuid) {
        return ResponseEntity.ok(moduleRepository.findByUuid(uuid));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNewModule(
            @RequestParam String name,
            @RequestParam(required = false) boolean internal
    ) {
        Module module = new Module();
        module.setName(name);
        module.setUuid(String.valueOf(UUID.randomUUID()));

        LocalDateTime localDateTime = LocalDateTime.now();
        module.setDateCreation(localDateTime);
        module.setDateModification(localDateTime);
        module.setLastModifier(getAuthentificatedUser());
        module.setIinternal(true);
        moduleRepository.save(module);

        return ResponseEntity.ok(module);
    }
}
