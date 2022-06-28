//package ServletClass;
//import java.util.Base64;
//import java.util.Random;
//
//public class EncryptDecryptPassword {
//
//	public static void main(String[] args) {
//		StoreData storedata = new StoreData();
//		String password = storedata.password;
//		
//		 Base64.Encoder enc = Base64.getEncoder();
//	     Base64.Decoder dec = Base64.getDecoder();
//	       
//
//	        // encode data using BASE64
//	        String encodedPassword = enc.encodeToString(password.getBytes());
//	        System.out.println("encoded value is \t" + encodedPassword);
//
//	        // Decode data
//	        String decodedPassword = new String(dec.decode(encodedPassword));
//	        System.out.println("decoded value is \t" + decodedPassword);
////	        System.out.println("original value is \t" + str);
//								
//				
//	
//	
////	public static boolean encryptPassword(){
//		
//	
//        
//	}
//
//	
////	public String CreatePassword(int length)
////    {
////        String valid = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
////        String res = "";
////        Random rnd = new Random();
////        while (0 < length--)
////        	
////        	valid.
//////        	res = res + valid
////            res += valid[rnd.Next(valid.Length)];
////        return res;
////    }
//}
//
//
//
//
//
