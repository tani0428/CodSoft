package com.example.quoteoftheday;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FavoriteQuotesActivity extends AppCompatActivity {

    private ListView favoriteQuotesListView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_quotes);

        favoriteQuotesListView = findViewById(R.id.favoriteQuotesListView);

        ArrayList<String> favoriteQuotes = getIntent().getStringArrayListExtra("FAVORITE_QUOTES");
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, favoriteQuotes);
        favoriteQuotesListView.setAdapter(adapter);
    }
}
