package Decrypt;


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
public class DecryptFile {
    
    private String algoCrypt;
    private byte[] key;
    private File cryptFile;
    private File decryptFile;
    
    public DecryptFile(String algoCrypt, byte[] key, File cryptFile, File decryptFile){ 
        this.algoCrypt = algoCrypt;
        this.key = key;
        this.cryptFile = cryptFile;
        this.decryptFile = decryptFile;
    }
    
    public void decrytage() throws Exception{
        Key secretKey = new SecretKeySpec(this.key, this.key+"");
        Cipher cipher = Cipher.getInstance(this.algoCrypt);
        
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        
        // Stock inside the inputBytes buffer from the inputStream
        FileInputStream inputStream = new FileInputStream(this.cryptFile);
        byte[] inputBytes = new byte[(int) this.cryptFile.length()];
        inputStream.read(inputBytes);
        
        FileOutputStream outStream = new FileOutputStream(this.cryptFile);
        byte[] outBytes = cipher.doFinal(inputBytes);   // encrypt data 
        outStream.write(outBytes);
        
        inputStream.close();
        outStream.close();
    }

    public File getDecryptFile() {
        return this.decryptFile;
    }
}
