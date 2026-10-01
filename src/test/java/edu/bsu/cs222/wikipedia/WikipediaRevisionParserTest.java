package edu.bsu.cs222.wikipedia;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class WikipediaRevisionParserTest {
    @Test
    public void testDataStreamNotNull() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream DataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("apollloSample.json");
        JSONArray user = parser.parse(DataStream,"$..user");
        Assertions.assertNotNull(user);
    }
    @Test
    public void testFirstUser() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream DataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("apollloSample.json");
        JSONArray user = parser.parse(DataStream,"$..user");
        String firstUser = user.getFirst().toString();
        Assertions.assertEquals("CockroachHunter",firstUser);
    }
    @Test
    public void testSecondUser() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream dataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("apollloSample.json");
        JSONArray user = parser.parse(dataStream,"$..user");
        String secondUser = user.get(1).toString();
        Assertions.assertEquals("Krightonn",secondUser);
    }
    @Test
    public void testForJsonData() throws IOException, URISyntaxException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream dataStream = parser.getJsonData("Apollo");
        Assertions.assertNotNull(dataStream);

    }
    @Test
    public void testUserInputApollo() throws IOException, URISyntaxException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream dataStream=parser.getJsonData("Apollo");
        JSONArray user = parser.parse(dataStream,"$..user");
        String secondUser = user.get(1).toString();
        Assertions.assertEquals("Krightonn",secondUser);

    }
    @Test
    public void testGetUserAndTimestamp() throws IOException, URISyntaxException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream dataStream = parser.getJsonData("Apollo");
        JSONArray user = parser.parse(dataStream,"$..user");
        dataStream.reset();
        JSONArray timestamp = parser.parse(dataStream,"$..timestamp");

        String revision = (user.getFirst().toString() + timestamp.getFirst().toString());
        Assertions.assertEquals("CockroachHunter2026-09-12T16:46:08Z",revision);
    }


}
