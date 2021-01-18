package com.example.project.ui.brands;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.ui.brands.adapter.BrandsRecyclerViewAdapter;
import com.example.project.ui.brands.brandactivity.BrandPageActivity;
import com.example.project.ui.brands.model.Brands;

import java.util.ArrayList;
import java.util.List;

public class BrandsFragment extends Fragment implements BrandsRecyclerViewAdapter.UserDataInterface {

    private BrandsViewModel brandsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        brandsViewModel = new ViewModelProvider(this).get(BrandsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_brands, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Brands> brandsDataList = new ArrayList<>();
        generateUserData(brandsDataList);

        //fetching the id of recycler view
        RecyclerView recyclerView = getView().findViewById(R.id.brand_recycle_view);

        BrandsRecyclerViewAdapter brandsRecyclerViewAdapter = new BrandsRecyclerViewAdapter(brandsDataList, BrandsFragment.this);

        //setting Linear Layout manager in the recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(brandsRecyclerViewAdapter);
    }

    @Override
    public void onUserClick(Brands brands) {
        Intent intent = new Intent(getContext(), BrandPageActivity.class);
        intent.putExtra("brandName", brands.getName());
        intent.putExtra("pageImage", brands.getImageUrl());
        startActivity(intent);
    }

    private void generateUserData(List<Brands> brandsDataList) {
        brandsDataList.add(new Brands("Apple", Uri.parse("android.resource://" + R.class.getPackage().getName() + "/" + R.drawable.apple).toString(), "#F3948E"));
        brandsDataList.add(new Brands("OnePlus", Uri.parse("android.resource://" + R.class.getPackage().getName() + "/" + R.drawable.oneplus).toString(), "#DEE883"));
        brandsDataList.add(new Brands("Sony", Uri.parse("android.resource://" + R.class.getPackage().getName() + "/" + R.drawable.sony).toString(), "#72B7ED"));
        brandsDataList.add(new Brands("Samsung", Uri.parse("android.resource://" + R.class.getPackage().getName() + "/" + R.drawable.samsung).toString(), "#E8CC79"));
        brandsDataList.add(new Brands("Xiaomi", Uri.parse("android.resource://" + R.class.getPackage().getName() + "/" + R.drawable.xiaomi).toString(), "#BC94F3"));
    }
}