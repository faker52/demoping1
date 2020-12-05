package com.example.demoping1.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoping1.Fruit;
import com.example.demoping1.FruitAdapter;
import com.example.demoping1.R;
import com.example.demoping1.foodTime;
import com.example.demoping1.foodTimeAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private foodTime[] fruits = {new foodTime("早上", R.drawable.morning,"豆浆","油条","粥"),
            new foodTime("中午" , R.drawable.moon1,"米饭","青菜","红烧排骨"),
            new foodTime("晚上", R.drawable.moon2,"面条","白菜"," "),
        };


    private List<foodTime> fruitList = new ArrayList<>();

    private List<Fruit> fruitList1 = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
//获取当前时间
        Date date = new Date(System.currentTimeMillis());
        String str = simpleDateFormat.format(date);
        Fruit time = new Fruit(str.substring(0,12),R.drawable.time1);
        fruitList1.add(time);
        dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        initFruits();
        RecyclerView rl = root.findViewById(R.id.rl);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        rl.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList1,R.layout.card_view_history_time);
        rl.setAdapter(adapter);


        RecyclerView rl1 = root.findViewById(R.id.rl1);
        GridLayoutManager layoutManager1 = new GridLayoutManager(getContext(), 1);
        rl1.setLayoutManager(layoutManager1);
        foodTimeAdapter adapter1 = new foodTimeAdapter(fruitList,R.layout.card_view_history_fo0dname);
        rl1.setAdapter(adapter1);
     //   final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
              //  textView.setText(s);
            }
        });
        return root;
    }

    private void initFruits() {
        fruitList.clear();
        for (int i = 0; i < fruits.length; i++) {
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[i]);
        }
    }

}