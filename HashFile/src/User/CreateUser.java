package User;


import Encrypt.EncryptAlgorithm;
import javax.swing.JOptionPane;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe qui permet d'ajouter un nouvelle utilisateur
 * @author ouvryl
 */
public class CreateUser {
    public String login;
    public String mdpCrypte;
    public User user;
    public CreateUser(){
       
        String mdp;
        boolean cryptageOK=false;
        login = JOptionPane.showInputDialog(null, "Entrer votre nom", " Nouvelle utilisateur !", JOptionPane.QUESTION_MESSAGE);
        // voir comment ne pas affihce le mdp
        mdp= JOptionPane.showInputDialog(null, "Entrer votre mdp", "Nouvelle utilisateur !", JOptionPane.QUESTION_MESSAGE);
        String cryptage = JOptionPane.showInputDialog(null, "Entrer la méthode de cryptage, laisser vide si inconnu", " Cryptage !", JOptionPane.QUESTION_MESSAGE);
        for(EncryptAlgorithm a :Encrypt.EncryptAlgorithm.values()){
            if(a.toString().equals(cryptage)){
                cryptageOK=true;
                break;
            }
        }
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(mdp);
        mdpCrypte=encryptedPassword;
        if(!cryptageOK){
            System.out.println("Cryptage non prit en charge");
            cryptage="AES";
        }
        user=new User(login,mdpCrypte,cryptage);
        System.out.println("mot de passe cryptée:"+mdpCrypte);
        user.ajouter(); // vérif pas 2 fois  le même login pas faite.
        
        
       
    }
    
    
}
