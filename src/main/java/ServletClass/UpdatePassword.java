package ServletClass;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 * Servlet implementation class UpdatePassword
 */
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		Connection con = null;
		String oldPassword = request.getParameter("oldPassword");
		PrintWriter out = response.getWriter();
		
//		String email = (String)request.getAttribute("email");
		String email = request.getParameter("email");
		System.out.println("In Upadate Password page"+email);
		String databasePassword = null;
		String salt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javademo", "root", "root@123");
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from cruddata where email='"+email+"'");
			while(rs.next()) {
				databasePassword = rs.getString("password");
				salt = rs.getString("salt");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		oldPassword += "_";
		oldPassword += salt;
		System.out.println("oldPassword:"+oldPassword);
		System.out.println("databasePassword:"+databasePassword);
		
		if(Validator.passwordMatcher(oldPassword, databasePassword)) {
			String newPassword1 = request.getParameter("newPassword1");
			String newPassword2 = request.getParameter("newPassword2");
			System.out.println(" newPassword1: "+newPassword1);
			System.out.println("newPassword2: "+newPassword2);
			if(newPassword1.equals(newPassword2)) {
				System.out.println("Both password matches..");
				String newSalt = Validator.generateSalt();
				
				try {
					Statement st1=con.createStatement();
					int i=st1.executeUpdate("update cruddata set password='"+Validator.encryptPassword(newPassword1, newSalt)+"', salt='"+ newSalt +"'where email='"+email+"'");
					if(i>0)
						System.out.println("Password update successfully.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
//		request.setAttribute("salt", salt);
//		request.setAttribute("databasePassword", databasePassword);
//		RequestDispatcher rd = request.getRequestDispatcher("UpdatePassword2.java");
//		rd.forward(request, response);
	}

}
