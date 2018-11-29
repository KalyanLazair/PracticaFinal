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
    
    //Vars de instancia que vamos a manejar.
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
        int ultimoElemento;  //Nos va a permitir obtener el texto de los elementos que no sean atributos.
        String cadena_resultado="";
      
        public ManejadorSAX(){
            ultimoElemento=0;
        }
        //Método que nos permite indicar qué hacemos cuando nos encontramos con una etiqueta de apertura
        @Override public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException{
           if(qName.equals("perro")){
               //Obtenemos los valores de los atributos y los guardamos en la cadena_resultado que nos va a devolver.
               cadena_resultado=cadena_resultado+ "\nChip: " + atts.getValue(atts.getQName(0))+ "\n";
               cadena_resultado=cadena_resultado+ "Afijo: " + atts.getValue(atts.getQName(1))+ "\n";
               cadena_resultado=cadena_resultado+ "Nacimiento: " + atts.getValue(atts.getQName(2))+"\n";
               ultimoElemento=1;
           }else if(qName.equals("nombre")){
               ultimoElemento=2;
               cadena_resultado=cadena_resultado + "Nombre; ";
           }else if(qName.equals("raza")){
               ultimoElemento=3;
               cadena_resultado=cadena_resultado + "Raza; ";
           
           }else if(qName.equals("sexo")){
               ultimoElemento=4;
               cadena_resultado=cadena_resultado + "Sexo; ";
           
           }else if(qName.equals("propietario")){
               ultimoElemento=5;
               cadena_resultado=cadena_resultado + "Propietario; ";
           
           }else if(qName.equals("deporte")){
               ultimoElemento=6;
               cadena_resultado=cadena_resultado + "Deporte; ";
           
           }else if(qName.equals("grado")){
               ultimoElemento=7;
               cadena_resultado=cadena_resultado + "Grado; ";
           
           }else if(qName.equals("club")){
               ultimoElemento=8;
               cadena_resultado=cadena_resultado + "Club; ";
           
           }
        }
        
        //Método que nos va a permitir indicar qué ocurre cuando nos encontramos con una etiqueta de cierre
        @Override public void endElement(String uri, String localName, String qName) throws SAXException{
             if(qName.equals("perro")){
               System.out.println("Se ha encontrado el final de un elemento");
               cadena_resultado=cadena_resultado + "\n -----------------------------";
             }
        }
        
        //Método que nos va a permitir manejar elementos tipo char.
        @Override public void characters(char[] ch, int start, int length) throws SAXException{
           if(ultimoElemento==2){
               //usamos un bucle for para recorrer los chars que el manejador se ha encontrado.
              for(int i=start; i<length+start; i++){
                 cadena_resultado=cadena_resultado+ch[i];
              }
           }else if(ultimoElemento==3){
              for(int i=start; i<length+start; i++){
                 cadena_resultado=cadena_resultado+ch[i];
              }
           }else if(ultimoElemento==4){
             for(int i=start; i<length+start; i++){
                 cadena_resultado=cadena_resultado+ch[i];
              }
           }else if(ultimoElemento==5){
              for(int i=start; i<length+start; i++){
                 cadena_resultado=cadena_resultado+ch[i];
              }
           }else if(ultimoElemento==6){
              for(int i=start; i<length+start; i++){
                 cadena_resultado=cadena_resultado+ch[i];
              }
           }else if(ultimoElemento==7){
              for(int i=start; i<length+start; i++){
                 cadena_resultado=cadena_resultado+ch[i];
              }
           }else if(ultimoElemento==8){
              for(int i=start; i<length+start; i++){
                 cadena_resultado=cadena_resultado+ch[i];
              }
           }
        }
    }
    
    public String recorrerSAX(){
        try{
            //Parseamos el archivo con el manejador SAX para que nos lance los eventos y nos ejecute el código.
            parser.parse(ficheroXML,manejador);
            return manejador.cadena_resultado;
        
        }catch(SAXException e){
          e.printStackTrace(); 
          return "Error al parsear con SAX";
        }catch(Exception e){
          e.printStackTrace(); 
          return "Error al parsear con SAX";
        }
    }
    
}
