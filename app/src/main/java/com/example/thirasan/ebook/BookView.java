package com.example.thirasan.ebook;

import java.util.List;

/**
 * Created by thirasan on 4/20/2017 AD.
 */

public interface BookView {
    void update(Book book);
    void updateAll(List<Book> books);
}
