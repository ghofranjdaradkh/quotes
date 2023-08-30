package quotes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class parseQuotesFromURL {


    public static Quotes randomFavQsAPI() throws IOException {
        final String API_KEY = "cd17fc6f77805fbbcc2fec5f4004a219";
        URL url = new URL("https://favqs.com/api/quotes/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", "Token token=" + API_KEY);

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                String responseLine;
                StringBuilder response = new StringBuilder();
                while ((responseLine = reader.readLine()) != null) {
                    response.append(responseLine);
                }

                String jsonData = response.toString();

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);

                JsonArray quotesArray = jsonObject.getAsJsonArray("quotes");

                Quotes[] quoteList = gson.fromJson(quotesArray, Quotes[].class);

                Random random = new Random();
                int randomIndex = random.nextInt(quoteList.length);

                return quoteList[randomIndex];
            } catch (IOException e) {
                return new Quotes("Error", e.getMessage());
            } finally {
                connection.disconnect();
            }
        } else {
            return new Quotes("Error", "HTTP request failed with response code: " + responseCode);
        }
    }

    public static void saveQoutes(Quotes[] newQuotes) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        // Read existing quotes from the file
        List<Quotes> existingQuotes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("app\\src\\main\\resources\\recentQuotes.json"))) {
            Quotes[] savedQuotes = gson.fromJson(reader, Quotes[].class);
            existingQuotes.addAll(Arrays.asList(savedQuotes));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Add new quotes to the existing list
        existingQuotes.addAll(Arrays.asList(newQuotes));

        // Write the combined list of quotes back to the file
        try (Writer writer = new FileWriter("app\\src\\main\\resources\\recentQuotes.json")) {
            gson.toJson(existingQuotes, writer);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }}