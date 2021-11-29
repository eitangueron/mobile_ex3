package com.example.ex3;

import java.util.concurrent.ThreadLocalRandom;

public class Quotes {
    private final String[] quotes = {
            "Vini Vidi Vici",
            "Carpe Diem",
            "YOLO",
            "Que Sera Sera",
            "Ce la vie",
            "Asta la vista baby",
            "Work Hard Play Hard"
    };

    String getRandomQuote(){
        int rand = ThreadLocalRandom.current().nextInt(quotes.length);
        return quotes[rand];
    }

}
