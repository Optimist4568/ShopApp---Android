package com.example.shopapp.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderId;
    private List<CartItem> items;
    private double totalPrice;
    private String date;
    private String status;

    public Order(String orderId, List<CartItem> items, double totalPrice, String date, String status) {
        this.orderId = orderId;
        this.items = new ArrayList<>(items);
        this.totalPrice = totalPrice;
        this.date = date;
        this.status = status;
    }

    public String getOrderId() { return orderId; }
    public List<CartItem> getItems() { return items; }
    public double getTotalPrice() { return totalPrice; }
    public String getDate() { return date; }
    public String getStatus() { return status; }
}
