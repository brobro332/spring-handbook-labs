package aop;

import aop.model.Comment;
import aop.service.CommentService;
import config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class Main {
    /*
     * [AOP 반환값]
     * 1. 포인트컷(대상 메서드)과 애스펙트에 반환 값이 있다면,
     *    애스펙트에서 반환하는 값이 최종적으로 반환된다.
     * 2. 관련 코드를 다크 사이드로 숨길 수 있으므로,
     *    쉽게 암시될 수 있는 관련 없는 코드 줄을 숨길 때만 사용해야 한다.
     */
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CommentService commentService = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("brobro332");
        comment.setText("demo comment");

        String value = commentService.publishComment(comment);
        logger.info(value); // SUCCESS is returned by aspect
    }
}
