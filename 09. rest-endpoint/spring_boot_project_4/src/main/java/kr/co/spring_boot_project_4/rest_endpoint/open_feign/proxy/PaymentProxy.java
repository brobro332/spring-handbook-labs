package kr.co.spring_boot_project_4.rest_endpoint.open_feign.proxy;

import kr.co.spring_boot_project_4.rest_endpoint.open_feign.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payment", url = "${name.service.url}")
public interface PaymentProxy {
    @PostMapping("/payment")
    public Payment createPayment(@RequestHeader("requestId") String requestId, @RequestBody Payment payment);
}
