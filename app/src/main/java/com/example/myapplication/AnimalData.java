package com.example.myapplication;

public class AnimalData {

    //this class creates object for RecyclerView and displays of animal_layout.xml components

    //variable declaration for animal components
    private int animalImage;
    private String animalText;


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
    public String getText(){

        return animalText;
    }

}
