package com.example.thirasan.ebook;

/**
 * Created by thirasan on 5/9/2017 AD.
 */

public class ProfilePresenter {
    private ProfileView view;
    User user;
    public ProfilePresenter(ProfileView view) {
        this.view = view;
        user = new User();
    }
    public void refill(double amount) {
        user.refill(amount);
        view.updateWallet(user.checkWallet());
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

    public double getWallet(){
        return user.wallet;
    }


    public void purchase(){
        user.purchase();
        view.updateAll(user.cart.getDummyCart());
    }
}
