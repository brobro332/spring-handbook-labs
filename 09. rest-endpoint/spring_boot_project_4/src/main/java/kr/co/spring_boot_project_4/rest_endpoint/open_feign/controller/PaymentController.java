package kr.co.spring_boot_project_4.rest_endpoint.open_feign.controller;

import kr.co.spring_boot_project_4.rest_endpoint.open_feign.entity.Payment;
import kr.co.spring_boot_project_4.rest_endpoint.open_feign.proxy.PaymentProxy;
import kr.co.spring_boot_project_4.rest_endpoint.open_feign.proxy.PaymentProxyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class PaymentController {
    private final PaymentProxy paymentProxy;
    private final PaymentProxyService paymentProxyService;

    public PaymentController(PaymentProxy paymentProxy, PaymentProxyService paymentProxyService) {
        this.paymentProxy = paymentProxy;
        this.paymentProxyService = paymentProxyService;
    }

    /**
     * [외부 API 요청]
     * 1. openFeign, restTemplate, webClient 라이브러리를 사용하여 외부 API 요청 처리
     * 2. API 요청 예시: curl.exe -X POST http://localhost:8090/payment/open-feign -H "Content-Type: application/json" -d '{\"amount\":1000}'
     * 3. API 응답 예시: {"id":"2325fac8-6df0-4e07-89bc-a67a52263d4e","amount":1000.0}
     * 4. 각 라이브러리 특징
     * 4-1. openFeign: 프록시 인터페이스를 통해 OpenFeign 클라이언트를 정의하면,
     *                 openFeign 의존성이 이 인터페이스를 구현한다.
     *                 구성 클래스에 @EnableFeignClients 애너테이션을 추가해야 한다.
     * 4-2. restTemplate: 스프링5부터 유지보수 모드로 전환되어, 더이상 사용되지 않을 예정이다.
     * 4-3. webClient: 리액티브 방식을 기반으로 하는데,
     *                 리액티브 방식은 기존 방식처럼 하나의 스레드가 처음부터 끝까지 모든 태스크를 실행하지 않고,
     *                 태스크를 독립적인 것으로 간주하고 여러 스레드와 협업하여 여러 태스크로 구성된 비즈니스 흐름을 완료한다.
     *                 비동기적이고, 논블로킹이며, 이벤트 기반으로 작업을 처리한다.
     */
    @PostMapping("/payment/open-feign")
    public Payment createPayment(
        @RequestBody Payment payment
    ) {
        String requestId = UUID.randomUUID().toString();
        return paymentProxy.createPayment(requestId, payment);
    }

    @PostMapping("/payment/rest-template")
    public Payment createPaymentRestTemplate(
            @RequestBody Payment payment
    ) {
        String requestId = UUID.randomUUID().toString();
        return paymentProxyService.createPaymentRestTemplate(payment);
    }

    @PostMapping("/payment/web-client")
    public Mono<Payment> createPaymentWebClient(
            @RequestBody Payment payment
    ) {
        String requestId = UUID.randomUUID().toString();
        return paymentProxyService.createPaymentWebClient(payment);
    }
}
