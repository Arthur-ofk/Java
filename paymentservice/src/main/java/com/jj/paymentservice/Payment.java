package com.jj.paymentservice;


import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection = "payments")
public class Payment {

    @Id
    private String id; 
    private String productId;
    private double amount;
    private String currency;
    private String method;
    private LocalDateTime timestamp;

   
    public Payment() {
    }

    public Payment(double amount, String currency, String method, LocalDateTime timestamp) {
        this.amount = amount;
        this.currency = currency;
        this.method = method;
        this.timestamp = timestamp;
    }

   

    public String getId() {
        return id;
    }
 public String getProductId()
 {
    return productId;
 }
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

   
}