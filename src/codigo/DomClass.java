/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package codigo;


import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import javax.xml.xpath.*;
/**
 *
 * @author Marta
 */
public class DomClass {
    
    Document doc=null;
    
    public int abrirDom(File fichero){
       try{
           //Creamos un DocumentBuilderFactory que nos permitirá crear el DocumentBUilder
           DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
           //Ignoramos comentarios y espacios en blanco del documento.
           factory.setIgnoringComments(true);
           factory.setIgnoringElementContentWhitespace(true);
           //A partir del factory creamos un DocumentBuilder que nos va a permitir cargar en él
           //la estructura del árbol DOM a partir del XML que le hemos pasado.
           DocumentBuilder builder=factory.newDocumentBuilder();
           //Parseamos el fichero y cargamos sobre el Document la estructura de árbol del DOM.
           doc=builder.parse(fichero);
                  
           return 0;
       
       }catch(Exception e){
          e.printStackTrace();
          return -1;
       }
    }
    
    //Vamos a crear un método de procesamiento para comprobar que los datos se guardan correctamente.
    
    public String recorrerDom(){
       String datos_nodo[]=null;
       String salida="";
       Node node;
       
       //Obtenemos el primer nodo del Dom.
       Node raiz=doc.getFirstChild();
       //Obtenemos una lista de nodos con todos los nodos hijo del nodo raíz.
       NodeList listaNodos=raiz.getChildNodes();
       //Procesamos los nodos hijo con un bucle for.
       for(int i=0; i<listaNodos.getLength(); i++){
           node=listaNodos.item(i); //node adopta el valor del elemento en la lista de nodos posición i. Es un elemento perro.
                                    //Estos son los elementos que vamos a procesar con el método procesarPerros.
           if(node.getNodeType()==Node.ELEMENT_NODE){
               datos_nodo=procesarPerros(node); //Este array es el mismo que devuelve el método procesarPerros.
               //En salida guardamos el valor del array datos_nodo ya procesado
               salida=salida + "\n" + "Chip; " + datos_nodo[1];
                salida=salida + "\n" + "Afijo; " + datos_nodo[0];
                 salida=salida + "\n" + "Nacimiento; " + datos_nodo[2];
                  salida=salida + "\n" + "Nombre; " + datos_nodo[3];
                   salida=salida + "\n" + "Raza; " + datos_nodo[4];
                    salida=salida + "\n" + "Sexo; " + datos_nodo[5];
                     salida=salida + "\n" + "Propietario; " + datos_nodo[6];
                      salida=salida + "\n" + "Deporte; " + datos_nodo[7];
                       salida=salida + "\n" + "Grado; " + datos_nodo[8];
                        salida=salida + "\n" + "Club; " + datos_nodo[9];
                        salida=salida + "\n" + "---------------------------";
           }
       }
        
        return salida;
    }
    
