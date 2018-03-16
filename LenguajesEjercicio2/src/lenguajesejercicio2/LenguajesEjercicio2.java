package lenguajesejercicio2;

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

public class LenguajesEjercicio2 extends DefaultHandler {

    List myEmpls;

    private String tempVal;

    //to maintain context
    private Dia tempEmp;
    private Dato dato;
    private Probabilidad pro;
    private Temperatura temp;
    private Viento viento;

    public LenguajesEjercicio2() {
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

        System.out.println("No de Dias '" + myEmpls.size() + "'.");

        Iterator it = myEmpls.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    //Event Handlers
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //reset
        tempVal = "";
        if (qName.equalsIgnoreCase("dia")) {
            //create a new instance of employee
            tempEmp = new Dia();
            tempEmp.setFecha(attributes.getValue("fecha"));
        }
        else if(qName.equalsIgnoreCase("prob_precipitacion")){
            pro = new Probabilidad();
            pro.setPeriodo(attributes.getValue("periodo"));
        }
        else if(qName.equalsIgnoreCase("cota_nieve_prov")){
            pro = new Probabilidad();
            pro.setPeriodo(attributes.getValue("periodo"));
        }
        else if(qName.equalsIgnoreCase("estado_cielo")){
            pro = new Probabilidad();
            pro.setPeriodo(attributes.getValue("periodo"));
            pro.setDescripcion(attributes.getValue("descripcion"));
        }
        else if(qName.equalsIgnoreCase("viento")){
            viento = new Viento();
            viento.setPeriodo(attributes.getValue("periodo"));
        }
        else if(qName.equalsIgnoreCase("racha_max")){
            viento = new Viento();
            viento.setPeriodo(attributes.getValue("periodo"));
        }
        else if(qName.equalsIgnoreCase("temperatura")){
            temp = new Temperatura();
        }
        else if(qName.equalsIgnoreCase("dato")){
            dato = new Dato();
            dato.setHora(attributes.getValue("hora"));
        }
        else if(qName.equalsIgnoreCase("sens_termica")){
            temp = new Temperatura();
        }
        else if(qName.equalsIgnoreCase("humedad_relativa")){
            temp = new Temperatura();
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if(tempEmp != null){
            if (qName.equalsIgnoreCase("dia")) {
                //add it to the list
                myEmpls.add(tempEmp);
                tempEmp = null;

            } else if (qName.equalsIgnoreCase("prob_precipitacion")) {
                pro.setProbabilidad(tempVal);
                tempEmp.setlPrecipitacion(pro);
            } else if (qName.equalsIgnoreCase("cota_nieve_prov")) {
                pro.setProbabilidad(tempVal);
                tempEmp.setlNieve(pro);
            } else if (qName.equalsIgnoreCase("estado_cielo")) {
                pro.setProbabilidad(tempVal);
                tempEmp.setlCielo(pro);
            } 
            
            else if (qName.equalsIgnoreCase("direccion")) {
                viento.setDireccion(tempVal);
            }
            else if (qName.equalsIgnoreCase("velocidad")) {
                viento.setVelocidad(tempVal);
            }
            else if (qName.equalsIgnoreCase("viento")) {
                tempEmp.setlViento(viento);
            }
            
            else if (qName.equalsIgnoreCase("racha_max")) {
                viento.setVelocidad(tempVal);
                tempEmp.setlRacha(viento);
            }
            
            else if (qName.equalsIgnoreCase("maxima")) {
                temp.setMaxima(tempVal);
            }
            else if (qName.equalsIgnoreCase("minima")) {
                temp.setMinima(tempVal);
            }
            else if (qName.equalsIgnoreCase("dato")) {
                dato.setDato(tempVal);
                temp.setLdato(dato);
            }
            else if (qName.equalsIgnoreCase("temperatura")) {
                tempEmp.setlTemperatura(temp);
            }
            
            else if (qName.equalsIgnoreCase("sens_termica")) {
                tempEmp.setlTermica(temp);
            }
            
            else if (qName.equalsIgnoreCase("humedad_relativa")) {
                tempEmp.setlRelativa(temp);
            }
            
            else if (qName.equalsIgnoreCase("uv_max")) {
                tempEmp.setUv(tempVal);
            }
        }
        

    }

    public static void main(String[] args) {

        System.out.println("SAX");
        System.out.println("---");

        LenguajesEjercicio2 spe = new LenguajesEjercicio2();
        spe.runExample();
    }

}
