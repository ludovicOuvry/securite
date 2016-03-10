package Encrypt;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Florent
 */
public class EncryptFile {
    
    private String algoCrypt;
    private String key;
    private File clearFile;
    private File cryptFile;
    
    public EncryptFile(String algoCrypt, String key, File clearFile, File cryptFile){
        boolean algoVersion = false;
        
        for(EncryptAlgorithm algo : EncryptAlgorithm.values()){
            if(algoCrypt.equals(algo)){
                algoVersion = true;
            }
        }
        
        if(algoVersion){
            this.algoCrypt = algoCrypt;
        }else{
            this.algoCrypt = "AES";
        }
        
        this.key = key;
        this.clearFile = clearFile;
        this.cryptFile = cryptFile;
    }
    
    public void cryptage() throws Exception{
        Key secretKey = new SecretKeySpec(this.key.getBytes(), this.key);
        Cipher cipher = Cipher.getInstance(this.algoCrypt);
        
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        
        FileInputStream inputStream = new FileInputStream(this.clearFile);
        byte[] inputBytes = new byte[(int) this.clearFile.length()];
        inputStream.read(inputBytes);
        
        FileOutputStream outStream = new FileOutputStream(this.cryptFile);
        byte[] outBytes = cipher.doFinal(inputBytes);
        outStream.write(outBytes);
        
        inputStream.close();
        outStream.close();
    }
}
