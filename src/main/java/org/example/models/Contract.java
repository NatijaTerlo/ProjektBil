package org.example.models;

import java.util.Date;

public class Contract {
    private int contractId;
    private int customerId;
    private int carId;
    private Date startDate;
    private Date endDate;
    private double totalPrice;

    public Contract(){
    }
    public Contract(int contractId, int customerId, int carId, Date startDate, Date endDate, double totalPrice) {
        this.contractId = contractId;
        this.customerId = customerId;
        this.carId = carId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = totalPrice;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "contractId=" + contractId +
                ", customerId=" + customerId +
                ", carId=" + carId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
