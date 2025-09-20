package bean.entity;

import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*
         * [스프링 컨텍스트 초기화]
         * 1. 구성 클래스를 기반으로 스프링 컨텍스트를 초기화한다.
         * 2. 스프링 컨텍스트에서 빈을 가져온다.
         * 3. 동일한 클래스 타입의 빈이 여러 개 존재한다면 해당 클래스를 기반으로 빈을 가져올 경우 예외가 발생한다.
         * 3-1. 이 경우 @Primary 애노테이션을 통해 기본 빈을 가져오도록 할 수 있다.
         * 3-2. 기본 빈 외에는 빈 이름(메서드 이름)을 식별자로 하여 조회할 수 있다.
         * 3-3. @Bean에 name 또는 value 속성을 통해 빈 이름을 등록하여 빈 이름을 통해 가져올 수 있따.
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Parrot p1 = context.getBean(Parrot.class);
        Parrot p2 = context.getBean("parrot2", Parrot.class);
        Parrot p3 = context.getBean("parrot3", Parrot.class);
        String s = context.getBean(String.class);
        Integer i = context.getBean(Integer.class);

        System.out.println(p1); // Parrot{name='koko'}
        System.out.println(p2); // Parrot{name='miki'}
        System.out.println(p3); // Parrot{name='riki'}
        System.out.println(s); // Hello
        System.out.println(i); // 10
    }
}
