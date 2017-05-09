package com.example.thirasan.ebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  BookView{

    BookPresenter presenter = null;
    ListView resultListView;
    Spinner spin;
    String state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewHolders();

        if(presenter == null) {
            presenter = new BookPresenter(this);
        }

        presenter.listAllBook();

        spin = (Spinner)findViewById(R.id.spin);

        ArrayList<String> choices = new ArrayList<String>();
        choices.add("by Title");
        choices.add("by Published year");

        ArrayAdapter spinAdapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, choices);
        spin.setAdapter(spinAdapter);
    }

    private void initViewHolders() {
        resultListView = (ListView) findViewById(R.id.list);
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void updateAll(List<Book> books) {
        String[] list = new String[books.size()];

        for (int i = 0;i<books.size();i++) {
            list[i] = books.get(i).getTitle()+"\n"+ books.get(i).getPub_year()+ "\nPrice: " + books.get(i).getPrice() + " USD";
        }
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        resultListView.setAdapter(adapter);

        resultListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {
                presenter.addToCart(position);
            }
        });
    }

    public void onSearch(View view) {
        EditText editText = (EditText)findViewById(R.id.text);
        String text = editText.getText().toString();
        state = String.valueOf(spin.getSelectedItem());
        presenter.search(text,state);
    }

    public void onProfile(View view) {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
        ArrayList<Book> cartBooks = presenter.user.cart.getBooks();
        intent.putExtra("size", cartBooks.size()+"");
//        for (int i = 0;i<cartBooks.size();i++) {
//            intent.putExtra("cartBook"+i,cartBooks.get(i).getTitle()+"\n"+ cartBooks.get(i).getPub_year()+ "\nPrice: " + cartBooks.get(i).getPrice() + " USD");
//        }
        startActivity(intent);
        finish();
    }
}
