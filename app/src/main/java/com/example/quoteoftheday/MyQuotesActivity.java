package com.example.quoteoftheday;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MyQuotesActivity extends AppCompatActivity {

    private ListView myQuotesListView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> myQuotesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_quotes);

        myQuotesListView = findViewById(R.id.myQuotesListView);

        myQuotesList = getIntent().getStringArrayListExtra("MY_QUOTES");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myQuotesList);
        myQuotesListView.setAdapter(adapter);
    }
}
