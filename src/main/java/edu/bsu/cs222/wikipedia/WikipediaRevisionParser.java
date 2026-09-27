package edu.bsu.cs222.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

public class WikipediaRevisionParser {
    public InputStream getJsonData(String userInput) throws IOException, URISyntaxException {
       WikipediaConnector connector = new WikipediaConnector();
       String jsonData = connector.startSearcher(userInput);
        return new ByteArrayInputStream(jsonData.getBytes(StandardCharsets.UTF_8));
    }

    public String parse(InputStream DataStream, int Index,String rootElement) throws IOException {
        JSONArray result = JsonPath.read(DataStream,rootElement);
        return result.get(Index).toString();

    }
    public String formatOutput(InputStream DataStream) throws IOException {
        StringBuilder outputBuilder = new StringBuilder();
        outputBuilder.append(parse(DataStream,0,"$..timestamp"));
        return outputBuilder.toString();
    }
}

