package com.example.project.ui.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.networkmanager.RetrofitBuilder;
import com.example.project.ui.product.adapter.MerchantRecyclerViewAdapter;
import com.example.project.ui.product.model.Cart;
import com.example.project.ui.product.model.Merchants;
import com.example.project.ui.product.network.ICartApi;
import com.example.project.ui.product.network.IMerchantApi;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProductDetailsActivity extends AppCompatActivity implements MerchantRecyclerViewAdapter.UserDataInterface {

    int prod_qty_counter = 1;
    Cart cart = new Cart();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_product_detail);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        TextView tvProdName = findViewById(R.id.tv_detail_prod_name);
        TextView tvProdPrice = findViewById(R.id.tv_detail_prod_price);
        RatingBar prodRatingBar = findViewById(R.id.ratingBar_detail_product);
        PhotoView ivProd = findViewById(R.id.iv_details_prod);
        TextView tvProdId = findViewById(R.id.tv_prodId);
        TextView tvProdColor = findViewById(R.id.tv_prodColor);
        TextView tvProdMemory = findViewById(R.id.tv_prodMemory);
        TextView tvProdCamera = findViewById(R.id.tv_prodCamera);

        tvProdName.setText(getIntent().getStringExtra("prodName"));
        tvProdPrice.setText(String.valueOf(getIntent().getDoubleExtra("prodPrice", 0)));
        prodRatingBar.setRating(getIntent().getFloatExtra("prodRating", 0));
        Glide.with(ivProd.getContext()).load(getIntent().getStringExtra("prodImage")).placeholder(R.drawable.placeholder).into(ivProd);
        tvProdId.setText(String.valueOf(getIntent().getIntExtra("prodId", 0)));
        tvProdColor.setText(getIntent().getStringExtra("prodColor"));
        tvProdMemory.setText(getIntent().getStringExtra("prodMemory"));
        tvProdCamera.setText(getIntent().getStringExtra("prodCamera"));

        ivProd.setOnClickListener(View -> {
            Intent intent = new Intent(this, ProductImageActivity.class);
            intent.putExtra("prodZoomImage", getIntent().getStringExtra("prodImage"));
            startActivity(intent);
        });

        TextView prod_qty = findViewById(R.id.tv_prod_qty);
        findViewById(R.id.btn_prod_qty_dec).setOnClickListener(v -> {
            if (prod_qty_counter > 1) {
                prod_qty_counter--;
                prod_qty.setText(String.valueOf(prod_qty_counter));
            } else {
                Toast.makeText(this, "Quantity Cannot Be Less Than 1", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_prod_qty_inc).setOnClickListener(v -> {
            prod_qty_counter++;
            prod_qty.setText(String.valueOf(prod_qty_counter));
        });

        findViewById(R.id.btn_addToCart).setOnClickListener(v -> {
            Retrofit retrofit = RetrofitBuilder.getInstance();
            ICartApi iCartApi = retrofit.create(ICartApi.class);

            cart.setUserId(0);
            cart.setProductId(Integer.parseInt(tvProdId.getText().toString()));
            cart.setProductName(tvProdName.getText().toString());
            cart.setMerchantId(1);
            cart.setPrice(Double.parseDouble(tvProdPrice.getText().toString()));
            cart.setQuantity(Integer.parseInt(prod_qty.getText().toString()));
            cart.setImageURL(getIntent().getStringExtra("prodImage"));

            Call<Cart> cartResponse = iCartApi.postCart(cart);
            cartResponse.enqueue(new Callback<Cart>() {
                @Override
                public void onResponse(Call<Cart> call, Response<Cart> response) {
                    Log.d("CartAdd", "Added to cart");
                }

                @Override
                public void onFailure(Call<Cart> call, Throwable t) {
                    Toast.makeText(ProductDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        });

        int prodId = Integer.parseInt(tvProdId.getText().toString());
        initApi(prodId);
    }

    @Override
    public void onUserClick(Merchants merchant) {
//        ******************************************************************************
//        -- > API call to select merchant
//        ******************************************************************************
    }

    private void initApi(int prodId) {
        Retrofit retrofit = RetrofitBuilder.getInstance();
        IMerchantApi iMerchantApi = retrofit.create(IMerchantApi.class);
        Call<List<Merchants>> responses = iMerchantApi.getMerchants(prodId);
        responses.enqueue(new Callback<List<Merchants>>() {
            @Override
            public void onResponse(Call<List<Merchants>> call, retrofit2.Response<List<Merchants>> merchantData) {
                List<Merchants> merchantsList = merchantData.body();

                //fetching the id of recycler view
                RecyclerView recyclerView = findViewById(R.id.recycleView_merchants);
                MerchantRecyclerViewAdapter merchantRecyclerViewAdapter = new MerchantRecyclerViewAdapter(merchantsList, ProductDetailsActivity.this);

                //setting Linear Layout manager in the recycler view
                recyclerView.setLayoutManager(new LinearLayoutManager(ProductDetailsActivity.this));
                recyclerView.setAdapter(merchantRecyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<Merchants>> call, Throwable t) {
                Toast.makeText(ProductDetailsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}