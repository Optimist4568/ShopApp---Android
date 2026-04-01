package com.example.shopapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shopapp.R;
import com.example.shopapp.activities.ProductDetailActivity;
import com.example.shopapp.models.Cart;
import com.example.shopapp.models.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    public void updateList(List<Product> newList) {
        productList = newList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        holder.tvEmoji.setText(product.getEmoji());
        holder.tvName.setText(product.getName());
        holder.tvCategory.setText(product.getCategory());
        holder.tvPrice.setText("₹" + String.format("%,.0f", product.getPrice()));
        holder.tvRating.setText("⭐ " + product.getRating() + " (" + product.getReviewCount() + ")");

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ProductDetailActivity.class);
            intent.putExtra("product_id", product.getId());
            context.startActivity(intent);
        });

        holder.btnAddToCart.setOnClickListener(v -> {
            Cart.getInstance().addProduct(product);
            Toast.makeText(context, product.getName() + " added to cart!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() { return productList.size(); }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tvEmoji, tvName, tvCategory, tvPrice, tvRating;
        Button btnAddToCart;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvEmoji    = itemView.findViewById(R.id.tvProductEmoji);
            tvName     = itemView.findViewById(R.id.tvProductName);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvPrice    = itemView.findViewById(R.id.tvPrice);
            tvRating   = itemView.findViewById(R.id.tvRating);
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart);
        }
    }
}
