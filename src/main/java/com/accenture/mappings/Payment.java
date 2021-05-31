package com.accenture.mappings;


public class Payment {

    private String user;
    private float amount;

    @Override
    public String toString() {
        return "Payment{" +
                "user='" + user + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Payment() {
    }

    public Payment(String user, float amount) {
        this.user = user;
        this.amount = amount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
