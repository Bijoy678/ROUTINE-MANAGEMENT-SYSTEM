package conn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.lang.*;

/**
 * Servlet implementation class SignUpLogin
 */

@WebServlet("/SignUpLogin")
public class SignUpLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
// public static final String s="10";
	protected static final String Id = null;
 
    
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try { /* SignUp data insert or update*/
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/routine", "root","");	
		        String Id = request.getParameter("id");
				String psw = request.getParameter("pws");
				String Short = request.getParameter("Shot");
				String Techerid = request.getParameter("Tech");			
				String stor1=Id; String stor2=psw; String stor3 = Short; String stor4=Techerid;
			PreparedStatement stor = conn.prepareStatement("insert into  signuplogin(UserID,Password,Shortname,TeacherID) values(?,?,?,?)");
			 stor.setString(1, Id);//1st value into UserID 
	          stor.setString(2, psw);
	          stor.setString(3, Short);
	          stor.setString(4, Techerid);
	         // System.out.println(s);
	         
	         stor.executeUpdate();
	         
	         PreparedStatement up = conn.prepareStatement("insert into  teacher_login(UserID,Password,Shortname,TeacherID) values(?,?,?,?)");
             
	         up.setString(1, stor1);//1st value into UserID 
	         up.setString(2, stor2);
	         up.setString(3, stor3);
	         up.setString(4, stor4);	        
	         int result = up.executeUpdate(); 
	            
	        
	         if(result>0) {
	        	 
	        	 
	        	 PrintWriter pn = response.getWriter();
	  			 pn.print("SignUp Sucessful "); /* After Successful login its show SignUp Successful */
	        	
// This Line is excute then 
	  			 /*
		        	RequestDispatcher rd = request.getRequestDispatcher("Signup.jsp");
		        	rd.forward(request, response); 
		        	*/
		        	  
		        	
	         }
	      
			 conn.close();
	          stor.close();
	          up.close();
	          
	                   
	        //  rs.close();
	         
	          
	/*        
	          
try {   
				Class.forName("com.mysql.cj.jdbc.Driver");
			Connection teache = DriverManager.getConnection("jdbc:mysql://localhost:3306/routine", "root","");
			
String update = "insert into  signuplogin(UserID,Password)"+ " select UserID,Password from teacher_login";

PreparedStatement up = teache.prepareStatement("insert into  teacher_login(UserID,Password) values(?,?)");

up.setString(1, stor1);
up.setString(2, stor2);
up.executeUpdate(); 
teache.close();
         
PrintWriter er = response.getWriter();

er.print(" Sucessful UPDATE ");
	   
	    
	          
}
catch(Exception e) {
	PrintWriter er = response.getWriter();
	
	er.print(" Update into login table Error Try again");
	
	
}*/
	          
	                        
		}
		catch(Exception e)
		{
			PrintWriter cc = response.getWriter();
			PrintWriter pn = response.getWriter();
			pn.print("<h1> Same  ");pn.print("<h1>Login Not sucessful ..!</h1>");

			cc.print("Error Try again last part");
		}/* SignUp data insert or update*/
		
		
	}
	
}
