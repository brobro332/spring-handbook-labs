package kr.co.spring_boot_project_2.web_scope.processor;

import kr.co.spring_boot_project_2.web_scope.service.LoggedUserManagementService;
import kr.co.spring_boot_project_2.web_scope.service.LoginCounterService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    /*
     * [요청 스코프]
     * 1. @RequestScope 애노테이션 지정하면,
     *    스프링이 HTTP 요청마다 새로운 인스턴스 생성함
     * 2. 요청이 끝나면 해당 인스턴스 소멸됨
     * 3. 주로 요청 단위 상태 관리할 때 사용함
     */

    private final LoggedUserManagementService loggedUserManagementService;
    private final LoginCounterService loginCounterService;

    public LoginProcessor(
        LoggedUserManagementService loggedUserManagementService,
        LoginCounterService loginCounterService
    ) {
        this.loggedUserManagementService = loggedUserManagementService;
        this.loginCounterService = loginCounterService;
    }

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login() {
        loginCounterService.increment();

        String username = this.getUsername();
        String password = this.getPassword();

        if ("brobro332".equals(username) && "1234".equals(password)) {
            loggedUserManagementService.setUsername(username);
            return true;
        } else {
            return false;
        }
    }
}
