package com.example.project.ui.product.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.ui.product.ProductDetailsActivity;
import com.example.project.ui.product.model.Merchants;

import java.util.List;

public class MerchantRecyclerViewAdapter extends RecyclerView.Adapter<MerchantRecyclerViewAdapter.ViewHolder> {

    private final List<Merchants> mMerchantDataList;
    private final ProductDetailsActivity productDetailsActivity;


    public MerchantRecyclerViewAdapter(List<Merchants> merchantDataList, ProductDetailsActivity productDetailsActivity) {
        this.mMerchantDataList = merchantDataList;
        this.productDetailsActivity = productDetailsActivity;
    }

    @NonNull
    @Override
    public MerchantRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_merchant, parent, false);
        return new MerchantRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MerchantRecyclerViewAdapter.ViewHolder holder, int position) {
        Log.d("CartResponse", "merchant adapter");
        Merchants merchant = mMerchantDataList.get(position);
        holder.tvMerchantId.setText(String.valueOf(merchant.getMerchantId()));
        holder.tvMerchantPrice.setText(String.valueOf(merchant.getMerchantPrice()));
        holder.rootView.setOnClickListener((view -> productDetailsActivity.onUserClick(merchant)));
    }

    @Override
    public int getItemCount() {
        return mMerchantDataList == null ? 0 : mMerchantDataList.size();
    }

    public interface UserDataInterface {
        void onUserClick(Merchants merchant);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvMerchantId;
        private final TextView tvMerchantPrice;
        private final View rootView;

        public ViewHolder(View view) {
            super(view);
            rootView = view;
            tvMerchantId = view.findViewById(R.id.tv_merchant_id);
            tvMerchantPrice = view.findViewById(R.id.tv_merchant_price);
        }
    }
}