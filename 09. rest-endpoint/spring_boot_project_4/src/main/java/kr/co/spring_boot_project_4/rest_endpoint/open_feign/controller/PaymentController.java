package kr.co.spring_boot_project_4.rest_endpoint.open_feign.controller;

import kr.co.spring_boot_project_4.rest_endpoint.open_feign.entity.Payment;
import kr.co.spring_boot_project_4.rest_endpoint.open_feign.proxy.PaymentProxy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {
    private final PaymentProxy paymentProxy;

    public PaymentController(PaymentProxy paymentProxy) {
        this.paymentProxy = paymentProxy;
    }

    /**
     * [외부 API 요청]
     * 1. openFeign 라이브러리를 사용하여 외부 API 요청 처리
     * 2. API 요청 예시 : curl.exe -X POST http://localhost:8090/payment/open-feign -H "Content-Type: application/json" -d '{\"amount\":1000}'
     * 3. API 응답 예시 : {"id":"2325fac8-6df0-4e07-89bc-a67a52263d4e","amount":1000.0}
     */
    @PostMapping("/payment/open-feign")
    public Payment createPayment(
        @RequestBody Payment payment
    ) {
        String requestId = UUID.randomUUID().toString();
        return paymentProxy.createPayment(requestId, payment);
    }
}
