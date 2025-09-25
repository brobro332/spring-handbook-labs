package kr.co.spring_boot_external_project_4.rest_endpoint.open_feign.controller;

import kr.co.spring_boot_external_project_4.rest_endpoint.open_feign.entity.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.logging.Logger;

@Controller
public class PaymentController {
    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    ) {
        logger.info("received request with id: " + requestId + " ;payment amount: " + payment.getAmount());

        payment.setId(requestId);
        return ResponseEntity
            .status(HttpStatus.OK)
            .header("requestId", requestId)
            .body(payment);
    }

}
