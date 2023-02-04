package com.meighen.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restfull {
    @GetMapping("/")
    public String mainResp() {
        return "Hello world!";
    }
}
