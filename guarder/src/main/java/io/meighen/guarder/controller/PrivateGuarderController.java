package io.meighen.guarder.controller;

import io.meighen.guarder.dto.CheckAuthDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
public class PrivateGuarderController {
    @GetMapping("check_auth")
    private ResponseEntity<?> checkForValidAuth() {
        return ResponseEntity.ok(new CheckAuthDto("OK"));
    }
}
