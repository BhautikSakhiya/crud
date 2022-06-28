package ServletClass;

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
import java.sql.SQLException;

public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String address = request.getParameter("address");

		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javademo", "root", "root@123");
			System.out.println("Id in UpdateUser page:-->"+id);
			PreparedStatement ps = con.prepareStatement("Update cruddata set email=?,name=?,address=? where id="+id);
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, address);
			int check = ps.executeUpdate();
			if(check>0) {
				out.print("Data Updated..");
//				response.sendRedirect("ShowAllUserData.jsp");
			}else {
				out.print("Something Wrong../n Data not updated..");
			}
				
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.print(e+"   Error!");
		}
		
		
	}

}
