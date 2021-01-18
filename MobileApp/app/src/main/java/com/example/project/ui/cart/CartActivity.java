package com.example.project.ui.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project.R;
import com.example.project.networkmanager.RetrofitBuilder;
import com.example.project.ui.cart.adapter.CartRecyclerVewAdapter;
import com.example.project.ui.cart.model.Cart;
import com.example.project.ui.cart.model.CartTotal;
import com.example.project.ui.cart.network.ICartApi;
import com.example.project.ui.checkout.CheckoutActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_cart);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        findViewById(R.id.btn_checkout).setOnClickListener(v -> {
            startActivity(new Intent(this, CheckoutActivity.class));
        });

        initApi();
    }

    private void initApi() {
        Retrofit retrofit = RetrofitBuilder.getInstance();
        ICartApi iCartApi = retrofit.create(ICartApi.class);
        Call<List<Cart>> cartResponses = iCartApi.getCart(0);
        Call<CartTotal> cartTotalCall = iCartApi.getCartTotal(0);
        cartResponses.enqueue(new Callback<List<Cart>>() {
            @Override
            public void onResponse(Call<List<Cart>> call, retrofit2.Response<List<Cart>> cartData) {

                //fetching the id of recycler view
                RecyclerView recyclerView = findViewById(R.id.cart_recycle_view);
                CartRecyclerVewAdapter cartRecyclerVewAdapter = new CartRecyclerVewAdapter(cartData.body(), CartActivity.this);

                //setting Linear Layout manager in the recycler view
                recyclerView.setLayoutManager(new LinearLayoutManager(CartActivity.this));
                recyclerView.setAdapter(cartRecyclerVewAdapter);
            }

            @Override
            public void onFailure(Call<List<Cart>> call, Throwable t) {
                Toast.makeText(CartActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        cartTotalCall.enqueue(new Callback<CartTotal>() {
            @Override
            public void onResponse(Call<CartTotal> call, Response<CartTotal> response) {
                CartTotal cartTotal = response.body();
                TextView tvCartTotal = findViewById(R.id.total_price);
                tvCartTotal.setText(cartTotal == null ? "0.00" : String.valueOf(cartTotal.getTotalAmount()));
            }

            @Override
            public void onFailure(Call<CartTotal> call, Throwable t) {
                Toast.makeText(CartActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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