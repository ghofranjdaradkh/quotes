package quotes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class Quotes {

    private String author;
    private String text;
    private String body;

    Quotes(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getBody() {
        return body;
    }

    public String getAuthor() {
        return author;
    }

    public  String getQuote() {
        return text;
    }



    @Override
    public String toString() {
        String quoteContent = text != null ? text : body;
        return "Quote: " + quoteContent + "\nAuthor: " + author;
    }




}
