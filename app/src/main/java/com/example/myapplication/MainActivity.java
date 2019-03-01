package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;


public class MainActivity extends AppCompatActivity {

    /*

    variable declarations:
    1. RecyclerView: maintains RecyclerView developed in layout xml
    2. RecyclerView.Adapter: connects and loads ArrayList/data to RecyclerView
    3. RecyclerView.LayoutManager: creates list view of components

     */

    private RecyclerView recyclerView;
    private AnimalAdapter recycleAdapter;
    private RecyclerView.LayoutManager recycleLayout;
    private Button flip, rotate, addFactButton, nextFact, deleteFact;
    private ImageView up, down, forward, back, pad;
    private EditText addTextFact;

    private ArrayList<AnimalData> animalList;

    int imageSelectPosition;
    View imageSelectView;
    TextView selectedText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);


        rotate = (Button) findViewById(R.id.rotateButton);
        flip = (Button) findViewById(R.id.flipButton);
        addFactButton = (Button) findViewById(R.id.addButton);
        nextFact = (Button) findViewById(R.id.nextButton);

        up = (ImageView) findViewById(R.id.up);
        down = (ImageView) findViewById(R.id.up);
        forward = (ImageView) findViewById(R.id.up);
        back = (ImageView) findViewById(R.id.up);
        pad = (ImageView) findViewById(R.id.padImg);

        addTextFact = (EditText) findViewById(R.id.addFact);






        buildDataList();
        buildRecycler();

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animalList.get(imageSelectPosition).rotate(imageSelectView);

            }
        });

        flip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                animalList.get(imageSelectPosition).flip(imageSelectView);

            }
        });


        addFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String factInput = addTextFact.getText().toString();

            }
        });


}
    public int dpToPx(int dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, this.getResources().getDisplayMetrics());
    }

    public void buildDataList() {

        //ArrayList of animal data objects initialized
        animalList = new ArrayList<>();
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

    }

    public void buildRecycler() {

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

        recycleAdapter.setOnItemClickListener(new AnimalAdapter.OnItemClickListener() {

            @Override
            public void onImageClick(int position, View v, TextView text) {

                imageSelectPosition = position;
                imageSelectView = v;
                selectedText = text;


            }


    });


        }
    }

