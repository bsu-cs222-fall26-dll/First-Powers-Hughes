package edu.bsu.cs222.wikipedia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Objects;

public class OutputFormatterTest {
    @Test
    public void outputOutputFormatterTest() throws IOException {

        OutputFormatter outputFormattertest = new OutputFormatter();
        InputStream dataStream1 = new ByteArrayInputStream(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream("apollloSample.json")).readAllBytes());
        String testResult = outputFormattertest.formatOutput(dataStream1);
        Assertions.assertEquals("""
                Redirects From: Apolllo
                To: Apollo
                1  2026-09-12T16:46:08Z  CockroachHunter
                2  2026-09-03T21:30:20Z  Krightonn
                3  2026-09-03T21:09:04Z  Day Creature
                4  2026-09-03T21:07:49Z  Day Creature
                """, testResult);



    }
    @Test
    public void notfoundOutputFormatterTest() throws IOException, URISyntaxException {
        OutputFormatter outputFormattertest = new OutputFormatter();
        WikipediaRevisionParser parsertest = new WikipediaRevisionParser();
        String testResult= outputFormattertest.formatOutput(parsertest.getJsonData("ghjgfdgdfgfdgerpopopofhgfgfghf"));
        Assertions.assertEquals("No Page Found", testResult);
    }

    }
