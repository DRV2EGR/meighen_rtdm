package io.meighen.presenter.controller;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import io.meighen.presenter.entity.Backup;
import io.meighen.presenter.entity.Variable;
import io.meighen.presenter.entity.dto.CountPagesDto;
import io.meighen.presenter.entity.dto.VariableDto;
import io.meighen.presenter.mapper.ObjectMapper;
import io.meighen.presenter.repository.BackupRepository;
import io.meighen.presenter.repository.VariableRepository;
import io.meighen.presenter.repository.ObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/variables")
public class VariableController extends BasicPrivateController {
    @Autowired
    ObjectRepository objectRepository;

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private BackupRepository backupRepository;
    @Autowired
    private VariableRepository variableRepository;


    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getVariablesByPage(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "true") boolean direction
    ) {
        try {
            List<VariableDto> tutorials = new ArrayList<VariableDto>();
            Pageable paging = PageRequest.of(page, size);

            Page<Variable> pageTuts;
            if (name == null)
                pageTuts = variableRepository.findAll(paging);
            else
                pageTuts = variableRepository.findAllByNameContaining(name, paging);

            tutorials = pageTuts.getContent().stream().map(i -> mapper.modelToDto(i)).collect(Collectors.toList());
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
    public ResponseEntity<Map<String, java.lang.Object>> getVariablesByLastModifier(
            @RequestParam (required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "true") boolean direction
    ) {
        try {
            List<VariableDto> tutorials = new ArrayList<VariableDto>();
            Pageable paging = PageRequest.of(page, size);

            Page<Variable> pageTuts;
            if (name == null)
                pageTuts = variableRepository.findAllOrderByLastModifier_FirstNameAsc(paging);
            else
                pageTuts = variableRepository.findAllByNameContainingOrderByLastModifier_FirstNameAsc(name, paging);

            tutorials = pageTuts.getContent().stream().map(i -> mapper.modelToDto(i)).collect(Collectors.toList());
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
    public ResponseEntity<Map<String, java.lang.Object>> getVariablesByDateCreation(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "true") boolean direction
    ) {
        try {
            List<VariableDto> tutorials = new ArrayList<VariableDto>();
            Pageable paging = PageRequest.of(page, size);

            Page<Variable> pageTuts;

            if (name == null)
                pageTuts = variableRepository.findAllByOrderByDateCreationAsc(paging);
            else
                pageTuts = variableRepository.findAllByNameContainingOrderByDateCreationAsc(name, paging);

            tutorials = pageTuts.getContent().stream().map(i -> mapper.modelToDto(i)).collect(Collectors.toList());
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
    public ResponseEntity<Map<String, java.lang.Object>> getVariablesByDateModification(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "true") boolean direction
    ) {
        try {
            List<VariableDto> tutorials = new ArrayList<VariableDto>();
            Pageable paging = PageRequest.of(page, size);

            Page<Variable> pageTuts;

            if (name == null)
                pageTuts = variableRepository.findAllByOrderByDateModificationAsc(paging);
            else
                pageTuts = variableRepository.findAllByNameContainingOrderByDateModificationAsc(name, paging);

            tutorials = pageTuts.getContent().stream().map(i -> mapper.modelToDto(i)).collect(Collectors.toList());
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

        return ResponseEntity.ok(new CountPagesDto(variableRepository.count()/onOnePage));
    }

    @GetMapping("/variable")
    public ResponseEntity<?> getVariableInfo(@RequestParam String uuid) {
        return ResponseEntity.ok(variableRepository.findByUuid(uuid));
    }

    @PostMapping("/variable")
    public ResponseEntity<?> createNewVariable(
            @RequestParam String name,
            @RequestParam String type
    ) {
        Variable variablle = new Variable();
        variablle.setName(name);
        variablle.setUuid(String.valueOf(UUID.randomUUID()));
        variablle.setType(type);

        LocalDateTime localDateTime = LocalDateTime.now();
        variablle.setDateCreation(localDateTime);
        variablle.setDateModification(localDateTime);
        variablle.setLastModifier(getAuthentificatedUser());
        variableRepository.save(variablle);

        io.meighen.presenter.entity.Object object = new io.meighen.presenter.entity.Object();
        object.setObjId(variablle.getId());
        object.setType("Variable");
        object.setAllowedUsers(List.of(getAuthentificatedUser()));
        object.setObjUUID(variablle.getUuid());
        objectRepository.save(object);

        return ResponseEntity.ok(variablle);
    }

    @PutMapping("/variable")
    public ResponseEntity<?> updateVariable(
            @RequestParam String uuid,
            @RequestBody VariableDto variableDto
    ) {
        Variable variablle = variableRepository.findByUuid(uuid);
        variableDto.setDateModification(LocalDateTime.now());
        mapper.updateVariableFromDto(variableDto, variablle);
        variableRepository.save(variablle);

        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/variable")
    public ResponseEntity<?> deleteVariable(
            @RequestParam String uuid
    ) {
        Variable variablle = variableRepository.findByUuid(uuid);

        Backup backup = new Backup();
        backup.setUuid(variablle.getUuid());

        LocalDateTime localDateTime = LocalDateTime.now();
        backup.setDateCreation(localDateTime);
        backup.setDateModification(localDateTime);
        backup.setLastModifier(getAuthentificatedUser());
        backup.setType("Variable");
        backup.setBody(variablle.toString());

        backupRepository.save(backup);
        variableRepository.delete(variablle);

        return ResponseEntity.ok("OK");
    }
}
