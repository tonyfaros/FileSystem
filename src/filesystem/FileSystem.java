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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
       Directorio raiz = new Directorio("raiz",null);
       FileSys fileSys = new FileSys(raiz,10,500,"raiz");
       Directorio hijo1 = new Directorio("hijo1",raiz);
       raiz.addDirectorio(hijo1);
       
       Archivo ar1 = new Archivo(10, ".txt","archivo1","01-01-01","01-01-01","asdf",2,hijo1);
       raiz.addArchivo(ar1);
       hijo1.addArchivo(ar1);
       Directorio clone =  new Directorio(raiz);
       clone.getListaArchivos().remove(0);
       
       
       leer(clone,"archivo1");
       
    }
    
    public static void leer(Directorio raiz,String nombre){
        
        System.out.println(raiz.getListaArchivos().size());
        int cont = 0;
        int largo = raiz.getdHijo().size();
        //ListIterator  lit;
        //for(Directorio i : raiz.dHijo){
            
        //}
       // lit = raiz.dHijo.listIterator();
    }
    
    public static Archivo searchFile(ArrayList<Archivo> listaArchivos, String nombre){
        for(Archivo i : listaArchivos){
            if(i.nombre.equals(nombre)){
                System.out.println("Encontrado");
                return i;
            }
        }
        return null;
    }
    
    /*public static Archivo recursive1(Directorio dirActual, String nombre){
        Archivo archivoTemp = searchFile(dirActual.listaArchivos, nombre);
        if(archivoTemp != null){
            return archivoTemp;
        }
        else if(!dirActual.dHijo.isEmpty()){
            return recursive1(dirActual.dHijo.get(0),nombre);
        }
       
    }*/
    
    
}
