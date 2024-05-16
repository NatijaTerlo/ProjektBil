package org.example.controllers;

import org.example.models.Payment;
import org.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.Date;
import java.util.List;

@Controller
public class PaymentController {

    @Autowired

    PaymentService paymentService;

    @GetMapping("/all_payments")
    public String showAllPayments(Model model) {
        List<Payment> payments = paymentService.showAllPayments();
        model.addAttribute("payments", payments);
        return "home/all_payments";
    }
    @GetMapping("/add_payment")
    public String addPayment() {
        return "home/add_payment";
    }

   /* @GetMapping("/payments")
    public String getPayments(Model model) {
        List<Payment> payments = paymentService.getPayments();
        model.addAttribute("payments", payments);
        return "home/payments";
    }

    */


    @PostMapping("/create_payment")
    public String createPayment(@RequestParam int contractId,
                                @RequestParam double amount,
                                @RequestParam("paymentDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date paymentDate,
                                @RequestParam String paymentMethod) {
        paymentService.createPayment(contractId, amount, paymentDate, paymentMethod);
        return "/create_payment";
    }

    @PostMapping("update_payment")
    public String updatePayment(@RequestParam int contractId,
                                @RequestParam double amount,
                                @RequestParam("paymentDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date paymentDate,
                                @RequestParam String paymentMethod) {
        paymentService.updatePayment(contractId, amount, paymentDate, paymentMethod);
        return "redirect:/all_payments";
    }

    @PostMapping("delete_payment")
    public String deletePayment(@RequestParam int id) {
        paymentService.deletePayment(id);
        return "redirect:/all_payments";
    }

   @GetMapping("/delete_payment")
    public String deletePayment(@RequestParam int id, Model model) {
        Payment payment = paymentService.getPayment(id);
        System.out.println(payment);
        model.addAttribute("id", payment.getPaymentId());
        model.addAttribute("paymentId",payment.getPaymentId());
        model.addAttribute("paymentDate", payment.getPaymentDate());
        model.addAttribute("contractId", payment.getContractId());
        return "home/delete_payment";
    }



    @PostMapping("/insert_payment")
    public String insertPayment(@RequestParam int contractId,
                                @RequestParam double amount,
                                @RequestParam("paymentDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date paymentDate,
                                @RequestParam String paymentMethod) {
        paymentService.insertPayment(contractId, amount, paymentDate, paymentMethod);
        return "redirect:/all_payments";
    }
}
