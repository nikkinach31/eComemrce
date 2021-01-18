package com.example.project.ui.product;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.project.R;
import com.github.chrisbanes.photoview.PhotoView;

public class ProductImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_image);

        String prodImage = getIntent().getStringExtra("prodZoomImage");
        PhotoView photoView = findViewById(R.id.photoView_prodImg);
        Glide.with(this).load(prodImage).placeholder(R.drawable.placeholder).into(photoView);
    }
}