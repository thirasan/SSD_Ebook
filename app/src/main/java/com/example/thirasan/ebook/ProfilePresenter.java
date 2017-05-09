package com.example.thirasan.ebook;

/**
 * Created by thirasan on 5/9/2017 AD.
 */

public class ProfilePresenter {
    private ProfileView view;
    private User user;
    public ProfilePresenter(ProfileView view) {
        this.view = view;
        user = new User();
    }
    public void refill(double amount) {
        user.refill(amount);
        view.updateWallet(user.checkWallet());
    }

    public void showCart() {
        view.updateAll(user.cart.getBooks());
    }
}
