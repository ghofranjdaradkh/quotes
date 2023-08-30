
package quotes;


import java.io.IOException;


public class App {

    public static void main(String[] args) throws IOException {
        //from the json file
        Quotes[] randomQuote = parseQuotesFromFile.parseRandomQuote();
        System.out.println(randomQuote[0]);

        //from URL
        Quotes randomQuoteFromURL = parseQuotesFromURL.randomFavQsAPI();
        parseQuotesFromURL.saveQoutes(new Quotes[]{randomQuoteFromURL});

        System.out.println(randomQuoteFromURL);

    }}