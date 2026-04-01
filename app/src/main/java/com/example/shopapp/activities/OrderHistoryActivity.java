package com.example.shopapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.R;
import com.example.shopapp.adapters.OrderAdapter;
import com.example.shopapp.models.OrderHistory;

public class OrderHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);

        RecyclerView rvOrders = findViewById(R.id.rvOrders);
        LinearLayout layoutEmpty = findViewById(R.id.layoutEmptyOrders);

        if (OrderHistory.getInstance().isEmpty()) {
            layoutEmpty.setVisibility(View.VISIBLE);
            rvOrders.setVisibility(View.GONE);
        } else {
            layoutEmpty.setVisibility(View.GONE);
            rvOrders.setVisibility(View.VISIBLE);
            rvOrders.setLayoutManager(new LinearLayoutManager(this));
            rvOrders.setAdapter(new OrderAdapter(this, OrderHistory.getInstance().getOrders()));
        }

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("My Orders");
        }
    }

    @Override
    public boolean onSupportNavigateUp() { finish(); return true; }
}
