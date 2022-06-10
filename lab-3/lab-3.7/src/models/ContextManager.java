package models;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class ContextManager {
    private Strategy strategy;

    public ContextManager(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void checkAvg(String inputFile, String resultFile) throws ParserConfigurationException,
            TransformerException, SAXException, XMLStreamException, IOException {
        if (inputFile != null && resultFile != null) {
            strategy.checkAverage(inputFile, resultFile);
        }
    }
}
