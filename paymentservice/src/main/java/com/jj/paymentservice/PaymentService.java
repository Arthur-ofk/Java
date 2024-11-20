package com.jj.paymentservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    // Створення нового платежу
    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    // Отримання всіх платежів
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    // Отримання платежу за ідентифікатором
    public Optional<Payment> getPaymentById(String id) {
        return paymentRepository.findById(id);
    }

    // Оновлення існуючого платежу
    public Payment updatePayment(String id, Payment paymentDetails) {
        return paymentRepository.findById(id).map(payment -> {
            payment.setAmount(paymentDetails.getAmount());
            payment.setCurrency(paymentDetails.getCurrency());
            payment.setMethod(paymentDetails.getMethod());
            payment.setTimestamp(paymentDetails.getTimestamp());
            return paymentRepository.save(payment);
        }).orElseThrow(() -> new ResourceNotFoundException("Payment not found with id " + id));
    }

    // Видалення платежу за ідентифікатором
    public void deletePayment(String id) {
        if (!paymentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Payment not found with id " + id);
        }
        paymentRepository.deleteById(id);
    }
}
