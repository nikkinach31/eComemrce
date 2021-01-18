package com.example.project.ui.cart.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.ui.cart.CartActivity;
import com.example.project.ui.cart.model.Cart;

import java.util.List;

public class CartRecyclerVewAdapter extends RecyclerView.Adapter<CartRecyclerVewAdapter.ViewHolder> {

    private final List<Cart> mCartDataList;
    private final CartActivity cartActivity;


    public CartRecyclerVewAdapter(List<Cart> cartDataList, CartActivity cartActivity) {
        this.mCartDataList = cartDataList;
        this.cartActivity = cartActivity;
    }

    @NonNull
    @Override
    public CartRecyclerVewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_product_item, parent, false);
        return new CartRecyclerVewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartRecyclerVewAdapter.ViewHolder holder, int position) {
        Cart cart = mCartDataList.get(position);
        Glide.with(holder.ivCartProduct.getContext()).load(cart.getImageURL()).placeholder(R.drawable.placeholder).into(holder.ivCartProduct);
        holder.tvCartProductName.setText(cart.getProductName());
        holder.tvCartProductPrice.setText(String.valueOf(cart.getPrice()));
        holder.btnRemoveItem.setOnClickListener(v -> {
            //******************************************************************************
            // --> API call to remove cart item
            //******************************************************************************
        });
    }

    @Override
    public int getItemCount() {
        return mCartDataList == null ? 0 : mCartDataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivCartProduct;
        private final TextView tvCartProductName;
        private final TextView tvCartProductPrice;
        private final Button btnRemoveItem;
        //        private final Button btnCartQtyDec;
//        private final Button btnCartQtyInc;
//        private final TextView tvCartProdQty;
        private final View rootView;

        public ViewHolder(View view) {
            super(view);
            rootView = view;
            ivCartProduct = view.findViewById(R.id.iv_cart_prod);
            tvCartProductName = view.findViewById(R.id.tv__cart_prod_name);
            tvCartProductPrice = view.findViewById(R.id.tv_detail_prod_price);
            btnRemoveItem = view.findViewById(R.id.btn_remove_cart_item);
//            btnCartQtyDec = view.findViewById(R.id.btn_cart_qty_dec);
//            btnCartQtyInc = view.findViewById(R.id.btn_cart_qty_inc);
//            tvCartProdQty = view.findViewById(R.id.tv_cart_prod_qty);
        }
    }
}