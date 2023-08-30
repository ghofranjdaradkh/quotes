package quotes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class parseQuotesFromFile {
public static Quotes[] parseRandomQuote(){
 try {
        // Reading the data
        BufferedReader reader = new BufferedReader(new FileReader("app\\src\\main\\resources\\recentQuotes.json"));


        Gson gson = new Gson();

        // Parse the JSON data into an array of Quotes

        Quotes[] quoteList = gson.fromJson(reader, Quotes[].class);



        // Choose a random quote
        Random random = new Random();
        int randomIndex = random.nextInt(quoteList.length);
        return new Quotes[]{quoteList[randomIndex]};
    } catch (
    IOException e) {
        return new Quotes[]{new Quotes("Error", e.getMessage())};
    }

    }
}


