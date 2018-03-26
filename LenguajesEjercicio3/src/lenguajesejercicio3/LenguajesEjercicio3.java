/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lenguajesejercicio3;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author v6222
 */
public class LenguajesEjercicio3 {
    
    List lAgenda;
    Document dom;
    
    public LenguajesEjercicio3(){
        
        lAgenda = new ArrayList();
        
        crearDoc();
    }
    
    private void iniciar(){
        cargarXML();
        parsearDOM();
        crearDoc();
        crearDOM();
        crearXML();
        
        lAgenda = new ArrayList();
        cargarXML();
        parsearDOM();
        mostrarDOM();
    }
    
    private void crearDoc() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();

            dom = db.newDocument();

        } catch (ParserConfigurationException pce) {
            System.out.println("Hay un problema  " + pce);
            System.exit(1);
        }

    }
    
    private void crearDOM(){
    
        Element rootEle = dom.createElement("agenda");
        dom.appendChild(rootEle);

        lAgenda.add(new Agenda("Jon", "Xu", "jon.xu@ikasle.egibide.org", 622277733));
        lAgenda.add(new Agenda("Sergio", "Zulueta", "sergio.zulueta@ikasle.egibide.org", 999999999));
        
        Iterator it = lAgenda.iterator();
        while (it.hasNext()) {
            Agenda b = (Agenda) it.next();
            Element aEle = crearAgenda(b);
            rootEle.appendChild(aEle);
        }
    }
    
    private Element crearAgenda(Agenda a) {

        Element aEle = dom.createElement("contacto");

        //create author element and author text node and attach it to bookElement
        Element nomEle = dom.createElement("Nombre");
        Text nomT = dom.createTextNode(a.getNombre());
        nomEle.appendChild(nomT);
        aEle.appendChild(nomEle);

        Element apeEle = dom.createElement("apellidos");
        Text apeT = dom.createTextNode(a.getApellidos());
        apeEle.appendChild(apeT);
        aEle.appendChild(apeEle);
        
        Element emEle = dom.createElement("email");
        Text emT = dom.createTextNode(a.getEmail());
        emEle.appendChild(emT);
        aEle.appendChild(emEle);
        
        Element telEle = dom.createElement("telefono");
        Text telT = dom.createTextNode(String.valueOf(a.getTelefono()));
        telEle.appendChild(telT);
        aEle.appendChild(telEle);

        return aEle;

    }
    
    private void crearXML(){
        OutputFormat format = new OutputFormat(dom);
        format.setIndenting(true);
        XMLSerializer serializer;
        try {
            serializer = new XMLSerializer(new FileOutputStream(new File("./agenda.xml")), format);
            serializer.serialize(dom);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LenguajesEjercicio3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LenguajesEjercicio3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cargarXML(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            dom = db.parse("./agenda.xml");
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(LenguajesEjercicio3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void parsearDOM(){
        
        Element docEle = dom.getDocumentElement();

        NodeList nl = docEle.getElementsByTagName("contacto");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {

                Element el = (Element) nl.item(i);

                Agenda a = getAgenda(el);

                lAgenda.add(a);
            }
        }
    }
    
    private void mostrarDOM(){
        System.out.println("No contactos '" + lAgenda.size() + "'.");

        Iterator it = lAgenda.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    
    private Agenda getAgenda(Element e1) {

        String nombre = getTextValue(e1, "Nombre");
        String apellidos = getTextValue(e1, "apellidos");
        String email = getTextValue(e1, "email");
        int telefono = getIntValue(e1, "telefono");

        Agenda a = new Agenda(nombre, apellidos, email, telefono);

        return a;
    }
    
    private String getTextValue(Element ele, String tagName) {
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
        }

        return textVal;
    }
    
    private int getIntValue(Element ele, String tagName) {
        //in production application you would catch the exception
        return Integer.parseInt(getTextValue(ele, tagName));
    }
    
    public static void main(String [] Args){
        
        LenguajesEjercicio3 apk = new LenguajesEjercicio3();
        
        apk.iniciar();
        
    }
    
}
