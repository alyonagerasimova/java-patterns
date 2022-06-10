package models;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;

public class DomAnalyzer implements Strategy {
    public double avg = 0.0;
    public double newAvg = 0.0;
    public int countOfMark = 0;

    @Override
    public void checkAverage(String file, String newDomFile) throws ParserConfigurationException,
            IOException, SAXException, TransformerException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        Node root = document.getDocumentElement();
        NodeList subject = document.getElementsByTagName("subject");

        for (int i = 0; i < subject.getLength(); i++) {
            NamedNodeMap attributes = subject.item(i).getAttributes();
            for (int j = 0; j < attributes.getLength(); j++) {
                if (attributes.item(j).getNodeName().equals("mark")) {
                    newAvg += Integer.parseInt(attributes.item(j).getTextContent());
                    countOfMark++;
                }
            }
        }
        if (countOfMark > 0) {
            newAvg = newAvg / countOfMark;
        } else {
            System.out.println("Оценки по предметам отсутствуют");
        }
        Node avgNode = document.getElementsByTagName("average").item(0);

        avg = Double.parseDouble(avgNode.getTextContent());
        if (avg != newAvg) {
            System.out.println("Средняя оценка не верна");

            avgNode.getFirstChild().setNodeValue(String.valueOf(newAvg));

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
//            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(root);
            StreamResult resultFile = new StreamResult(newDomFile);
            transformer.transform(source, resultFile);
            System.out.println("Создан новый файл с правильной средней оценкой (DOM)");
        } else {
            System.out.println("Средние значения совпадают");
        }
    }
}
