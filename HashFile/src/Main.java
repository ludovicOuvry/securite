
import User.Authentification;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.jasypt.util.password.StrongPasswordEncryptor;

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
    public static void main(String[] args) throws IOException, Exception {
        new MiseEnPlace();

        //CreateUser user=new CreateUser();
        //new UserCryptFile(user.login);
        File f = new File("test.txt");
        f.createNewFile();
        FileWriter fw = new FileWriter(f);
        fw.write("message dans fichier crypté");
        fw.close();

        while (true) {
            Authentification a = new Authentification();
            int rep = 1;
            if (a.userValide != null) {
                rep = JOptionPane.showOptionDialog(null, "Metter vos fichier dans le dossier,les fichiers seront cryptées quand vous appuyerez sur OK", "Fin!",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                        null,
                        MiseEnPlace.boutonok,
                        MiseEnPlace.boutonok[0]);

                while (rep == 1) {

                }
                System.out.println("fin!");
                a.crypteDossier();
            }
        }

    }

}
