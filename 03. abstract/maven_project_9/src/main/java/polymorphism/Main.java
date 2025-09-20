package polymorphism;

import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import polymorphism.model.Comment;
import polymorphism.service.CommentService;

public class Main {
    public static void main(String[] args) {
        /*
         * [스테레오 타입 애노테이션을 통한 의존성 주입]
         * 1. 각 계층(서비스, 레포지토리, 프록시)의 구현체를 컴포넌트로 만든다.
         * 2. 구성 클래스에서 컴포넌트 스캔을 수행한다.
         * 3. 스프링 컨텍스트에 의해 의존성 주입이 되고, 빈을 가져올 수 있다.
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Comment comment = new Comment();
        comment.setAuthor("brobro332");
        comment.setText("demo comment");

        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
