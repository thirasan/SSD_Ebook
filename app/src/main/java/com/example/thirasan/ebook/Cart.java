package com.example.thirasan.ebook;

import java.util.ArrayList;

/**
 * Created by thirasan on 5/9/2017 AD.
 */

public class Cart {
    ArrayList<Book> books;
    double sumPrice;
    public Cart() {
        books = new ArrayList<Book>();
        sumPrice = 0;
    }
    public void addToCart(Book book) {
        books.add(book);
        sumPrice+=book.getPrice();
    }
    public ArrayList<Book> getBooks(){
        return books;
    }
    public double getSumPrice() {
        return this.sumPrice;
    }
    public void clear() {
        this.books.clear();
        this.sumPrice = 0;
    }
}
