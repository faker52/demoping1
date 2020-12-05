package com.example.demoping1.ui.doctor;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.demoping1.Doctor;
import com.example.demoping1.DoctorAdapter;
import com.example.demoping1.DoctorinitAdapter;
import com.example.demoping1.Fruit;
import com.example.demoping1.FruitAdapter;
import com.example.demoping1.R;
import com.example.demoping1.iniDoctor;
import com.example.demoping1.ui.dashboard.DashboardViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DoctorFragment extends Fragment {
    private DoctorViewModel doctorViewModel;
    private iniDoctor[] fruits1 = {new iniDoctor("favourite", R.drawable.favourites,R.drawable.turn),
                             };
    private List<iniDoctor> fruitList1 = new ArrayList<>();
    private iniDoctor[] fruits2 = {new iniDoctor("phone", R.drawable.phone,R.drawable.turn),
            new iniDoctor("contact", R.drawable.ask,R.drawable.turn)};
    private List<iniDoctor> fruitList2 = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        doctorViewModel =
                new ViewModelProvider(this).get(DoctorViewModel.class);
        View root = inflater.inflate(R.layout.doctor_fragment, container, false);
        //final TextView textView = root.findViewById(R.id.text_doctor);
        //textView.setText("hello doctor");
        initFruits();
        initFruits2();
        DoctorinitAdapter adapter = new DoctorinitAdapter(getContext(),R.layout.initdoctor,fruitList1);
        ListView listView = (ListView) root.findViewById(R.id.listview);
        listView.setAdapter(adapter);
        DoctorinitAdapter adapter1 = new DoctorinitAdapter(getContext(),R.layout.initdoctor,fruitList2);
        ListView listView1 = (ListView) root.findViewById(R.id.listview1);
        listView1.setAdapter(adapter1);
        doctorViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {


            }
        });
        return root;
    }

    private void initFruits() {
        fruitList1.clear();
        for (int i = 0; i < fruits1.length; i++) {
            Random random = new Random();
            int index = random.nextInt(fruits1.length);
            fruitList1.add(fruits1[i]);
        }
    }
    private void initFruits2() {
        fruitList2.clear();
        for (int i = 0; i < fruits2.length; i++) {
            Random random = new Random();
            int index = random.nextInt(fruits2.length);
            fruitList2.add(fruits2[i]);
        }
    }



}