package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "bean")
public class AppConfig {
    /*
    * [컴포넌트 스캔]
    * 1. 스테레오 타입 애노테이션으로 지정된 클래스를 검색하여 빈으로 등록함
    * 2. main 패키지와 그 하위 모든 패키지에 있는 클래스를 스캔함
    */
}
