
package filesystem;

/**
 *
 * @author Anthony-PC
 */
public class Archivo {
    int tamano;
    String extension;
    String nombre;
    String fechaCreacion;
    String fechaMod;
    String contenido;
    int numSector;
    Directorio dPadre;

    public Archivo(int tamano, String extension, String nombre, String fechaCreacion, String fechaMod, String contenido, 
            int numSector, Directorio dPadre) {
        this.tamano = tamano;
        this.extension = extension;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.fechaMod = fechaMod;
        this.contenido = contenido;
        this.numSector = numSector;
        this.dPadre = dPadre;
    }

    public Directorio getdPadre() {
        return dPadre;
    }

    public void setdPadre(Directorio dPadre) {
        this.dPadre = dPadre;
    }
    
    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(String fechaMod) {
        this.fechaMod = fechaMod;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getNumSector() {
        return numSector;
    }

    public void setNumSector(int numSector) {
        this.numSector = numSector;
    }
   
}
