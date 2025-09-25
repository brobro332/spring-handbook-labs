package kr.co.spring_boot_project_4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootProject4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProject4Application.class, args);
	}

}
