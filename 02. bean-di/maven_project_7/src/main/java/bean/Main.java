package bean;

import bean.model.Person;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println(context.getBean(Person.class)); // Person{name='brobro332', parrot=Parrot{name='miki'}}
    }
}
