package conn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import com.mysql.cj.protocol.Resultset;

import jakarta.servlet.RequestDispatcher;
import java.lang.*;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class routine
 */
@WebServlet("/routine")
public class routine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/routine", "root","");	

			 String subject = request.getParameter("Stream");
			// System.out.println("Stream"+subject); 
			 try (Statement statement = conn.createStatement() /* Which databse have run in here */ ) {
	             String query = "Select * from subject_table";
	             
	             ResultSet result = statement.executeQuery(query);
	         
	             int count=0;
	             while(result.next()){ // it is run while info have in databases  one by one
	                 String  subject_name; /* all data come in string format like int vrchar, */
	                 
	                 String subjectId,teacher1,teacher2,teacher3;
	                 subjectId = result.getString("SubjectID");
	                 subject_name = result.getString("SubjectName");
	                 teacher1 = result.getString("TeacherID1");
	                 teacher2 = result.getString("TeacherID2");
	                 teacher3 = result.getString("TeacherID3");

	               /*  System.out.println("Subject id : "+subjectId);
	                 System.out.println("Subject id : "+subject_name);
	                 System.out.println("Subject id : "+teacher1);
	                 System.out.println("Subject id : "+teacher2);
	                 System.out.println("Subject id : "+teacher3); */
	                 
	                 count =count+1;
	         //     System.out.println("Count: "+count);
                        try{
	    	            if(teacher1==null) {
	    	            	
	    	            	// 
	    	            	
	    	            }
	               

	    	            else if(teacher1!=null) {
	    	            	//
	    	            	
	    	    			PreparedStatement stor = conn.prepareStatement("SELECT * FROM  routinetable WHERE Subject =?  and Teacher1 =?");
	    	   			 stor.setString(1,subject_name);//1st value into UserID 

	    	   			 stor.setString(2,teacher1);
	    		         ResultSet rs = stor.executeQuery();
	    		         if(rs.next()) {
	    		        	// System.out.println("Subject is avabilale in routine  Table........ ");
	    		         }

	    		         else { //monday 
	    		        	 
    		        		 String day1 = "Monday";
	    		        	 String time1 = "9:00";


	    		        	 PreparedStatement check = conn.prepareStatement("SELECT * FROM  routinetable WHERE Subject =?  and Teacher1 =? and Day=? and Time=?");
	    		        	 
	    		        	 check.setString(1,subject_name);//1st value into UserID 

	    		        	 check.setString(2,teacher1);
	    		        	 check.setString(3,day1);
	    		        	 check.setString(4,time1);


		    		         ResultSet out =  check.executeQuery();
	    		        	 
	    		        	 
	    		        	 if(out.next()) {
	    		        		// System.out.println("Hello ");
	    		        	 }
	    		        	 else {
	    		        //	 System.out.println("Subject is not avabilale in routine  Table "); //Monday      	 
	    		        	 
	    		        	 /* Working ......................................................................! */ // day and time not completed 
	    		        	 String strm = "SELECT stream FROM stream WHERE subject = ?"; // Find out stream table in database like arts: English 
	    		        	// System.out.println("Test 1");
	    		        	 PreparedStatement sp = conn.prepareStatement(strm);
	    		        	 sp.setString(1,subject_name );//
	    		        	 ResultSet ab = sp.executeQuery();
	    		        	// System.out.println("Test 2");

	    		        	 if (ab.next()){ 
	    	                        // Retrieve the stream name
	    		        		 String day = "Monday";
		    		        	 String time = "9:00";
		    		        	 String Type = "Theroy";
		    		        	// System.out.println("Test 3");

	    	                       String su = ab.getString("stream"); // Steam value get from stream table 
	    	                       /*
	    	                        System.out.println("Strem :" +su);
	    	                        System.out.println("Subject :"+subject_name);
	    	                        System.out.println("techerId :"+teacher1);
	    	                        System.out.println("Day :"+day);
	    	                        System.out.println("Time :"+time); */
	    	                        


	    		        	 
	    		        	
	    			         PreparedStatement up = conn.prepareStatement("insert into  routinetable(Stream,Subject,Day,Time,Teacher1,Type) values(?,?,?,?,?,?)");
	    			         up.setString(1,su);//1st value into UserID 
	    			         up.setString(2,subject_name);
	    			         up.setString(3,day);
	    			         up.setString(4,time);
	    			         up.setString(5,teacher1);
	    			         up.setString(6,Type);

	    			       
	    			         
	    			      //   System.out.println("Test 4");

	    	                        
	    			         int update = up.executeUpdate(); 
	    			        // System.out.println("Test 5");
	    			         
	    			         if(update>0) {
	    			        	 System.out.println("Successful update");	   
	    			        	 
	    			         
	    			        	 PrintWriter pn = response.getWriter();
	    			  			 pn.print("Update Sucessful ");
	    			         }
	    			         else 
	    			         {
	    			        	 PrintWriter tr = response.getWriter();

	    			  			 tr.print("No Update");
	    			        	 System.out.println("Not update");
	    			         }
                                
	    		        	 System.out.println("Subject is  not avabilale in routine  Table !!!!!!!!!! ");
	    		        	 }
	    		         
	    		        	
	    		         }		        	 

	    		         
	    		         } ///System.out.println("");                                  //else part in if 	    
	    		         
	    		     //***********************************************       New Lab code ******************************************************  
	    		         
	    		         
	    		         
	    		         
	    		         
	    		         try (Statement la = conn.createStatement()){ // 1:0 varsion Try 
	    		         String seach = "Select * from labtable";
	    	             
	    	             ResultSet quarry = la.executeQuery(seach);
	    	             while(quarry.next()) { //2.0 while loop
	    	            	 
	    	            	 
	    	            	 String Labno,Suject;
	    	            	 Labno = quarry.getString("LabNo");
	    	            	 Suject = quarry.getString("Subject");
			                 System.out.println("Labtable Subject  : ");

			              //  System.out.println("labNo  :-> "+Labno);
			                //System.out.println("Suject  :-> "+Suject);

	    	            	 if(Suject==null) {
	    	            		 //subejct is null 
	    	            	 } else if(Suject!=null)
	    	            	 { //3.0 
	    	            		// Not Null Subject 
	    	            		 
	    	            		 
	    	            		  try (Statement n = conn.createStatement()){ // Try version 2.0
	    	 	    		         String search2 = "Select * from subject_table"; // Subject table --->> SubjectName , TeacherID1, TeacherID2, TeacherID3
	    	 	    	             
	    	 	    	             ResultSet out2 = n.executeQuery(search2);
	    	            		 while(out2.next()) { // 	While 3.0 
	    	            			 //SubjectName
	    	            			 String subjectname,Teacher1,Teacher2,Teacher3;
	    	    	            	 subjectname = out2.getString("SubjectName");
	    	    	            	 Teacher1 = out2.getString("TeacherID1");
	    	    	            	 Teacher2 = out2.getString("TeacherID2");
	    	    	            	 Teacher3 = out2.getString("TeacherID3");
	    	    	            	 
	    	    	            	 if(Teacher1!=null&&Teacher2!=null) { //  while 3.0 --> if --> 1:0 version  
	    	    	            		 
	    	    	            		// System.out.println("Teacher1 : "+Teacher1);
	    	    	            		// System.out.println("Teacher2 :"+Teacher2);
	    	    	            		 
	    	    	            		// PreparedStatement neo = conn.prepareStatement("insert into  routinetable(Subject,Day,Teacher1,Teacher2,LabNo) values(?,?,?,?,?,?)");
	    	    	            		 //System.out.println("Test 1");
	    	    	            		 
	    	    	            		 
	    	    	            		
	    	    	         			PreparedStatement neo = conn.prepareStatement("SELECT * FROM  	routinetable 	 WHERE Subject =? and Day =? and Time =? and Teacher1 =? and Teacher2=?");

	    	    	            		 String day="Monday";String time="2:00";
	    			    			        neo.setString(1,subjectname);
	    			    			        neo.setString(2,day);
	    			    			        neo.setString(3,time); 
	    			    			        neo.setString(4,Teacher1);
	    			    			        neo.setString(5,Teacher2);
	    			    			 
		    	    	            		 ResultSet	 value= neo.executeQuery();
	    			    			         
		    	    	            	//	 System.out.println("Test 3");
	    			    			         
	    			    			         if(value.next()) { // if 1.0 
	    			    			        	 System.out.println("Value is avabiable");    			    			

	    			    			         }
	    			    			         else  {   // else 2.0 
	    			    			        	 
	    			    			        //	 System.out.println("Plseae Insert Value in datase ******************************************************");	    			    			        	 
	    			    			        	 
	    			    			        	
	   /* ***************************************************************** *****************    Lab ****************************** *****************************/
	    		    		    	    	        
	    		    		    	    	        String[] arts = {"English","Education","History","Music","Geography"};
	    		    		    	    	        String[] commerce = {"Business", "Income Tax","Corporate Law","Economics","Auditing"};
	    		    		    	    	       String[] science = {"Physics", "Chemistry","Mathematics","Biology","Computer"};
	    		    		    	    	    
	    		    		    	    	       System.out.println();
	    		    		    	    	       String stm="";
	    		    		    	    	       for (int i = 0; i < 5; i++) {
	    		    		    	    	            if (subjectname.equals(arts[i])) {
	    		    		    	    	               System.out.println("Arts");
	    		    		    	    	              stm="Arts";
	    		    		    	    	                break;
	    		    		    	    	            } else if (subjectname.equals(commerce[i])) {
	    		    		    	    	                System.out.println("Commerce");
	    		    		    	    	                stm="commerce";
	    		    		    	    	                		
	    		    		    	    	                break;
	    		    		    	    	            } else if (subjectname.equals(science[i])) {
	    		    		    	    	                System.out.println("Science");
	    		    		    	    	                stm="Science";
	    		    		    	    	                
	    		    		    	    	                break;
	    		    		    	    	            }
	    		    		    	    	        }
	    		    		    	    	       
	    		    		    	    	       
	    		    		    	    	      
	    		    		    	    	       
	    		    		    	    	       String numb="";
	    		    		    	    	      try( Statement num = conn.createStatement()){ //1.0.0
	    		    		    	    	    	//  System.out.println("Test 222");
	    		    		  	    		         String no = "Select * from labtable";
	    		    		  	    	            
	    		    		  	    	             ResultSet data = num.executeQuery(no);
	    		    		  	    	             while(data.next()) { //while 1.0.1
	    		    		  	    	            String Labno2,Suject3;
	    		    		  	    	            	 Labno2 = data.getString("LabNo");
	    		    		  	    	            	 Suject3 = data.getString("Subject");
	    		    		  			                 System.out.println("Lab NO   : ");
	    		    		  			                 
	    		    		    	    	            if(subjectname.equals(Suject3)) {  
	    		    		    	    	            	 numb=Labno2;
	    		    		    	    	            	
	    		    		    	    	            	 
	    		    		    	    	            	 System.out.println("Test 555");
	 	    		    		    	    	            break;
	    		    		    	    	            } //if 
	    		    		    	    	           
	    		    		    	    	             else {
	    		    		    	    	            	//Nothing 
	    		    		    	    	            	 System.out.println("Test 666");
	    		    		    	    	             }
	    		    		  	    	          } //while 1.0.1
	    		    		    	    	      } //Try 1.0.0
	    		    		    	    	      catch(Exception e) {
	    		    		    	    	    	  System.out.println("Exception ********************* Lab No !!!!!!!****************!!!!!!");
	    		    		    	    	      }
    		    		    
	    		    		    	    	       PreparedStatement lau = conn.prepareStatement("insert into  routinetable(Stream,Subject,Day,Time,Teacher1,Teacher2,Type,LabNo) values(?,?,?,?,?,?,?,?)");
	    		    		    	    	     
	    		    		    	    	        String Type = "Lab";
	    		    		    	    	        
	    		    		    	    	       String G = "1";
	    		    		    	    	        
	    		    		    	    	        String Stream =stm;
	    		    		    	    	           lau.setString(1,Stream);
	    		    		    	    	           lau.setString(2,subjectname);
	    		    		    	    	           lau.setString(3,day);
	    		    		    	    	           lau.setString(4,time); 
	    		    		    	    	           lau.setString(5,Teacher1);
	    		    		    	    	           lau.setString(6,Teacher2);
	    		    		    	    	           lau.setString(7,Type);	   		  
	    		    		    	    	         // lau.setString(8,"Group1");
	    		    		    	    	           lau.setString(8,numb);
	    			    			        	 
	    			    			        	 
	    		    		    	    	           int uu=    lau.executeUpdate();
	    		    		    	    	           
	    		    		    	    	           
	    		                                        if(uu>0) {
	    		   			    			        	 System.out.println("Subject update sucessful");

	    		                                        }
	    		                                        else 
	    		                                        {
	    		      			    			        	 System.out.println("Subject  update not sucessful.....................!");
	    		                                        }
	    		                                        
	                      /*  --------------------------------------- Start Time 3:00 time Lab  ----------------------------------  */
	    		
	    		                                        //check error 
	    		                                        System.out.println("Working .............................!!!!!! *********** ");

	    		                                            
	    		                                        String sub3 = "Select * from subject_table";
	    		                       	             
	    		                       	             ResultSet sujit = statement.executeQuery(sub3);
	    		                       	         
	    		                       	          
	    		                       	             while(sujit.next()){ // it is run while info have in databases  one by one
	    		                       	                 String  T2,T3,Sub; // all data come in string format like int vrchar, 
	    		                       	             Sub = sujit.getString("SubjectName");
	    		                       	              T2 = sujit.getString("TeacherID2");
	    		                 	                 T3 = sujit.getString("TeacherID3");
	    		                                      //  System.out.println("Subject "+Sub);
	    		                                       // System.out.println("Teacher2 : "+T2);
	    		                                       // System.out.println("Teacher3: "+T3);

	    		                                        if(T2==null&&T3==null) {
	    		                                        	//
	    		                                        }
	    		                                        else if(T2!=null&&T3!=null) {
	    		                                        	
	    		                                
	    		                                        	 PreparedStatement jio = conn.prepareStatement("SELECT * FROM  	routinetable 	 WHERE Subject =? and Day =? and Time =? and Teacher2=? and Teacher3 =?");
		    			    	    	            		 String day1="Monday";String time1="3:00";
		    			    			    			        jio.setString(1,Sub);
		    			    			    			        jio.setString(2,day1);
		    			    			    			        jio.setString(3,time1); 
		    			    			    			        jio.setString(4,T2);
		    			    			    			        jio.setString(5,T3);
		    			    			    			       // neo.setString(5,Teacher2);
		    			    			    			 
		    				    	    	            		 ResultSet	 ou= jio.executeQuery();
		    			    			    			         
		    				    	    	            	//	 System.out.println("Test 3");
		    			    			    			         
		    			    			    			         if(ou.next()) { //2
		    			    			    			        	 System.out.println("Value is avabiable");    			    			

		    			    			    			         }
		    			    			    			         else  {   
		    			    			    			        	 
		    			    			    			        	 
		    			    			    			        	  String[] arts1 = {"English","Education","History","Music","Geography"};
		    			    		    		    	    	        String[] commerce1 = {"Business", "Income Tax","Corporate Law","Economics","Auditing"};
		    			    		    		    	    	       String[] science1 = {"Physics", "Chemistry","Mathematics","Biology","Computer"};
		    			    		    		    	    	    
		    			    		    		    	    	       System.out.println();
		    			    		    		    	    	       String stm1="";
		    			    		    		    	    	       
		    			    		    		    	    	       for (int i = 0; i < 5; i++) {
		    			    		    		    	    	            if (Sub.equals(arts1[i])) {
		    			    		    		    	    	               System.out.println("Arts");
		    			    		    		    	    	              stm1="Arts";
		    			    		    		    	    	                break;
		    			    		    		    	    	            } else if (Sub.equals(commerce1[i])) {
		    			    		    		    	    	                System.out.println("Commerce");
		    			    		    		    	    	                stm1="commerce";
		    			    		    		    	    	                		
		    			    		    		    	    	                break;
		    			    		    		    	    	            } else if (Sub.equals(science1[i])) {
		    			    		    		    	    	                System.out.println("Science");
		    			    		    		    	    	                stm1="Science";
		    			    		    		    	    	                
		    			    		    		    	    	                break;
		    			    		    		    	    	            }
		    			    		    		    	    	        }
		    			    		    		    	    	       
		    			    		    		    	    	     PreparedStatement labu = conn.prepareStatement("insert into  routinetable(Stream,Subject,Day,Time,Teacher1,Teacher2,Teacher3,Type,LabNo) values(?,?,?,?,?,?,?,?,?)");

		    			    			    			        String	 T1 ="";
		    			    		    		    	    	     
		    			    				                    //     System.out.println(+Stream+""+Sub+""+day1+""+time1+""+T2+""+T3);

		    			    			    			        	 String Type2 ="Lab";
		    			    			    			        	 System.out.println("Hello Bijoy");
		    			    			    			        	 
		    			    			    			        	 System.out.println("Lab No : "+numb);
                                                                  String Lab3 ="";
		    			    			    			        	 if (Sub.equalsIgnoreCase("English")) {
		    			    			    			        		 Lab3="1";
		    			    			    			        		 
		    			    			    			                 System.out.println("Lab number 1");
		    			    			    			             } else if (subject.equalsIgnoreCase("History")) {
		    			    			    			        		 Lab3="2";
		    			    			    			                 System.out.println("Lab number 2");
		    			    			    			             }
		    			    			    			             
		    			    			    			             else if (subject.equalsIgnoreCase("Music")) {
		    			    			    			        		 Lab3="3";

		    			    			    			                 System.out.println("Lab number 3");
		    			    			    			             }
		    			    			    			        	 
		    			    			    			             else if (subject.equalsIgnoreCase("Geography")) {
		    			    			    			        		 Lab3="4";
		    			    			    			             }
		    			    			    			             else if (subject.equalsIgnoreCase("Education")) {
		    			    			    			        		 Lab3="5";
		    			    			    			             }
		    			    			    			             else if (subject.equalsIgnoreCase("Auditing")) {
		    			    			    			        		 Lab3="6";
		    			    			    			             }
		    			    			    			             else if (subject.equalsIgnoreCase("Economics")) {
		    			    			    			        		 Lab3="7";
		    			    			    			             }
		    			    			    			             else if (subject.equalsIgnoreCase("Corporate Law")) {
		    			    			    			        		 Lab3="8";
		    			    			    			             }
		    			    			    			             else if (subject.equalsIgnoreCase("Income Tax")) {
		    			    			    			        		 Lab3="9";
		    			    			    			             }
		    			    			    			             else if (subject.equalsIgnoreCase("Business")) {
		    			    			    			        		 Lab3="10";
		    			    			    			             }
		    			    			    			             else if (subject.equalsIgnoreCase("Mathematics")) {
		    			    			    			        		 Lab3="11";
		    			    			    			             }
		    			    			    			             else if (subject.equalsIgnoreCase("Physics")) {
		    			    			    			        		 Lab3="12";
		    			    			    			             }
		    			    			    			             else if (subject.equalsIgnoreCase("Chemistry")) {
		    			    			    			        		 Lab3="13";
		    			    			    			             }
		    			    			    			        	 
		    			    			    			             else if (subject.equalsIgnoreCase("Biology")) {
		    			    			    			            	 Lab3="14";
		    			    			    			             }
		    			    			    			             else if (subject.equalsIgnoreCase("Computer")) {
		    			    			    			                 Lab3="15";
		    			    			    			             } else {
		    			    			    			                 System.out.println("Lab number not assigned");
		    			    			    			             }
		    			    			    			             
		    			    			    			  
		    			    			    			        	 System.out.println(stm1 + " " + Sub + " " + day1 + " " + time1 + " " + T2 + " " + T3);
		    			    		    		    	    	       
		    			    		    		    	    	       labu.setString(1,stm1);
		    			    		    		    	    	       labu.setString(2,Sub);
		    			    		    		    	    	       labu.setString(3,day1);
		    			    		    		    	    	       labu.setString(4,time1);
		    			    		    		    	    	       labu.setString(5,T1);
		    			    		    		    	    	       labu.setString(6,T2);
		    			    		    		    	    	       labu.setString(7,T3);
		    			    		    		    	    	       labu.setString(8,Type2);	   		  
		    		    		    		    	    	         // lau.setString(8,"Group1");
		    			    		    		    	    	       labu.setString(9,Lab3);
		    			    		    		    	    	     int oc=  labu.executeUpdate();
		    			    		    		    	  System.out.println("oc : "+oc);
		    			    		    		    	    	      /* if(oc>0) {
		    			    		    		    	    	    	   System.out.println("Execute Update Successful !!");   
		    			    		    		    	    	       }
		    			    		    		    	    	       else {
		    			    		    		    	    	    	   System.out.println("Execute Update Not Successful !!");   

		    			    		    		    	    	       }*/
		    			    		    		    	    	   
		    			    			    			        	 System.out.println("Please Insert Time 3:00      Monday        Here Yoooooooooo ");
		    			    			    			        	//break; 
		    			    			    			      
		    			    			    			      } 
	    		                                        }
	    		                                        
	    		                                        	
	    		                                      //  }
	    		                                       // else {
	    		                                        	
	    		                                      //  } 
	    		                 	                   
	    		                 	                   
	    		                 	                   
	    		                 	                   
	    		                 	                  
	    		                                    /*
	    		                                       PreparedStatement jio = conn.prepareStatement("SELECT * FROM  	routinetable 	 WHERE Subject =? and Day =? and Time =? and Teacher3 =?");
	    			    	    	            		 String day1="Monday";String time1="3:00";
	    			    			    			        jio.setString(1,subjectname);
	    			    			    			        jio.setString(2,day);
	    			    			    			        jio.setString(3,time); 
	    			    			    			        jio.setString(4,Teacher3);
	    			    			    			       // neo.setString(5,Teacher2);
	    			    			    			 
	    				    	    	            		 ResultSet	 ou= jio.executeQuery();
	    			    			    			         
	    				    	    	            	//	 System.out.println("Test 3");
	    			    			    			         
	    			    			    			         if(ou.next()) { //2
	    			    			    			        	 System.out.println("Value is avabiable");    			    			

	    			    			    			         }
	    			    			    			         else  {   
	    			    			    			     	 
	    			    			    			         }  */
	    		                                      
	    		                       	           }  //Lab 3:00 PM while loop close        
	    		                                        
	  /*--------------------------------------- End Time 3:00 Lab  ----------------------------------    */	                                        
	    		                                        

} /*  while 3.0 --> if --> 1:0 version  --> else 2.0 

(public class routine extends HttpServlet)-->{doGet(request, response);}-->[1st Try]--->

[2nd Try]-->{while loop}-->[3rd Try]-->[4th Try]-->[5th try]-->{while loop}-->{else if}-->[try 6th]--->{while loop}--->{if} --->else


*/
	    			    			         
	    			    			         
	    			    			         
	    			    			         
	    			    			         
	    			    			         
	    			    			         
	     
} /* (public class routine extends HttpServlet)-->{doGet(request, response);}-->[1st Try]--->

[2nd Try]-->{while loop}-->[3rd Try]-->[4th Try]-->[5th try]-->{while loop}-->else if-->[try 6th]--->{while loop}--->if  */  

	     	 
	    	    	            	 
	    	    	            	 
	    	    	            	 
	    	    	            	 
	    	            		 
}/* (public class routine extends HttpServlet)-->{doGet(request, response);}-->[1st Try]--->

[2nd Try]-->{while loop}-->[3rd Try]-->[4th Try]-->[5th try]-->{while loop}-->else if-->[try 6th]--->{while loop}  */  


	    	            		 
	    	            		 
	    	            		 
	    	            		 
	    	            		 
	    	            		 
}/* (public class routine extends HttpServlet)-->{doGet(request, response);}-->[1st Try]--->

[2nd Try]-->{while loop}-->[3rd Try]-->[4th Try]-->[5th try]-->{while loop}-->else if-->[try 6th]  */    	            		  
	    	            	 
	    	  
	    	            		                         catch(Exception e)
  			    				                                           {
  			    				                              System.out.println(""+e);		
  			    				                                            } 
	    	            		  
}/*  (public class routine extends HttpServlet)-->{doGet(request, response);}-->[1st Try]--->

[2nd Try]-->{while loop}-->[3rd Try]-->[4th Try]-->[5th try]-->{while loop}-->else if 
	            	 
	    */	            	 
	    	            	 
	    	            	 
	    	            	 
	    	            	 
	    	            	 
	    	            		
	    	            	 
}//(public class routine extends HttpServlet)-->{doGet(request, response);}-->[1st Try]--->[2nd Try]-->while loop-->[3rd Try]-->[4th Try]-->[5th try]-->while loop
	    	             
	    	             
	    	             
}//(public class routine extends HttpServlet)-->{doGet(request, response);}-->[1st Try]--->[2nd Try]-->while loop-->[3rd Try]-->[4th Try]-->[5th try]
	    		         
	    		         
catch(Exception e){System.out.println(""+e);		
}//(public class routine extends HttpServlet)-->{doGet(request, response);}--> [1st Try] --->[2nd Try] -->while loop-->[3rd Try]-->[4th Try]-->[4th catch]
	    		         
	   		         
	    // ******************************************************* End Lab Code *****************************************************		         
 
	    	            }
} //(public class routine extends HttpServlet)-->{doGet(request, response);}--> [1st Try] ---> [2nd Try] -->while loop-->[3rd Try]
                  
                        
catch(Exception e){System.out.println(""+e);		
}////(public class routine extends HttpServlet)------->{doGet(request, response);}-----> [1st Try] ------> [2nd Try] -->while loop-->[3rd Try]--->catch
                         
                        
} // (public class routine extends HttpServlet)------->{doGet(request, response);}-----> [1st Try] ------> [2nd Try] -->while loop
//statement.close();
//result.close();


			 }//  (public class routine extends HttpServlet)------->{doGet(request, response);}-----> [1st Try] ------> [2nd Try]			 
			 catch(Exception e)
				{
				System.out.println(""+e);	
				
				} //(public class routine extends HttpServlet)------->{doGet(request, response);}-----> [1st Try] ------> [2nd Try]------>catch(Exception e)
		 
		} // (public class routine extends HttpServlet)------->{doGet(request, response);}--------> [1st Try] 
		
		
		catch (Exception e)
		{
		System.out.println(""+e);		
		}// (public class routine extends HttpServlet)------->{doGet(request, response);}--------> [1st Try] -------> (( catch (Exception e))

		
	}//doGet(request, response);

}// public class routine extends HttpServlet 

