package Encrypt;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Florent
 */
public class EncryptFile {
    
    private String algoCrypt;
    private byte[] key;
    private File clearFile;
    private File cryptFile;
    
    private SecretKeySpec secretKey;
    
    public EncryptFile(String algoCrypt, byte[] key, File clearFile, File cryptFile){
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
        KeyGenerator kg = KeyGenerator.getInstance(this.algoCrypt);
        kg.init(128);
        this.secretKey = (SecretKeySpec) kg.generateKey();
    
        //SecretKeySpec secretKey = new SecretKeySpec(this.key, this.algoCrypt);
        Cipher cipher = Cipher.getInstance(this.algoCrypt);
        
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        
        // Stock inside the inputBytes buffer from the inputStream
        FileInputStream inputStream = new FileInputStream(this.clearFile);
        byte[] inputBytes = new byte[(int) this.clearFile.length()];
        inputStream.read(inputBytes);
        
       // clearFile.delete();
        FileOutputStream outStream = new FileOutputStream(this.cryptFile);
        byte[] outBytes = cipher.doFinal(inputBytes);
        outStream.write(outBytes);
        
        inputStream.close();
        outStream.close();
        
        System.out.println("Fin cryptage");
    }

    public byte[] getKey() {
        return key;
    }

    public SecretKeySpec getSecretKey() {
        return secretKey;
    }
    
}
