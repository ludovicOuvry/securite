
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
    public CreateUser(){
       
        String mdp;
        
        login = JOptionPane.showInputDialog(null, "Entrer votre nom", " Nouvelle utilisateur !", JOptionPane.QUESTION_MESSAGE);
        // voir comment ne pas affihce le mdp
        mdp= JOptionPane.showInputDialog(null, "Entrer votre mdp", "Nouvelle utilisateur !", JOptionPane.QUESTION_MESSAGE);
        
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(mdp);
        mdpCrypte=encryptedPassword;
        
        
       
    }
    
    
}
