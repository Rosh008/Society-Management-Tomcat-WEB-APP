
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
public class Add extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	 public void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 
		 String fname = request.getParameter("first");
		 String lname = request.getParameter("last");
		 int flat = Integer.parseInt(request.getParameter("flat"));
		 int mobile = Integer.parseInt(request.getParameter("mob"));
		 PrintWriter out=response.getWriter();
		 
		 try {
	            Class.forName("com.mysql.jdbc.Driver");
	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://127.0.0.1:3306/societymanager", "Admin", "1234");
	 
	            PreparedStatement ps = con
	                    .prepareStatement("insert into societymembers (FirstName,LastName,Flatno,MobileNumber) values(?,?,?,?)");
	 
	            ps.setString(1, fname);
	            ps.setString(2, lname);
	            ps.setInt(3, flat);
	            ps.setInt(4, mobile);
	 
	            int i = ps.executeUpdate();
	            if (i > 0)
	            	out.println(fname +" "+ lname + " "+"Flat No:"+ " " +  flat + " "+ "Mobile No:" + " " + mobile);
	                out.println("<h5>Stored into Database Successfully....</h5>");
	 
	        } catch (Exception e2) {
	            System.out.println(e2);
	        }
		 
		 	
		 
	 }

}
