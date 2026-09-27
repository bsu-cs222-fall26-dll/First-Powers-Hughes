package edu.bsu.cs222.wikipedia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class WikipediaRevisionParserTest {
    @Test
    public void testFirstUser() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("apollloSample.json");
        String user = parser.parse(testDataStream,0,"$..user");
        Assertions.assertEquals("CockroachHunter",user);
    }
    @Test
    public void testSecondUser() throws IOException {
        WikipediaRevisionParser parser = new WikipediaRevisionParser();
        InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("apollloSample.json");
        String user = parser.parse(testDataStream,1,"$..user");
        Assertions.assertEquals("Krightonn",user);
    }
}
