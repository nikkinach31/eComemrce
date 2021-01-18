package com.example.project.ui.brands.brandactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.example.project.networkmanager.RetrofitBuilder;
import com.example.project.ui.brands.brandactivity.adapter.BrandProductsRecyclerViewAdapter;
import com.example.project.ui.brands.brandactivity.model.BrandProducts;
import com.example.project.ui.brands.brandactivity.network.IBrandProdApi;
import com.example.project.ui.product.ProductDetailsActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class BrandPageActivity extends AppCompatActivity implements BrandProductsRecyclerViewAdapter.UserDataInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_page);
        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar_brand);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        toolbar.setTitle(getIntent().getStringExtra("brandName"));

        ImageView brandImage = findViewById(R.id.iv_brand_page);
        Glide.with(brandImage.getContext()).load(getIntent().getStringExtra("pageImage")).placeholder(R.drawable.placeholder).into(brandImage);

        initApi();
    }

    @Override
    public void onUserClick(BrandProducts brandProduct) {
        Intent intent = new Intent(this, ProductDetailsActivity.class);
        intent.putExtra("prodName", brandProduct.getModelName());
        intent.putExtra("prodPrice", brandProduct.getPrice());
        intent.putExtra("prodRating", brandProduct.getRating());
        intent.putExtra("prodImage", brandProduct.getImage());
        intent.putExtra("prodId", brandProduct.getProductId());
        intent.putExtra("prodColor", brandProduct.getColor());
        intent.putExtra("prodMemory", brandProduct.getMemory());
        intent.putExtra("prodCamera", brandProduct.getCamera());
        startActivity(intent);
    }

    private void initApi() {
        Retrofit retrofit = RetrofitBuilder.getInstance();
        IBrandProdApi iBrandProdApi = retrofit.create(IBrandProdApi.class);
        Call<List<BrandProducts>> responses = iBrandProdApi.getBrandProducts();
        responses.enqueue(new Callback<List<BrandProducts>>() {
            @Override
            public void onResponse (Call<List<BrandProducts>> call, retrofit2.Response<List<BrandProducts>> productData) {

                //fetching the id of recycler view
                RecyclerView recyclerView = findViewById(R.id.brand_prod_recycle_view);
                BrandProductsRecyclerViewAdapter brandProductsRecyclerViewAdapter = new BrandProductsRecyclerViewAdapter(productData.body(), BrandPageActivity.this);

                //setting Grid Layout manager in the recycler view
                recyclerView.setLayoutManager(new GridLayoutManager(BrandPageActivity.this, 2));
                recyclerView.setAdapter(brandProductsRecyclerViewAdapter);

            }

            @Override
            public void onFailure (Call<List<BrandProducts>> call, Throwable t) {
                Toast.makeText(BrandPageActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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