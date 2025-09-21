package polymorphism;

import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import polymorphism.service.CommentService;
import polymorphism.service.UserService;

public class Main {
    public static void main(String[] args) {
        /*
         * [스프링 싱글톤 스코프 빈]
         * 1. 스프링 컨테이너 내에서 같은 빈 이름으로 등록된 빈은 한 번만 생성됨
         * 2. 컨테이너에서 동일한 타입 및 이름으로 빈을 조회하면 항상 같은 인스턴스를 반환받는다.
         * 3. 여러 빈이 동일한 싱글톤 빈을 주입받을 경우, 참조되는 객체는 모두 같은 인스턴스이다.
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CommentService commentService1 = context.getBean(CommentService.class);
        CommentService commentService2 = context.getBean(CommentService.class);
        UserService userService = context.getBean(UserService.class);

        System.out.println(commentService1 == commentService2); // true
        System.out.println(commentService1.getDbCommentRepository() == userService.getDbCommentRepository()); // true
    }
}
