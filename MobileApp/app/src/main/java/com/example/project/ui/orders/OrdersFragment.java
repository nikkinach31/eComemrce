package com.example.project.ui.orders;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project.R;
import com.example.project.networkmanager.RetrofitBuilder;
import com.example.project.ui.orders.adapter.OrdersRecyclerViewAdapter;
import com.example.project.ui.orders.model.OrderItems;
import com.example.project.ui.orders.model.Orders;
import com.example.project.ui.orders.network.IOrdersApi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

public class OrdersFragment extends Fragment {

    private OrdersViewModel ordersViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ordersViewModel = new ViewModelProvider(this).get(OrdersViewModel.class);
        View root = inflater.inflate(R.layout.fragment_orders, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

////        --------------------------------------------------------------------
////        --------------------------------------------------------------------
//
//        initApi();
//    }
//
//    private void initApi() {
//        Retrofit retrofit = RetrofitBuilder.getInstance();
//        IOrdersApi iOrdersApi = retrofit.create(IOrdersApi.class);
//        Call<List<Orders>> ordersCall = iOrdersApi.getOrders();
//        ordersCall.enqueue(new Callback<List<Orders>>() {
//            @Override
//            public void onResponse(Call<List<Orders>> call, retrofit2.Response<List<Orders>> ordersData) {
//
//                //fetching the id of recycler view
//                RecyclerView recyclerView = getView().findViewById(R.id.orders_recycle_view);
//                OrdersRecyclerViewAdapter ordersRecyclerViewAdapter = new OrdersRecyclerViewAdapter(ordersData.body());
//
//                //setting Linear Layout manager in the recycler view
//                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//                recyclerView.setAdapter(ordersRecyclerViewAdapter);
//            }
//
//            @Override
//            public void onFailure(Call<List<Orders>> call, Throwable t) {
//                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}

//        ---------------------------------------------------------------------
//        ---------------------------------------------------------------------
        List<Orders> ordersDataList = new ArrayList<>();
        generateUserData(ordersDataList);

        //fetching the id of recycler view
        RecyclerView recyclerView = getView().findViewById(R.id.orders_recycle_view);

        OrdersRecyclerViewAdapter ordersRecyclerViewAdapter = new OrdersRecyclerViewAdapter(ordersDataList);

        //setting Grid Layout manager in the recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(ordersRecyclerViewAdapter);
    }

    private void generateUserData(List<Orders> ordersDataList) {
        List<OrderItems> orderItems1 = new ArrayList<>();
        orderItems1.add(new OrderItems("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGpKRV-DZvEofQY2iZvdfXj4NirTuvnQBbpFTcwc071R_1ljkYaRdsU7k7wLeGdIfJm5IdN0o4gw&usqp=CAc", "Apple iPhone 7", 23456789, 2));

        List<OrderItems> orderItems2 = new ArrayList<>();
        orderItems2.add(new OrderItems("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGpKRV-DZvEofQY2iZvdfXj4NirTuvnQBbpFTcwc071R_1ljkYaRdsU7k7wLeGdIfJm5IdN0o4gw&usqp=CAc", "Apple iPhone 9", 2345678, 7));
        orderItems2.add(new OrderItems("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQGpKRV-DZvEofQY2iZvdfXj4NirTuvnQBbpFTcwc071R_1ljkYaRdsU7k7wLeGdIfJm5IdN0o4gw&usqp=CAc", "Samsung Galaxy 9", 12345, 8));


        ordersDataList.add(new Orders(12345678, new Date(), orderItems1));
        ordersDataList.add(new Orders(456789, new Date(), orderItems2));
    }
}