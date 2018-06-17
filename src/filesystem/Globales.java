
package filesystem;

/**
 *
 * @author Anthony-PC
 */
public class Globales {
    
    private static Globales instance;
    
    private static Directorio directorioActual;

    public static Globales getInstance(){
        if(instance == null){
            instance = new Globales();
            directorioActual = null;
        }
        return instance;
    }
    
    public Directorio getDirectorioActual() {
        return directorioActual;
    }
    
}
