package bean;

import bean.model.Parrot;
import bean.model.Person;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    /*
     * [와이어링 시 인스턴스 개수]
     * 1. main()에서 Parrot 인스턴스는 단 한 개 생성된다.
     * 1-1. 해당 인스턴스는 스프링 컨텍스트에서 관리되므로,
     *      해당 빈을 참조하려고 할 경우 컨텍스트에서 직접 인스턴스를 가져온다.
     * 1-2. 아직 스프링 컨텍스트에 없을 경우, parrot() 메서드를 호출하고 빈을 반환한다.
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println(context.getBean(Person.class)); // Person{name='brobro332', parrot=Parrot{name='koko'}}
        System.out.println(context.getBean(Parrot.class)); // Parrot{name='koko'}
    }
}
