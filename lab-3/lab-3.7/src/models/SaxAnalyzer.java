package models;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.TransformerException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SaxAnalyzer implements Strategy {
    public static double average = 0;
    public static double newAverage = 0;

    @Override
    public void checkAverage(String file, String resultFile) throws ParserConfigurationException, IOException,
            SAXException, XMLStreamException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        StudentHandler handler = new StudentHandler();
        parser.parse(file, handler);

        ArrayList<Integer> listMarks = handler.getListMark();
        ArrayList<String> listSubject = handler.getListSubject();
        String lastname = handler.getLastName();

        for (Integer mark : listMarks) {
            newAverage += mark;
        }

        average = handler.getAvg();

        if (listMarks.size() != 0) {
            newAverage /= listMarks.size();
        } else {
            System.out.println("Оценки по предметам отсутствуют");
        }

        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
        FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
        XMLStreamWriter xmlWriter = xmlOutputFactory.createXMLStreamWriter(fileOutputStream);

        if (average != newAverage) {
            xmlWriter.writeStartDocument("UTF-8", "1.0");
            xmlWriter.writeCharacters("\n");
            xmlWriter.writeStartElement("student");
            xmlWriter.writeAttribute("lastname", lastname);
            xmlWriter.writeCharacters("\n");

            for (int i = 0; i < listMarks.size(); i++) {
                xmlWriter.writeCharacters("     ");
                xmlWriter.writeStartElement("subject");
                xmlWriter.writeAttribute("title", listSubject.get(i));
                xmlWriter.writeAttribute("mark", String.valueOf(listMarks.get(i)));
                xmlWriter.writeEndElement();
                xmlWriter.writeCharacters("\n");
            }

            xmlWriter.writeCharacters("     ");
            xmlWriter.writeStartElement("average");
            xmlWriter.writeCharacters(String.valueOf(newAverage));
            xmlWriter.writeEndElement();
            xmlWriter.writeCharacters("\n");
            xmlWriter.writeEndElement();
            System.out.println("Исправления записаны в новый файл (SAX)");
        } else {
            System.out.println("Средняя оценка верна");
        }

        xmlWriter.writeEndDocument();
    }
}
