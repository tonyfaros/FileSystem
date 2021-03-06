
package filesystem;

import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author Anthony-PC
 */
public class Globales {
    
    private static Globales instance;
    
    private static Directorio directorioActual;
    
    private static Directorio root;
    
    private static String rutas;

    public static Globales getInstance(){
        if(instance == null){
            instance = new Globales();
            directorioActual = null;
            root = null;
            rutas = "";
        }
        return instance;
    }
    
    public Directorio getDirectorioActual() {
        return directorioActual;
    }
    
    public Directorio getRoot() {
        return root;
    }
    
    public void setDirectorioActual(Directorio dirActual){
        Globales.directorioActual = dirActual;
    }
    
    public void setRoot(Directorio root){
        Globales.root = root;
    }
    
    public void addRuta(String ruta){
        Globales.rutas += "\n"+ruta;
        
    }
    
    public String getRuta(){
        return rutas;
    }
    
    public void setRuta(){
        Globales.rutas = "";
    }
    
}
