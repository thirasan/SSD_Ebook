package com.example.thirasan.ebook;

/**
 * Created by thirasan on 4/20/2017 AD.
 */

public class BookPresenter {

    private BookView view;

    public BookPresenter(BookView view){
        this.view = view;
    }

    public void listAllBook(){
        MockupRepository mock = new MockupRepository();
        view.updateAll(mock.getAllBooks());
    }
}
