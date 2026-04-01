package com.example.shopapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.R;
import com.example.shopapp.models.CartItem;
import com.example.shopapp.models.Order;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    private Context context;
    private List<Order> orders;

    public OrderAdapter(Context context, List<Order> orders) {
        this.context = context;
        this.orders = orders;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_order, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        Order order = orders.get(position);

        holder.tvOrderId.setText(order.getOrderId());
        holder.tvOrderDate.setText(order.getDate());
        holder.tvOrderStatus.setText(order.getStatus());
        holder.tvOrderTotal.setText("Total: ₹" + String.format("%,.0f", order.getTotalPrice()));

        // Build item summary inside the order card
        holder.layoutOrderItems.removeAllViews();
        for (CartItem item : order.getItems()) {
            TextView tv = new TextView(context);
            tv.setText(item.getProduct().getEmoji() + "  " + item.getProduct().getName()
                    + "  x" + item.getQuantity()
                    + "   ₹" + String.format("%,.0f", item.getTotalPrice()));
            tv.setTextSize(13f);
            tv.setTextColor(0xFF616161);
            tv.setPadding(0, 4, 0, 4);
            holder.layoutOrderItems.addView(tv);
        }
    }

    @Override
    public int getItemCount() { return orders.size(); }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView tvOrderId, tvOrderDate, tvOrderStatus, tvOrderTotal;
        LinearLayout layoutOrderItems;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOrderId      = itemView.findViewById(R.id.tvOrderId);
            tvOrderDate    = itemView.findViewById(R.id.tvOrderDate);
            tvOrderStatus  = itemView.findViewById(R.id.tvOrderStatus);
            tvOrderTotal   = itemView.findViewById(R.id.tvOrderTotal);
            layoutOrderItems = itemView.findViewById(R.id.layoutOrderItems);
        }
    }
}
