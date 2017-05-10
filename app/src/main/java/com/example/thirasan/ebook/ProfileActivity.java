package com.example.thirasan.ebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    Button purchaseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViewHolders();

        if(presenter == null) {
            presenter = new ProfilePresenter(this,getIntent());
        }

    }

    private void initViewHolders() {
        resultListView = (ListView) findViewById(R.id.listProfile);
        wallet = (TextView) findViewById(R.id.wallet);
        purchaseBtn = (Button) findViewById(R.id.purchaseButton);
    }
    public void onRefill(View view) {
        EditText editText = (EditText)findViewById(R.id.refillText);
        double amount = Double.parseDouble(editText.getText().toString());
        presenter.refill(amount);
    }
    public void onMain(View view) {
        Intent intent = new Intent(ProfileActivity.this, MainActivity.class);

        ArrayList<String> collection = presenter.user.checkCollection();

        intent.putExtra("collectionSize", collection.size()+"");
        intent.putExtra("wallet", presenter.getWallet()+"");
        for (int i = 0;i<collection.size();i++) {
            intent.putExtra("collection"+i,collection.get(i));
        }
        startActivity(intent);
        finish();
    }

    @Override
    public void updateWallet(double amount) {
        wallet.setText("Wallet: "+ amount + " USD");
    }

    @Override
    public void updateAll(ArrayList<String> books) {
        String[] list = new String[books.size()];

        for (int i = 0;i<books.size();i++) {
            list[i] = books.get(i);
        }
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        resultListView.setAdapter(adapter);

    }

    public void onCart(View view) {
        presenter.showCart();
        purchaseBtn.setVisibility(View.VISIBLE);
    }

    public void onCollection(View view) {
        presenter.showCollection();
        purchaseBtn.setVisibility(View.INVISIBLE);
    }

    public void onPurchase(View view) {
        presenter.purchase();
    }
}
