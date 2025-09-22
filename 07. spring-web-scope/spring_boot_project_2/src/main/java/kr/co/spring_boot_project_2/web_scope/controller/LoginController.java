package kr.co.spring_boot_project_2.web_scope.controller;

import kr.co.spring_boot_project_2.web_scope.processor.LoginProcessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
        @RequestParam String username,
        @RequestParam String password,
        Model model
    ) {
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);

        boolean isLoginSuccess = loginProcessor.login();
        if (isLoginSuccess) return "redirect:/main";

        model.addAttribute("message", "login failed");

        return "login.html";
    }
}
