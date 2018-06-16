/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

/**
 *
 * @author Anthony-PC
 */
public class FileSys {
    
    Directorio dRaiz;
    //Directorio dHijo;
    //int tamano;
    int cantSectores;
    int tamSector;
    String nombreRaiz;

    public FileSys(Directorio dRaiz,/* int tamano,*/ int cantSectores, int tamSector, String nombreRaiz) {
        this.dRaiz = dRaiz;
        //this.tamano = tamano;
        this.cantSectores = cantSectores;
        this.tamSector = tamSector;
        this.nombreRaiz = nombreRaiz;
    }

    public Directorio getdRaiz() {
        return dRaiz;
    }

    public void setdRaiz(Directorio dRaiz) {
        this.dRaiz = dRaiz;
    }

   /* public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }*/

    public int getCantSectores() {
        return cantSectores;
    }

    public void setCantSectores(int cantSectores) {
        this.cantSectores = cantSectores;
    }

    public int getTamSector() {
        return tamSector;
    }

    public void setTamSector(int tamSector) {
        this.tamSector = tamSector;
    }

    public String getNombreRaiz() {
        return nombreRaiz;
    }

    public void setNombreRaiz(String nombreRaiz) {
        this.nombreRaiz = nombreRaiz;
    }
    
    
    
    
}
