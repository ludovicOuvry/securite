
import java.io.File;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ouvryl
 */
public class UserCryptFile {
    
    public UserCryptFile(String login){
        String path = JOptionPane.showInputDialog(null, "Entrer le chemin vers le fichier", " Fichier !", JOptionPane.QUESTION_MESSAGE);
        File file=null;
        String cryptage="";
        while(file==null){
             cryptage = JOptionPane.showInputDialog(null, "Entrer la méthode de cryptage, laisser vide si inconnu", " Cryptage !", JOptionPane.QUESTION_MESSAGE);
             file= new File(path);
        }
        
        new Encrypt.EncryptFile(cryptage, login,file, new File(path));
        file.delete();
        
    }   
    
}
