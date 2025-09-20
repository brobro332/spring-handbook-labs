package polymorphism.repository;

import polymorphism.model.Comment;

public class DbCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("storing comment: " + comment.getText());
    }
}
