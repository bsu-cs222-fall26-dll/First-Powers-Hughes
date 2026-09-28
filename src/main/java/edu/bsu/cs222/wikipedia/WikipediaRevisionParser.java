package edu.bsu.cs222.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;


public class WikipediaRevisionParser {
    public InputStream getJsonData(String userInput) throws IOException, URISyntaxException {
       WikipediaConnector connector = new WikipediaConnector();
       String jsonData = connector.startSearcher(userInput);
        return new ByteArrayInputStream(jsonData.getBytes(StandardCharsets.UTF_8));
    }

    public JSONArray parse(InputStream DataStream,String rootElement) throws IOException {
        JSONArray result = JsonPath.read(DataStream,rootElement);
        DataStream.reset();
        System.out.println(result);
        return result;

    }
    public String formatOutput(InputStream DataStream) throws IOException {
        JSONArray timestamps = parse(DataStream,"$..timestamp");
        JSONArray users = parse(DataStream,"$..user");
        StringBuilder outputBuilder = new StringBuilder();
        for(int i=0;i<16;i++){
            outputBuilder.append(i+1).append("  ").append(timestamps.get(i).toString()).append("  ").append(users.get(i).toString()).append("\n");
        }
        return outputBuilder.toString();
    }
}

