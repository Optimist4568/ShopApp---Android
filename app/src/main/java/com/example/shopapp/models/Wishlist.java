package com.example.shopapp.models;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    private static Wishlist instance;
    private List<Product> items = new ArrayList<>();

    private Wishlist() {}

    public static Wishlist getInstance() {
        if (instance == null) instance = new Wishlist();
        return instance;
    }

    public void addProduct(Product product) {
        if (!contains(product.getId())) items.add(product);
    }

    public void removeProduct(int productId) {
        items.removeIf(p -> p.getId() == productId);
    }

    public boolean contains(int productId) {
        for (Product p : items) if (p.getId() == productId) return true;
        return false;
    }

    public void toggle(Product product) {
        if (contains(product.getId())) removeProduct(product.getId());
        else addProduct(product);
    }

    public List<Product> getItems() { return items; }
    public int getCount() { return items.size(); }
}
