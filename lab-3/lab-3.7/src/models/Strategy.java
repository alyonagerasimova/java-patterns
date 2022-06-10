package models;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public interface Strategy {
    void checkAverage(String file, String newFile) throws ParserConfigurationException, IOException, SAXException, TransformerException, XMLStreamException;
}
