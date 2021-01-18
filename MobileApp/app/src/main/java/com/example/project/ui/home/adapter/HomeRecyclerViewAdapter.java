package com.example.project.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.ui.home.HomeFragment;
import com.example.project.ui.home.model.Products;

import java.util.List;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder> {

    private final List<Products> mProductDataList;
    private final HomeFragment homeFragment;


    public HomeRecyclerViewAdapter(List<Products> productDataList, HomeFragment homeFragment) {
        this.mProductDataList = productDataList;
        this.homeFragment = homeFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Products product = mProductDataList.get(position);
        Glide.with(holder.ivProduct.getContext()).load(product.getProductImage()).placeholder(R.drawable.placeholder).into(holder.ivProduct);
        holder.tvProductName.setText(product.getName());
        holder.tvProductPrice.setText(product.getPrice()+"");
        holder.rootView.setOnClickListener((view -> homeFragment.onUserClick(product)));
    }

    @Override
    public int getItemCount() {
        return mProductDataList == null ? 0 : mProductDataList.size();
    }

    public interface UserDataInterface {
        void onUserClick(Products product);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivProduct;
        private final TextView tvProductName;
        private final TextView tvProductPrice;
        private final View rootView;

        public ViewHolder(View view) {
            super(view);
            rootView = view;
            ivProduct = view.findViewById(R.id.iv_prod);
            tvProductName = view.findViewById(R.id.tv_prod_name);
            tvProductPrice = view.findViewById(R.id.tv_prod_price);
        }
    }
}
