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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class CheckLoginData
 */
public class CheckLoginData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckLoginData() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String databaseSalt = null;
		String databasePassword = null;
		String databaseName = null;

		PrintWriter out = response.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javademo", "root", "root@123");
			PreparedStatement ps = con.prepareStatement("select * from cruddata where email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				databaseName = rs.getString("name");
				databasePassword = rs.getString("password");
				databaseSalt = rs.getString("salt");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		password += "_";
		password += databaseSalt;
//		String password1 = password+" "+databaseSalt;
		System.out.println(password);
		if (Validator.passwordMatcher(password, databasePassword)) {
			request.setAttribute("email", email);
			request.setAttribute("name", databaseName);
			System.out.println("==================================");
//			response.sendRedirect("HomePage.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("ErrorPage.jsp");
			rd.forward(request, response);
		}

	}

}
