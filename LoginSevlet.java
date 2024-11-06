package conn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSevlet
 */
@WebServlet("/LoginSevlet")
public class LoginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PrintWriter outpu;

	public void fun(String id, String pwd){
		
		System.out.println("");
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/routine", "root","");		
			String id =request.getParameter("name"); // Store input data from login page 
			String pwd = request.getParameter("password"); //Working
			PreparedStatement stor = conn.prepareStatement("SELECT * FROM  	teacher_login 	 WHERE UserID =? and Password =?");
			 stor.setString(1, id);//1st value into UserID 
	          stor.setString(2, pwd);
	         ResultSet rs = stor.executeQuery();
	       
	         
	      
	         /*  rs is true then execute this line      */
	        
			if(rs.next()) {
	        	  /*
				 PrintWriter s = response.getWriter();
					s.print("Login Sucessful ...!"); */
				
	        	RequestDispatcher rd = request.getRequestDispatcher("Teacher.jsp");
	        	rd.forward(request, response); 
	          }
	          else {
	        	  
	        	  outpu.print("Erro to login"); 
	          }
	         
			 conn.close();
	          stor.close();
	          rs.close(); /* Last line of the code and close this line on system*/    
	                   
	          
		}
		catch(Exception e)
		{
			PrintWriter pn = response.getWriter();
			pn.print("<h1 style= color:red;> Try Again Invalid Userid/ password  ..!</h1>");
		}
		
		/*                                        !-------------------------Login Code End-----------------------------!                        */
		
		/* Here new code ------------------------*/
		
		
		
		
		
		
	/*			
try { /* SignUp data insert or update*/
			
			
		//	Class.forName("com.mysql.cj.jdbc.Driver");
		
			// Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/routine", "root","");
	/*		 String TeacherNmae = request.getParameter("name");
			 String Stream = request.getParameter("Stream");
			 String Subject = request.getParameter("Subject");
			 String Lab = request.getParameter("Lab");
			 
				PrintWriter test = response.getWriter();
				test.print("Teacher Name: "+TeacherNmae);
				test.print("Stream: " +Stream +'\n' +"");
				test.print("Subject: "+Subject +'\n');
				test.print("Lab : "+'\n'+Lab);
				//test.print("Teacher Name"+TeacherNmae);


				
			 
}*/
		/*
catch(Exception e)
{
	PrintWriter cc = response.getWriter();
	PrintWriter pn = response.getWriter();
	pn.print("<h1> Same  ");pn.print("<h1>Login Not sucessful ..!</h1>");

	cc.print("Error Try again last part");
}/* SignUp data insert or update*/
			
		
	}

}
