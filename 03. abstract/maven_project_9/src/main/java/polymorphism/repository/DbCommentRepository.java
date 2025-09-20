package polymorphism.repository;

import org.springframework.stereotype.Component;
import polymorphism.model.Comment;

@Component
public class DbCommentRepository implements CommentRepository {
    @Override
    public void storeComment(Comment comment) {
        System.out.println("storing comment: " + comment.getText());
    }
}