    //Vamos a procesar los nodos perro, hijos del nodo raíz perros, para obtener sus datos. Para ellos le pasamos
    //el Nodo perro obtenido en el método anterior.
    protected String[] procesarPerros(Node n){
        String datos[]=new String[10]; //Declaramos un array de 10 que es lo que nos va a devolver con el contenido del árbol
        Node ntemp=null; //Declaramos un nodo temporal para poder procesar los nodos hijo de perro.
        int contador=3; //Lo vamos a usar para movernos por las posiciones dentro del array.
        //Dentro del array guardamos los valores de los nodos atributo.
        datos[0]=n.getAttributes().item(0).getNodeValue();
        datos[1]=n.getAttributes().item(1).getNodeValue();
        datos[2]=n.getAttributes().item(2).getNodeValue();
        //Dentro de una lista de nodos guardamos todos los nodos hijo de perro (nombre, propietario, club, deporte, etc, etc, etc).
        //n es el nodo perro que le hemos pasado en el método de recorrerDom.
        NodeList nodos=n.getChildNodes();
        //Procesamos a través de un bucle for.
        for(int i=0; i<nodos.getLength();i++){
            ntemp=nodos.item(i); //ntemp adopta el valor del elemento de la lista de nodos en la posición i en cada vuelta del bucle
            //En caso que el tipo de nodo de ntemp sea tipo elemento, ejecutamos el código.
            if(ntemp.getNodeType()==Node.ELEMENT_NODE){
                //Accedemos al nodo hijo de los nodos tipo elemento para poder obtener el valor texto. Los nodos hijo
                //de nombre, propietario, etc, son nodos texto donde se almacena el contenido textual del nodo.
                datos[contador]=ntemp.getChildNodes().item(0).getNodeValue();
                contador++;  //El contador nos mueve a través de la posición del array.
            }
        }
        
        return datos;
    }
    
    
    public int addDom(String chip, String afijo, String nacimiento, String nombre, String raza, 
            String sexo, String propietario, String deporte, String grado, String club){
        try{
             //Vamos a crear un nodo de tipo elemento con el nombre de 'nombre' (<nombre>)
            Node pNombre=doc.createElement("nombre");
            //Creamos un nodo tipo texto con el nombre del perro. Le pasamos como parámetro lo que haya escrito el usuario
            //en el textfield.
            Node pNombre_texto=doc.createTextNode(nombre);
            //Añadimos el nodo texto que acabamos de crear al nodo nombre, como hijo del elemento nombre.
            pNombre.appendChild(pNombre_texto);
            //Este mismo proceso lo hacemos con todos los demás nodos tipo elemento.
            //Elemento tipo raza.
            Node pRaza=doc.createElement("raza");
            Node pRaza_texto=doc.createTextNode(raza);
            pRaza.appendChild(pRaza_texto);
            //Elemento tipo sexo.
            Node pSexo=doc.createElement("sexo");
            Node pSexo_texto=doc.createTextNode(sexo);
            pSexo.appendChild(pSexo_texto);
            //Elemento tipo propietario.
            Node pProp=doc.createElement("propietario");
            Node pProp_texto=doc.createTextNode(propietario);
            pProp.appendChild(pProp_texto);
            //Elemento tipo deporte
            Node pDeporte=doc.createElement("deporte");
            Node pDeporte_texto=doc.createTextNode(deporte);
            pDeporte.appendChild(pDeporte_texto);
            //Elemento tipo grado
            Node pGrado=doc.createElement("grado");
            Node pGrado_texto=doc.createTextNode(grado);
            pGrado.appendChild(pGrado_texto);
            //Elemento tipo club
            Node pClub=doc.createElement("club");
            Node pClub_texto=doc.createTextNode(club);
            pClub.appendChild(pClub_texto);
        
            //Creamos un nodo de tipo perro.
            Node pPerro=doc.createElement("perro");
        
            //Al nuevo nodo le añadimos los atributos.
            ((Element)pPerro).setAttribute("chip", chip);
            ((Element)pPerro).setAttribute("afijo", afijo);
            ((Element)pPerro).setAttribute("nacimiento", nacimiento);
        
            //Se añaden al nodo perro el resto de nodos tipo elemento que hemos creado antes. 
            pPerro.appendChild(pNombre);
            pPerro.appendChild(pRaza);
            pPerro.appendChild(pSexo);
            pPerro.appendChild(pProp);
            pPerro.appendChild(pDeporte);
            pPerro.appendChild(pGrado);
            pPerro.appendChild(pClub);
        
            //Obtenemos el primer nodo del documento y le añadimos como hijos el nodo perro que ya
            //tiene todos sus nodos hijos y atributos creados y añadidos.
            Node raiz= doc.getChildNodes().item(0);
            raiz.appendChild(pPerro);
            
            return 0;
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    
    }
    
    //Búsqueda de datos específicos con XPATH. Vamos a utilizar los métodos del árbol DOM.
    
    public String ejecutaXPATH(String consulta){
           String datos_nodo[]=null;
           String salida="";
           Node node;
           
           try{
               //Creamos un objeto XPATH.
               XPath path=XPathFactory.newInstance().newXPath();
               //Creamos un XPATHEXPRESSION con la consulta deseada. La consulta se la vamos a pasar como parámetro
               //de entrada a través de los radiobuttons.
               XPathExpression exp=path.compile(consulta);
               //Ejecuta la consulta sobre el DOM y devuelve el resultado en una lista de nodos que hay que procesar.
               Object result=exp.evaluate(doc, XPathConstants.NODESET);
               NodeList lista=(NodeList)result;
               //Recorremos la lista con un bucle for para sacar los resultados.
               for(int i=0;i<lista.getLength(); i++){
                   node=lista.item(i); //Analizamos el objeto en la lista en la posición i.
                   //En caso de que el nodo sea de tipo elemento y el nombre del elemento sea perro, ejecutamos
                   //el mismo código con el que procesábamos los perros para que nos dé todos los resultados.
                   if(node.getNodeType()==Node.ELEMENT_NODE && node.getNodeName()=="perro"){
                      datos_nodo=procesarPerros(node);
                      
                       //En salida guardamos el valor del array datos_nodo ya procesado
                        salida=salida + "\n" + "Chip; " + datos_nodo[1];
                         salida=salida + "\n" + "Afijo; " + datos_nodo[0];
                          salida=salida + "\n" + "Nacimiento; " + datos_nodo[2];
                           salida=salida + "\n" + "Nombre; " + datos_nodo[3];
                            salida=salida + "\n" + "Raza; " + datos_nodo[4];
                             salida=salida + "\n" + "Sexo; " + datos_nodo[5];
                              salida=salida + "\n" + "Propietario; " + datos_nodo[6];
                               salida=salida + "\n" + "Deporte; " + datos_nodo[7];
                                salida=salida + "\n" + "Grado; " + datos_nodo[8];
                                 salida=salida + "\n" + "Club; " + datos_nodo[9];
                                  salida=salida + "\n" + "---------------------------";                                   
                   }else if(node.getNodeType()==Node.ELEMENT_NODE && (node.getNodeName()=="raza" || node.getNodeName()=="sexo"
                           || node.getNodeName()=="deporte" || node.getNodeName()=="grado" || node.getNodeName()=="club")){
                       //Procedemos a analizar los nodos tipo elemento hijos de perro.
                       salida=salida + "\n" + lista.item(i).getChildNodes().item(0).getNodeValue();
                   }else if(node.getNodeType()==Node.ATTRIBUTE_NODE && (node.getNodeName()=="afijo" || node.getNodeName()=="nacimiento")){
                       //Obtenemos los atributos
                       salida=salida + "\n" + lista.item(i).getChildNodes().item(0).getNodeValue();
                   }
               
               }
           
           
           }catch(Exception ex){
              salida="Error: " + ex.toString();
              return salida;
           }
           
           
           return salida;
    }
    
    
   
    //Método que nos permite guardar el archivo DOM, que nos servirá para guardar los añadidos del DOM
    
    public int guardarDomComoFile(File nombreArchivo){
  
           try{
            //especificamos el formato de salida.
            OutputFormat format= new OutputFormat(doc); 
            //Especificamos que la salida esté indentada
            format.setIndenting(true);
            //Escribe el contenido en el file serializando y lo guarda en el archivo.
            XMLSerializer serializer=new XMLSerializer(new FileOutputStream(nombreArchivo),format);
            
            serializer.serialize(doc);
            
            return 0;   
        
        }catch(Exception e){
            System.out.println("No se ha guardado el archivo");
            return -1;
        }

          
        }
    
    
    
}




