
package filesystem;

/**
 *
 * @author Anthony-PC
 */
public class Sector {
    
    int numeroSector;
    String contenido;
    int tamTotal;
    

    public Sector(int numeroSector, String contenido, int tamTotal) {
        this.numeroSector = numeroSector;
        this.contenido = contenido;
        this.tamTotal = tamTotal;
    }

    public int getNumeroSector() {
        return numeroSector;
    }

    public void setNumeroSector(int numeroSector) {
        this.numeroSector = numeroSector;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getTamTotal() {
        return tamTotal;
    }

    public void setTamTotal(int tamTotal) {
        this.tamTotal = tamTotal;
    }
    
    
    
}
