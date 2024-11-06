//import conn.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

//import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Teacher
 */
@WebServlet("/Teacher")
public class Teacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String T1 = null;
	
  
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
try { /* SignUp data insert or update*/;
			int a,b;
			a=b=0;

		Class.forName("com.mysql.cj.jdbc.Driver");
		
	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/routine", "root","");
		 String Teacherid = request.getParameter("Tid");
		 String shortname = request.getParameter("Sname");                                        /*  String = request.getParameter(""); */
			 String TeacherNmae = request.getParameter("name");
			 String Stream = request.getParameter("Stream");
			 String Subject = request.getParameter("Subject");
			 String Lab = request.getParameter("lab_update");
			 String LabNo= request.getParameter("lab_number");			// LoginSevlet aa = new LoginSevlet();
			 String Id =Teacherid ;             
 String Sub = Subject; 
 String Yes ="Yes";
 String No ="No";
			
			 System.out.println("LAB : "+Lab +" Lab NO :"+LabNo);		// PreparedStatement stor = conn.prepareStatement("insert into  teachertable(TeacherID,TeacherName,ShortName) values(?,?,?)");
			 PreparedStatement stor = conn.prepareStatement("insert into  teachertable(TeacherID,ShortName,TeacherName) values(?,?,?)");

			 
			 stor.setString(1, Teacherid);//1st value into UserID 
	          stor.setString(2, shortname);
	          stor.setString(3, TeacherNmae);
	          stor.executeUpdate();
	          PrintWriter pn = response.getWriter();
				 pn.print(" Sucessful ");
	             
	  /*--------------------------------Subject Insert----------------------------------*/           
	           
	  
	     	   
	      //  PreparedStatement up = conn.prepareStatement("insert ignore into subject_table(SubjectName) values(?)");
			 
		try	 (Statement statement = conn.createStatement()){
			 
			String query = "Select * from subject_table WHERE SubjectName = ?"; 
			

			 PreparedStatement preparedStatement = conn.prepareStatement(query);
	            preparedStatement.setString(1, Sub);

	            // Executing the query
	            ResultSet resultSet = preparedStatement.executeQuery();
	            
	            
	            if (resultSet.next()) {
	            	
	            	// System.out.println("Name exists in the database.");
	            	
	            	String T1 = resultSet.getString("TeacherID1");
	            	String T2 = resultSet.getString("TeacherID2");
	            	String T3 = resultSet.getString("TeacherID3");

	            	if(T1==null)
	            	{
	            		 String updateSQL = "UPDATE subject_table SET TeacherID1 = ? WHERE  SubjectName = ?";
	            		 
	            		 PreparedStatement updateStatement = conn.prepareStatement(updateSQL);
	                     updateStatement.setString(1, Id);
	                     updateStatement.setString(2, Sub);
	     	            		 
	                     int rowsUpdated = updateStatement.executeUpdate();

	                     if (rowsUpdated > 0) {
	                         System.out.println("Address updated successfully.");
	                     }
	                     updateStatement.close();
	                 } 
	            	else if(T2==null) {
	            		
	            		
	            		String updateSQL = "UPDATE subject_table SET TeacherID2 = ? WHERE  SubjectName = ?";
	            		 
	            		 PreparedStatement updateStatement = conn.prepareStatement(updateSQL);
	                     updateStatement.setString(1, Id);
	                     updateStatement.setString(2, Sub);
	     	            		 
	                     int rowsUpdated = updateStatement.executeUpdate();

	                     if (rowsUpdated > 0) {
	                         System.out.println("Address updated successfully.");
	                     }
	                     updateStatement.close();
	                 } 
	            			            		
	            	else if (T3==null) {            		

	            		String updateSQL = "UPDATE subject_table SET TeacherID3 = ? WHERE  SubjectName = ?";
	            		 
	            		 PreparedStatement updateStatement = conn.prepareStatement(updateSQL);
	                     updateStatement.setString(1, Id);
	                     updateStatement.setString(2, Sub);
	     	            		 
	                     int rowsUpdated = updateStatement.executeUpdate();

	                     if (rowsUpdated > 0) {
	                         System.out.println("Address updated successfully.");
	                     }
	                     updateStatement.close();	            		
	            		
	            	}
	            
	            	else {
	            		 System.out.println("Teacher1 Teacher2 Teacher3  datbase is Full ");
	            		
	            	}
	            	
	            	
	                System.out.println("Teacher1 datbase is Null");
	               
	                    
	            }
	            	else if(T1!=null)
	            	{
	            		System.out.println("Not  Null");
	            	}
	            statement.close();            	
/*       -------------------------- Lab Table update -------------------------------------------*/
	            
	            /* here subject lab update */
	              
	      
	            try(Statement stream = conn.createStatement()) 
	            {
	            	
	           // 	String value="1";
	            	 
//	    			String st = "Select * from labtable WHERE LabNo = ?"; 
	            	
	            	System.out.println("Test 1......Successful ");
	            	
	            	if("Yes".equalsIgnoreCase(Lab)) {
	            	String st = "Select * from labtable ";

	    			 PreparedStatement pnew = conn.prepareStatement(st);
	    	         //   pnew.setString(1,value);

           			
	    	            // Executing the query
	    	            ResultSet ne = pnew.executeQuery();	
	    	            
		            	System.out.println("Test 2......Successful ");

           			    			
	    	    			    if (ne.next()) {
	    	    	            	
	    	    	            
	    	    	            	
	    	    	            	System.out.println("Test 3......Successful ");

	    	    	          
										
										while(ne.next())
		    	    	            	 {
											
											String j = ne.getString("Subject");
											String N = ne.getString("LabNo");
											 System.out.println("lab no : "+N);
		    	    	            		 System.out.println("Subject : "+j); 
		    	    	            		 
		    	    	            		 
		    	    	            		 
		    	    	            		 if(Subject.equalsIgnoreCase(j)) {
		    	    	            			 System.out.println("Subject is Avabilivle ");
		    	    	            			 b=b+1;
		    	    	            		 }
		    	    	            		

		    	    	            	 } 
	    	    	            		    	            	
	    	    	            	
	    	    	   
									
	    	    	            
	    	    	            if(a == b)
	    		            	{
	    	    	            	
	    		            		//String up = "insert into  labtable(LanNo,Subject) values(?,?) ";
	    		            		 
	    		            	//String up =	"UPDATE labtable SET Subject = ? where Subject IS NULL ";
	    	    	            	
		    		            	String up =	"UPDATE labtable SET  Subject = ? where LabNo = ? "; 

	    		 	            	System.out.println("Test 4......Successful ");

	    		            		 PreparedStatement ok = conn.prepareStatement(up);
	    		            		// ok.setString(1, Val);
	    		            		 ok.setString(1, Sub);
	    		                     ok.setString(2, LabNo);
	    		                     
	    		                    // ok.setString(3, LabNo);
	    		                     
	    		 	            	System.out.println("Test 5......Successful ");
	 
	    		                     int ro = ok.executeUpdate();
		    		 	            	System.out.println("Test new 5.1.1.1......Successful ");


	    		                     if (ro > 0) {
	    		                         System.out.println("Address updated successfully..........now!!!!!!");
	    		     	            	System.out.println("Test 6......Successful ");
 
	    		                     }
	    		                     else {
	    		                    	  System.out.println("Address updated Not ..........!");
	    		                     }
	    		                     ok.close();
	    		 	            	System.out.println("Test 7......Successful ");

	    		            	} //if condition end 
	    	    	            else
	    	    	            {
	    	    	            	System.out.println("Already exaist data ");
	    	    	            }
	    	    	            
	    	    	            	 
	    	    			    }
	            	}
	            	else if("No".equalsIgnoreCase(Lab)) {
	            		System.out.println("Hello YOU are input NO........... So udate here!");            		
	            	}
	            	else {
	            		System.out.println("You are not input Yes and No ");
	            	}
	            	
	            	
	            	stream.close();}
	           
	    		
	    	            
	    	            catch(Exception e)
	    		           { 
	    		        	   System.out.println("Hello Lab issue here .....!");
	    		           }
           			
                     
/*               last line of code open --------------------------------- */
	                
	            }
	              	
	            
	           catch(Exception e)
	           { 
	        	   System.out.println("Hello Lab issue here .....!");
	           }
	    /*       -----------------------------------------   Lab Table code ---------------------------- */ 
		
	                 
	            
		
	      //   PrintWriter b = response.getWriter();
		//	 b.print(" work 2....! ");   
	          
	        // up.close();
	         PrintWriter c = response.getWriter();
			 c.print(" Work 3.....! ");   
	             
		//	 conn.close();
          //   stor.close();
  
	             
			 
}
catch(Exception e)
{
	PrintWriter cc = response.getWriter();
	 PrintWriter bb = response.getWriter(); 
	cc.print("<h1> Same  "); 
	bb.print("<h1>Login Not sucessful ..!</h1>");

	cc.print("Error Try again last part");
}/* SignUp data insert or update*/

		
		
		
}


	}
