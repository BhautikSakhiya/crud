package ServletClass;

import java.util.Random;

public class Test {
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
	public static void main(String ...args) {
		System.out.println("SALT -->"+ generateSalt());
	}

}
