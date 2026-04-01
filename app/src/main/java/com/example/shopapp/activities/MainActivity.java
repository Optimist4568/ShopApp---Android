package com.example.shopapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.R;
import com.example.shopapp.adapters.ProductAdapter;
import com.example.shopapp.models.Cart;
import com.example.shopapp.models.Product;
import com.example.shopapp.models.ProductData;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvProducts;
    private ProductAdapter productAdapter;
    private List<Product> allProducts;
    private EditText etSearch;
    private ChipGroup chipGroup;
    private TextView tvCartBadge, tvWishlistBadge;
    private String selectedCategory = "All";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvProducts      = findViewById(R.id.rvProducts);
        etSearch        = findViewById(R.id.etSearch);
        chipGroup       = findViewById(R.id.chipGroup);
        tvCartBadge     = findViewById(R.id.tvCartBadge);
        tvWishlistBadge = findViewById(R.id.tvWishlistBadge);

        allProducts = ProductData.getAllProducts();
        productAdapter = new ProductAdapter(this, new ArrayList<>(allProducts));
        rvProducts.setLayoutManager(new GridLayoutManager(this, 2));
        rvProducts.setAdapter(productAdapter);

        setupCategories();
        setupSearch();

        findViewById(R.id.btnCart).setOnClickListener(v ->
                startActivity(new Intent(this, CartActivity.class)));

        findViewById(R.id.btnWishlist).setOnClickListener(v ->
                startActivity(new Intent(this, WishlistActivity.class)));

        findViewById(R.id.btnOrders).setOnClickListener(v ->
                startActivity(new Intent(this, OrderHistoryActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateBadges();
    }

    private void updateBadges() {
        int cartCount = Cart.getInstance().getTotalItems();
        tvCartBadge.setVisibility(cartCount > 0 ? View.VISIBLE : View.GONE);
        tvCartBadge.setText(String.valueOf(cartCount));

        int wishCount = com.example.shopapp.models.Wishlist.getInstance().getCount();
        tvWishlistBadge.setVisibility(wishCount > 0 ? View.VISIBLE : View.GONE);
        tvWishlistBadge.setText(String.valueOf(wishCount));
    }

    private void setupCategories() {
        for (String category : ProductData.getCategories()) {
            Chip chip = new Chip(this);
            chip.setText(category);
            chip.setCheckable(true);
            chip.setChecked(category.equals("All"));
            chip.setOnClickListener(v -> {
                selectedCategory = category;
                filterProducts();
            });
            chipGroup.addView(chip);
        }
    }

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void onTextChanged(CharSequence s, int start, int before, int count) { filterProducts(); }
            @Override public void afterTextChanged(Editable s) {}
        });
    }

    private void filterProducts() {
        String query = etSearch.getText().toString().toLowerCase().trim();
        List<Product> filtered = new ArrayList<>();
        for (Product p : allProducts) {
            boolean matchesCategory = selectedCategory.equals("All") || p.getCategory().equals(selectedCategory);
            boolean matchesSearch = query.isEmpty() || p.getName().toLowerCase().contains(query);
            if (matchesCategory && matchesSearch) filtered.add(p);
        }
        productAdapter.updateList(filtered);
    }
}
