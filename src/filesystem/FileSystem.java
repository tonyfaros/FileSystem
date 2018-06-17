/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author Anthony-PC
 */
public class FileSystem {
    
     private static Globales instance= Globales.getInstance();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        
        
       Main main = new Main();
       main.setVisible(true);
       
       Directorio raiz = new Directorio("raiz",null);
       instance.setRoot(raiz);
       FileSys fileSys = new FileSys(raiz,10,500,"raiz");
       Directorio hijo1 = new Directorio("hijo1",raiz);
       Directorio hijo2 = new Directorio("hijo2",hijo1);
       raiz.addDirectorio(hijo1);
       hijo1.addDirectorio(hijo2);
       Archivo ar1 = new Archivo(".txt","archivo1","01-01-01","01-01-01","asdf",2,hijo2);
       raiz.addArchivo(ar1);
       hijo1.addArchivo(ar1);
       hijo2.addArchivo(ar1);
       ar1.setRuta(ar1, hijo2);
       System.out.println(ar1.getRuta());
       String s = "/raiz/hijo1/";
       
       // System.out.println(Arrays.toString(s.split("/")));
       Directorio prueba1 = accederDirectorio("/raiz/hijo1/");
       System.out.println(prueba1.getNombre());
       //Directorio clone =  new Directorio(raiz);
       //clone.getListaArchivos().remove(0);
       
       
       //leer(raiz,"archivo1","/root/",".txt");
       
    }
    
    //Crea un directorio, devuelve -1 si existe otro con el mismo nombre
    public int crearDirectorio(String nombre, Directorio padre){
        
        for(Directorio i : instance.getDirectorioActual().getdHijo()){
            if(i.getNombre().equals(nombre)){
                return -1;
            }
        }
       
        Directorio directorio = new Directorio(nombre, padre);
        return 0;
    }
    
    //Accede y devuelve directorio recibiendo la ruta de este, si no lo encuentra devuelve null
    public static Directorio accederDirectorio(String ruta){
        String[] listaAcceso = ruta.split("/");
        ArrayList<String>listDef = new ArrayList<>();
        for(int i = 2; i<listaAcceso.length; i++){
            listDef.add(listaAcceso[i]);
            System.out.println(listaAcceso[i]);
        }
        
        Directorio dirTemp = instance.getRoot();
        for(String i : listDef){
          //  System.out.println("1for");
            dirTemp = searchDirectorio(i,dirTemp);
            if(dirTemp == null){
               // System.out.println("1if");
                return null;
            }
        }
        return dirTemp;
    }
    
    
    public static Directorio searchDirectorio(String nombre, Directorio padre){
        Directorio dir = null;
        for(Directorio i : padre.getdHijo()){
            //System.out.println("2for");
            if(i.getNombre().equals(nombre)){
                //System.out.println("2if");
                return i;
            }
        }
        return dir;
    }
    
    
    //Crea archivo devuelve -1 si ya existe
    public int crearArchivo(String extension, String nombre, String contenido){
        for(Archivo i : instance.getDirectorioActual().getListaArchivos()){
            if(i.getNombre().equals(nombre) && i.getExtension().equals(extension)){
                return -1;
            }
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String fecha  = dateFormat.format(date).toString();
        
        Archivo archivo = new Archivo(extension, nombre, fecha, fecha,contenido,0,instance.getDirectorioActual());
        
        
        //System.out.println(dateFormat.format(date));
        return 0;
    }
    
    //Busca archivo en todo fileSystem
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
    
    //Busca y devuelve archivo, recibe la lista de archivos, nombre y extension
    public static Archivo searchFile(ArrayList<Archivo> listaArchivos, String nombre,String extension){
        for(Archivo i : listaArchivos){
            if(i.nombre.equals(nombre) && i.extension.equals(extension)){
                return i;
            }
        }
        return null;
    }
    
    
    
    
}
