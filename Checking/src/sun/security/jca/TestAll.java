package sun.security.jca;

import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

public class TestAll {

	private static Key myKey;

	public static void main(String[] args) throws GeneralSecurityException {
		// TODO Auto-generated method stub
		GCMParameterSpec myParams = new GCMParameterSpec(0, null);
		Cipher c = Cipher.getInstance("DES/EBS/NoPadding"); // original AES/GCM/NoPadding
		c.init(Cipher.ENCRYPT_MODE, myKey, myParams);
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");

		SecureRandom secureRandom = new SecureRandom();
		int keyBitSize = 64; //original 256
		keyGenerator.init(keyBitSize, secureRandom);

		@SuppressWarnings("unused")
		SecretKey secretKey = keyGenerator.generateKey();
		
	}
	
	public class KeyGen{
		
	}

}
