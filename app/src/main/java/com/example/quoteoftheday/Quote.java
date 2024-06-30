package com.example.quoteoftheday;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Quote {
    private String text;
    private static List<String> quoteList = new ArrayList<>();

    static {
        quoteList.add("The only way to do great work is to love what you do. - Steve Jobs");
        quoteList.add("Life is what happens when you’re busy making other plans. - John Lennon");
        quoteList.add("The purpose of our lives is to be happy. - Dalai Lama");
        quoteList.add("Get busy living or get busy dying. - Stephen King");
        quoteList.add("You have within you right now, everything you need to deal with whatever the world can throw at you. - Brian Tracy");
        quoteList.add("Believe you can and you're halfway there. - Theodore Roosevelt");
        quoteList.add("Your time is limited, don't waste it living someone else's life. - Steve Jobs");
        quoteList.add("The only impossible journey is the one you never begin. - Tony Robbins");
        quoteList.add("Go confidently in the direction of your dreams! Live the life you've imagined. - Henry David Thoreau");
        quoteList.add("Act as if what you do makes a difference. It does. - William James");
        quoteList.add("Success is not final, failure is not fatal: It is the courage to continue that counts. - Winston Churchill");
        quoteList.add("Hardships often prepare ordinary people for an extraordinary destiny. - C.S. Lewis");
        quoteList.add("The best way to predict the future is to invent it. - Alan Kay");
        quoteList.add("I think, therefore I am. - René Descartes");
    }

    public Quote(String text) {
        this.text = text;
    }

    public static String getRandomQuote() {
        Random random = new Random();
        return quoteList.get(random.nextInt(quoteList.size()));
    }

    public static void addQuote(String quote) {
        quoteList.add(quote);
    }
}
