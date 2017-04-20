package com.example.thirasan.ebook;

/**
 * Created by thirasan on 4/20/2017 AD.
 */

public class MockupRepository implements Repository {
    private Book[] books ;

    public MockupRepository(){
        books = new Book[4];
        Book book1 = new Book(1,20,"ahhal","hhaah");
        Book book2 = new Book(2,200,"atweo","tow");
        Book book3 = new Book(3,2000,"eee","heeeh");
        Book book4 = new Book(4,20000,"afou","fouah");

        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
    }

    public Book[] getAllBooks() {
        return books;
    }
    public Book getBook(String bookName) {
        return books[0];
    }
}
