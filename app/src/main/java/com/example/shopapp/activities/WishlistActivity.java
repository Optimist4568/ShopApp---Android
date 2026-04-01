package com.example.shopapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.R;
import com.example.shopapp.adapters.ProductAdapter;
import com.example.shopapp.models.Wishlist;

public class WishlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);

        RecyclerView rvWishlist = findViewById(R.id.rvWishlist);
        LinearLayout layoutEmpty = findViewById(R.id.layoutEmptyWishlist);

        if (Wishlist.getInstance().getItems().isEmpty()) {
            layoutEmpty.setVisibility(View.VISIBLE);
            rvWishlist.setVisibility(View.GONE);
        } else {
            layoutEmpty.setVisibility(View.GONE);
            rvWishlist.setVisibility(View.VISIBLE);
            rvWishlist.setLayoutManager(new GridLayoutManager(this, 2));
            rvWishlist.setAdapter(new ProductAdapter(this, Wishlist.getInstance().getItems()));
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My Wishlist ❤️");
        }
    }

    @Override
    public boolean onSupportNavigateUp() { finish(); return true; }
}
