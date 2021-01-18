package com.example.project.ui.brands.brandactivity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.ui.brands.brandactivity.BrandPageActivity;
import com.example.project.ui.brands.brandactivity.model.BrandProducts;

import java.util.List;

public class BrandProductsRecyclerViewAdapter extends RecyclerView.Adapter<BrandProductsRecyclerViewAdapter.ViewHolder> {

    private final List<BrandProducts> mBrandProductDataList;
    private final BrandPageActivity brandPageActivity;


    public BrandProductsRecyclerViewAdapter(List<BrandProducts> brandProductDataList, BrandPageActivity brandPageActivity) {
        this.mBrandProductDataList = brandProductDataList;
        this.brandPageActivity = brandPageActivity;
    }

    @NonNull
    @Override
    public BrandProductsRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new BrandProductsRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandProductsRecyclerViewAdapter.ViewHolder holder, int position) {
        BrandProducts brandProduct = mBrandProductDataList.get(position);
        Glide.with(holder.ivProduct.getContext()).load(brandProduct.getProductImage()).placeholder(R.drawable.placeholder).into(holder.ivProduct);
        holder.tvProductName.setText(brandProduct.getName());
        holder.tvProductPrice.setText(brandProduct.getPrice()+"");
        holder.rootView.setOnClickListener((view -> brandPageActivity.onUserClick(brandProduct)));
    }

    @Override
    public int getItemCount() {
        return mBrandProductDataList == null ? 0 : mBrandProductDataList.size();
    }

    public interface UserDataInterface {
        void onUserClick(BrandProducts brandProduct);
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