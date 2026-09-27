package edu.bsu.cs222.wikipedia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class WikipediaRevisionParserTest {
    @Test
    public void testFirstUser() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream DataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("apollloSample.json");
        String user = parser.parse(DataStream,0,"$..user");
        Assertions.assertEquals("CockroachHunter",user);
    }
    @Test
    public void testSecondUser() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream DataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("apollloSample.json");
        String user = parser.parse(DataStream,1,"$..user");
        Assertions.assertEquals("Krightonn",user);
    }
    @Test
    public void testForJsonData() throws IOException, URISyntaxException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        String jsonData = parser.getJsonData("Apollo");
        Assertions.assertNotNull(jsonData);

    }

}
