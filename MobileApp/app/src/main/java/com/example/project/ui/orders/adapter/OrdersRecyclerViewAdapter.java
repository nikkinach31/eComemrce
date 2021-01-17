package com.example.project.ui.orders.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.ui.orders.model.Orders;

import java.util.List;

public class OrdersRecyclerViewAdapter extends RecyclerView.Adapter<OrdersRecyclerViewAdapter.ViewHolder> {

    private final List<Orders> mOrdersDataList;
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    public OrdersRecyclerViewAdapter(List<Orders> ordersDataList) {
        this.mOrdersDataList = ordersDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Orders orders = mOrdersDataList.get(position);
        holder.tvOrderDate.setText(orders.getOrderDate().toString());
        holder.tvOrderAmount.setText(String.valueOf(orders.getOrderAmount()));

        // Create layout manager with initial prefetch item count
        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.rvOrderItems.getContext(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setInitialPrefetchItemCount(orders.getOrderItems() == null ? 0 : orders.getOrderItems().size());

        // Create sub item view adapter
        OrdersItemsRecyclerViewAdapter ordersItemsRecyclerViewAdapter = new OrdersItemsRecyclerViewAdapter(orders.getOrderItems());

        holder.rvOrderItems.setLayoutManager(layoutManager);
        holder.rvOrderItems.setAdapter(ordersItemsRecyclerViewAdapter);
        holder.rvOrderItems.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return mOrdersDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvOrderDate;
        private final TextView tvOrderAmount;
        private final RecyclerView rvOrderItems;
        private final View rootView;

        public ViewHolder(View view) {
            super(view);
            rootView = view;
            tvOrderDate = view.findViewById(R.id.tv_order_date);
            tvOrderAmount = view.findViewById(R.id.tv_order_price);
            rvOrderItems = view.findViewById(R.id.orders_items_recycle_view);
        }
    }
}