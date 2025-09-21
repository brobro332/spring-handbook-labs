package aop.service;

import aop.model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CommentService {
    /*
     * [로깅]
     * 1. 로깅 프레임워크는 모든 자바 앱과 호환됨
     * 2. 프로덕션 수준의 앱에서는 콘솔 출력 대신 로깅 기능을 사용한다.
     */
    private final Logger logger = Logger.getLogger(CommentService.class.getName());

    public String publishComment(Comment comment) {
        logger.info("publishing comment: " + comment.getText());
        return "SUCCESS";
    }
}
