package bean.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    /*
    * [필드 의존성 주입]
    * 1. 컴포넌트 스캔이나 구성 클래스 등을 통해 빈으로 등록된 경우,
    *    스프링 컨텍스트가 자동으로 의존성을 주입해줌
    * 2. final을 붙이지 못하므로 불변성이 깨지기 때문에 사이드 이펙트 발생 가능
    *
    * [생성자 의존성 주입]
    * 1. 필드를 final로 지정할 수 있음
    *
    * [Setter 의존성 주입]
    * 1. Setter를 통해 의존성을 주입할 수 있음
    * 2. final로 만들지 못하고, 장점 없이 단점만 존재하여 사용하지 않음
    */

    private String name;

    /* 필드 의존성 주입
        @Autowired
        private Parrot parrot;
    */

    private final Parrot parrot;

    @Autowired
    public Person(Parrot parrot) {
        this.parrot = parrot;
        this.name = "brobro332";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    /* Setter 의존성 주입
        public void setParrot(Parrot parrot) {
            this.parrot = parrot;
        }
    */

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", parrot=" + parrot +
                '}';
    }
}
