package bean;

import bean.entity.Parrot;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    /*
    * [빈 등록 시나리오]
    * 1. 코드 라인 수를 고려하여 가능한 스테레오 타입 애노테이션을 사용하기
    * 2. 다른 방법으로 빈을 추가할 수 없을 때만 @Bean을 사용하기
    * 3. 빈을 등록한 클래스에 @PostConstructor 애노테이션을 지정하면
    *    빈을 생성한 후 스프링이 실행하는 일련의 명령을 지정할 수 있다.
    */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Parrot p = context.getBean(Parrot.class);

        System.out.println(p); // Parrot{name='koko'}
    }
}
