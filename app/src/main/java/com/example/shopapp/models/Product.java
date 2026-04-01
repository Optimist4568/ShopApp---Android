package com.example.shopapp.models;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private String category;
    private String emoji;
    private float rating;
    private int reviewCount;

    public Product(int id, String name, String description, double price,
                   String category, String emoji, float rating, int reviewCount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.emoji = emoji;
        this.rating = rating;
        this.reviewCount = reviewCount;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public String getEmoji() { return emoji; }
    public float getRating() { return rating; }
    public int getReviewCount() { return reviewCount; }
}
