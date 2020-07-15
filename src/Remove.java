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
public class Remove extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 int flat = Integer.parseInt(request.getParameter("delete"));
		 PrintWriter out=response.getWriter();
		 
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://127.0.0.1:3306/societymanager", "Admin", "1234");
	 
	            PreparedStatement ps = con
	                    .prepareStatement("DELETE FROM societymembers WHERE FlatNo=?");
	 
				ps.setInt(1,flat);
			 
				int rowsDeleted = ps.executeUpdate();
				if (rowsDeleted > 0) {
						out.println("<h5>A user was deleted successfully!</h5>");
					}
	        } catch (Exception e2) {
	            System.out.println(e2);
	        }
		 
		 	
		 
	 }

}
