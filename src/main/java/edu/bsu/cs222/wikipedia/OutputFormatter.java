package edu.bsu.cs222.wikipedia;

import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class OutputFormatter {
    public String formatOutput(InputStream DataStream) throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        JSONArray redirects = parser.parse(DataStream,"$..redirects");
        DataStream.reset();
        JSONArray timestamps = parser.parse(DataStream,"$..timestamp");
        DataStream.reset();
        JSONArray users = parser.parse(DataStream,"$..user");
        StringBuilder outputBuilder = new StringBuilder();
        if(!redirects.isEmpty()){
            outputBuilder.append(redirects.getFirst().toString()).append("\n");
        }
        for(int i=0;i<16;i++){
            outputBuilder.append(i+1).append("  ").append(timestamps.get(i).toString()).append("  ").append(users.get(i).toString()).append("\n");
        }
        return outputBuilder.toString();
    }
}
