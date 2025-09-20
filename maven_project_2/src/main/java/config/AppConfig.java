package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import bean.entity.Parrot;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {
    /*
     * [빈 등록]
     * 1. @Configuration 애노테이션을 통해 스프링 구성 클래스 생성
     * 2. 메서드 이름을 ID로 갖는 빈이 생성되고, 스프링 컨텍스트 하에 관리된다.
     */
    @Bean
    @Primary
    Parrot parrot1() {
        Parrot p = new Parrot();
        p.setName("koko");

        return p;
    }

    @Bean
    Parrot parrot2() {
        Parrot p = new Parrot();
        p.setName("miki");

        return p;
    }

    @Bean
    Parrot parrot3() {
        Parrot p = new Parrot();
        p.setName("riki");

        return p;
    }

    @Bean
    String hello() {
        return "Hello";
    }

    @Bean
    Integer ten() {
        return 10;
    }
}
