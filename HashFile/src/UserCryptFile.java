
import User.User;
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
    
    public UserCryptFile(User user){ // l'utilisateur à forcément rentrer un mot de passe correcte pour arriver ici.
        String path = JOptionPane.showInputDialog(null, "Entrer le chemin vers le fichier", " Fichier !", JOptionPane.QUESTION_MESSAGE);
        File file=null;
        String cryptage="";
        while(file==null){
             cryptage = JOptionPane.showInputDialog(null, "Entrer la méthode de cryptage, laisser vide si inconnu", " Cryptage !", JOptionPane.QUESTION_MESSAGE);
             file= new File(path);
        }
        if(!file.canRead()){
            System.out.println("problème avec le fichier");
            
        }else{
            
            System.out.println("nom du fichier:"+file.getName());
            File Fcrypte= new File(user.getLogin()+File.separatorChar+file.getName()); // pour acéder au dossier

            new Encrypt.EncryptFile(cryptage, user.getLogin(),file,Fcrypte);
            System.out.println("Fichier cryptée");
            file.delete(); // supression de l'ancien fichier 

    }   
    
    }
}

//public File [] listFiles ();

