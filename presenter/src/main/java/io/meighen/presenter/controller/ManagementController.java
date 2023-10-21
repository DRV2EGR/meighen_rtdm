package io.meighen.presenter.controller;

import java.util.*;
import java.util.stream.Collectors;

import io.meighen.presenter.entity.Module;
import io.meighen.presenter.entity.ModuleInfo;
import io.meighen.presenter.entity.dto.ModuleDto;
import io.meighen.presenter.mapper.ObjectMapper;
import io.meighen.presenter.repository.ModuleInfoReposirory;
import io.meighen.presenter.repository.ModuleRepository;
import io.meighen.presenter.service.ProducerService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/management")
public class ManagementController {
    @Autowired
    ModuleRepository moduleRepository;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ProducerService producerService;

    @Autowired
    private ModuleInfoReposirory moduleInfoReposirory;

    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> getModulesByPage(
            @RequestParam(required = false) String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(required = false, defaultValue = "true") boolean direction
    ) {
        try {
            List<ModuleDto> tutorials = new ArrayList<ModuleDto>();
            Pageable paging = PageRequest.of(page, size);

            Page<Module> pageTuts;
            if (name == null)
                pageTuts = moduleRepository.findAll(paging);
            else
                pageTuts = moduleRepository.findAllByNameContaining(name, paging);

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

    @GetMapping("/deploy")
    public ResponseEntity<?> deployModule(@RequestParam String moduleUUID) {
        Module module = moduleRepository.findByUuid(moduleUUID);

        if (!module.getModuleInfo().getStatus().equals("builded")) {
            JSONObject jo = new JSONObject();
            jo.put("response", "Для развертывания сервиса необходимо выполнить предыдущие действия!");
            return ResponseEntity.status(499).body(jo);
        }

        producerService.deployService(module.getUuid());
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/build")
    public ResponseEntity<?> buildModule(@RequestParam String moduleUUID) {
        Module module = moduleRepository.findByUuid(moduleUUID);

        if (!module.getModuleInfo().getStatus().equals("validated") || module.getModuleInfo().getState() < 1) {
            JSONObject jo = new JSONObject();
            jo.put("response", "Для сборки сервиса необходимо выполнить предыдущие действия!");
            return ResponseEntity.status(499).body(jo);
        }

        producerService.buildService(module.getUuid());
        return ResponseEntity.ok("{\"response\":\"Сборка запущена!\"}");
    }

    @GetMapping("/undeploy")
    public ResponseEntity<?> undeployModule(@RequestParam String moduleUUID) {
        Module module = moduleRepository.findByUuid(moduleUUID);

        if (!module.getModuleInfo().getStatus().equals("deployed")) {
            JSONObject jo = new JSONObject();
            jo.put("response", "Невозможно изъять неразвернутый сервис!");
            return ResponseEntity.status(499).body("{\"response\":\"Невозможно изъять неразвернутый сервис!\"}");
        }

        producerService.unDeployService(module.getUuid());
        return ResponseEntity.ok("{\"response\":\"Развертывание запущено!\"}");
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateModule(@RequestParam String moduleUUID) throws InterruptedException {
        Module module = moduleRepository.findByUuid(moduleUUID);

        Thread.sleep(3000);

        ModuleInfo moduleInfo = module.getModuleInfo();
        moduleInfo.setState(1);
        if (moduleInfo.getStatus().equals("created"))
            moduleInfo.setStatus("validated");
        moduleInfoReposirory.save(moduleInfo);

        return ResponseEntity.ok("OK");
    }

    @GetMapping("/status")
    public ResponseEntity<?> getModuleStatus(@RequestParam String moduleUUID) {
        Module module = moduleRepository.findByUuid(moduleUUID);

        return ResponseEntity.ok(module.getModuleInfo());
    }
}
