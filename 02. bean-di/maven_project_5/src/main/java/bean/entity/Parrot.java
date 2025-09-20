package bean.entity;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name;

    public Parrot(String name) {
        System.out.println("parrot created");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }
}
