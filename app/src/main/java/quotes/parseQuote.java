package quotes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class parseQuote {
public static Quotes parseRandomQuote(){
 try {
        // Reading the data
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\CW\\quotes\\app\\src\\main\\resources\\recentQuotes.txt"));


        Gson gson = new Gson();

        // Parse the JSON data into an array of Quotes
        Quotes[] quoteList = gson.fromJson(reader, Quotes[].class);

        // Choose a random quote
        Random random = new Random();
        int randomIndex = random.nextInt(quoteList.length);
        return quoteList[randomIndex];
    } catch (
    IOException e) {
        return new Quotes("Error",e.getMessage());
    }

    }
}


