package com.technoglitz.io;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/** Possible encoding string values
 * "US-ASCII" Seven-bit ASCII, a.k.a. "ISO646-US", a.k.a. the Basic Latin block of the Unicode character set ISO-8859-1 ISO Latin Alphabet No. 1, a.k.a."ISO-LATIN-1" 
 * "UTF-8" Eight-bit UCS Transformation Format 
 * "UTF-16BE" Sixteen-bit UCS Transformation Format, big-endian byte order 
 * "UTF-16LE" Sixteen-bit UCS Transformation Format, little-endian byte order 
 * "UTF-16" Sixteen-bit UCS Transformation Format, byte order identified by an optional byte-ordermark
 * 
 */
public class GetPath {

	public static void main(String[] args) {
		try {
		String tempFilePath = GetPath.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			System.out.println("file path" + URLDecoder.decode(tempFilePath, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
