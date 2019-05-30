package com.tnf.unsdg.qa.util;

import com.tnf.unsdg.qa.base.TestBase;
import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	
	/********************************************************************
	 * 
	 * encryptXOR(String message, String key)
	 * 
	 * 		Uses provided key to encrypt provided message using simple XOR
	 * 
	 *********************************************************************/

	@SuppressWarnings("restriction")
	public static String encryptXOR(String message, String key){        
		try {
		        if (message==null || key==null ) return null;        
		        char[] keys=key.toCharArray();
		        char[] mesg=message.toCharArray();            
		        int ml=mesg.length;
		        int kl=keys.length;
		        char[] newmsg=new char[ml];            
		        for (int i=0; i<ml; i++){
		       newmsg[i]=(char)(mesg[i]^keys[i%kl]);
		        }
		        mesg=null; 
		        keys=null;
		        return new String(new BASE64Encoder().encodeBuffer(new String(newmsg).getBytes()));
		} catch (Exception e) {
		        e.printStackTrace();
		        return null;
		    }
		}
	
	/********************************************************************
	 * 
	 * decryptXOR(String message, String key)
	 * 
	 * 		Uses provided key to decrypt provided message encrypted using the same key
	 * 
	 *********************************************************************/
	@SuppressWarnings("restriction")
	public static String decryptXOR(String message, String key){
	    try {
	      if (message==null || key==null ) return null;          
	      BASE64Decoder decoder = new BASE64Decoder();
	      char[] keys=key.toCharArray();
	      char[] mesg=new String(decoder.decodeBuffer(message)).toCharArray();
	      int ml=mesg.length;
	      int kl=keys.length;
	      char[] newmsg=new char[ml];
	      for (int i=0; i<ml; i++){
	        newmsg[i]=(char)(mesg[i]^keys[i%kl]);
	      }
	      mesg=null; keys=null;
	      return new String(newmsg);
	    }
	    catch ( Exception e ) {
	      return null;
	        }  
	      }

	
	public static void main(String[] args) {
		
		System.out.println(encryptXOR("Kumar","triconunlockkey"));
	//	System.out.println(decryptXOR(encryptXOR("Kumar","triconunlockkey"),"triconunlockkey"));
		System.out.println(decryptXOR("PwcEAh0=","triconunlockkey"));
	}

}
