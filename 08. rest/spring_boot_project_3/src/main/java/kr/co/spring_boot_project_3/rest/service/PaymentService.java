package kr.co.spring_boot_project_3.rest.service;

import kr.co.spring_boot_project_3.rest.exception.NotEnoughMoneyException;
import kr.co.spring_boot_project_3.rest.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public Payment processPayment() {
        throw new NotEnoughMoneyException();
    }
}
