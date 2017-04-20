package com.example.thirasan.ebook;

/**
 * Created by thirasan on 4/20/2017 AD.
 */

public class Book {
    private double price;
    private int id;
    private String title;
    private String image;

    public Book(double price,int id,String title,String image){
        this.id = id;
        this.price = price;
        this.title = title;
        this.image = image;
    }

    public int getId(){
        return  this.id;
    }

    public double getPrice(){
        return this.price;
    }

    public String getTitle(){
        return this.title;
    }

    public String getImage(){
        return this.image;
    }

}
