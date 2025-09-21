package polymorphism.repository;

import polymorphism.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
