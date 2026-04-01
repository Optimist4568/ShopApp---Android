package com.example.shopapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.R;
import com.example.shopapp.adapters.CartAdapter;
import com.example.shopapp.models.Cart;

public class CartActivity extends AppCompatActivity implements CartAdapter.CartUpdateListener {

    private RecyclerView rvCart;
    private CartAdapter cartAdapter;
    private TextView tvTotal, tvItemCount;
    private LinearLayout layoutEmpty;
    private LinearLayout layoutCartContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rvCart = findViewById(R.id.rvCart);
        tvTotal = findViewById(R.id.tvCartTotal);
        tvItemCount = findViewById(R.id.tvCartItemCount);
        layoutEmpty = findViewById(R.id.layoutEmptyCart);
        layoutCartContent = findViewById(R.id.layoutCartContent);

        rvCart.setLayoutManager(new LinearLayoutManager(this));
        refreshCart();

        findViewById(R.id.btnCheckout).setOnClickListener(v ->
                startActivity(new Intent(this, CheckoutActivity.class)));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("My Cart");
    }

    private void refreshCart() {
        Cart cart = Cart.getInstance();
        boolean isEmpty = cart.getItems().isEmpty();

        layoutEmpty.setVisibility(isEmpty ? View.VISIBLE : View.GONE);
        layoutCartContent.setVisibility(isEmpty ? View.GONE : View.VISIBLE);

        if (!isEmpty) {
            cartAdapter = new CartAdapter(this, cart.getItems(), this);
            rvCart.setAdapter(cartAdapter);
            tvTotal.setText("₹" + String.format("%,.0f", cart.getTotalPrice()));
            tvItemCount.setText(cart.getTotalItems() + " item(s)");
        }
    }

    @Override
    public void onCartUpdated() { refreshCart(); }

    @Override
    public boolean onSupportNavigateUp() { finish(); return true; }
}
