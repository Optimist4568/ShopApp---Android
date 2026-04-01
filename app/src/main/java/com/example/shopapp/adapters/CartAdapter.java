package com.example.shopapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.R;
import com.example.shopapp.models.Cart;
import com.example.shopapp.models.CartItem;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private Context context;
    private List<CartItem> cartItems;
    private CartUpdateListener listener;

    public interface CartUpdateListener {
        void onCartUpdated();
    }

    public CartAdapter(Context context, List<CartItem> cartItems, CartUpdateListener listener) {
        this.context = context;
        this.cartItems = cartItems;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem item = cartItems.get(position);

        holder.tvEmoji.setText(item.getProduct().getEmoji());
        holder.tvName.setText(item.getProduct().getName());
        holder.tvPrice.setText("₹" + String.format("%,.0f", item.getProduct().getPrice()));
        holder.tvQuantity.setText(String.valueOf(item.getQuantity()));
        holder.tvSubtotal.setText("₹" + String.format("%,.0f", item.getTotalPrice()));

        holder.btnIncrease.setOnClickListener(v -> {
            Cart.getInstance().updateQuantity(item.getProduct().getId(), item.getQuantity() + 1);
            listener.onCartUpdated();
        });

        holder.btnDecrease.setOnClickListener(v -> {
            Cart.getInstance().updateQuantity(item.getProduct().getId(), item.getQuantity() - 1);
            listener.onCartUpdated();
        });

        holder.btnRemove.setOnClickListener(v -> {
            Cart.getInstance().removeItem(item.getProduct().getId());
            listener.onCartUpdated();
        });
    }

    @Override
    public int getItemCount() { return cartItems.size(); }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView tvEmoji, tvName, tvPrice, tvQuantity, tvSubtotal;
        ImageButton btnIncrease, btnDecrease, btnRemove;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmoji    = itemView.findViewById(R.id.tvCartEmoji);
            tvName     = itemView.findViewById(R.id.tvCartProductName);
            tvPrice    = itemView.findViewById(R.id.tvCartPrice);
            tvQuantity = itemView.findViewById(R.id.tvCartQuantity);
            tvSubtotal = itemView.findViewById(R.id.tvCartSubtotal);
            btnIncrease = itemView.findViewById(R.id.btnIncrease);
            btnDecrease = itemView.findViewById(R.id.btnDecrease);
            btnRemove   = itemView.findViewById(R.id.btnRemoveItem);
        }
    }
}
