package com.example.thirasan.ebook;

import java.util.ArrayList;

/**
 * Created by thirasan on 5/9/2017 AD.
 */

public class User {
    Cart cart;
    double wallet;
    ArrayList<Book> collection;
    public User() {
        cart = new Cart();
        wallet = 0;
        collection = new ArrayList<Book>();
    }
    public double refill(double amount) {
        this.wallet += amount;
        return this.wallet;
    }
    public double checkWallet() {
        return this.wallet;
    }
    public void addToCart(Book book) {
        if (wallet>=cart.getSumPrice()+book.getPrice())
            cart.addToCart(book);
    }
    public void purchase() {
        wallet-=cart.getSumPrice();
        for (int i = 0;i<cart.getBooks().size();i++) {
            collection.add(cart.getBooks().get(i));
        }
        cart.clear();
    }
    public ArrayList<Book> checkCollection() {
        return this.collection;
    }

}
