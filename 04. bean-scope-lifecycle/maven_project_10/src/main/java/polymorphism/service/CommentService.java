package polymorphism.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polymorphism.repository.DbCommentRepository;

@Service
public class CommentService {
    @Autowired
    private DbCommentRepository dbCommentRepository;

    public DbCommentRepository getDbCommentRepository() {
        return dbCommentRepository;
    }
}
