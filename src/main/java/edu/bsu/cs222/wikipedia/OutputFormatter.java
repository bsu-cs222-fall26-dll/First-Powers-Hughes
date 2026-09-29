package edu.bsu.cs222.wikipedia;

import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class OutputFormatter {
    public String formatOutput(InputStream DataStream) throws IOException {
        JSONArray redirects = getArrayAndResetDataStream(DataStream,"$..redirects");
        JSONArray timestamps = getArrayAndResetDataStream(DataStream,"$..timestamp");
        JSONArray users = getArrayAndResetDataStream(DataStream,"$..user");
        StringBuilder outputBuilder = new StringBuilder();
        if(!redirects.isEmpty()){
            JSONArray redirectFrom = getArrayAndResetDataStream(DataStream,"$..from");
            JSONArray redirectTo = getArrayAndResetDataStream(DataStream,"$..to");
            outputBuilder.append("Redirects From: ").append(redirectFrom.getFirst().toString()).append("\n").append("To: ").append(redirectTo.getFirst().toString()).append("\n");
        }
        for(int i=0;i<16;i++){
            outputBuilder.append(i+1).append("  ").append(timestamps.get(i).toString()).append("  ").append(users.get(i).toString()).append("\n");
        }
        return outputBuilder.toString();
    }
    public JSONArray getArrayAndResetDataStream(InputStream DataStream, String rootElement) throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        DataStream.reset();
        return parser.parse(DataStream,rootElement);
    }
}
