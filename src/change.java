import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class MyServlet
 */
public class change extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 int flat = Integer.parseInt(request.getParameter("update"));
		 String fname = request.getParameter("first");
		 String lname = request.getParameter("last");
		 int mob = Integer.parseInt(request.getParameter("mob"));
		 PrintWriter out=response.getWriter();
		 
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://127.0.0.1:3306/societymanager", "Admin", "1234");
	 
	            PreparedStatement ps = con
	                    .prepareStatement("UPDATE societymembers SET FirstName=?, LastName=?, MobileNumber=? WHERE FlatNo=?");
	 
				ps.setString(1,fname);
				ps.setString(2, lname);
				ps.setInt(3, mob);
				ps.setInt(4, flat);
				
			 
				int rows = ps.executeUpdate();
				if (rows> 0) {
						out.println("<h5>A User Was Updated  Successfully!</h5>");
					}
	        } catch (Exception e2) {
	            System.out.println(e2);
	        }
		 
		 	
		 
	 }

}
