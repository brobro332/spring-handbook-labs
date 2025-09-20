package bean;

import bean.model.Parrot;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*
        * [스프링 컨텍스트] 스프링 컨텍스트 인스턴스 생성
        */
        ApplicationContext context = new AnnotationConfigApplicationContext();

        /*
        * [생성자]
        * 1. 사용자 정의된 생성자가 없을 경우 기본 생성자는 자동 생성됨
        * 2. 생성자는 기본적으로 부모 생성자를 호출함
        * 3. 메모리 상에서 p 변수가 가리키는 객체는 Parrot 타입이며,
        *    그 상위 클래스(Object)의 멤버도 함께 포함된 상태임
        */
        Parrot p = new Parrot();

        /*
        * TODO: 스프링 컨텍스트에 Parrot 인스턴스 추가
        * - 현재 Parrot 인스턴스를 생성했지만 스프링 컨텍스트 외부에 존재한다.
        * - 스프링 컨텍스트에 해당 Parrot 인스턴스를 추가하면,
        *   스프링이 해당 인스턴스를 관리할 수 있다.
        */
    }
}
