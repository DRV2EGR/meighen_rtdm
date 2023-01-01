package io.meighen.guarder.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
public class PrivateUserController {
    @GetMapping("/check_auth")
    public ResponseEntity<?> doCheckAuth() {
        
    }
}
