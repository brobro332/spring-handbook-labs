package polymorphism.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import polymorphism.model.Comment;
import polymorphism.processor.CommentProcessor;
import polymorphism.repository.CommentRepository;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentService {
    private CommentRepository commentRepository;

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void sendComment(Comment comment) {
        CommentProcessor commentProcessor = new CommentProcessor();
        commentProcessor.setComment(comment);
        commentProcessor.processComment();
        commentProcessor.validateComment();

        comment = commentProcessor.getComment();
        System.out.println(comment);
    }
}
