package edu.bsu.cs222.wikipedia;
import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;
import java.util.Objects;

public class WikipediaConnector {

    public String startSearcher(String userInput) throws IOException, URISyntaxException {
        URLConnection connection = connectToWikipedia(userInput);

        String jsonData = readJsonAsStringFrom(Objects.requireNonNull(connection));
        printRawJson(jsonData);
        return jsonData;

    }

    protected static URLConnection connectToWikipedia(String search) throws IOException, URISyntaxException {
        String encodedUrlString = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(search, Charset.defaultCharset()) +
                "&rvprop=timestamp" + URLEncoder.encode("|",Charset.defaultCharset()) + "user&rvlimit=16&redirects";
        try {
            URI uri = new URI(encodedUrlString);
            URLConnection connection = uri.toURL().openConnection();
            connection.setRequestProperty("User-Agent",
                    "CS222FirstProject/0.1 (rhughes3@bsu.edu)");
            connection.connect();
            return connection;
        }catch(UnknownHostException e){
            return null;
        }
    }

    private static String readJsonAsStringFrom(URLConnection connection) throws IOException {
        return new String(connection.getInputStream().readAllBytes(), Charset.defaultCharset());
    }

    private static void printRawJson(String jsonData) {
        System.out.println(jsonData);
    }

}
