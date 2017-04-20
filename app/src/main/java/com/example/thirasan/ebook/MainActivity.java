package com.example.thirasan.ebook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements  BookView{

    BookPresenter presenter = null;
    ListView resultListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewHolders();

        if(presenter == null) {
            presenter = new BookPresenter(this);
        }

        presenter.listAllBook();
    }

    private void initViewHolders() {
        resultListView = (ListView) findViewById(R.id.list);
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void updateAll(Book[] books) {

        String[] list = new String[books.length];
        for (int i = 0;i<books.length;i++) {
            list[i] = books[i].getId()+"\n"+books[i].getTitle() + "\n" + books[i].getPrice();
        }
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        resultListView.setAdapter(adapter);
    }
}
