package com.example.thirasan.ebook;

import java.util.ArrayList;

/**
 * Created by thirasan on 5/9/2017 AD.
 */

public class User {
    Cart cart;
    double wallet;
    ArrayList<String> collectionList;

    public User() {
        cart = new Cart();
        wallet = 0;
        collectionList = new ArrayList<String>();
    }
    public double refill(double amount) {
        this.wallet += amount;
        return this.wallet;
    }
    public double checkWallet() {
        return this.wallet;
    }
    public void addToCart(Book book) {
        cart.addToCart(book);
    }
    public void purchase() {
        if (wallet>=cart.getSumPrice()) {
            wallet -= cart.getSumPrice();
            for (int i = 0; i < cart.cartList.size(); i++) {
                collectionList.add(cart.cartList.get(i));
            }
            cart.clear();
        }
    }
    public ArrayList<String> checkCollection() {
        return this.collectionList;
    }
    public void addCollection(String book){
        collectionList.add(book);
    }

}
