package kr.co.spring_boot_project_1.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    /*
     * [컨트롤러]
     * 1. HTTP 요청에 대응하는 컨트롤러 액션을 정의한다.
     * 2. "/home"로 요청이 들어오면 home() 메서드가 실행된다.
     * 3. return 값 "home.html"은 뷰 이름으로 해석된다.
     * 3-1. 뷰 리졸버가 등록되어 있으면 resources/templates/home.html을 찾는다.
     * 3-2. 뷰 리졸버가 없으면, 반환 문자열은 경로로 처리되고,
     *      DispatcherServlet과 정적 리소스 핸들러가 처리하여
     *      resources/static/home.html이 브라우저에 전달될 수 있다.
     * 4. resources/static 폴더에 있는 home.html은 컨트롤러를 거치지 않고
     *    "/home.html" 경로로도 직접 접근 가능하다.
     */
    @RequestMapping("/home")
    public String home() {
        return "home.html";
    }
}
