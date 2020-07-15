<%@ page import = "java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  border-collapse: collapse;
}

table,th,td{
	border: 1px solid black;
	
}

td{
	heigth: 50px;
}
</style>

</head>
<body>
	<form method="post">
		<table>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Flat No: </td>
				<td>Mobile No:</td>
			</tr>
			
			<%
				try{
					Class.forName("com.mysql.jdbc.Driver");
		            Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/societymanager", "Admin", "1234");
		            
		            Statement statement  = con.createStatement();
		            
		            ResultSet re = statement.executeQuery("select * from societymembers;");
		            
		            while(re.next())
		            {
		     
		      %>
		            	
		                <tr>
		                <td><%=re.getString("FirstName") %></td>
		                <td><%=re.getString("LastName") %></td>
		                <td><%=re.getInt("FlatNo") %></td>
		                <td><%=re.getInt("MobileNumber") %></td>
		                </td>
		    		<%
		    		
		            }
		    		%>
		            	
		 </table>   
		 			
					
				<%
   						 re.close();
   							 statement.close();
   							 con.close();
   					 }
					catch(Exception e)
					{
    					e.printStackTrace();
    				}




				%>
	
	
	</form>
</body>
</html>