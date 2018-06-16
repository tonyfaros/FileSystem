/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.util.ArrayList;

/**
 *
 * @author Anthony-PC
 */
public class Directorio {
    
    String nombre;
    ArrayList<Archivo> listaArchivos;
    Directorio dPadre;
    ArrayList<Directorio> dHijo;
    int numSector;

    public Directorio(String nombre, Directorio dPadre, int numSector) {
        this.nombre = nombre;
        this.listaArchivos = null;
        this.dPadre = dPadre;
        this.dHijo = null;
        this.numSector = numSector;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Archivo> getListaArchivos() {
        return listaArchivos;
    }

    public void setListaArchivos(ArrayList<Archivo> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }

    public Directorio getdPadre() {
        return dPadre;
    }

    public void setdPadre(Directorio dPadre) {
        this.dPadre = dPadre;
    }

    public ArrayList<Directorio> getdHijo() {
        return dHijo;
    }

    public void setdHijo(ArrayList<Directorio> dHijo) {
        this.dHijo = dHijo;
    }
    
    
    public int getNumSector() {
        return numSector;
    }

    public void setNumSector(int numSector) {
        this.numSector = numSector;
    }
    
    
    public void addArchivo(Archivo archivo){
        this.listaArchivos.add(archivo);
    }
    
}
