package com.jj.paymentservice;


import org.springframework.data.mongodb.repository.MongoRepository;


public interface PaymentRepository extends MongoRepository<Payment, String> {
    // Додаткові методи за потреби
}