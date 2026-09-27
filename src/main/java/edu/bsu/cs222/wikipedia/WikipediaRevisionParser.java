package edu.bsu.cs222.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class WikipediaRevisionParser {
    public String getJsonData(String userInput) throws IOException, URISyntaxException {
       WikipediaConnector connector = new WikipediaConnector();
        return connector.startSearcher(userInput);
    }

    public String parse(InputStream DataStream, int Index,String rootElement) throws IOException {
        JSONArray result = JsonPath.read(DataStream,rootElement);
        return result.get(Index).toString();

    }
}

