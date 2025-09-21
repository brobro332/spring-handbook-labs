package aop.service;

import aop.aspect.annotation.ToLog;
import aop.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    private final Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment) {
        logger.info("publishing comment: " + comment.getText());
        return "SUCCESS";
    }

    @ToLog
    public String deleteComment(Comment comment) {
        logger.info("deleting comment: " + comment.getText());

        return "SUCCESS";
    }

    public void editComment(Comment comment) {
        logger.info("editing comment: " + comment.getText());
    }
}
