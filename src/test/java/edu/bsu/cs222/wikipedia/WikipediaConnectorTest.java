package edu.bsu.cs222.wikipedia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;
import java.nio.charset.Charset;

public class WikipediaConnectorTest {
   @Test
   public void testWikipediaConnectorConnectionNotNull() throws IOException, URISyntaxException {
       Assertions.assertNotNull(WikipediaConnector.connectToWikipedia("Zappa"));
   }



    @Test
    public void testWikipediaDataNotNull() throws IOException, URISyntaxException {
        WikipediaConnector connector = new WikipediaConnector();
        String testData = connector.startSearcher("Zappa");
        Assertions.assertNotNull(testData);
    }
    @Test
    public void testEncodeURL(){
       Assertions.assertEquals("https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Zappa&rvprop=timestamp%7Cuser&rvlimit=16&redirects", encodeURL("Zappa"));

    }
    public String encodeURL(String searchInput){
       return "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=" +
                URLEncoder.encode(searchInput, Charset.defaultCharset()) +
                "&rvprop=timestamp" + URLEncoder.encode("|",Charset.defaultCharset()) + "user&rvlimit=16&redirects";
    }

}
