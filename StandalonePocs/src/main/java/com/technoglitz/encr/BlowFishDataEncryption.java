package com.technoglitz.encr;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class BlowFishDataEncryption {

	
	public static void main(String args[]){
		String dataToEncrypt="Data to encrypt";
		String encryptionKey="the key";
		SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(), "Blowfish");
		String encryptedData="";
		byte[] encryptedBytes;
		Cipher cipher;
		try {
		    //Get cipher instance for Blowfish algorithm
			cipher = Cipher.getInstance("Blowfish");
			//initialize cipher in encryption mode with the specified key
			cipher.init(Cipher.ENCRYPT_MODE, key);
			//encrypted bytes of data string
			encryptedBytes = cipher.doFinal(dataToEncrypt.getBytes("UTF-8"));
			//encode encrypted data in Hex String
			encryptedData = Hex.encodeHexString(encryptedBytes);
			System.out.println("DATA:"+encryptedData);

			System.out.println(Hex.decodeHex(Hex.encodeHex(encryptedBytes)));

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DecoderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}