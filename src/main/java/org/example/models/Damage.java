package org.example.models;


public class Damage {
    private int damageId;
    private int contractId;
    private String description;
    private double price;


    public Damage(int damageId, int contractId, String description, double price) {
        this.damageId = damageId;
        this.contractId = contractId;
        this.description = description;
        this.price = price;
    }
    public Damage(){
    }

    public int getDamageId() {
        return damageId;
    }

    public void setDamageId(int damageId) {
        this.damageId = damageId;
    }

    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Damage{" +
                "damageId=" + damageId +
                ", contractId=" + contractId +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
