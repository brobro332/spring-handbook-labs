package polymorphism.proxy;

import polymorphism.model.Comment;

public interface CommentNotificationProxy {
    /*
     * [프록시]
     * 1. 외부 시스템(메일 서버, 메시징 서비스 등)과의 통신을 담당하는 객체를 프록시라 한다.
     * 2. 이러한 클래스나 인터페이스의 이름에 Proxy를 붙이는 것이 일반적인 명명 규칙이다.
     */
    void sendComment(Comment comment);
}