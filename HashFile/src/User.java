
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Classe qui représente un utislisateur
 * @author Ludovic
 */
public class User {
    
     private String login;
     private String mdpCrypte;
    public User(String login, String mdpCrypte ){
        this.login=login;
        this.mdpCrypte=mdpCrypte;
    }
    
    /**
     * Vérifie que le mot passse est correcte
     * @param mdp le mot de passe en claire
     * @return true si c'est le bon mdp false sinon.
     */
    public boolean verif(String mdp){
        ;
       return new  StrongPasswordEncryptor().encryptPassword(mdp).equals(mdpCrypte);
        
    }
    
    /**
     * Ajoute l'utilisateur au fichier utilisateur.txt qui contient les login et les mdp crypté.
     * de la forme login;mdpcrypte;
     * @return
     */
    public boolean ajouter(){
         try {
              FileWriter utilisateur =new FileWriter("utilisateur.txt");
              utilisateur.write(this.toString());
              utilisateur.close();
              
         } catch (Exception ex) {
             System.err.println(ex);
         }finally{
             
         }
         
         
        
        
    }
     @Override
    public String toString(){
        return login+";"+mdpCrypte+"\n";
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the mdpCrypte
     */
    public String getMdpCrypte() {
        return mdpCrypte;
    }

    /**
     * @param mdpCrypte the mdpCrypte to set
     */
    public void setMdpCrypte(String mdpCrypte) {
        this.mdpCrypte = mdpCrypte;
    }
    
}
