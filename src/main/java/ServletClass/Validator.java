package ServletClass;

import java.util.Base64;
import java.util.Objects;
import java.util.Random;

public class Validator {
	
	public static String generateSalt() {
		String alphabets = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
		String numbers = "1234567890";
		String alphanumaric = alphabets + numbers;
	
		StringBuilder stringbuilder = new StringBuilder();
		Random random = new Random();
	
		for (int i = 0; i < 3; i++) {
			int index = random.nextInt(alphanumaric.length());
			char randomString = alphanumaric.charAt(index);
			stringbuilder.append(randomString);
		}
		return stringbuilder.toString();
	}


	public static String encryptPassword(String password,String salt) {
    	String passwordWithSalt = password+"_"+salt;
        String encodedPassword = Base64.getEncoder().encodeToString(passwordWithSalt.getBytes());
        System.out.println(encodedPassword);
		return encodedPassword;		
       
	}

	public static boolean passwordMatcher(String enteredPassword,String dbPassword) {
		String decodedPassword =new String(Base64.getDecoder().decode(dbPassword));
		if(Objects.equals(decodedPassword, enteredPassword)) {
			System.out.println("event TRUE password match");
			return true;
		}
		return false;
	}
	
	
	
//	public static void main(String ...args) {
//	System.out.println("SALT -->"+ new Validator().generateSalt());
//	new Validator().encryptPassword();
//	new Validator().decryptPassword();
//}
//

}
