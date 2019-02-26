package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*

    variable declarations:
    1. RecyclerView: maintains RecyclerView developed in layout xml
    2. RecyclerView.Adapter: connects and loads ArrayList/data to RecyclerView
    3. RecyclerView.LayoutManager: creates list view of components

     */

    private RecyclerView recyclerView;
    private RecyclerView.Adapter recycleAdapter;
    private RecyclerView.LayoutManager recycleLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        //ArrayList of animal data objects initialized
        ArrayList<AnimalData> animalList=new ArrayList<>();
        animalList.add(new AnimalData(R.drawable.bear, getString(R.string.bear_fact)));
        animalList.add(new AnimalData(R.drawable.camel, getString(R.string.camel_fact)));
        animalList.add(new AnimalData(R.drawable.cheetah, getString(R.string.cheetah_fact)));
        animalList.add(new AnimalData(R.drawable.rhino, getString(R.string.rhino_fact)));
        animalList.add(new AnimalData(R.drawable.eagle, getString(R.string.eagle_fact)));
        animalList.add(new AnimalData(R.drawable.penguin, getString(R.string.penguin_fact)));
        animalList.add(new AnimalData(R.drawable.croc, getString(R.string.croc_fact)));
        animalList.add(new AnimalData(R.drawable.tiger, getString(R.string.tiger_fact)));
        animalList.add(new AnimalData(R.drawable.kangaroo, getString(R.string.kangaroo_fact)));
        animalList.add(new AnimalData(R.drawable.lion, getString(R.string.lion_fact)));

        //initialize RecyclerView with xml layout
        recyclerView = findViewById(R.id.recycleView);

        recycleLayout = new LinearLayoutManager(this);

        //pass arraylist as argument to adapter class for the viewholder
        recycleAdapter = new AnimalAdapter(animalList);

        //layout and adapter passed to RecyclerView
        recyclerView.setLayoutManager(recycleLayout);
        recyclerView.setAdapter(recycleAdapter);

        //increases performance; set true if we know RecycleView won't change in size
        recyclerView.setHasFixedSize(true);
    }


}
