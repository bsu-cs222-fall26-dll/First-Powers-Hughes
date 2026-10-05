package edu.bsu.cs222.wikipedia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;

public class WikipediaConnectorTest {
    @Test
    public void testWikipediaDataNotNull() throws IOException, URISyntaxException {
        WikipediaConnector connector = new WikipediaConnector();
        String testData = connector.startSearcher("Zappa");
        Assertions.assertNotNull(testData);
    }

}
