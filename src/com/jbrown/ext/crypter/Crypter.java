package com.jbrown.ext.crypter;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.KeySpec;
import java.util.Arrays;

import javax.crypto.*;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Crypter {
	    private static final String UNICODE_FORMAT = "UTF8";
	    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
	    private KeySpec myKeySpec;
	    private SecretKeyFactory mySecretKeyFactory;
	    private Cipher cipher;
	    private byte[] keyAsBytes;
	    private String myEncryptionKey;
	    private String myEncryptionScheme;
	    private SecretKey key;
	    private Encoder encoder;
	 
	    public Crypter() throws Exception
	    {
	        myEncryptionKey = "JavaBrown@EncryptionR786";
	        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
	        keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
	        myKeySpec = new DESedeKeySpec(keyAsBytes);
	        mySecretKeyFactory = SecretKeyFactory.getInstance(myEncryptionScheme);
	        cipher = Cipher.getInstance(myEncryptionScheme);
	        key = mySecretKeyFactory.generateSecret(myKeySpec);
	        encoder = new Encoder();
	    }
	  
	    /**
	     * Method To Encrypt The String
	     */
	    public String encrypt(String unencryptedString) {
	        String encryptedString = null;
	        
	        try {
	            cipher.init(Cipher.ENCRYPT_MODE, key);
	            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
	            byte[] encryptedText = cipher.doFinal(plainText);
	            BASE64Encoder base64encoder = new BASE64Encoder();
	            encryptedString = base64encoder.encode(encryptedText);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return encoder.encode(encryptedString);
	    }
	    
	    /**
	     * Method To Decrypt An Ecrypted String
	     */
	    public String decrypt(String encryptedString) {
	    	encryptedString = encoder.decode(encryptedString);
	        String decryptedText=null;
	        try {
	            cipher.init(Cipher.DECRYPT_MODE, key);
	            BASE64Decoder base64decoder = new BASE64Decoder();
	            byte[] encryptedText = base64decoder.decodeBuffer(encryptedString);
	            byte[] plainText = cipher.doFinal(encryptedText);
	            decryptedText= bytes2String(plainText);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return decryptedText;
	    }
	    
	    /**
	     * Returns String From An Array Of Bytes
	     */
	    private static String bytes2String(byte[] bytes) {
	        StringBuffer stringBuffer = new StringBuffer();
	        for (int i = 0; i < bytes.length; i++) {
	            stringBuffer.append((char) bytes[i]);
	        }
	        return stringBuffer.toString();
	    }
	 
	    /**
	     * Testing The DESede Encryption And Decryption Technique
	     */
	    public static void main(String args []) throws Exception
	    {
	    	Crypter myEncryptor= new Crypter();
	 
	        String stringToEncrypt = "Java Test";
	        String encrypted = myEncryptor.encrypt(stringToEncrypt);
	        String decrypted = myEncryptor.decrypt(encrypted);

		    System.out.println("encrypted=" + encrypted + ", decrypted="
				+ decrypted);
	 
	    }
}