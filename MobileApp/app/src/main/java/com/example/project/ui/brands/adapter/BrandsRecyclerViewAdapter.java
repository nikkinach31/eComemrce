package com.example.project.ui.brands.adapter;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.ui.brands.BrandsFragment;
import com.example.project.ui.brands.model.Brands;

import java.util.List;

public class BrandsRecyclerViewAdapter extends RecyclerView.Adapter<BrandsRecyclerViewAdapter.ViewHolder> {

    private final List<Brands> mBrandsDataList;
    private final BrandsFragment brandsFragment;

    public BrandsRecyclerViewAdapter(List<Brands> mBrandsDataList, BrandsFragment brandsFragment) {
        this.mBrandsDataList = mBrandsDataList;
        this.brandsFragment = brandsFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.brand_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Brands brands = mBrandsDataList.get(position);
        holder.rootView.getBackground().setColorFilter(Color.parseColor(brands.getBgColor()), PorterDuff.Mode.DARKEN);
        holder.tvBrandName.setText(brands.getName());
        Glide.with(holder.ivBrandImg.getContext()).load(brands.getImageUrl()).placeholder(R.drawable.placeholder).into(holder.ivBrandImg);
        holder.rootView.setOnClickListener((view -> brandsFragment.onUserClick(brands)));
    }

    @Override
    public int getItemCount() {
        return mBrandsDataList.size();
    }

    public interface UserDataInterface {
        void onUserClick(Brands brands);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvBrandName;
        private final ImageView ivBrandImg;
        private final View rootView;

        public ViewHolder(View view) {
            super(view);
            rootView = view;
            tvBrandName = view.findViewById(R.id.tv_brand_name);
            ivBrandImg = view.findViewById(R.id.iv_brand_logo);
        }
    }
}
