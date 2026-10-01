package edu.bsu.cs222.wikipedia;

import net.minidev.json.JSONArray;

import java.io.IOException;
import java.io.InputStream;

public class OutputFormatter {
    public String formatOutput(InputStream dataStream) throws IOException {
        JSONArray missing = getArrayAndResetDataStream(dataStream,"$..missing");
        JSONArray redirects = getArrayAndResetDataStream(dataStream,"$..redirects");
        JSONArray timestamps = getArrayAndResetDataStream(dataStream,"$..timestamp");
        JSONArray users = getArrayAndResetDataStream(dataStream,"$..user");
        StringBuilder outputBuilder = new StringBuilder();
        if(!redirects.isEmpty()){
            JSONArray redirectFrom = getArrayAndResetDataStream(dataStream,"$..from");
            JSONArray redirectTo = getArrayAndResetDataStream(dataStream,"$..to");
            outputBuilder.append("Redirects From: ").append(redirectFrom.getFirst()).append("\n").append("To: ").append(redirectTo.getFirst()).append("\n");
        }
        if(!missing.isEmpty()){
            outputBuilder.append("No Page Found");
        }
        else{
            for(int index=0;index< users.size();index++){
                outputBuilder.append(index+1).append("  ").append(timestamps.get(index)).append("  ").append(users.get(index)).append("\n");
        }
        }
        return outputBuilder.toString();
    }
    public JSONArray getArrayAndResetDataStream(InputStream dataStream, String rootElement) throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        dataStream.reset();
        return parser.parse(dataStream,rootElement);
    }
}
