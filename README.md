# ShopApp---Android
<div align="center">

# 🛍️ Shopify
### A Native Android Ecommerce Application

![Android](https://img.shields.io/badge/Platform-Android-brightgreen?style=for-the-badge&logo=android)
![Java](https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java)
![Material Design](https://img.shields.io/badge/UI-Material%20Design-blue?style=for-the-badge&logo=materialdesign)
![Status](https://img.shields.io/badge/Status-Complete-success?style=for-the-badge)

*A college project demonstrating core Android development concepts —
built entirely from scratch in Java with no backend or external APIs.*

</div>

---

## 📱 Screenshots & Features

| 🏠 Home | 🔍 Search & Filter | 📄 Product Detail |
|---|---|---|
| 2-column product grid | Real-time search + category chips | Full detail with wishlist & buy now |

| 🛒 Cart | 📦 Order History | ❤️ Wishlist |
|---|---|---|
| Quantity controls & live total | All past orders with timestamps | Saved favourite products |

---

## ✨ Features

- 🔍 **Real-time Search** — filters products as you type
- 🏷️ **Category Filters** — Food, Electronics, Clothing, Footwear, Books, Home & Kitchen
- 🛒 **Shopping Cart** — add, remove, increase/decrease quantity with live total
- ❤️ **Wishlist** — save favourite products with a toggle button
- 📦 **Order History** — every placed order saved with ID, date and itemised receipt
- ✅ **Checkout Flow** — full shipping form with input validation and payment selection
- 🔢 **Cart & Wishlist Badges** — live count shown on home screen icons

---

## 🗂️ Project Structure
```
app/src/main/java/com/example/shopapp/
│
├── 📁 models/
│   ├── Product.java          # Product data class
│   ├── CartItem.java         # Product + quantity wrapper
│   ├── Cart.java             # Singleton cart manager
│   ├── Order.java            # Order data class
│   ├── OrderHistory.java     # Singleton order history
│   ├── Wishlist.java         # Singleton wishlist manager
│   └── ProductData.java      # 29 products across 6 categories
│
├── 📁 activities/
│   ├── MainActivity.java          # Home screen
│   ├── ProductDetailActivity.java # Product detail screen
│   ├── CartActivity.java          # Shopping cart screen
│   ├── CheckoutActivity.java      # Checkout & order placement
│   ├── OrderHistoryActivity.java  # Past orders screen
│   └── WishlistActivity.java      # Saved products screen
│
└── 📁 adapters/
    ├── ProductAdapter.java   # RecyclerView adapter for products
    ├── CartAdapter.java      # RecyclerView adapter for cart
    └── OrderAdapter.java     # RecyclerView adapter for orders
```

---

## 🧠 Concepts & Patterns Used

| Concept | Where |
|---|---|
| **Singleton Pattern** | `Cart`, `OrderHistory`, `Wishlist` |
| **ViewHolder Pattern** | All three RecyclerView adapters |
| **Callback / Interface** | `CartUpdateListener` in CartAdapter |
| **Activity Lifecycle** | `onResume()` for badge refresh |
| **Intents & Data Passing** | Between all activities |
| **Form Validation** | Checkout screen |
| **Dynamic View Creation** | Order items built at runtime in OrderAdapter |

---

## 🛠️ Built With

- **Language** — Java
- **UI** — XML Layouts, Material Design Components
- **Lists** — RecyclerView + CardView
- **Navigation** — Android Activities + Intents
- **Build Tool** — Gradle 8.9
- **Min SDK** — API 24 (Android 7.0+)
- **Target SDK** — API 35 (Android 15)

---

## 🚀 Getting Started

### Prerequisites
- Android Studio (latest version)
- Java 21
- Android SDK API 24 or higher

### Installation
```bash
# 1. Clone the repository
git clone https://github.com/YOUR_USERNAME/Shopify-Android.git

# 2. Open in Android Studio
File → Open → select the ShopApp folder

# 3. Let Gradle sync finish

# 4. Run on emulator or physical device
```

---

## 📦 Product Catalogue

| Category | Items |
|---|---|
| 🍫 Food | Honey, Dark Chocolate, Coffee Beans, Dry Fruits, Instant Noodles |
| 📱 Electronics | Earbuds, Smart Watch, BT Speaker, Fast Charger, Power Bank |
| 👕 Clothing | Jeans, Hoodie, Graphic Tee, Cargo Shorts, Formal Blazer |
| 👟 Footwear | Air Max, Leather Loafers, Running Shoes, Flip Flops |
| 📚 Books | Atomic Habits, The Alchemist, Rich Dad Poor Dad, Zero to One, Deep Work |
| 🏠 Home & Kitchen | Air Fryer, Water Bottle, Pan Set, Desk Lamp, Candle Set |

---

## 👨‍💻 Author

Made with pain and suffering as a college project
