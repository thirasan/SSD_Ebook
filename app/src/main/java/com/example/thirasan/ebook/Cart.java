package com.example.thirasan.ebook;

import java.util.ArrayList;

/**
 * Created by thirasan on 5/9/2017 AD.
 */

public class Cart {
    ArrayList<Book> books;
    double sumPrice;
    ArrayList<String> cartList;

    public Cart() {
        books = new ArrayList<Book>();
        sumPrice = 0;
        cartList = new ArrayList<String>();
    }
    public void addToCart(Book book) {
        books.add(book);
        sumPrice+=book.getPrice();
    }
    public ArrayList<Book> getBooks(){
        return books;
    }

    public ArrayList<String> getDummyCart(){
        return cartList;
    }

    public double getSumPrice() {
        return this.sumPrice;
    }
    public void clear() {
        this.sumPrice = 0;
        cartList.clear();
        books.clear();
    }
    public void addDummyCart(String book){
        cartList.add(book);
    }
}
