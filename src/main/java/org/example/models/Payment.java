package org.example.models;


import java.util.Date;

public class Payment {

    private int paymentId;
    private int contractId;
    private double amount;
    private Date paymentDate;
    private String paymentMethod;

    public Payment(int paymentId, int contractId, double amount, Date paymentDate, String paymentMethod) {
        this.paymentId =paymentId;
        this.contractId = contractId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
    }

    public Payment(){

    }
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }


    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Payment{" +
                ", contractId=" + contractId +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

}
