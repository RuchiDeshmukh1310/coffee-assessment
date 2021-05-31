package com.accenture.mappings;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Payment {
    @JsonProperty("user")
    private String user;
    @JsonProperty("amount")
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
