package com.example.shopapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.shopapp.R;
import com.example.shopapp.models.Cart;
import com.example.shopapp.models.OrderHistory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class CheckoutActivity extends AppCompatActivity {

    private EditText etName, etEmail, etPhone, etAddress, etCity, etPincode;
    private RadioGroup rgPayment;
    private TextView tvOrderTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        etName     = findViewById(R.id.etName);
        etEmail    = findViewById(R.id.etEmail);
        etPhone    = findViewById(R.id.etPhone);
        etAddress  = findViewById(R.id.etAddress);
        etCity     = findViewById(R.id.etCity);
        etPincode  = findViewById(R.id.etPincode);
        rgPayment  = findViewById(R.id.rgPayment);
        tvOrderTotal = findViewById(R.id.tvOrderTotal);

        double total    = Cart.getInstance().getTotalPrice();
        double shipping = total > 999 ? 0 : 49;
        String shippingNote = (shipping == 0) ? " (Free Shipping!)" : " (incl. ₹49 shipping)";
        tvOrderTotal.setText("Order Total: ₹" + String.format("%,.0f", total + shipping) + shippingNote);

        Button btnPlaceOrder = findViewById(R.id.btnPlaceOrder);
        btnPlaceOrder.setOnClickListener(v -> {
            if (validateInputs()) {
                // Save to order history before clearing cart
                String date = new SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault()).format(new Date());
                OrderHistory.getInstance().addOrder(
                    new ArrayList<>(Cart.getInstance().getItems()),
                    Cart.getInstance().getTotalPrice() + shipping,
                    date
                );

                Cart.getInstance().clear();
                Toast.makeText(this, "🎉 Order placed successfully!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Checkout");
        }
    }

    private boolean validateInputs() {
        if (etName.getText().toString().trim().isEmpty()) {
            etName.setError("Name is required"); etName.requestFocus(); return false;
        }
        if (etEmail.getText().toString().trim().isEmpty()) {
            etEmail.setError("Email is required"); etEmail.requestFocus(); return false;
        }
        if (etPhone.getText().toString().trim().length() < 10) {
            etPhone.setError("Valid phone required"); etPhone.requestFocus(); return false;
        }
        if (etAddress.getText().toString().trim().isEmpty()) {
            etAddress.setError("Address is required"); etAddress.requestFocus(); return false;
        }
        if (etCity.getText().toString().trim().isEmpty()) {
            etCity.setError("City is required"); etCity.requestFocus(); return false;
        }
        if (etPincode.getText().toString().trim().length() < 6) {
            etPincode.setError("Valid pincode required"); etPincode.requestFocus(); return false;
        }
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() { finish(); return true; }
}
