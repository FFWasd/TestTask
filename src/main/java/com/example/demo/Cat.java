package com.example.demo;

public class Cat {
    private String name;
    private int rate;
    private String imageUrl;

    Cat(String name, String imageUrl){
        this.name = name;
        this.rate = 0;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public String getName(){
        return name;
    }

    public int getRate(){
        return rate;
    }

    public void addRate(){
        rate++;
    }

    @Override 
    public String toString(){
        return name + ", баллы: " + rate;
    }
}
