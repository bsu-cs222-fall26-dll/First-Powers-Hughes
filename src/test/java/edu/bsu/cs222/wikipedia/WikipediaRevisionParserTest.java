package edu.bsu.cs222.wikipedia;

import net.minidev.json.JSONArray;
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
        JSONArray user = parser.parse(DataStream,"$..user");
        String firstUser = user.get(0).toString();
        Assertions.assertEquals("CockroachHunter",firstUser);
    }
    @Test
    public void testSecondUser() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream DataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("apollloSample.json");
        JSONArray user = parser.parse(DataStream,"$..user");
        String secondUser = user.get(1).toString();
        Assertions.assertEquals("Krightonn",secondUser);
    }
    @Test
    public void testForJsonData() throws IOException, URISyntaxException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream DataStream = parser.getJsonData("Apollo");
        Assertions.assertNotNull(DataStream);

    }
    @Test
    public void testUserInputApollo() throws IOException, URISyntaxException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream DataStream=parser.getJsonData("Apollo");
        JSONArray user = parser.parse(DataStream,"$..user");
        String secondUser = user.get(1).toString();
        Assertions.assertEquals("Krightonn",secondUser);

    }


}
