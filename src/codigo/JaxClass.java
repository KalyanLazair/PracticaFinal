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
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
/**
 *
 * @author Marta
 */
public class JaxClass {
    
    JAXBContext contexto; //Crea un contexto con una una nueva instancia de JaxB para la clase principal obtenida del esquema XML.
    Perros misPerros;  //Creamos un objeto tipo Perros
    
    public int abrirJAXB(File fichero){
      try{
          //Se crea la instancia JAXB.
          contexto=JAXBContext.newInstance(Perros.class);
          //Se usa para obtener del documento XML los datos que son almacenados en la estructura de objetos Java.
          Unmarshaller u=contexto.createUnmarshaller();
          //Deserializa el fichero. Se lee el fichero y lo interpreta en las clases Java.
          misPerros=(Perros)u.unmarshal(fichero);
          
          return 0;
      
      }catch(Exception ex){
        ex.printStackTrace();
        
        return -1;
      }
    }
    
    //Método para recorrer la lista que nos genera JaxB. Vamos a guardar los datos en un array que usaremos en la aplicación
    //para guardar los datos en sus correspondientes textareas para modificarlos posteriormente.
    public String[] recorrerJaxB(String entrada){
        String datos[]=new String[10]; //Declaramos un array donde vamos a guardar los datos que obtendremos al recorrer el archivo
        String auxiliar=""; //String que vamos a utilizar para hacer comprobaciones.
        try{
          //Se crea una lista con objetos de tipo Perro.
          List<Perros.Perro> losPerros=misPerros.getPerro();
        
          //Recorremos la lista para sacar los valores.
          for(int i=0; i<losPerros.size(); i++){
            //Vamos a guardar el valor del chip en una variable string auxiliar, que usaremos para hacer una comprobación
            //Si coincide con elvalor introducido por el usuario como parámetro de entrada, entonces guardamos los
            //datos relacionados con ese chip en un array.
             auxiliar=losPerros.get(i).getChip();

             if(auxiliar.equals(entrada)){
                datos[0]=losPerros.get(i).getChip();
                datos[1]=losPerros.get(i).getAfijo();
                datos[2]=losPerros.get(i).getNacimiento();
                datos[3]=losPerros.get(i).getNombre();
                datos[4]=losPerros.get(i).getRaza();
                datos[5]=losPerros.get(i).getSexo();
                datos[6]=losPerros.get(i).getPropietario();
                datos[7]=losPerros.get(i).getDeporte();
                datos[8]=losPerros.get(i).getGrado();
                datos[9]=losPerros.get(i).getClub();
             }
           
          }
        }catch(Exception e){
           e.printStackTrace();
        }

        return datos;
    }
    //Método que edita los datos en JaxB. Le pasamos los valores como parámetros de entrada.
    public int editarJaxB(String chip, String afijo, String nacimiento, String nombre, String raza, 
            String sexo, String propietario, String deporte, String grado, String club){
        String auxiliar=""; //Vamos a utilizar el String auxiliar para hacer comprobaciones.
        
        try{
            List<Perros.Perro> losPerros=misPerros.getPerro();
            
            for(int i=0;i<losPerros.size();i++){
                auxiliar=losPerros.get(i).getChip(); //Asignamos el valor del objeto chip al String auxiliar.
                //En caso que sea igual al del parámetro que le hemos pasado como entrada, ejecuta
                //Modifica todos los datos para facilitar la tarea.
                if(auxiliar.equals(chip)){
                   losPerros.get(i).setAfijo(afijo);
                   losPerros.get(i).setNacimiento(nacimiento);
                   losPerros.get(i).setNombre(nombre);
                   losPerros.get(i).setRaza(raza);
                   losPerros.get(i).setSexo(sexo);
                   losPerros.get(i).setPropietario(propietario);
                   losPerros.get(i).setDeporte(deporte);
                   losPerros.get(i).setGrado(grado);
                   losPerros.get(i).setClub(club);
                }
            }
            
            
            return 0;
        
        }catch(Exception e){
            e.printStackTrace();
            return -1;
        }
    
    }
    //Método para guardar.
    public void guardarJaxB(File archivo){
       try{
          //Creamos un objeto marshaller
          Marshaller m=contexto.createMarshaller();
          //Le damos formato para que no nos lo guarde en una linea
          m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
          //llamamos al marshaller y serializamos el objeto misPerros en el archivo que le pasamos como parámetro
          m.marshal(misPerros, archivo);
       }catch(Exception e){
         e.printStackTrace();
       }
    
    }
    
    
}
