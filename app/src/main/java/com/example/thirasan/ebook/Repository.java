package com.example.thirasan.ebook;

/**
 * Created by thirasan on 4/20/2017 AD.
 */

public interface Repository {
    public Book[] getAllBooks();
    public Book getBook(String bookName);


}
