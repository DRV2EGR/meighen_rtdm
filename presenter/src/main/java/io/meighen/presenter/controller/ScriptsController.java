package io.meighen.presenter.controller;

import java.time.LocalDateTime;
import java.util.*;

import io.meighen.presenter.entity.Backup;
import io.meighen.presenter.entity.Module;
import io.meighen.presenter.entity.Object;
import io.meighen.presenter.entity.Script;
import io.meighen.presenter.entity.dto.ModuleDto;
import io.meighen.presenter.entity.dto.ScriptDto;
import io.meighen.presenter.mapper.ObjectMapper;
import io.meighen.presenter.repository.BackupRepository;
import io.meighen.presenter.repository.ObjectRepository;
import io.meighen.presenter.repository.ScriptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/scripts")
public class ScriptsController extends BasicPrivateController {
    @Autowired
    ScriptRepository scriptRepository;
    @Autowired
    private ObjectRepository objectRepository;
    @Autowired
    private ObjectMapper mapper;
    @Autowired
    BackupRepository backupRepository;

    @GetMapping("/")
    public ResponseEntity<Map<String, java.lang.Object>> getScriptsByPage(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "true") boolean direction
    ) {
        try {
            List<Script> tutorials = new ArrayList<Script>();
            Pageable paging = PageRequest.of(page, size);

            Page<Script> pageTuts;
            if (name == null)
                pageTuts = scriptRepository.findAll(paging);
            else
                pageTuts = scriptRepository.findAllByNameContaining(name, paging);

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
    public ResponseEntity<Map<String, java.lang.Object>> getScriptsByLastModifier(
            @RequestParam (required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "true") boolean direction
    ) {
        try {
            List<Script> tutorials = new ArrayList<Script>();
            Pageable paging = PageRequest.of(page, size);

            Page<Script> pageTuts;
            if (name == null)
                pageTuts = scriptRepository.findAllOrderByLastModifier_FirstNameAsc(paging);
            else
                pageTuts = scriptRepository.findAllByNameContainingOrderByLastModifier_FirstNameAsc(name, paging);

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
    public ResponseEntity<Map<String, java.lang.Object>> getScriptsByDateCreation(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "true") boolean direction
    ) {
        try {
            List<Script> tutorials = new ArrayList<Script>();
            Pageable paging = PageRequest.of(page, size);

            Page<Script> pageTuts;

            if (name == null)
                pageTuts = scriptRepository.findAllByOrderByDateCreationAsc(paging);
            else
                pageTuts = scriptRepository.findAllByNameContainingOrderByDateCreationAsc(name, paging);


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
    public ResponseEntity<Map<String, java.lang.Object>> getScriptsByDateModification(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "true") boolean direction
    ) {
        try {
            List<Script> tutorials = new ArrayList<Script>();
            Pageable paging = PageRequest.of(page, size);

            Page<Script> pageTuts;

            if (name == null)
                pageTuts = scriptRepository.findAllByOrderByDateModificationAsc(paging);
            else
                pageTuts = scriptRepository.findAllByNameContainingOrderByDateModificationAsc(name, paging);


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

    @GetMapping("/script")
    public ResponseEntity<?> getScriptInfo(@RequestParam String uuid) {
        return ResponseEntity.ok(scriptRepository.findByUuid(uuid));
    }

    @PostMapping("/script")
    public ResponseEntity<?> createNewScript(
            @RequestParam String name,
            @RequestParam(required = false) boolean internal
    ) {
        Script script = new Script();
        script.setName(name);
        script.setUuid(String.valueOf(UUID.randomUUID()));

        LocalDateTime localDateTime = LocalDateTime.now();
        script.setDateCreation(localDateTime);
        script.setDateModification(localDateTime);
        script.setLastModifier(getAuthentificatedUser());
        scriptRepository.save(script);

        Object object = new Object();
        object.setObjId(script.getId());
        object.setType("SCRIPT");
        object.setAllowedUsers(List.of(getAuthentificatedUser()));
        object.setObjUUID(script.getUuid());
        objectRepository.save(object);

        return ResponseEntity.ok(script);
    }

    @PutMapping("/script")
    public ResponseEntity<?> updateScript(
            @RequestParam String uuid,
            @RequestBody ScriptDto scriptDto
    ) {
        Script script = scriptRepository.findByUuid(uuid);
        scriptDto.setDateModification(LocalDateTime.now());
        mapper.updateScriptFromDto(scriptDto, script);
        scriptRepository.save(script);

        return ResponseEntity.ok("OK");
    }

    @DeleteMapping("/script")
    public ResponseEntity<?> deleteScript(
            @RequestParam String uuid
    ) {
        Script script = scriptRepository.findByUuid(uuid);

        Backup backup = new Backup();
        backup.setUuid(script.getUuid());

        LocalDateTime localDateTime = LocalDateTime.now();
        backup.setDateCreation(localDateTime);
        backup.setDateModification(localDateTime);
        backup.setLastModifier(getAuthentificatedUser());
        backup.setType("MODULE");
        backup.setBody(script.toString());

        backupRepository.save(backup);
        scriptRepository.delete(script);

        return ResponseEntity.ok("OK");
    }
}
