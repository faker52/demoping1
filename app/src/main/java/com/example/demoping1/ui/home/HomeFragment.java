package com.example.demoping1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoping1.Fruit;
import com.example.demoping1.FruitAdapter;
import com.example.demoping1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Fruit[] fruits = {new Fruit("蛋白质：10%", R.drawable.protein1),
            new Fruit("铁：10%", R.drawable.iron),
            new Fruit("脂肪：10%", R.drawable.zhifang),
            new Fruit("碳水化合物：10%", R.drawable.tanshui),
            new Fruit("钾：10mg", R.drawable.jiayuansu),
            new Fruit("钙：10%", R.drawable.ca),
            new Fruit("磷：10%", R.drawable.lin),
            new Fruit("胆固醇：10%", R.drawable.dangucun),
            new Fruit("能量：100焦耳",R.drawable.power1)};
    private List<Fruit> fruitList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        initFruits();
        RecyclerView rl = root.findViewById(R.id.rl_home);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        rl.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList,R.layout.cardview_text);
        rl.setAdapter(adapter);

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                //textView.setText(s);
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