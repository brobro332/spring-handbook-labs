package polymorphism;

import polymorphism.model.Comment;
import polymorphism.proxy.CommentNotificationProxy;
import polymorphism.proxy.EmailCommentNotificationProxy;
import polymorphism.repository.CommentRepository;
import polymorphism.repository.DbCommentRepository;
import polymorphism.service.CommentService;

public class Main {
    public static void main(String[] args) {
        CommentRepository commentRepository = new DbCommentRepository();
        CommentNotificationProxy commentNotificationProxy = new EmailCommentNotificationProxy();
        CommentService commentService = new CommentService(commentRepository, commentNotificationProxy);

        Comment comment = new Comment();
        comment.setAuthor("brobro332");
        comment.setText("demo comment");

        commentService.publishComment(comment);
    }
}
