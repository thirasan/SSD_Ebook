package com.example.thirasan.ebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thirasan on 4/20/2017 AD.
 */

public class MockupRepository extends Repository {
    private List<Book> books ;

    public MockupRepository(){
        books = new ArrayList<Book>();
        Book book1 = new Book("grgrhghrghr",24,23.4,2004,"hhaah");
        Book book2 = new Book("grgrhghrghr",23,2.4,2003,"hhnoaah yes");
        Book book3 = new Book("grgrhghrghr",22,23000,2002,"hhaahno ");
        Book book4 = new Book("grgrhghrghr",21,123,2001,"Stop ");

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
    }

    public List<Book> getAllBooks() {
        return books;
    }
    public List<Book> getBooks(String bookName) {
        return books;
    }
}
