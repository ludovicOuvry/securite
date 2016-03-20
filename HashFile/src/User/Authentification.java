package User;

import Decrypt.DecryptFile;
import Encrypt.EncryptFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.jasypt.util.password.StrongPasswordEncryptor;


/**
 * premier menu qui redirige vers l'authetification ou la création d'un
 * utilisatteur
 *
 * @author HashFile
 */
public class Authentification {

    public User userValide = null;

    private EncryptFile enc;
    private DecryptFile dec;

    public Authentification() throws FileNotFoundException, IOException {
        userValide = null;
        String ligne;

        String rep = JOptionPane.showInputDialog(null, "n pour créer un nouvelle utilisteur. \n a pour vous authentifier. \n q pour quitter.", " Menu1 !", JOptionPane.QUESTION_MESSAGE);
        if (rep == null) {
            rep = "";
        }
        if (rep.equals("q")) {
          System.exit(0);
        }
        if (rep.equals("a")) {
            String login = JOptionPane.showInputDialog(null, "entrer votre Login", " Login !", JOptionPane.QUESTION_MESSAGE);
            if(login==null){
            login="";
        }
            BufferedReader buff = new BufferedReader(new FileReader("utilisateur.txt"));
            while ((ligne = buff.readLine()) != null) {
                String[] tabLigne = ligne.split(";"); // 0 login, 1 mdp cryptée
                if (tabLigne[0].equals(login)) {
                    System.out.println("Login trouvé");
                    String mdp = JOptionPane.showInputDialog(null, "entrer votre mot de passe", " Login !", JOptionPane.QUESTION_MESSAGE);
                    
                    if(mdp==null){
                        mdp="";
                    }
                    
                    if (new User(tabLigne[0], tabLigne[1], tabLigne[2]).verif(mdp)) {
                        System.out.println("Utilisateur valide");
                        userValide = new User(tabLigne[0], tabLigne[1], tabLigne[2]);
                        
                        //decrypteDossier();
                        
                        break;
                    } else {
                        System.out.println("tabLigne1: " + tabLigne[1]);
                        System.out.println(new StrongPasswordEncryptor().encryptPassword(mdp));

                        System.out.println("mot de passe incorrecte");
                    }

                }
            }
        }else if(rep.equals("n")){
            userValide=new CreateUser().user;
        }
    }
    
    public void crypteDossier(){
        File repertoire= new File(userValide.getLogin());
        String[] tab=repertoire.list();
        
        for(String s: tab){
            try {
                this.enc = new EncryptFile(userValide.getCle(), userValide.getLogin().getBytes(),new File(userValide.getLogin()+File.separatorChar+s),new File(userValide.getLogin()+File.separatorChar+s));
                this.enc.cryptage();
            } catch (Exception ex) {
                System.err.println(ex);
            }
        }
    }
    
    public void decrypteDossier(){
        File repertoire= new File(userValide.getLogin());
        String[] tab=repertoire.list();
        
        System.out.println("Passage in decrypt");
        
        for(String s: tab){
            System.out.println("Passage boucle decrypt");
            System.out.println(s.toString());
            
            File encryptFile = new File(userValide.getLogin()+File.separatorChar+s);
            File decryptFile = new File(userValide.getLogin()+File.separatorChar+"test2.txt.txt");
            
            System.out.println(encryptFile.toString());
            System.out.println(decryptFile.toString());
            
            //System.out.println(this.enc.getSecretKey().getAlgorithm());
            
            try {   
                this.dec = new DecryptFile(userValide.getCle(),this.enc.getSecretKey(),encryptFile,decryptFile);
                this.dec.decrytage();
            } catch (Exception ex) {
                //System.out.println("Problem decryptage :\nAlgortihm : "+userValide.getCle()+"\nSecretKey : "+this.enc.getSecretKey().toString()+"\nEncryptFile :");
                System.err.println(ex);
            }
        }
    }

}
