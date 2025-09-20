package config;

import bean.entity.Parrot;
import bean.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    /*
    * [와이어링]
    * 1. 두 인스턴스 간 관계를 설정하는 것
    * 2. 구성 클래스의 한 메서드에서 다른 메서드를 호출하는 것을 의미
    * 3. 이 방법은 직관적이므로 자주 사용됨
    *
    * [구성 클래스 의존성 주입]
    * 1. 구성 클래스 안에서 @Bean 애노테이션이 정의되어 있을 경우,
    *    파라미터에 해당하는 인스턴스가 빈으로 등록되어 있다면 스프링 컨텍스트가 자동으로 주입함
    * 2. @Configuration이 없으면 일반 메서드 호출로 인식되어 DI가 적용되지 않음
    */
    @Bean
    public Parrot parrot() {
        return new Parrot("koko");
    }

    @Bean
    public Person person(Parrot parrot) {
        Person p = new Person("brobro332");
        p.setParrot(parrot);

        return p;
    }

    /* 와이어링
        @Bean
        public Person person() {
            Person p = new Person("brobro332");
            p.setParrot(parrot());

            return p;
        }
    */
}
