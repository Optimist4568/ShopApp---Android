package com.example.shopapp.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private static Cart instance;
    private List<CartItem> items = new ArrayList<>();

    private Cart() {}

    public static Cart getInstance() {
        if (instance == null) instance = new Cart();
        return instance;
    }

    public void addProduct(Product product) {
        for (CartItem item : items) {
            if (item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + 1);
                return;
            }
        }
        items.add(new CartItem(product, 1));
    }

    public void removeItem(int productId) {
        items.removeIf(item -> item.getProduct().getId() == productId);
    }

    public void updateQuantity(int productId, int qty) {
        for (CartItem item : items) {
            if (item.getProduct().getId() == productId) {
                if (qty <= 0) removeItem(productId);
                else item.setQuantity(qty);
                return;
            }
        }
    }

    public List<CartItem> getItems() { return items; }

    public int getTotalItems() {
        int total = 0;
        for (CartItem item : items) total += item.getQuantity();
        return total;
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) total += item.getTotalPrice();
        return total;
    }

    public void clear() { items.clear(); }
}
