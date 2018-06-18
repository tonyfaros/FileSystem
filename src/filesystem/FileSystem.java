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
       Controlador c = new Controlador();
       c.crearArchivo("bla", "bla", "bla");
       Directorio raiz = new Directorio("raiz",null);
       instance.setRoot(raiz);
       FileSys fileSys = new FileSys(raiz,10,500,"raiz");
       
       Directorio hijo1 = new Directorio("hijo1",raiz);
       Directorio hijo2 = new Directorio("hijo2",raiz);
       Directorio hijo3 = new Directorio("hijo3",hijo2);
       Directorio hijo4 = new Directorio("hijo4",hijo2);
       Directorio hijo5 = new Directorio("hijo4",hijo2);
       Directorio hijo6 = new Directorio("hijo4",hijo2);
       
       raiz.addDirectorio(hijo1);
       raiz.addDirectorio(hijo2);
       hijo2.addDirectorio(hijo3);
       
       
       Archivo ar1 = new Archivo(".txt","archivo1","01-01-01","01-01-01","asdf",2,hijo1,false);
       Archivo ar2 = new Archivo(".txt","archivo2","01-01-01","01-01-01","asdf",2,hijo2,false);
       Archivo ar3 = new Archivo(".txt","archivo3","01-01-01","01-01-01","asdf",2,hijo3,false);
       Archivo ar4 = new Archivo(".txt","archivo4","01-01-01","01-01-01","asdf",2,hijo4,false);
       Archivo ar5 = new Archivo(".txt","archivo5","01-01-01","01-01-01","asdf",2,hijo2,false);
       
       
       hijo1.addArchivo(ar1);
       hijo2.addArchivo(ar2);
       hijo3.addArchivo(ar3);
       
       
       ar1.setRuta(ar1, hijo1);
       ar2.setRuta(ar2, hijo2);
       ar3.setRuta(ar3, hijo3);
       
       /*System.out.println(ar1.getRuta());
       System.out.println(ar2.getRuta());
       System.out.println(ar3.getRuta());
        */
       //copiarVirtualVirtualDir("/raiz/hijo2/hijo3/","/raiz/hijo1/");
       
       //Directorio r = accederDirectorio("/raiz/hijo1/hijo3/");
       
       /*for(Archivo i : r.getListaArchivos()){
           System.out.println(i.getNombre());
           System.out.println(i.getRuta());
       }*/
       
       
      // System.out.println(hijo1.getListaArchivos().size());
       //copiarVirtualVirtualAr("/raiz/hijo1/hijo2","/raiz/hijo1/",ar1.getNombre(),ar1.getExtension());
       
       
       // System.out.println(Arrays.toString(s.split("/")));
       //Directorio prueba1 = accederDirectorio("/raiz/hijo1/");
       //System.out.println(prueba1.getNombre());
       //Directorio clone =  new Directorio(raiz);
       //clone.getListaArchivos().remove(0);
       
       
       //leer(raiz,"archivo1","/root/",".txt");
       
    }
    
    //Crea un directorio, devuelve -1 si existe otro con el mismo nombre
    public static int crearDirectorio(String nombre){
        
        for(Directorio i : instance.getDirectorioActual().getdHijo()){
            if(i.getNombre().equals(nombre)){
                return -1;
            }
        }
       
        Directorio directorio = new Directorio(nombre, instance.getDirectorioActual());
        return 0;
    }
    
    //Accede y devuelve directorio recibiendo la ruta de este, si no lo encuentra devuelve null
    public static Directorio accederDirectorio(String ruta){
        String[] listaAcceso = ruta.split("/");
        ArrayList<String>listDef = new ArrayList<>();
        for(int i = 2; i<listaAcceso.length; i++){
            listDef.add(listaAcceso[i]);
            //System.out.println("--:" + listaAcceso[i]);
                   
        }
        
        Directorio dirTemp = instance.getRoot();
        for(String i : listDef){
            //System.out.println("1for:--" + i);
            dirTemp = searchDirectorio(i,dirTemp);
            if(dirTemp == null){
                //System.out.println("1if");
                return null;
            }
        }
        return dirTemp;
    }
    
    
    public static Directorio searchDirectorio(String nombre, Directorio padre){
        Directorio dir = null;
        for(Directorio i : padre.getdHijo()){
            //System.out.println("2for" + i.getNombre());
            if(i.getNombre().equals(nombre)){
                //System.out.println("2if");
                return i;
            }
        }
        return dir;
    }
    
    
    //Crea archivo devuelve -1 si ya existe
    public static int crearArchivo(String extension, String nombre, String contenido,boolean real){
        for(Archivo i : instance.getDirectorioActual().getListaArchivos()){
            if(i.getNombre().equals(nombre) && i.getExtension().equals(extension)){
                return -1;
            }
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String fecha  = dateFormat.format(date).toString();
        
        Archivo archivo = new Archivo(extension, nombre, fecha, fecha,contenido,0,instance.getDirectorioActual(),real);
        
        
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
    
    //Busca y devuelve archivo, recibe la lista de archivos, nombre y extension   ----   PPT
    public static Archivo searchFile(ArrayList<Archivo> listaArchivos, String nombre,String extension){
        for(Archivo i : listaArchivos){
            if(i.nombre.equals(nombre) && i.extension.equals(extension)){
                return i;
            }
        }
        return null;
    }
    
    //MFLE recibe nombre,extension y contenido, devuelve el archivo ya modificado si existe.
    public static Archivo MFLE(String nombre,String extension, String contenido){
        Archivo archivo = searchFile(instance.getDirectorioActual().getListaArchivos(),nombre,extension);
        if(archivo != null){
            archivo.setNombre(nombre);
            archivo.setContenido(contenido);
        }
        return archivo;
    }
    
    //Copiar virtual virutal archivo
    public static void  copiarVirtualVirtualAr(String ruta, String rutaDestino,String nombreArchivo, String extension){
        Directorio dirOr = accederDirectorio(ruta);
        Directorio dirDes = accederDirectorio(rutaDestino);
        
        Archivo archivoOr = searchFile(dirOr.getListaArchivos(),nombreArchivo, extension);
        Archivo archivoCopia = new Archivo(archivoOr);
        dirDes.addArchivo(archivoCopia);
        archivoCopia.setdPadre(dirDes);
        archivoCopia.setRuta(archivoCopia, dirDes);
        
    }
    
    //Copiar virtual virtual directorio
    //Recibe la ruta del directorio que quiere copiar
    public static void  copiarVirtualVirtualDir(String ruta, String rutaDestino){
        Directorio dirOr = accederDirectorio(ruta);
        Directorio dirDes = accederDirectorio(rutaDestino);
        Directorio copia = new Directorio(dirOr);
        
        copia.setdPadre(dirDes);
        
        /*for(Archivo i: copia.getListaArchivos()){
            i.setRuta(i, dirDes);
        }*/
        copia = actualizarRutaAux(copia);
        dirDes.addDirectorio(copia);
         
    }
    
    public static Directorio actualizarRutaAux(Directorio directorio){
        
        
        for(Archivo i: directorio.getListaArchivos()){
            i.setRuta(i, directorio);
        }
        
        if(!directorio.getdHijo().isEmpty()){
            for(Directorio j : directorio.getdHijo()){
                j = actualizarRutaAux(j);
                
            }
        }
        return directorio;
    } 
}
