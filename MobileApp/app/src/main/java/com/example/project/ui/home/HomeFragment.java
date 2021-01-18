package com.example.project.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.networkmanager.RetrofitBuilder;
import com.example.project.ui.home.adapter.HomeRecyclerViewAdapter;
import com.example.project.ui.home.model.Products;
import com.example.project.ui.home.network.IProdApi;
import com.example.project.ui.product.ProductDetailsActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class HomeFragment extends Fragment implements HomeRecyclerViewAdapter.UserDataInterface {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initApi();
    }

    @Override
    public void onUserClick(Products product) {
        Intent intent = new Intent(getContext(), ProductDetailsActivity.class);
        intent.putExtra("prodName", product.getName());
        intent.putExtra("prodPrice", product.getPrice());
        intent.putExtra("prodModelName", product.getModelName());
        intent.putExtra("prodRating", product.getRating());
        intent.putExtra("prodImage", product.getProductImage());
        intent.putExtra("prodId", product.getProductId());
        intent.putExtra("prodColor", product.getColor());
        intent.putExtra("prodMemory", product.getMemory());
        intent.putExtra("prodCamera", product.getCamera());
        startActivity(intent);
    }

    private void initApi() {
        Retrofit retrofit = RetrofitBuilder.getInstance();
        IProdApi iProdApi = retrofit.create(IProdApi.class);
        Call<List<Products>> productCall = iProdApi.getProducts();
        productCall.enqueue(new Callback<List<Products>>() {
            @Override
            public void onResponse(Call<List<Products>> call, retrofit2.Response<List<Products>> productData) {

                //fetching the id of recycler view
                RecyclerView recyclerView = getView().findViewById(R.id.home_recycle_view);
                HomeRecyclerViewAdapter homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(productData.body(), HomeFragment.this);

                //setting Grid Layout manager in the recycler view
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
                recyclerView.setAdapter(homeRecyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}