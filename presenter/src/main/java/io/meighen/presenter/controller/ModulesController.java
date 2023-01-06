package io.meighen.presenter.controller;

import java.time.LocalDateTime;
import java.util.*;

import io.meighen.presenter.entity.Backup;
import io.meighen.presenter.entity.dto.CountPagesDto;
import io.meighen.presenter.entity.Module;
import io.meighen.presenter.entity.Object;
import io.meighen.presenter.entity.dto.ModuleDto;
import io.meighen.presenter.mapper.ObjectMapper;
import io.meighen.presenter.repository.BackupRepository;
import io.meighen.presenter.repository.ModuleRepository;
import io.meighen.presenter.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/modules")
public class ModulesController extends BasicPrivateController {
    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    ObjectRepository objectRepository;

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private BackupRepository backupRepository;


    @GetMapping("/")
    public ResponseEntity<Map<String, java.lang.Object>> getModulesByPage(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "true") boolean direction
    ) {
        try {
            List<Module> tutorials = new ArrayList<Module>();
            Pageable paging = PageRequest.of(page, size);

            Page<Module> pageTuts;
            if (name == null)
                pageTuts = moduleRepository.findAll(paging);
            else
                pageTuts = moduleRepository.findAllByNameContaining(name, paging);

            tutorials = pageTuts.getContent();
            if (!direction) { Collections.reverse(Arrays.asList(tutorials)); }

            Map<String, java.lang.Object> response = new HashMap<>();
            response.put("objects", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all/byModifier")
    public ResponseEntity<Map<String, java.lang.Object>> getModulesByLastModifier(
            @RequestParam (required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "true") boolean direction
    ) {
        try {
            List<Module> tutorials = new ArrayList<Module>();
            Pageable paging = PageRequest.of(page, size);

            Page<Module> pageTuts;
            if (name == null)
                pageTuts = moduleRepository.findAllOrderByLastModifier_FirstNameAsc(paging);
            else
                pageTuts = moduleRepository.findAllByNameContainingOrderByLastModifier_FirstNameAsc(name, paging);

            tutorials = pageTuts.getContent();
            if (!direction) { Collections.reverse(Arrays.asList(tutorials)); }

            Map<String, java.lang.Object> response = new HashMap<>();
            response.put("objects", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all/byDateCreation")
    public ResponseEntity<Map<String, java.lang.Object>> getModulesByDateCreation(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "true") boolean direction
    ) {
        try {
            List<Module> tutorials = new ArrayList<Module>();
            Pageable paging = PageRequest.of(page, size);

            Page<Module> pageTuts;

            if (name == null)
                pageTuts = moduleRepository.findAllByOrderByDateCreationAsc(paging);
            else
                pageTuts = moduleRepository.findAllByNameContainingOrderByDateCreationAsc(name, paging);


            tutorials = pageTuts.getContent();
            if (!direction) { Collections.reverse(Arrays.asList(tutorials)); }

            Map<String, java.lang.Object> response = new HashMap<>();
            response.put("objects", tutorials);
            response.put("currentPage", pageTuts.getNumber());
            response.put("totalItems", pageTuts.getTotalElements());
            response.put("totalPages", pageTuts.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all/byDateModification")
    public ResponseEntity<Map<String, java.lang.Object>> getModulesByDateModification(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "true") boolean direction
    ) {
        try {
            List<Module> tutorials = new ArrayList<Module>();
            Pageable paging = PageRequest.of(page, size);

            Page<Module> pageTuts;

            if (name == null)
                pageTuts = moduleRepository.findAllByOrderByDateModificationAsc(paging);
            else
                pageTuts = moduleRepository.findAllByNameContainingOrderByDateModificationAsc(name, paging);


            tutorials = pageTuts.getContent();
            if (!direction) { Collections.reverse(Arrays.asList(tutorials)); }

            Map<String, java.lang.Object> response = new HashMap<>();
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

    @GetMapping("/module")
    public ResponseEntity<?> getModuleInfo(@RequestParam String uuid) {
        return ResponseEntity.ok(moduleRepository.findByUuid(uuid));
    }

    @PostMapping("/module")
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

        Object object = new Object();
        object.setObjId(module.getId());
        object.setType("MODULE");
        object.setAllowedUsers(List.of(getAuthentificatedUser()));
        object.setObjUUID(module.getUuid());
        objectRepository.save(object);

        return ResponseEntity.ok(module);
    }

    @PutMapping("/module")
    public ResponseEntity<?> updateModule(
            @RequestParam String uuid,
            @RequestBody ModuleDto moduleDto
    ) {
        Module module = moduleRepository.findByUuid(uuid);
        moduleDto.setDateModification(LocalDateTime.now());
        mapper.updateModuleFromDto(moduleDto, module);
        moduleRepository.save(module);

        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/module")
    public ResponseEntity<?> deleteModule(
            @RequestParam String uuid
    ) {
        Module module = moduleRepository.findByUuid(uuid);

        Backup backup = new Backup();
        backup.setUuid(module.getUuid());

        LocalDateTime localDateTime = LocalDateTime.now();
        backup.setDateCreation(localDateTime);
        backup.setDateModification(localDateTime);
        backup.setLastModifier(getAuthentificatedUser());
        backup.setType("MODULE");
        backup.setBody(module.toString());

        backupRepository.save(backup);
        moduleRepository.delete(module);

        return ResponseEntity.ok("OK");
    }
}
