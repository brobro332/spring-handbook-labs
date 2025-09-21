package polymorphism;

import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import polymorphism.service.CommentService;
import polymorphism.service.UserService;

public class Main {
    public static void main(String[] args) {
        /*
         * [프로토타입 스코프 빈]
         * 1. 등록한 빈에 대한 여러 개의 별개 인스턴스를 만들 수 있다.
         * 2. 싱글톤 스코프 빈과 다르게 생성된 인스턴스는 스프링 컨텍스트가 관리하지 않는다.
         *
         * [싱글톤 스코프 빈에서 프로토타입 스코프 빈 의존성 주입]
         * 1. 싱글톤 스코프 빈은 한 번만 생성되므로,
         *    만약 그 안에서 프로토타입 스코프 빈을 @Autowired로 주입받는다고 하더라도
         *    싱글톤 스코프와 다르지 않음
         * 1-1. 만약 이 문제를 해결하려면,
         *      싱글톤 스코프 빈 내에서 ApplicationContext를 의존성 주입받아
         *      특정 메서드를 호출할 때마다 getBean() 메서드를 통해 새로운 인스턴스를 생성하도록 해야함
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CommentService commentService1 = context.getBean(CommentService.class);
        CommentService commentService2 = context.getBean(CommentService.class);
        UserService userService = context.getBean(UserService.class);

        System.out.println(commentService1 == commentService2); // false
        System.out.println(commentService1.getCommentRepository() == userService.getCommentRepository()); // false
    }
}
