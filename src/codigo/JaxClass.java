/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;


import generated.Perros;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
/**
 *
 * @author Marta
 */
public class JaxClass {
    
    JAXBContext contexto;
    Perros misPerros;
    
    public int abrirJAXB(File fichero){
      try{
          contexto=JAXBContext.newInstance(Perros.class);
          Unmarshaller u=contexto.createUnmarshaller();
          
          misPerros=(Perros)u.unmarshal(fichero);
          System.out.println("Se ha abierto el archivo");
          
          return 0;
      
      }catch(Exception ex){
        ex.printStackTrace();
        return -1;
      }
    }
    
    
}
