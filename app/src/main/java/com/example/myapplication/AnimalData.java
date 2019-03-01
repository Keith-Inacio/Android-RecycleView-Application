package com.example.myapplication;


import android.media.Image;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

public class AnimalData {

    //this class creates object for RecyclerView and displays of animal_layout.xml components

    //variable declaration for animal components
    private int animalImage;
    private int newFactPosition;
    private String animalText;
    private String newFact;


    public AnimalData(){

    }
    //constructor is passed animal component arguments
    public AnimalData(int image, String text){
       animalImage=image;
       animalText=text;

    }

    //method to return animal image position
    public int getImage(){

        return animalImage;
    }

    //method to return animal description
    public String getText() {

        return animalText;
    }

    public void rotate(View view) {

        view.setRotation(view.getRotation() + 90);

    }

    public void flip(View view) {

        view.setScaleX(view.getScaleX() * -1);

    }



}
