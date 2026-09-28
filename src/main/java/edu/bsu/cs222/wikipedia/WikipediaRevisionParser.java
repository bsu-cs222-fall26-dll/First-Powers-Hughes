package edu.bsu.cs222.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;

public class WikipediaRevisionParser {
    public InputStream getJsonData(String userInput) throws IOException, URISyntaxException {
       WikipediaConnector connector = new WikipediaConnector();
       String jsonData = connector.startSearcher(userInput);
        return new ByteArrayInputStream(jsonData.getBytes(StandardCharsets.UTF_8));
    }

    public JSONArray parse(InputStream DataStream,String rootElement) throws IOException {
        JSONArray result = JsonPath.read(DataStream,rootElement);
        System.out.println(result);
        return result;

    }
    public String formatOutput(InputStream UserStream,InputStream TimestampStream) throws IOException {
        JSONArray timestamps = parse(TimestampStream,"$..timestamp");
        JSONArray users = parse(UserStream,"$..user");
        System.out.println((users.get(0).toString() + timestamps.get(0).toString()));
        return String.valueOf(timestamps.get(0));
    }
}

