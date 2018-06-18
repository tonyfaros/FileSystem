
package filesystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Anthony-PC
 */


public class Controlador {
    
    private static Globales instance= Globales.getInstance();

    public Controlador() {
    }
    
    public void crearArchivo(String nombre, String extension, String contenido){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String fecha  = dateFormat.format(date).toString();
        System.out.println(fecha);
        int crear = FileSystem.crearArchivo(extension, nombre, contenido, false);
         
    }
    
}
