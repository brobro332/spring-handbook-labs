package polymorphism.proxy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import polymorphism.model.Comment;

// @Primary
@Component
@Qualifier("PUSH")
public class PushCommentNotificationProxy implements CommentNotificationProxy {
    @Override
    public void sendComment(Comment comment) {
        System.out.println("sending push notification for comment: " + comment.getText());
    }
}
