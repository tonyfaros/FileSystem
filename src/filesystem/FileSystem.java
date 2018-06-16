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
public class FileSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Directorio raiz = new Directorio("raiz",null,0);
       FileSys fileSys = new FileSys(raiz,10,500,"raiz");
       Directorio hijo1 = new Directorio("hijo1",raiz,1);
       Archivo ar1 = new Archivo(10, ".txt","archivo1","01-01-01","01-01-01","asdf",2,hijo1);
       
       
    }
    
}
