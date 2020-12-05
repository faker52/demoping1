package com.example.demoping1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class foodTimeAdapter extends RecyclerView.Adapter<foodTimeAdapter.ViewHolder> {
    private Context mContext;
    private int sonviewid;//子界面布局的id
    private List<foodTime> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView fruitImage;
        TextView fruittime;
        TextView food1;
        TextView food2;
        TextView food3;


        public ViewHolder(View view) {
            super(view);

            cardView = (CardView) view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruittime = (TextView) view.findViewById(R.id.fruit_name);
            food1 = (TextView) view.findViewById(R.id.food1);
            food2 = (TextView) view.findViewById(R.id.food2);
            food3 = (TextView) view.findViewById(R.id.food3);
        }
    }

    public foodTimeAdapter(List<foodTime> fruitList,int id) {
        mFruitList = fruitList;
        sonviewid =id;

    }

    @Override
    public foodTimeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(sonviewid, parent, false);
        final foodTimeAdapter.ViewHolder holder = new foodTimeAdapter.ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                foodTime fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you click the view"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int position = holder.getAdapterPosition();
                foodTime fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you click the image"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(foodTimeAdapter.ViewHolder holder, int position) {
        foodTime fruit = mFruitList.get(position);

        holder.fruittime.setText(fruit.getName());
        holder.food1.setText(fruit.getFood1());
        holder.food2.setText(fruit.getFood2());
        holder.food3.setText(fruit.getFood3());
        Glide.with(mContext).load(fruit.getImage()).into(holder.fruitImage);
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

}