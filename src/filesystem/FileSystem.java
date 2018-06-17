/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 *
 * @author Anthony-PC
 */
public class FileSystem {
    
     private Globales instance= Globales.getInstance();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
       Directorio raiz = new Directorio("raiz",null);
       FileSys fileSys = new FileSys(raiz,10,500,"raiz");
       Directorio hijo1 = new Directorio("hijo1",raiz);
       Directorio hijo2 = new Directorio("hijo2",hijo1);
       raiz.addDirectorio(hijo1);
       hijo1.addDirectorio(hijo2);
       Archivo ar1 = new Archivo(10, ".txt","archivo1","01-01-01","01-01-01","asdf",2,hijo1);
       raiz.addArchivo(ar1);
       hijo1.addArchivo(ar1);
       hijo2.addArchivo(ar1);
       
       //Directorio clone =  new Directorio(raiz);
       //clone.getListaArchivos().remove(0);
       
       
       leer(raiz,"archivo1","/root/",".txt");
       
    }
    
    public int crearDirectorio(String nombre, Directorio padre){
        
        for(Directorio i : instance.getDirectorioActual().getdHijo()){
            if(i.getNombre().equals(nombre)){
                return -1;
            }
        }
       
        Directorio directorio = new Directorio(nombre, padre);
        return 0;
    }
    
    public int crearArchivo(String extension, String nombre){
        return 0;
    }
    
    
    public static Directorio leer(Directorio raiz,String nombre,String ruta,String extension){
        if(!raiz.getListaArchivos().isEmpty()){
            Archivo archivo1 = searchFile(raiz.getListaArchivos(),nombre,extension);
            if(archivo1 != null){
                System.out.println("Ruta: "+ruta);
            }
        }
        
        if(!raiz.getdHijo().isEmpty()){
            for(Directorio i : raiz.getdHijo()){
                return leer(i,nombre,ruta+i.getNombre()+"/",extension);
             
            }
        }
       return null;
    }
    
    public static Archivo searchFile(ArrayList<Archivo> listaArchivos, String nombre,String extension){
        for(Archivo i : listaArchivos){
            if(i.nombre.equals(nombre) && i.extension.equals(extension)){
                return i;
            }
        }
        return null;
    }    
    
}
