package lenguajesejercicio1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class LenguajesEjercicio1 extends DefaultHandler {

    List myEmpls;

    private String tempVal;

    //to maintain context
    private NoticiaAyuntamiento tempEmp;

    public LenguajesEjercicio1() {
        myEmpls = new ArrayList();
    }

    public void runExample() {
       
        parseDocument();
        printData();
    }

    private void parseDocument() {

		//get a factory
        try {
            //get a new instance of parser
            SAXParser spf = SAXParserFactory.newInstance().newSAXParser();

            //parse the file and also register this class for call backs
            spf.parse("rssAction.xml", this);

        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * Iterate through the list and print the contents
     */
    private void printData() {

        System.out.println("No de noticias '" + myEmpls.size() + "'.");

        Iterator it = myEmpls.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    //Event Handlers
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //reset
        tempVal = "";
        if (qName.equalsIgnoreCase("item")) {
            //create a new instance of employee
            tempEmp = new NoticiaAyuntamiento();
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if(tempEmp != null){
            if (qName.equalsIgnoreCase("item")) {
                //add it to the list
                myEmpls.add(tempEmp);
                tempEmp = null;

            } else if (qName.equalsIgnoreCase("title")) {
                tempEmp.setTitle(tempVal);
            } else if (qName.equalsIgnoreCase("link")) {
                tempEmp.setLink(tempVal);
            } else if (qName.equalsIgnoreCase("pubDate")) {
                tempEmp.setPubDate(tempVal);
            } else if (qName.equalsIgnoreCase("guid")) {
                tempEmp.setGuid(tempVal);
            } else if (qName.equalsIgnoreCase("dc:creator")) {
                tempEmp.setCreator(tempVal);
            } else if (qName.equalsIgnoreCase("dc:date")) {
                tempEmp.setDate(tempVal);
            } else if (qName.equalsIgnoreCase("dc:source")) {
                tempEmp.setSource(tempVal);
            }
        }
        

    }

    public static void main(String[] args) {

        System.out.println("SAX");
        System.out.println("---");

        LenguajesEjercicio1 spe = new LenguajesEjercicio1();
        spe.runExample();
    }

}
