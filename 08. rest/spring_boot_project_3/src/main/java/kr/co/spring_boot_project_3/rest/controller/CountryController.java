package kr.co.spring_boot_project_3.rest.controller;

import kr.co.spring_boot_project_3.rest.model.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    /**
     * [@RestController]
     * 1. 해당 클래스가 REST 방식의 컨트롤러임을 의미함
     * 2. 모든 메서드가 자동으로 @ResponseBody가 적용되므로,
     *    반환되는 객체가 JSON 등으로 변환되어 HTTP 응답 본문에 담김
     */
    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        Country country = Country.of("France", 67);
        return ResponseEntity
            .status(HttpStatus.ACCEPTED)
            .header("continent", "Europe")
            .header("capital", "Paris")
            .header("favorite_food", "cheese and wine")
            .body(country);
    }

    @GetMapping("/all")
    public List<Country> countries() {
        Country country1 = Country.of("France", 67);
        Country country2 = Country.of("name", 47);

        return List.of(country1, country2);
    }
}
