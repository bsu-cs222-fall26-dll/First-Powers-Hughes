package edu.bsu.cs222.wikipedia;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParser {
    public String parse(InputStream testDataStream, int Index,String rootElement) throws IOException {
        JSONArray result = (JSONArray) JsonPath.read(testDataStream,rootElement);
        return result.get(Index).toString();
    }
}

