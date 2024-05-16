package org.example.service;
import org.example.models.Payment;
import org.example.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    public List<Payment>showAllPayments(){
        return paymentRepository.showAllPayments();
    }
    public List<Payment> getPayments(){
        return paymentRepository.getPayments();
    }
    public void createPayment(int contractId, double amount, Date paymentDate, String paymentMethod){
        paymentRepository.createPayment(contractId, amount, paymentDate, paymentMethod);
    }
    public void updatePayment(int contractId, double amount, Date paymentDate, String paymentMethod){
        paymentRepository.updatePayment(contractId, amount, paymentDate, paymentMethod);
    }
    public void deletePayment(int id){
        paymentRepository.deletePayment(id);
    }
    public Payment getPayment(int id) {
       return paymentRepository.getPayment(id);
    }
    public void insertPayment(int contractId, double amount, Date paymentDate, String paymentMethod){
        paymentRepository.insertPayment(contractId, amount, paymentDate, paymentMethod);
    }
}
