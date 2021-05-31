package com.accenture.mappings;


public class Order {
    private String user;
    private String drink;
    private String size;

    public Order() {

    }

    public Order(String user, String drink, String size) {
        this.user = user;
        this.drink = drink;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "user='" + user + '\'' +
                ", drink='" + drink + '\'' +
                ", size='" + size + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


}
