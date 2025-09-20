package bean.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
    /*
     *
     */
    private final String name = "brobro332";
    private Parrot parrot;

    /* 파라미터 이름과 빈 이름이 동일할 경우 정상적으로 의존성이 주입됨
       구성 클래스에서의 빈 등록과 마찬가지로, 파라미터 이름에 의존하게 되므로 다른 개발자가 수정해버릴 수 있음
        public Person(String name, Parrot parrot2) {
            this.name = name;
            this.parrot = parrot2;
        }
    */

    public Person(@Qualifier("parrot2") Parrot parrot) {
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public Parrot getParrot() {
        return parrot;
    }

    public void setParrot(Parrot parrot) {
        this.parrot = parrot;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", parrot=" + parrot +
                '}';
    }
}
