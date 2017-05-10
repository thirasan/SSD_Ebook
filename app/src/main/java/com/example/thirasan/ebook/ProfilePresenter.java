package com.example.thirasan.ebook;

import android.content.Intent;

/**
 * Created by thirasan on 5/9/2017 AD.
 */

public class ProfilePresenter {
    private ProfileView view;
    User user;
    public ProfilePresenter(ProfileView view, Intent intent) {
        this.view = view;
        user = new User();
        createUser(intent);
    }
    public void refill(double amount) {
        user.refill(amount);
        view.updateWallet(user.checkWallet());
    }
    public void createUser(Intent intent){
        int cartSize = Integer.parseInt(intent.getStringExtra("cartSize"));
        int collectionSize = Integer.parseInt(intent.getStringExtra("collectionSize"));
        double wallet = Double.parseDouble(intent.getStringExtra("wallet"));
        double sumPrice = Double.parseDouble(intent.getStringExtra("sumPrice"));

        for(int i=0;i<collectionSize;i++){
            user.addCollection(intent.getStringExtra("collection"+i));
        }

        for(int i=0;i<cartSize;i++){
            user.cart.addDummyCart(intent.getStringExtra("cartBook"+i));
        }

        setWallet(wallet);
        setSumPrice(sumPrice);
        view.updateWallet(user.wallet);
    }


    public void showCart() {
        view.updateAll(user.cart.getDummyCart());
    }

    public void showCollection(){
        view.updateAll(user.checkCollection());
    }

    public void setWallet(double wallet){
        user.wallet = wallet;
    }

    public void setSumPrice(double sumPrice){
        user.cart.sumPrice = sumPrice;
    }

    public double getWallet() {
        return user.wallet;
    }

    public void purchase(){
        user.purchase();
        view.updateAll(user.cart.getDummyCart());
        view.updateWallet(user.wallet);
    }
}
