package polymorphism.repository;

import org.springframework.stereotype.Repository;
import polymorphism.model.Comment;

@Repository
public class DbCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("storing comment: " + comment.getText());
    }
}
