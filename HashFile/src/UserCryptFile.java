
import Decrypt.DecryptFile;
import Encrypt.EncryptFile;
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
    
    private EncryptFile enc;
    
    private DecryptFile dec;
    
    public UserCryptFile(User user) throws Exception{ // l'utilisateur à forcément rentrer un mot de passe correcte pour arriver ici.
        String path = JOptionPane.showInputDialog(null, "Entrer le chemin vers le fichier", " Fichier !", JOptionPane.QUESTION_MESSAGE);
        File file=null;
        String cryptage="";
        while(file==null){
             cryptage = JOptionPane.showInputDialog(null, "Entrer la méthode de cryptage, laisser vide si inconnu", " Cryptage !", JOptionPane.OK);
             file= new File(path);
        }
        if(!file.canRead()){
            System.out.println("problème avec le fichier");
            
        }else{
            
            System.out.println("nom du fichier:"+file.getName());
            File Fcrypte= new File(user.getLogin()+File.separatorChar+file.getName()); // pour acéder au dossier

            this.enc = new EncryptFile(cryptage, user.getLogin().getBytes(),file,Fcrypte);
            this.enc.cryptage();
            
            System.out.println("Fichier cryptée");
            file.delete(); // supression de l'ancien fichier 

        }
    
/*        Thread.sleep(100);
        System.out.println("Decrytage launching");
        
        String decryptPath = JOptionPane.showInputDialog(null, "Entrer le chemin vers le fichier", " Fichier !", JOptionPane.QUESTION_MESSAGE);
        File decryptFile=null;
        String decryptage="";
        while(decryptFile==null){
             decryptage = JOptionPane.showInputDialog(null, "Entrer la méthode de decryptage, laisser vide si inconnu", " Decryptage !", JOptionPane.QUESTION_MESSAGE);
             decryptFile= new File(decryptPath);
        }
        if(!decryptFile.canRead()){
            System.out.println("problème avec le fichier");
            
        }else{
            
            System.out.println("nom du fichier:"+decryptFile.getName());
            File Fcrypte= new File(user.getLogin()+"/"+decryptFile.getName()); // pour acéder au dossier

            this.dec = new DecryptFile(decryptage, this.enc.getSecretKey(), decryptFile, Fcrypte);
            this.dec.decrytage();
            
            System.out.println("Fichier decryptée");
            //decryptFile.delete(); // supression de l'ancien fichier 
        
        }*/
    }
}

//public File [] listFiles ();

