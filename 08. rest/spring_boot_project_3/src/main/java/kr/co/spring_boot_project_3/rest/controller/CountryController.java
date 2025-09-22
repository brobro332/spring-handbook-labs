package kr.co.spring_boot_project_3.rest.controller;

import kr.co.spring_boot_project_3.rest.model.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @GetMapping("/france")
    public Country france() {
        return Country.of("France", 67);
    }
}
