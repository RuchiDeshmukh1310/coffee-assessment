package com.accenture.mappings;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class CoffeeShop {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        String content = "";
        List<Order> orderList = new ArrayList<>();
        List<Payment> paymentList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        try {
            content = new String(Files.readAllBytes(Paths.get("src/main/resources/com/accenture/mappings/orders.json")));
            orderList = Arrays.asList(objectMapper.readValue(content, Order[].class));

            content = new String(Files.readAllBytes(Paths.get("src/main/resources/com/accenture/mappings/payments.json")));
            paymentList = Arrays.asList(objectMapper.readValue(content, Payment[].class));

            content = new String(Files.readAllBytes(Paths.get("src/main/resources/com/accenture/mappings/products.json")));
            productList = Arrays.asList(objectMapper.readValue(content, Product[].class));


        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Double> totalPayments = getTotalPayments(paymentList);

//Amount paid per user
        System.out.println("Amount paid per user: " + totalPayments);

        Map<String, HashMap<String, Double>> menuList = getProductList(productList);

        Map<String, Double> totalBill = getTotalBill(orderList, menuList);

//Amount that each user owes
        for (String user : totalBill.keySet()) {
            System.out.println(user + " owes " + (totalBill.get(user) - totalPayments.get(user)));
        }

    }

    private static Map<String, Double> getTotalBill(List<Order> orderList, Map<String, HashMap<String, Double>> menuList) {
        return orderList
                .stream()
                .collect(Collectors.groupingBy(Order::getUser, Collectors.summingDouble(i -> menuList.get(i.getDrink()).get(i.getSize()))));
    }

    private static Map<String, HashMap<String, Double>> getProductList(List<Product> productList) {
        return productList
                .stream()
                .collect(Collectors.toMap(Product::getDrink_name, Product::getPrices));
    }

    private static Map<String, Double> getTotalPayments(List<Payment> paymentList) {
        return paymentList
                .stream()
                .collect(Collectors.groupingBy(Payment::getUser, Collectors.summingDouble(Payment::getAmount)));
    }


}
