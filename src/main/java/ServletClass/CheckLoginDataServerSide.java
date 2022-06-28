package ServletClass;

import jakarta.servlet.DispatcherType;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class CheckLoginDataServerSide
 */

public class CheckLoginDataServerSide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLoginDataServerSide() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email.equals("bhautiksakhiya005@gmail.com") && password.equals("1111")) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javademo", "root", "root@123");
				Statement statement = con.createStatement();
				ResultSet rs = statement.executeQuery("select * from cruddata");
				
				out.println("<table border=1 width=50% height=50%>");  
	            out.println("<tr><th>Id</th><th>Email</th><th>Name</th><th>Address</th><tr>"); 
//           int id = 0;
	            String id = null;
				while(rs.next()) {
					id = rs.getString("id");
					String email1 = rs.getString("email");
					String name1 = rs.getString("name");
					String address1 = rs.getString("address");
//					System.out.print("Id"+id);
					out.print("<tr><td>" + id + "</td><td>" + email1 + "</td><td>" + name1 + "</td><td>" + address1 + "</td><td>" + "<a href = 'Edit.jsp?id="+id+"'> Edit </a>" + "</td><td>" + "<a href = 'DeleteUser.java?id="+id+"'>Delete</a>" + "</td></tr>"); 
				}
				 out.println("</table>");
			}catch (Exception e) {
						// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
