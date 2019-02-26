package com.example.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {

    private ArrayList<AnimalData> AnimalList;

    //constructor; ArrayList animal data passed for adapter access
    public AnimalAdapter(ArrayList<AnimalData> list){

       AnimalList=list;
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder{

        /**
        AnimalViewHolder class connects/loads ArrayList data to RecyclerView layout. AnimalViewholder holds
        identification reference to resources, to avoid costly "get" method calls. Variable declaration
        for layout view components and constructor for variable assignment are below.
        */

        public ImageView ImageView;
        public TextView TextView;

        public AnimalViewHolder(View itemView) {
            super(itemView);
            ImageView = (ImageView) itemView.findViewById(R.id.imageView);
            TextView = (TextView) itemView.findViewById(R.id.textView);
        }
    }


    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        //layout passed to adapter by returning a viewholder in this method

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_layout, viewGroup, false);
        AnimalViewHolder vHolder = new AnimalViewHolder(view);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder dataHolder, int i) {

        //AnimalViewHolder object is passed along with item position to obtain image and string for display
        //AnimalData object instantiated and assigned current item of ArrayList; image and string set for display
        AnimalData currentAnimal = AnimalList.get(i);
        dataHolder.ImageView.setImageResource(currentAnimal.getImage());
        dataHolder.TextView.setText(currentAnimal.getText());

    }

    @Override
    public int getItemCount() {

        //number of items ing list returned
        return AnimalList.size();
    }
}
