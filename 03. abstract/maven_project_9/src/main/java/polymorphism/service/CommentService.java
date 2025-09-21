package polymorphism.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import polymorphism.model.Comment;
import polymorphism.proxy.CommentNotificationProxy;
import polymorphism.repository.CommentRepository;

@Service
public class CommentService {
    /*
     * [의존성 주입과 생성자]
     * 1. 만약 의존성을 주입하려는 필드에 생성자가 두 개 이상있다면,
     *    @Autowired 애노테이션을 사용해야 한다.
     * 2. 만약 의존성을 주입하려는 인터페이스에 구현체가 두 개 이상있다면,
     *    @Qualifier를 통해 해당 빈과 의존성을 주입하려는 파라미터에
     *    구현체를 지정해야 한다.
     */
    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;

    public CommentService(
        CommentRepository commentRepository,
        @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy
    ) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
