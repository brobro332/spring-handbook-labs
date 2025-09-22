package kr.co.spring_boot_project_2.web_scope.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCounterService {
    /*
     * [애플리케이션 스코프]
     * 1. 애플리케이션 컨텍스트가 살아있는 동안 빈 인스턴스가 유지됨
     * 1-1. 즉, 웹 애플리케이션이 구동되고 있는 동안 해당 빈은 하나만 생성되어
     *      모든 사용자와 모든 세션에서 공유됨
     * 2. 여러 사용자가 동시에 접근할 수 있기 때문에,
     *    멀티스레드 환경에서 상태를 변경하는 필드는 동기화에 주의해야 함
     * 3. 기본적으로 @Service는 싱글톤 스코프이기 때문에 큰 차이는 없지만,
     *    @ApplicationScope는 웹 애플리케이션 컨텍스트에 명확히 종속되어 있음
     * 4. 주로 방문자 수, 전역 설정값, 캐시 등 애플리케이션 전역에서 공유해야 하는 상태를 저장할 때 사용함
     */
    private int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
