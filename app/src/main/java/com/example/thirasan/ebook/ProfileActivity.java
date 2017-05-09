package com.example.thirasan.ebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thirasan on 5/9/2017 AD.
 */

public class ProfileActivity extends AppCompatActivity implements ProfileView{
    ListView resultListView;
    TextView wallet;
    ProfilePresenter presenter = null;
    String[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViewHolders();

        if(presenter == null) {
            presenter = new ProfilePresenter(this);
        }

        Intent intent = getIntent();
        int size = Integer.parseInt(intent.getStringExtra("size"));
        wallet.setText(size);
    }

    private void initViewHolders() {
        resultListView = (ListView) findViewById(R.id.listProfile);
        wallet = (TextView) findViewById(R.id.wallet);
    }
    public void onRefill(View view) {
        EditText editText = (EditText)findViewById(R.id.refillText);
        double amount = Double.parseDouble(editText.getText().toString());
        presenter.refill(amount);
    }
    public void onMain(View view) {
        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void updateWallet(double amount) {
        wallet.setText("Wallet: "+ amount + " USD");
    }

    @Override
    public void updateAll(ArrayList<Book> books) {
        String[] list = new String[books.size()];

        for (int i = 0;i<books.size();i++) {
            list[i] = books.get(i).getTitle()+"\n"+ books.get(i).getPub_year()+ "\nPrice: " + books.get(i).getPrice() + " USD";
        }
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        resultListView.setAdapter(adapter);

    }

    public void onCart(View view) {
        presenter.showCart();
    }
}
