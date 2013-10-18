/**
 * 
 */
package com.cryptography;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Cryptographic
{
	private static final String algorithm = "AES";
	private static final byte[] key = new byte[]{'R', 'e', 'd', 'k', 'n', 'e', 'e', 'I',
		'n', 'c', '.', 'I', 'n', 'd', 'i', 'a'};

	public static void main(String[] args) throws Exception
	{
		String plainText = "0Wrg336gJLgDJ1y0";
		String plainText2 = "iwyEvBhEleQRvna3";
		String encryptedText = encrypt(plainText);

		System.out.println("Excrypted text is: "+encryptedText);
		
		String decryptedText = decrypt(encryptedText);
		if(decryptedText.equals(plainText))
		{
			System.out.println("Both texts match.");
		}
	}

	private static String encrypt(String plainText) throws Exception
	{
		Key secretKey = new SecretKeySpec(key, algorithm);
		String encryptedText = "";
		
		Cipher c = Cipher.getInstance(algorithm);
		c.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encodedText = c.doFinal(plainText.getBytes());
		encryptedText = new BASE64Encoder().encode(encodedText);
		
		return encryptedText;
	}
	
	private static String decrypt(String encryptedText) throws Exception
	{
		Key secretKey = new SecretKeySpec(key, algorithm);
		String decryptedText = "";
		
		Cipher c = Cipher.getInstance(algorithm);
		c.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decodedValue = new BASE64Decoder().decodeBuffer(encryptedText);
		byte[] decrypted = c.doFinal(decodedValue);
		decryptedText = new String(decrypted);
		
		return decryptedText;
	}
}
