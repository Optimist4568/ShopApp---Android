package com.example.shopapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopapp.R;
import com.example.shopapp.models.Cart;
import com.example.shopapp.models.Product;
import com.example.shopapp.models.ProductData;
import com.example.shopapp.models.Wishlist;

public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        int productId = getIntent().getIntExtra("product_id", -1);
        Product product = null;
        for (Product p : ProductData.getAllProducts()) {
            if (p.getId() == productId) { product = p; break; }
        }
        if (product == null) { finish(); return; }

        final Product finalProduct = product;

        ((TextView) findViewById(R.id.tvDetailEmoji)).setText(product.getEmoji());
        ((TextView) findViewById(R.id.tvDetailName)).setText(product.getName());
        ((TextView) findViewById(R.id.tvDetailCategory)).setText(product.getCategory());
        ((TextView) findViewById(R.id.tvDetailPrice)).setText("₹" + String.format("%,.0f", product.getPrice()));
        ((TextView) findViewById(R.id.tvDetailRating)).setText("⭐ " + product.getRating() + "  (" + product.getReviewCount() + " reviews)");
        ((TextView) findViewById(R.id.tvDetailDescription)).setText(product.getDescription());

        // Wishlist button
        Button btnWishlist = findViewById(R.id.btnWishlist);
        updateWishlistButton(btnWishlist, product.getId());

        btnWishlist.setOnClickListener(v -> {
            Wishlist.getInstance().toggle(finalProduct);
            updateWishlistButton(btnWishlist, finalProduct.getId());
            String msg = Wishlist.getInstance().contains(finalProduct.getId())
                    ? "Added to Wishlist ❤️" : "Removed from Wishlist";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });

        ((Button) findViewById(R.id.btnDetailAddToCart)).setOnClickListener(v -> {
            Cart.getInstance().addProduct(finalProduct);
            Toast.makeText(this, "Added to cart!", Toast.LENGTH_SHORT).show();
        });

        ((Button) findViewById(R.id.btnBuyNow)).setOnClickListener(v -> {
            Cart.getInstance().addProduct(finalProduct);
            startActivity(new Intent(this, CartActivity.class));
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(product.getName());
        }
    }

    private void updateWishlistButton(Button btn, int productId) {
        if (Wishlist.getInstance().contains(productId)) {
            btn.setText("❤️ Wishlisted");
            btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFFE53935));
        } else {
            btn.setText("🤍 Add to Wishlist");
            btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0xFF9E9E9E));
        }
    }

    @Override
    public boolean onSupportNavigateUp() { finish(); return true; }
}
