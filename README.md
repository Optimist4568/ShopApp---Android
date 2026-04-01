# Shopify – Android Ecommerce App (Java)

A fully functional ecommerce Android app built with Java for a college project.

---

## Features
- 🏠 **Home Screen** – Product grid with search bar and category filter chips
- 🔍 **Search** – Real-time search by product name
- 🏷️ **Category Filter** – Filter by Electronics, Clothing, Footwear, Bags, Accessories
- 📄 **Product Detail** – Full product page with description, rating, price
- 🛒 **Cart** – Add/remove items, adjust quantity, see live total
- 📦 **Checkout** – Shipping form with validation, payment method selection
- ✅ **Order Confirmation** – Success message, cart cleared

## Tech Stack
- **Language**: Java
- **UI**: XML Layouts, RecyclerView, CardView, Material Design Components
- **Architecture**: Activity-based, Singleton Cart

---

## How to Open in Android Studio

1. **Unzip** this folder somewhere on your computer
2. Open **Android Studio**
3. Click **"Open"** → select the `Shopify` folder
4. Wait for Gradle sync to finish
5. Click ▶️ **Run** on an emulator or physical device (API 24+)

---

## Project Structure

```
Shopify/
├── app/src/main/
│   ├── java/com/example/shopapp/
│   │   ├── activities/
│   │   │   ├── MainActivity.java          ← Product listing
│   │   │   ├── ProductDetailActivity.java ← Product detail page
│   │   │   ├── CartActivity.java          ← Shopping cart
│   │   │   └── CheckoutActivity.java      ← Checkout form
│   │   ├── adapters/
│   │   │   ├── ProductAdapter.java        ← RecyclerView for products
│   │   │   └── CartAdapter.java           ← RecyclerView for cart
│   │   └── models/
│   │       ├── Product.java               ← Product data class
│   │       ├── CartItem.java              ← Cart item class
│   │       ├── Cart.java                  ← Singleton cart manager
│   │       └── ProductData.java           ← Static product list
│   └── res/
│       ├── layout/                        ← All XML layouts
│       ├── drawable/                      ← Shapes & icons
│       └── values/                        ← Themes, strings
└── build.gradle
```

---

## Sample Products Included
| Product | Category | Price |
|---|---|---|
| Air Max Sneakers | Footwear | ₹2,499 |
| Wireless Earbuds | Electronics | ₹3,299 |
| Smart Watch | Electronics | ₹5,499 |
| Leather Tote Bag | Bags | ₹1,899 |
| Slim Fit Jeans | Clothing | ₹1,299 |
| Bluetooth Speaker | Electronics | ₹2,199 |
| + 4 more | … | … |
