package polymorphism.proxy;

import polymorphism.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}