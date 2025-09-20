package bean.model;

public class Parrot {
    private final String name;

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
