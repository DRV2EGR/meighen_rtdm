package com.meighen.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restfull {
//    @Autowired
//    Producer producer;

    @GetMapping("/")
    public String mainResp() {
        return "Hello world!";
    }

//    @GetMapping("/test_topics")
//    public String mainResp() {
//        for (int i = 0; i < 10; i++) {
//            producer.callNext(i.toString());
//        }
//        return "ok";
//    }
}
