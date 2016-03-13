
import User.Authentification;
import java.io.File;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ouvryl
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        new MiseEnPlace();
        //CreateUser user=new CreateUser();
        //new UserCryptFile(user.login);
        
        new Authentification();
        
        new File("test.txt").createNewFile();
        new UserCryptFile("ludo");
        
        
    }
    
}
