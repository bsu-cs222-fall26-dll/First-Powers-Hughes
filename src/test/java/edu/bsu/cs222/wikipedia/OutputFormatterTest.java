package edu.bsu.cs222.wikipedia;

import net.minidev.json.JSONArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class OutputFormatterTest {
    @Test
    public void outputOutputFormattertest() throws IOException, URISyntaxException {

        OutputFormatter outputFormattertest = new OutputFormatter();
        InputStream dataStream1 = new ByteArrayInputStream(Thread.currentThread().getContextClassLoader().getResourceAsStream("apollloSample.json").readAllBytes());
        String testResult = outputFormattertest.formatOutput(dataStream1);
        Assertions.assertEquals("Redirects From: Apolllo\n" +
                "To: Apollo\n" +
                "1  2026-09-12T16:46:08Z  CockroachHunter\n" +
                "2  2026-09-03T21:30:20Z  Krightonn\n" +
                "3  2026-09-03T21:09:04Z  Day Creature\n" +
                "4  2026-09-03T21:07:49Z  Day Creature\n", testResult);



    }


}
