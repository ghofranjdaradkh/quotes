package quotes;


import java.io.IOException;


public class App {

    public static void main(String[] args)  {

        try {
            Quotes randomQuote = Quotes.randomRecentQuote();
            System.out.println(randomQuote);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }}
