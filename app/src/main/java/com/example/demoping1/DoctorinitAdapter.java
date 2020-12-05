package com.example.demoping1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DoctorinitAdapter extends ArrayAdapter<iniDoctor> {
    private int resoureId;
    public DoctorinitAdapter(Context context, int textViewResourceID, List<iniDoctor> objects){
        super(context,textViewResourceID,objects);
        resoureId = textViewResourceID;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        iniDoctor person =getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resoureId,parent,false);
        ImageView Imageleft =(ImageView) view.findViewById(R.id.imageleft);
        TextView pername =(TextView) view.findViewById(R.id.name);
        ImageView Imageright =(ImageView) view.findViewById(R.id.imageright);

        Imageright.setImageResource(person.getImageright());
        pername.setText(person.getName());
        Imageleft.setImageResource(person.getImageleft());
        return view;
    }

}

