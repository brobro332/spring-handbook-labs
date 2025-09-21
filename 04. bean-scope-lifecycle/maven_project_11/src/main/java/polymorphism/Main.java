package polymorphism;

import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import polymorphism.service.CommentService;

public class Main {
    public static void main(String[] args) {
        /*
         * [지연로딩]
         * 1. 즉시 로딩의 경우 스프링 컨텍스트 인스턴스가 생성될 때 빈이 함께 로딩된다.
         * 2. 반면 지연 로딩의 경우 해당 빈을 참조할 때 빈을 생성하고 반환한다.
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("before retrieving the CommentService");
        CommentService commentService = context.getBean(CommentService.class);
        System.out.println("after retrieving the CommentService");
    }
}
