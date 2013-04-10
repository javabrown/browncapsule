package com.jbrown.ext.crypter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encoder {

	final String DEFAULT_ENCODING = "UTF-8";
	private BASE64Encoder encoder;
	private BASE64Decoder decoder;

	public Encoder() {
		this.encoder = new BASE64Encoder();
		this.decoder = new BASE64Decoder();
	}

	public String encode(String text) {
		try {
			String rez = this.encoder.encode(text.getBytes(DEFAULT_ENCODING));
			return rez;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	public String decode(String text) {

		try {
			return new String(this.decoder.decodeBuffer(text), DEFAULT_ENCODING);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}// base64decode
 
	public static void main(String[] args) {
		String txt = "RAJA KHAN";
		Encoder dis = new Encoder();
		String encoded = dis.encode(txt);

		System.out.println(encoded);

		System.out.println(dis.decode(encoded));
	}

}// class