import models.ContextManager;
import models.DomAnalyzer;
import models.SaxAnalyzer;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class StrategyMain {

    public static void main(String[] args) throws XMLStreamException, ParserConfigurationException, IOException, TransformerException, SAXException {
        if (args.length < 3) {
            throw new IllegalArgumentException("Params isn`t defined. Please define its and try again");
        }
        DomAnalyzer dom = new DomAnalyzer();
        SaxAnalyzer sax = new SaxAnalyzer();
        ContextManager contextManager = new ContextManager(dom);
        contextManager.checkAvg(args[0],args[2]);

        contextManager.setStrategy(sax);
        contextManager.checkAvg(args[0],args[1]);
    }
}
