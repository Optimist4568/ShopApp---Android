package com.example.shopapp.models;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private static OrderHistory instance;
    private List<Order> orders = new ArrayList<>();
    private int orderCounter = 1000;

    private OrderHistory() {}

    public static OrderHistory getInstance() {
        if (instance == null) instance = new OrderHistory();
        return instance;
    }

    public void addOrder(List<CartItem> items, double totalPrice, String date) {
        orderCounter++;
        String orderId = "#ORD" + orderCounter;
        orders.add(0, new Order(orderId, items, totalPrice, date, "Confirmed ✅"));
    }

    public List<Order> getOrders() { return orders; }
    public boolean isEmpty() { return orders.isEmpty(); }
}
