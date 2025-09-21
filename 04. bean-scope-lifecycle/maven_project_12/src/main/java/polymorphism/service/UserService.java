package polymorphism.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polymorphism.model.Comment;
import polymorphism.processor.CommentProcessor;
import polymorphism.repository.CommentRepository;

@Service
public class UserService {
    private CommentRepository commentRepository;

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }

    @Autowired
    public UserService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
