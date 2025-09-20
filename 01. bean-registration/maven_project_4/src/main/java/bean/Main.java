package bean;

import bean.entity.Parrot;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {
    /*
     * [AnnotationConfigApplicationContext 인스턴스의 registerBean() 메서드]
     * 1. 빈을 등록하는 메서드는 클래스에 다음과 같이 정의되어 있음
     *     public <T> void registerBean(@Nullable String beanName,
     *                              Class<T> beanClass,
     *                              @Nullable Supplier<T> supplier,
     *                              BeanDefinitionCustomizer... customizers) {
     *         this.reader.registerBean(beanClass, beanName, supplier, customizers);
     *     }
     * 1-1. 첫 번째 파라미터는 스프링 컨텍스트에 추가할 빈 이름
     * 1-2. 두 번째 파라미터는 해당 빈을 정의하는 클래스
     * 1-3. 세 번째 파라미터는 Supplier의 인스턴스로, 스프링 컨텍스트에 추가할 인스턴스 값을 전달해야 함
     *      Supplier는 java.util.function 패키지에서 찾을 수 있는 함수형 인터페이스
     *      Supplier 구현체는 파라미터 없이 사용자가 정의한 값을 반환하는 것이 목적임
     * 1-4. 빈의 다양한 특징을 구성할 때 구현하는 인터페이스로, 생략 가능하다.
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Parrot p = new Parrot();
        p.setName("koko");

        Supplier<Parrot> parrotSupplier = () -> p; // main()에서 정의한 Parrot 인스턴스를 반환하는 Supplier 구현

        // context.registerBean("parrot1", Parrot.class, parrotSupplier);
        context.registerBean(
            "parrot1",
            Parrot.class,
            parrotSupplier,
            bc -> bc.setPrimary(true) // 기본 빈으로 등록
        );

        System.out.println(context.getBean(Parrot.class)); // Parrot{name='koko'}
    }
}
