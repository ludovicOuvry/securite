
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * première classe appellée crée les fichier nécessaire
 * @author Ludovic
 */
public class MiseEnPlace {
    
    public MiseEnPlace(){
        if(!(new File("utilisateur.txt").isFile())){
            try {
                new File("utilisateur.txt").createNewFile();
            } catch (IOException ex) {
                System.err.println(ex);
            }
        }
        
    }
    
}
