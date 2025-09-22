package kr.co.spring_boot_project_2.web_scope.controller;

import kr.co.spring_boot_project_2.web_scope.service.LoggedUserManagementService;
import kr.co.spring_boot_project_2.web_scope.service.LoginCounterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCounterService loginCounterService;

    public MainController(
            LoggedUserManagementService loggedUserManagementService,
            LoginCounterService loginCounterService
    ) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCounterService = loginCounterService;
    }

    @GetMapping("/main")
    public String home(
        @RequestParam(required = false) String logout,
        Model model
    ) {
        if (logout != null) loggedUserManagementService.setUsername(null);

        String username = loggedUserManagementService.getUsername();
        int count = loginCounterService.getCount();
        if (username == null) return "redirect:/";

        model.addAttribute("username", username);
        model.addAttribute("count", count);

        return "main.html";
    }
}
