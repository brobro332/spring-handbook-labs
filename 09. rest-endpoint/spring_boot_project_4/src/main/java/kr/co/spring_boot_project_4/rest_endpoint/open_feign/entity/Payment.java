package kr.co.spring_boot_project_4.rest_endpoint.open_feign.entity;

public class Payment {
    private String id;
    private double amount;

    public Payment() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}