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
public class Directorio implements Cloneable{
    
    String nombre;
    ArrayList<Archivo> listaArchivos;
    Directorio dPadre;
    ArrayList<Directorio> dHijo;
    int numSector;

    public Directorio(String nombre, Directorio dPadre/* int numSector*/) {
        this.nombre = nombre;
        this.listaArchivos = new ArrayList<>();
        this.dPadre = dPadre;
        this.dHijo = new ArrayList<>();
        //this.numSector = numSector;
    }
    
    public Directorio(Directorio directorio){
        this.nombre = directorio.getNombre();
        this.listaArchivos = directorio.getListaArchivos();
        this.dPadre = directorio.getdPadre();
        this.dHijo = directorio.getdHijo();
       // this.numSector = directorio.getNumSector();
    }
        
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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
    
    /*
    public int getNumSector() {
        return numSector;
    }

    public void setNumSector(int numSector) {
        this.numSector = numSector;
    }*/
    
    
    public void addDirectorio(Directorio directorio){
        this.dHijo.add(directorio);
    }
    public void addArchivo(Archivo ar){
        this.listaArchivos.add(ar);
    }
    
}
