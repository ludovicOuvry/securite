
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ludovic
 */
public class Authentification {
    
    public Authentification(){
        
     String rep = JOptionPane.showInputDialog(null, "n pour créer un nouvelle utilisteur. \n a pour vous authentifier.", " Menu1 !", JOptionPane.QUESTION_MESSAGE);
     if(rep.equals("a")){
         
     }else{
         new CreateUser();
     }
    }
    
}
