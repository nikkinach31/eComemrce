package com.example.project.ui.orders.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.ui.orders.model.OrderItems;

import java.util.List;

public class OrdersItemsRecyclerViewAdapter extends RecyclerView.Adapter<OrdersItemsRecyclerViewAdapter.ItemViewHolder> {


    private List<OrderItems> orderItems;

    OrdersItemsRecyclerViewAdapter(List<OrderItems> orderItemsList) {
        this.orderItems = orderItemsList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_history_prod_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        OrderItems orderItem = orderItems.get(position);
        Glide.with(holder.ivOrderItemProd.getContext()).load(orderItem.getImage()).placeholder(R.drawable.placeholder).into(holder.ivOrderItemProd);
        holder.tvOrderItemName.setText(orderItem.getModelName());
        holder.tvOrderItemPrice.setText(String.valueOf(orderItem.getPrice()));
        holder.tvOrderItemQty.setText(String.valueOf(orderItem.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return orderItems == null ? 0 : orderItems.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivOrderItemProd;
        private final TextView tvOrderItemName;
        private final TextView tvOrderItemPrice;
        private final TextView tvOrderItemQty;
        private final RatingBar ratingBarOrderItem;
        private final Button btnGiveRating;
        private final View itemRootView;

        ItemViewHolder(View itemView) {
            super(itemView);
            itemRootView = itemView;
            ivOrderItemProd = itemView.findViewById(R.id.iv_order_prod);
            tvOrderItemName = itemView.findViewById(R.id.tv_order_prod_name);
            tvOrderItemPrice = itemView.findViewById(R.id.tv_order_prod_price);
            tvOrderItemQty = itemView.findViewById(R.id.tv_order_item_qty);
            ratingBarOrderItem = itemView.findViewById(R.id.ratingBar_product);
            btnGiveRating = itemView.findViewById(R.id.btn_give_rating);
        }

    }
}