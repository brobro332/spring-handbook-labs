package kr.co.spring_boot_project_2.web_scope.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class LoggedUserManagementService {
    /*
     * [세션 스코프]
     * 1. HTTP 세션 단위로 빈이 생성되고 관리됨
     * 2. 세션 만료나 종료 시 빈도 같이 소멸됨
     * 3. 사용자별 상태 저장할 때 유용함
     * 4. 세션 내 여러 요청이 동시에 처리될 수 있어서 상태 변경 시 동기화 필요할 수도 있음
     * 5. 세션 없는 환경에선 사용 불가하거나 오류 날 수 있음
     */
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
