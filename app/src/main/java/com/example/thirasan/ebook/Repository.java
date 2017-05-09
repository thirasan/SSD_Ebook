package com.example.thirasan.ebook;

import java.util.List;
import java.util.Observable;

/**
 * Created by thirasan on 4/20/2017 AD.
 */

public abstract class Repository extends Observable {
    public abstract List<Book> getAllBooks();
    public abstract List<Book> getBooks(String bookName);


}
