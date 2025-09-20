package bean.model;

import org.springframework.stereotype.Component;

@Component
public class Parrot {
    private String name;

    public Parrot() {
        System.out.println("parrot created");
        this.name = "koko";
    }

    @Override
    public String toString() {
        return "Parrot{" +
                "name='" + name + '\'' +
                '}';
    }
}
