package ServletClass;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Base64;
import java.util.Random;
import java.sql.*;

/**
 * Servlet implementation class StoreData
 */
public class StoreData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		String salt= Validator.generateSalt();
	
	        
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javademo", "root", "root@123");
			PreparedStatement ps = con.prepareStatement("insert into cruddata (email,name,address,password,salt) values(?,?,?,?,?)");
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, address);
			ps.setString(4, Validator.encryptPassword(password,salt));
			ps.setString(5, salt);
			int i = ps.executeUpdate();
			if(i>=1)
				out.println("Data Entered Successfully..");
			else
				out.println("Something Wrong..");
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
//	
//public String generateSalt() {
//	String alphabets = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
//	String numbers = "1234567890";
//	String alphanumaric = alphabets + numbers;
//	
//	StringBuilder stringbuilder = new StringBuilder();
//	Random random = new Random();
//	
//	for (int i = 0; i < 3; i++) {
//		int index = random.nextInt(alphanumaric.length());
//		char randomString = alphanumaric.charAt(index);
//		stringbuilder.append(randomString);
//	}
//	return stringbuilder.toString();
//}
//
//public String encryptPassword() {
//	Base64.Encoder enc = Base64.getEncoder();
//       
//    	String salt = generateSalt();
//    	String passwordWithSalt = password+"_"+salt;
//        // encode data using BASE64
//        String encodedPassword = enc.encodeToString(passwordWithSalt.getBytes());
//        System.out.println("encoded value is \t" + encodedPassword);
//		return encodedPassword;
//       
//}

//public String decryptPassword() {
//    Base64.Decoder dec = Base64.getDecoder();
//    
//    String encryptPassword =  encryptPassword();
//    String salt = generateSalt();
//    // Decode data
//    String decodedPassword = new String(dec.decode(encryptPassword));
//    System.out.println("decoded value is \t" + decodedPassword);
//    
//    return decodedPassword;
//
//}

}
