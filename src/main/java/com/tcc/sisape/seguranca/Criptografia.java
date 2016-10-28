package com.tcc.sisape.seguranca;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {
	public static String md5(String aSenha) {
		String sen = "";
		MessageDigest messageDigest = null;

		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		BigInteger hash = new BigInteger(1, messageDigest.digest(aSenha.getBytes()));
		sen = hash.toString(16);

		return sen;
	}
}
