package kr.co.spring_boot_project_1.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    /*
     * [컨트롤러]
     * 1. HTTP 요청에 대응하는 컨트롤러 액션을 정의함
     * 2. "/home"로 요청이 들어오면 home() 메서드가 실행됨
     * 3. return 값 "home.html"은 뷰 이름으로 해석됨
     * 3-1. 뷰 리졸버가 등록되어 있으면 resources/templates/home.html을 찾음
     * 3-2. 뷰 리졸버가 없으면, 반환 문자열은 경로로 처리되고,
     *      DispatcherServlet과 정적 리소스 핸들러가 처리하여
     *      resources/static/home.html이 브라우저에 전달될 수 있음
     * 4. resources/static 폴더에 있는 home.html은 컨트롤러를 거치지 않고
     *    "/home.html" 경로로도 직접 접근 가능함
     *
     * [모델]
     * 1. 컨트롤러가 뷰에 전송할 데이터를 저장함
     *
     * [요청 매개변수 사용]
     * 1. @RequestMapping 애노테이션을 사용함
     * 2. 파라미터를 포함하지 않는 것을 허용하려면 required 속성을 false 값으로 지정하면 됨
     * 
     * [경로변수 사용]
     * 1. @PathVariable 애노테이션을 사용함
     * 2. 경로를 정의할 때 중괄호 사이에 변수 이름을 지정한다.
     */
    @RequestMapping("/home/v1")
    public String homeV1(Model model) {
        model.addAttribute("username", "brobro332");
        model.addAttribute("color", "blue");

        return "home.html";
    }

    @RequestMapping("/home/v2")
    public String homeV2(@RequestParam(required = false) String color, Model model) {
        model.addAttribute("username", "brobro332");
        model.addAttribute("color", color);

        return "home.html";
    }

    @RequestMapping("/home/v3/{color}")
    public String homeV3(@PathVariable String color, Model model) {
        model.addAttribute("username", "brobro332");
        model.addAttribute("color", color);

        return "home.html";
    }
}
