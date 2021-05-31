package com.accenture.mappings;


import java.util.HashMap;

public class Product {

    private String drink_name;
    private HashMap<String, Double> prices;

    public Product() {
    }

    public Product(String drink_name, HashMap<String, Double> prices) {
        this.drink_name = drink_name;
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "Product{" +
                "drink_name='" + drink_name + '\'' +
                ", prices=" + prices +
                '}';
    }

    public String getDrink_name() {
        return drink_name;
    }

    public void setDrink_name(String drink_name) {
        this.drink_name = drink_name;
    }

    public HashMap<String, Double> getPrices() {
        return prices;
    }

    public void setPrices(HashMap<String, Double> prices) {
        this.prices = prices;
    }
}
