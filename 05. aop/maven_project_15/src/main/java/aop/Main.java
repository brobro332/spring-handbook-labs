package aop;

import aop.model.Comment;
import aop.service.CommentService;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        /*
         * [애스펙트 실행 체인]
         * 1. 동일 메서드에 여러 개의 AOP 애노테이션이 지정되면 기본적으로 실행 순서가 정해지지 않는다.
         * 2. @Order 애노테이션을 클래스에 지정함으로써 순서를 명시적으로 설정할 수 있다.
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CommentService commentService = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("brobro332");
        comment.setText("demo comment");

        String returnedValueByAspect = commentService.publishComment(comment);
        logger.info(returnedValueByAspect);
    }
}
