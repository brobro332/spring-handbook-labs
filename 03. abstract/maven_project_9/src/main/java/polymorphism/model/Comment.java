package polymorphism.model;

public class Comment {
    /*
     * [모델]
     * 1. 데이터를 모델링하는 역할을 가진 클래스
     * 2. 프레임워크나 외부 라이브러리에 종속되지 않은 순수 자바 객체로,
     *    이런 클래스를 POJO(Plain Old Java Object)라고 한다.
     */
    private String author;
    private String text;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
