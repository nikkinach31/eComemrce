package com.example.project.ui.product;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.github.chrisbanes.photoview.PhotoView;

public class ProductDetailsActivity extends AppCompatActivity {

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
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}