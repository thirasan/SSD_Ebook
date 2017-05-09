package com.example.thirasan.ebook;

import android.os.AsyncTask;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thirasan on 26/4/2560.
 */

public class JsonRepository extends Repository {
    private List<Book> books;

    private static JsonRepository instance = null;

    public static JsonRepository getInstance() {
        if(instance == null) {
            instance = new JsonRepository();
        }
        return instance;
    }

    public JsonRepository() {
        books = new ArrayList<Book>();
    }

    public void fetchAllBooks() {
        BookFetcherTask task = new BookFetcherTask();
        task.execute();
    }
    @Override
    public List<Book> getBooks(String text) {
        List<Book> result = new ArrayList<Book>();
        for(Book b:books) {
            if (b.toString().contains(text)) result.add(b);
        }
        return result;
    }
    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    public class BookFetcherTask extends AsyncTask<Void,Void,ArrayList<Book>> {
        @Override
        protected ArrayList<Book> doInBackground(Void... params) {
            String bookListJsonStr = loadJSON();
            if(bookListJsonStr != null) {
                return BookJSONDecoder.createListFromJSONStr(bookListJsonStr);
            } else {
                return null;
            }
        }

        private String loadJSON() {
            URL booksURL = null;
            try {
                booksURL = new URL("https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return (new UrlFetcher(booksURL)).fetch();
        }

        @Override
        protected void onPostExecute(ArrayList<Book> results) {
            if(results != null) {
                books.clear();
                books.addAll(results);
                setChanged();
                notifyObservers(books);
            }
        }
    }
    public Book getBookById(int position){
        return books.get(position);
    }
}
