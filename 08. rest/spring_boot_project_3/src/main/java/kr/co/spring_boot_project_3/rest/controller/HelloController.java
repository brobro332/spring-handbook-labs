package kr.co.spring_boot_project_3.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello!";
    }

    @GetMapping("/ciao")
    public String ciao() {
        return "ciao!";
    }
}
