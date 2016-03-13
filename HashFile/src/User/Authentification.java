package User;


import User.User;
import User.CreateUser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * premier menu qui redirige vers l'authetification ou la création d'un utilisatteur
 * @author Ludovic
 */
public class Authentification {
    public User userValide;
    
    public Authentification() throws FileNotFoundException, IOException{
        userValide=null;
        String ligne;
     String rep = JOptionPane.showInputDialog(null, "n pour créer un nouvelle utilisteur. \n a pour vous authentifier.", " Menu1 !", JOptionPane.QUESTION_MESSAGE);
     if(rep.equals("a")){
              String login = JOptionPane.showInputDialog(null, "entrer votre Login", " Login !", JOptionPane.QUESTION_MESSAGE);

         BufferedReader  buff = new BufferedReader(new FileReader("utilisateur.txt"));
         while((ligne = buff.readLine()) != null){
             String[] tabLigne=ligne.split(";"); // 0 login, 1 mdp cryptée
             if(tabLigne[0].equals(login)){
                 System.out.println("login trouvé");
                 String mdp = JOptionPane.showInputDialog(null, "entrer votre mot de passe", " Login !", JOptionPane.QUESTION_MESSAGE);

                 if(new User(tabLigne[0], tabLigne[1]).verif(mdp)){
                     System.out.println("utilisateur Valide");
                     userValide=new User(tabLigne[0], tabLigne[1]);
                 }
                 System.out.println("mot de passe incorrecte");
             }
         }
         
     }else if(rep.equals("n")){
        userValide=new CreateUser().user;
     }
    }
    
}
