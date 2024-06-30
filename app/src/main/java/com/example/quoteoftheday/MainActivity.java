package com.example.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView quoteTextView;
    private Button refreshButton, shareButton, favoriteButton, viewFavoritesButton, addQuoteButton, viewMyQuotesButton;
    private EditText newQuoteEditText, authorNameEditText;
    private Set<String> favoriteQuotes = new HashSet<>();
    private ArrayList<String> myQuotes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        quoteTextView = findViewById(R.id.quoteTextView);
        refreshButton = findViewById(R.id.refreshButton);
        shareButton = findViewById(R.id.shareButton);
        favoriteButton = findViewById(R.id.favoriteButton);
        viewFavoritesButton = findViewById(R.id.viewFavoritesButton);
        newQuoteEditText = findViewById(R.id.newQuoteEditText);
        authorNameEditText = findViewById(R.id.authorNameEditText);
        addQuoteButton = findViewById(R.id.addQuoteButton);
        viewMyQuotesButton = findViewById(R.id.viewMyQuotesButton);

        loadRandomQuote();

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadRandomQuote();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareQuote();
            }
        });

        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFavoriteQuote();
            }
        });

        viewFavoritesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewFavoriteQuotes();
            }
        });

        addQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewQuote();
            }
        });

        viewMyQuotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewMyQuotes();
            }
        });
    }

    private void loadRandomQuote() {
        String quote = Quote.getRandomQuote();
        quoteTextView.setText(quote);
    }

    private void shareQuote() {
        String quote = quoteTextView.getText().toString();
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, quote);
        shareIntent.setType("text/plain");
        startActivity(Intent.createChooser(shareIntent, "Share quote via"));
    }

    private void saveFavoriteQuote() {
        String quote = quoteTextView.getText().toString();
        if (favoriteQuotes.add(quote)) {
            Toast.makeText(this, "Quote added to favorites", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Quote already in favorites", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewFavoriteQuotes() {
        Intent intent = new Intent(MainActivity.this, FavoriteQuotesActivity.class);
        intent.putStringArrayListExtra("FAVORITE_QUOTES", new ArrayList<>(favoriteQuotes));
        startActivity(intent);
    }

    private void addNewQuote() {
        String newQuote = newQuoteEditText.getText().toString().trim();
        String authorName = authorNameEditText.getText().toString().trim();
        if (!newQuote.isEmpty() && !authorName.isEmpty()) {
            String formattedQuote = newQuote + " - " + authorName;
            Quote.addQuote(formattedQuote);
            myQuotes.add(formattedQuote);
            Toast.makeText(this, "Quote added successfully", Toast.LENGTH_SHORT).show();
            newQuoteEditText.setText("");
            authorNameEditText.setText("");
        } else {
            Toast.makeText(this, "Please enter both a quote and an author name", Toast.LENGTH_SHORT).show();
        }
    }

    private void viewMyQuotes() {
        Intent intent = new Intent(MainActivity.this, MyQuotesActivity.class);
        intent.putStringArrayListExtra("MY_QUOTES", myQuotes);
        startActivity(intent);
    }
}
