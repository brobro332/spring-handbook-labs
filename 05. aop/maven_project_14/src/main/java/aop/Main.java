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
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        CommentService commentService = context.getBean(CommentService.class);

        Comment comment = new Comment();
        comment.setAuthor("brobro332");
        comment.setText("demo comment");

        commentService.deleteComment(comment);
    }
}
