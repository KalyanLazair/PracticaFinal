/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
/**
 *
 * @author Marta
 */
public class SaxClass {
    
    //Vars de instancia que vamos a manejar
    File ficheroXML;
    SAXParser parser;
    ManejadorSAX manejador;
    
    
    //Método para abrir el archivo XML a través de SAX. Le vamos a pasar el fichero como parámetro a través de
    //la página principal, el que obtenemos con el jDialog.
    public int abrirSAX(File fichero){
        try{
           //Creamos un objeto SaxParserFactory
           SAXParserFactory factory=SAXParserFactory.newInstance();
           //Creamos un objeto parser que es el que nos va a interpretar el documento.
           parser=factory.newSAXParser();
           //Creamos una instancia del manejador que nos va a recorrer el documento de manera secuencial y nos va
           //a lanzar los eventos cuando detecte una etiqueta.        
           manejador=new ManejadorSAX();
           //FicheroXML adopta el valor del fichero que le hemos pasado como parámetro
           ficheroXML=fichero;
           
           return 0;
        
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
       
    }
    
    
    //Manejador Sax que extiende a la clase DefaultHandler y que nos va a permitir, a través de eventos
    //gestionar el contenido del fichero y sacarlo por pantalla.
    class ManejadorSAX extends DefaultHandler{
        int ultimoElemento;
        String cadena_resultado="";
      
        public ManejadorSAX(){
            ultimoElemento=0;
        }
        //Método que nos permite indicar qué hacemos cuando nos encontramos con una etiqueta de apertura
        @Override public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException{
           
        }
        
        //Método que nos va a permitir indicar qué ocurre cuando nos encontramos con una etiqueta de cierre
        @Override public void endElement(String uri, String localName, String qName) throws SAXException{
        
        }
        
        //Método que nos va a permitir manejar elementos tipo char.
        @Override public void characters(char[] ch, int start, int length) throws SAXException{
        
        }
    }
    
}
