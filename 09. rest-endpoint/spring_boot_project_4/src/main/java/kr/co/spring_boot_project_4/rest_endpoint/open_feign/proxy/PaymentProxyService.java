package kr.co.spring_boot_project_4.rest_endpoint.open_feign.proxy;

import kr.co.spring_boot_project_4.rest_endpoint.open_feign.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;

@Service
public class PaymentProxyService {
    private final RestTemplate restTemplate;
    private final WebClient webClient;

    @Value("${name.service.url}")
    private String paymentServiceUrl;

    public PaymentProxyService(RestTemplate restTemplate, WebClient webClient) {
        this.restTemplate = restTemplate;
        this.webClient = webClient;
    }

    public Payment createPaymentRestTemplate(Payment payment) {
        String uri = paymentServiceUrl + "/payment";

        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, headers);

        ResponseEntity<Payment> response = restTemplate.exchange(
            uri,
            HttpMethod.POST,
            httpEntity,
            Payment.class
        );

        return response.getBody();
    }

}
