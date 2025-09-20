package config;

import bean.model.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "bean")
public class AppConfig {
    @Bean
    public Parrot parrot1() {
        return new Parrot("koko");
    }

    @Bean
    public Parrot parrot2() {
        return new Parrot("miki");
    }

    /* 실습을 위해 컴포넌트 스캔으로 전환
        @Bean
        public Person person(@Qualifier("parrot2") Parrot parrot) {
            Person p = new Person("brobro332");
            p.setParrot(parrot);

            return p;
        }
    */

    /* 파라미터 이름과 빈 이름이 동일할 경우 정상적으로 의존성이 주입됨
       하지만, 파라미터 이름에 의존하게 되므로 다른 개발자가 수정해버릴 수 있음
        @Bean
        public Person person(Parrot parrot2) {
            Person p = new Person("brobro332");
            p.setParrot(parrot2);
    
            return p;
        }
    */
}
