import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Algorithms {
    public static void main(String[] args) {

    	Security.addProvider(new BouncyCastleProvider());
    }
    
    public class CipherInstance{
    	Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    	byte[] keyBytes   = new byte[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    	String algorithm  = "RawBytes";
    	SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);

    	cipher.init(Cipher.ENCRYPT_MODE);
    }
    
    public class signature{
    	SecureRandom secureRandom = new SecureRandom();
    	KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
    	KeyPair keyPair = keyPairGenerator.generateKeyPair();

    	Signature signature = Signature.getInstance("SHA256WithDSA");

    	signature.initSign(keyPair.getPrivate(null), void secureRandom());

    	byte[] data = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");
    	signature.update(data);

    	byte[] digitalSignature = signature.sign();


    	Signature signature2 = Signature.getInstance("SHA256WithDSA");
    	signature2.initVerify(keyPair.getPublic());

    	signature2.update(data);

    	boolean verified = signature2.verify(digitalSignature);

    	System.out.println("verified = " + verified);
    	
    }
}
