package atm.helpers;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {

	
	public static String getHashedPassword(String password) {
		try {
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] bytes=md.digest();
			StringBuffer buffer=new StringBuffer();
			for (byte b : bytes) {
				buffer.append(String.format("%02x", b));
			}
			password=buffer.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return password;
	}
}
