package kr.co.spring_boot_project_3.rest.controller;

import kr.co.spring_boot_project_3.rest.exception.NotEnoughMoneyException;
import kr.co.spring_boot_project_3.rest.model.Error;
import kr.co.spring_boot_project_3.rest.model.Payment;
import kr.co.spring_boot_project_3.rest.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    /*
     * [@RequestBody]
     * 1. 클라이언트가 HTTP 요청 본문에 보낸 JSON, XML 등의 데이터를 자바 객체로 변환해줌
     * 2. 주로 POST, PUT 같은 요청에서 사용되며, 요청 데이터를 메서드 파라미터로 바인딩함
     * 3. 스프링이 자동으로 메시지 컨버터를 사용해 데이터 형식을 변환하여 객체로 매핑함
     */
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> makePayment(@RequestBody Payment payment) {
        try {
            return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(payment);
        } catch (NotEnoughMoneyException e) {
            Error error = new Error();
            error.setMessage("not enough money to make the payment");

            return ResponseEntity
                .badRequest()
                .body(error);
        }
    }

}
