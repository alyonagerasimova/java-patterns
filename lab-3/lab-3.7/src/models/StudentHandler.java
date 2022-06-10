package models;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class StudentHandler extends DefaultHandler {
    private String lastName;
    private final ArrayList<Integer> listMark = new ArrayList<>();
    private final ArrayList<String> listSubject = new ArrayList<>();
    private double avg;
    private String element;

    @Override
    public void startElement(String namespace, String localName, String qname, Attributes attributes) {
        String mark = attributes.getValue("mark");
        String subject = attributes.getValue("title");
        String name = attributes.getValue("lastname");
        element = qname;

        if (name != null) {
            lastName = name;
        }
        if (subject != null) {
            listSubject.add(subject);
        }
        if (mark != null) {
            listMark.add(Integer.parseInt(mark));
        }
    }

    public ArrayList<Integer> getListMark() {
        return listMark;
    }

    public ArrayList<String> getListSubject() {
        return listSubject;
    }

    public double getAvg() {
        return avg;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public void characters(char[] ch, int start, int end) {
        if (element.equals("average")) {
            String str = new String(ch, start, end);
            avg = Double.parseDouble(str);
        }
    }
}
