package polymorphism.repository;

import polymorphism.model.Comment;

public interface CommentRepository {
    /*
     * [레포지토리]
     * 1. 데이터 액세스 객체(DAO)로, 데이터베이스와 직접 작업하는 역할을 수행한다.
     */
    void storeComment(Comment comment);
}
