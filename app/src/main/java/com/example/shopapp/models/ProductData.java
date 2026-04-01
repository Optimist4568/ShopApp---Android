package com.example.shopapp.models;

import java.util.ArrayList;
import java.util.List;

public class ProductData {

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        // --- FOOD ---
        products.add(new Product(1,  "Organic Honey 500g",   "Pure wildflower honey, cold-extracted and unfiltered. Rich in antioxidants.", 349,  "Food", "🍯", 4.7f, 312));
        products.add(new Product(2,  "Dark Chocolate Box",   "Assorted 70% dark chocolate truffles. Pack of 16 handcrafted pieces.",        499,  "Food", "🍫", 4.6f, 218));
        products.add(new Product(3,  "Gourmet Coffee Beans", "Single-origin Arabica beans from Coorg, medium roast, 250g pack.",            599,  "Food", "☕", 4.8f, 405));
        products.add(new Product(4,  "Dry Fruits Combo",     "Premium mix of cashews, almonds, pistachios and walnuts. 400g box.",          799,  "Food", "🥜", 4.5f, 189));
        products.add(new Product(5,  "Instant Noodles Pack", "Pack of 12 spicy masala instant noodles. Ready in 2 minutes.",                249,  "Food", "🍜", 4.2f, 527));

        // --- ELECTRONICS ---
        products.add(new Product(6,  "Wireless Earbuds",     "True wireless earbuds with ANC and 24-hour battery life.",                   3299, "Electronics", "🎧", 4.9f, 540));
        products.add(new Product(7,  "Smart Watch",          "Health tracking, GPS, SpO2 monitor and 7-day battery.",                      5499, "Electronics", "⌚", 4.7f, 389));
        products.add(new Product(8,  "Bluetooth Speaker",    "360° surround sound, IPX7 waterproof, 12-hour playtime.",                    2199, "Electronics", "🔊", 4.6f, 271));
        products.add(new Product(9,  "USB-C Fast Charger",   "65W GaN charger with 3 ports. Charges laptop, phone and tablet.",            1299, "Electronics", "🔌", 4.5f, 334));
        products.add(new Product(10, "Portable Power Bank",  "20000mAh slim power bank with dual USB-C and LED indicator.",                1899, "Electronics", "🔋", 4.6f, 412));

        // --- CLOTHING ---
        products.add(new Product(11, "Slim Fit Jeans",       "Classic slim-fit denim with stretch comfort fabric.",                        1299, "Clothing", "👖", 4.5f, 312));
        products.add(new Product(12, "Hoodie Sweatshirt",    "Cozy cotton-blend hoodie with kangaroo pocket. Pre-washed for softness.",    1099, "Clothing", "🧥", 4.4f, 156));
        products.add(new Product(13, "Graphic Tee",          "100% organic cotton oversized tee with minimalist print. Unisex fit.",        699, "Clothing", "👕", 4.3f, 223));
        products.add(new Product(14, "Cargo Shorts",         "6-pocket ripstop cargo shorts. Lightweight and quick-dry fabric.",            899, "Clothing", "🩳", 4.4f, 178));
        products.add(new Product(15, "Formal Blazer",        "Slim-fit single-button blazer in stretch fabric. Office to evening wear.",   2499, "Clothing", "🤵", 4.6f, 134));

        // --- FOOTWEAR ---
        products.add(new Product(16, "Air Max Sneakers",     "Premium comfort sneakers with air cushion sole for everyday wear.",          2499, "Footwear", "👟", 4.8f, 214));
        products.add(new Product(17, "Leather Loafers",      "Genuine leather slip-on loafers with memory foam insole.",                   1899, "Footwear", "🥿", 4.5f, 98));
        products.add(new Product(18, "Running Shoes",        "Lightweight mesh running shoes with responsive cushioning sole.",            3199, "Footwear", "👟", 4.7f, 302));
        products.add(new Product(19, "Flip Flops",           "Waterproof EVA flip flops with anti-slip textured sole.",                    399, "Footwear", "🩴", 4.1f, 445));

        // --- BOOKS ---
        products.add(new Product(20, "Atomic Habits",        "James Clear's #1 bestseller on building good habits and breaking bad ones.", 499, "Books", "📗", 4.9f, 1823));
        products.add(new Product(21, "The Alchemist",        "Paulo Coelho's timeless classic about following your dreams.",               299, "Books", "📙", 4.8f, 2104));
        products.add(new Product(22, "Rich Dad Poor Dad",    "Robert Kiyosaki's personal finance classic. A must-read for everyone.",      399, "Books", "📘", 4.7f, 1567));
        products.add(new Product(23, "Zero to One",          "Peter Thiel's insights on startups and building the future.",                549, "Books", "📕", 4.6f, 892));
        products.add(new Product(24, "Deep Work",            "Cal Newport on focused success in a distracted world.",                      449, "Books", "📓", 4.7f, 743));

        // --- HOME & KITCHEN ---
        products.add(new Product(25, "Air Fryer 4L",         "Digital air fryer with 8 presets and rapid heat technology.",               4999, "Home & Kitchen", "🍳", 4.7f, 634));
        products.add(new Product(26, "Steel Water Bottle",   "1L double-wall insulated bottle. Keeps cold 24h, hot 12h. BPA free.",        799, "Home & Kitchen", "🍶", 4.6f, 819));
        products.add(new Product(27, "Non-Stick Pan Set",    "3-piece granite-coated cookware set. Induction compatible.",                2299, "Home & Kitchen", "🥘", 4.5f, 412));
        products.add(new Product(28, "LED Desk Lamp",        "Touch-control desk lamp with 5 brightness levels and USB charging port.",   1199, "Home & Kitchen", "💡", 4.4f, 287));
        products.add(new Product(29, "Scented Candle Set",   "Set of 4 soy wax candles in lavender, vanilla, sandalwood and citrus.",      899, "Home & Kitchen", "🕯️", 4.6f, 356));

        return products;
    }

    public static List<String> getCategories() {
        List<String> cats = new ArrayList<>();
        cats.add("All");
        cats.add("Food");
        cats.add("Electronics");
        cats.add("Clothing");
        cats.add("Footwear");
        cats.add("Books");
        cats.add("Home & Kitchen");
        return cats;
    }
}
