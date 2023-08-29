package quotes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

public class urlConnection {




    public static Quotes randomRecentQuote() throws IOException {
        // Create a URL Object
        URL url = new URL("https://codefellows.github.io/code-401-java-guide/curriculum/class-08/recentquotes.json");
        // HttpConection instance by using Open a Connection method
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // Set the Request Method
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();//
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Reading the data
            try {
                // Reading the data
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String responseLine;
                StringBuilder response = new StringBuilder();
                while ((responseLine = reader.readLine()) != null) {
                    response.append(responseLine);
                }


                String jsonData = response.toString();

                Gson gson = new Gson();

                // Parse the JSON data into an array of Quotes
                Quotes[] quoteList = gson.fromJson(jsonData, Quotes[].class);

                // Choose a random quote
                Random random = new Random();
                int randomIndex = random.nextInt(quoteList.length);
                return quoteList[randomIndex];
            } catch (IOException e) {
                return new Quotes("Error",e.getMessage());
            }
            finally {
                connection.disconnect();
            }
        } else {
            return new Quotes("Error", "HTTP request failed with response code: " + responseCode);
        }
    }


}
