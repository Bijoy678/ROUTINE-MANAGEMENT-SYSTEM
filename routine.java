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
			 String strm123 =subject;
			// System.out.println("Stream"+subject); 
			 try (Statement statement = conn.createStatement() /* Which database have run in here */ ) {
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
	            
	                 int Room = 0;
		        	 if (subject_name.equalsIgnoreCase("English")) {
		        		 Room=1;
		        		 
		               //  System.out.println("Lab number 1");
		             } else if (subject_name.equalsIgnoreCase("History")) {
		            	 Room=2;
		               //  System.out.println("Lab number 2");
		             }
		             
		             else if (subject_name.equalsIgnoreCase("Music")) {
		            	 Room=3;
		                // System.out.println("Lab number 3");
		             }
		             else if (subject_name.equalsIgnoreCase("Geography")) {
		            	 Room=4;
		             }
		             else if (subject_name.equalsIgnoreCase("Education")) {
		            	 Room=5;
		             }
		             else if (subject_name.equalsIgnoreCase("Auditing")) {
		            	 Room=6;
		             }
		             else if (subject_name.equalsIgnoreCase("Economics")) {
		            	 Room=7;
		             }
		             else if (subject_name.equalsIgnoreCase("Corporate Law")) {
		            	 Room=8;
		             }
		             else if (subject_name.equalsIgnoreCase("Income Tax")) {
		            	 Room=9;
		             }
		             else if (subject_name.equalsIgnoreCase("Business")) {
		            	 Room=10;
		             }
		             else if (subject_name.equalsIgnoreCase("Mathematics")) {
		            	 Room=11;
		             }
		             else if (subject_name.equalsIgnoreCase("Physics")) {
		            	 Room=12;
		             }
		             else if (subject_name.equalsIgnoreCase("Chemistry")) {
		            	 Room=13;
		             }
		        	 
		             else if (subject_name.equalsIgnoreCase("Biology")) {
		            	 Room=14;
		             }
		             else if (subject_name.equalsIgnoreCase("Computer")) {
		            	 Room=15;
		             } else {
		                 System.out.println("Lab number not assigned");
		             }       
	                 
		        	 

	                 
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
	    	  
	    	                      
		    			      //  String	 R="99774";
	    			         PreparedStatement up = conn.prepareStatement("insert into  routinetable(Stream,Subject,Day,Time,Teacher1,Room,Type) values(?,?,?,?,?,?,?)");
	    			         up.setString(1,su);//1st value into UserID 
	    			         up.setString(2,subject_name);
	    			         up.setString(3,day);
	    			         up.setString(4,time);
	    			         up.setString(5,teacher1);
	    			          up.setInt(6,Room);
	    			         up.setString(7,Type);  
	    			       //  up.setString(8,LabNo);
	    			      //   System.out.println("Test 4");

	    	                        
	    			         int update = up.executeUpdate(); 
	    			        // System.out.println("Test 5");
	    			         
	    			         if(update>0) {
	    			        	// System.out.println("Successful update");	   
	    			        	 
	    			         
	    			        	 PrintWriter pn = response.getWriter();
	    			  			 pn.print("Update Sucessful ");
	    			         }
	    			         else 
	    			         {
	    			        	 PrintWriter tr = response.getWriter();

	    			  			 tr.print("No Update");
	    			        	// System.out.println("Not update");
	    			         }
                                
	    		        	// System.out.println("Subject is  not avabilale in routine  Table !!!!!!!!!! ");
	    		        	 }	    		         ab.close();	
	    		         }		        	 

	    		         
	    		         } 
	    		         stor.close();	    		         
	    		         
	    		         
	    		         ///System.out.println("");                                  //else part in if 	    
	    		         
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
	    	 	    		         String search2 = "Select * from subject_table"; // Subject table --->> SubjectName , TeacherID1, TeacherID2,TeacherID3
	    	 	    	             
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
	    		    		    	    	            	
	    		    		    	    	            	 
	    		    		    	    	            	// System.out.println("Test 555");
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
		    			    			    			        //	 System.out.println("Value is avabiable");    			    			
		    			    			    			         }
		    			    			    			         else  {   
		    			    			    			        	 
		    			    			    			        	 
		    			    			    			        	  String[] arts1 = {"English","Education","History","Music","Geography"};
		    			    		    		    	    	        String[] commerce1 = {"Business", "Income Tax","Corporate Law","Economics","Auditing"};
		    			    		    		    	    	       String[] science1 = {"Physics", "Chemistry","Mathematics","Biology","Computer"};
		    			    		    		    	    	    
		    			    		    		    	    	     //  System.out.println();     // Which stream according to Subjects 
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
		    			    			    			             
		    			    			    			  
		    			    			    			     //   	 System.out.println(stm1 + " " + Sub + " " + day1 + " " + time1 + " " + T2 + " " + T3);
		    			    			    			        	    
		    			    		    		    	    	     PreparedStatement labu = conn.prepareStatement("insert into  routinetable(Stream,Subject,Day,Time,Teacher1,Teacher2,Teacher3,Type,LabNo) values(?,?,?,?,?,?,?,?,?)");

		    			    			    			        String	 T1 ="";
		    			    			    			        String Type2 ="Lab";
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
		    			    		    		    	            //  System.out.println("oc : "+oc);
		    			    		    		    	    	      /* if(oc>0) {
		    			    		    		    	    	    	   System.out.println("Execute Update Successful !!");   
		    			    		    		    	    	       }
		    			    		    		    	    	       else {
		    			    		    		    	    	    	   System.out.println("Execute Update Not Successful !!");   

		    			    		    		    	    	       }*/
		    			    		    		    	    	   
		    			    			    			        //	 System.out.println("Please Insert Time 3:00      Monday        Here Yoooooooooo ");
		    			    			    			        	//break; 
		    			    			    			      
		    			    			    			      } 
	    		                                        }
	    		                                        
	    		                                     
	    		                                      
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
  
  
                        
                        
                        
                        
                        
                        
 /*  ///////////////////////////////******                       Teacher2 Add code   *******************************************                            */                        
                        
                        
 System.out.println("Bijoy You can add  T2 here ******** OKKKKKKKKKKKKKKKKKKKK");                    
                        
                      
          
 String Time2 ="11:00";
 String Day3="Monday";
 String Teacher1 ="";
 String Type3 = "Theroy";
 String Lab3 ="";

 
 
 try{
     if(teacher2==null) {
     	
     	// 
     	
     }
  
     else if(teacher2!=null) {
     	//
   	  System.out.println(" Techer 2 not null bijoy ");

		PreparedStatement stor2 = conn.prepareStatement("SELECT * FROM  routinetable WHERE Subject =? and Day=?  and Teacher2 =? and Time=?");
		 stor2.setString(1,subject_name);//1st value into UserID 
		 stor2.setString(2,Day3);

		 stor2.setString(3,teacher2);
		 
		 stor2.setString(4,Time2);

      ResultSet rs1 = stor2.executeQuery();
      if(rs1.next()) {
     	System.out.println("Subject is avabilale in routine  Table........ "); 
      }
      else {
    	
    	  System.out.println("Subject is avabilale not routine  Table........!! "); 
    	
    	  String[] arts1 = {"English","Education","History","Music","Geography"};
	        String[] commerce1 = {"Business", "Income Tax","Corporate Law","Economics","Auditing"};
	       String[] science1 = {"Physics", "Chemistry","Mathematics","Biology","Computer"};
	    
	     //  System.out.println();     // Which stream according to Subjects 
	       String stm1="";
	       
	       for (int i = 0; i < 5; i++) {
	            if (subject_name.equals(arts1[i])) {
	               System.out.println("Arts");
	              stm1="Arts";
	                break;
	            } else if (subject_name.equals(commerce1[i])) {
	                System.out.println("Commerce");
	                stm1="commerce";
	                		
	                break;
	            } else if (subject_name.equals(science1[i])) {
	                System.out.println("Science");
	                stm1="Science";
	                
	                break;
	            }
	        }
    	  
    	  
      	 if (subject_name.equalsIgnoreCase("English")) {
      		 Lab3="1";
      		 
              // System.out.println("Lab number 1");
           } else if (subject_name.equalsIgnoreCase("History")) {
      		 Lab3="2";
              // System.out.println("Lab number 2");
           }
           
           else if (subject_name.equalsIgnoreCase("Music")) {
      		 Lab3="3";

               System.out.println("Lab number 3");
           }
      	 
           else if (subject_name.equalsIgnoreCase("Geography")) {
      		 Lab3="4";
           }
           else if (subject_name.equalsIgnoreCase("Education")) {
      		 Lab3="5";
           }
           else if (subject_name.equalsIgnoreCase("Auditing")) {
      		 Lab3="6";
           }
           else if (subject_name.equalsIgnoreCase("Economics")) {
      		 Lab3="7";
           }
           else if (subject_name.equalsIgnoreCase("Corporate Law")) {
      		 Lab3="8";
           }
           else if (subject_name.equalsIgnoreCase("Income Tax")) {
      		 Lab3="9";
           }
           else if (subject_name.equalsIgnoreCase("Business")) {
      		 Lab3="10";
           }
           else if (subject_name.equalsIgnoreCase("Mathematics")) {
      		 Lab3="11";
           }
           else if (subject_name.equalsIgnoreCase("Physics")) {
      		 Lab3="12";
           }
           else if (subject_name.equalsIgnoreCase("Chemistry")) {
      		 Lab3="13";
           }
      	 
           else if (subject_name.equalsIgnoreCase("Biology")) {
          	 Lab3="14";
           }
           else if (subject_name.equalsIgnoreCase("Computer")) {
               Lab3="15";
           } else {
               System.out.println("Lab number not assigned");
           }

    	  PreparedStatement add = conn.prepareStatement("insert into  routinetable(Stream,Subject,Day,Time,Teacher1,Teacher2,Room,Type) values(?,?,?,?,?,?,?,?)");
 	     
	      //  String Stream =stm;
	           add.setString(1,stm1);
	           add.setString(2,subject_name);
	           add.setString(3,Day3);
	           add.setString(4,Time2); 
	           add.setString(5,Teacher1);
	           add.setString(6,teacher2);
	           add.setString(7,Lab3);	//room   		  
	         // lau.setString(8,"Group1");
	           add.setString(8,Type3);
  	 
	       int cc=   add.executeUpdate();
    	  if(cc>0) {

	        	 PrintWriter pn = response.getWriter();
	  			 pn.print("Update Sucessful Teacher2!! ");  
    	  }
    	  
    	  else {
    		  System.out.println("Tacher 2 Not Add ");
    	  }
    	  
      }
      
      }
     else {
   	  
   	//  System.out.println("Please Add Bijoy ***! ");
   	  
     }
 }
 catch(Exception e) {
	 
 }
 
 /*  ///////////////////////////////******         End              Teacher2 Add code   *******************************************                            */                        


 
 /*    **********************************************    Teacher 3 *************************************                                       */
 
 

 
 /*  ///////////////////////////////******                       Teacher2 Add code   *******************************************                            */                        
 
       
 String Time3 ="1:00";
 String Day4="Monday";
 String Teacher11 ="";
 String Teacher2 ="";
 String Type4 = "Theroy";
 String Lab4 ="";

 
 
 try{
     if(teacher3==null) {
     	
     	// 
     	
     }
  
     else if(teacher3!=null) {
     	//
   	  System.out.println(" Techer 2 not null bijoy ");

		PreparedStatement stor3 = conn.prepareStatement("SELECT * FROM  routinetable WHERE Subject =? and Day=?  and Teacher3 =? and Time=?");
		 stor3.setString(1,subject_name);//1st value into UserID 
		 stor3.setString(2,Day3);

		 stor3.setString(3,teacher3);
		 
		 stor3.setString(4,Time3);

      ResultSet rs2 = stor3.executeQuery();
      if(rs2.next()) {
     	System.out.println("Subject is avabilale in routine  Table........ "); 
      }
      else {
    	  
    	  
    	  
    	  System.out.println("Subject is avabilale not routine  Table........!! "); 
    	  

     	 
    	  String[] arts2 = {"English","Education","History","Music","Geography"};
	        String[] commerce2 = {"Business", "Income Tax","Corporate Law","Economics","Auditing"};
	       String[] science2 = {"Physics", "Chemistry","Mathematics","Biology","Computer"};
	    
	     //  System.out.println();     // Which stream according to Subjects 
	       String stm2="";
	       
	       for (int i = 0; i < 5; i++) {
	            if (subject_name.equals(arts2[i])) {
	               System.out.println("Arts");
	              stm2="Arts";
	                break;
	            } else if (subject_name.equals(commerce2[i])) {
	                System.out.println("Commerce");
	                stm2="commerce";
	                		
	                break;
	            } else if (subject_name.equals(science2[i])) {
	                System.out.println("Science");
	                stm2="Science";
	                
	                break;
	            }
	        }
    	  
    	  
      	 if (subject_name.equalsIgnoreCase("English")) {
      		 Lab4="1";
      		 
              // System.out.println("Lab number 1");
           } else if (subject_name.equalsIgnoreCase("History")) {
      		 Lab4="2";
              // System.out.println("Lab number 2");
           }
           
           else if (subject_name.equalsIgnoreCase("Music")) {
      		 Lab4="3";

               System.out.println("Lab number 3");
           }
      	 
           else if (subject_name.equalsIgnoreCase("Geography")) {
      		 Lab4="4";
           }
           else if (subject_name.equalsIgnoreCase("Education")) {
      		 Lab4="5";
           }
           else if (subject_name.equalsIgnoreCase("Auditing")) {
      		 Lab4="6";
           }
           else if (subject_name.equalsIgnoreCase("Economics")) {
      		 Lab4="7";
           }
           else if (subject_name.equalsIgnoreCase("Corporate Law")) {
      		 Lab4="8";
           }
           else if (subject_name.equalsIgnoreCase("Income Tax")) {
      		 Lab4="9";
           }
           else if (subject_name.equalsIgnoreCase("Business")) {
      		 Lab4="10";
           }
           else if (subject_name.equalsIgnoreCase("Mathematics")) {
      		 Lab4="11";
           }
           else if (subject_name.equalsIgnoreCase("Physics")) {
      		 Lab4="12";
           }
           else if (subject_name.equalsIgnoreCase("Chemistry")) {
      		 Lab4="13";
           }
      	 
           else if (subject_name.equalsIgnoreCase("Biology")) {
          	 Lab4="14";
           }
           else if (subject_name.equalsIgnoreCase("Computer")) {
               Lab4="15";
           } else {
               System.out.println("Lab number not assigned");
           }

    	  PreparedStatement add = conn.prepareStatement("insert into  routinetable(Stream,Subject,Day,Time,Teacher1,Teacher2,Teacher3,Room,Type) values(?,?,?,?,?,?,?,?,?)");
 	     
	     //   String Type = "Lab";
	        
    	 /* 
    	  String Time3 ="1:00";
    	  String Day4="Monday";
    	  String Teacher2 ="";
    	  String Type4 = "Theroy";
    	  String Lab4 ="";
*/
    	  
	       
	      //  String Stream =stm;
	           add.setString(1,stm2);
	           add.setString(2,subject_name);
	           add.setString(3,Day4);
	           add.setString(4,Time3); //Teacher11
	           add.setString(5,Teacher11);

	           add.setString(6,Teacher2);
	           add.setString(7,teacher3);
	           add.setString(8,Lab4);	//room   		  
	         // lau.setString(8,"Group1");
	           add.setString(9,Type4);
  	 
	       int cc=   add.executeUpdate();
    	  if(cc>0) {

	        	 PrintWriter pn = response.getWriter();
	  			 pn.print("Update Sucessful Teacher3!! ");  
    	  }
    	  
    	  else {
    		  System.out.println("Tacher 2 Not Add ");
    	  }
    	  
      }
      
      }
     else {
   	  
   	//  System.out.println("Please Add Bijoy ***! ");
   	  
     }
 }
 catch(Exception e) {
	 
 }
 
 /*  ///////////////////////////////******         End              Teacher2 Add code   *******************************************                            */                        

                 
                        
      /*  ***************************************************************      Teacher 3      ***********************************************   */                  
                        
                        
  /*        ******** Tuesday , Wednesday, Thusday,Friday, Saturday******** */                      
                        
                        
    
 
 //System.out.println("Hello Bijoy You can do **************************************************************"); 
 //

// L1=:9:00  L2=10:00 L3=11:00 
 
 
 //subject_name = result.getString("SubjectName");
// teacher1 = result.getString("TeacherID1");
 //teacher2 = result.getString("TeacherID2");
 //teacher3 = result.getString("TeacherID3");

 
 
// System.out.println(""+subject_name);
 
 //System.out.println(""+teacher1);

 //System.out.println(""+teacher2);

 

 String Time ="";
 String Day="Tuesday";
 //String Teacher ="";
 String Type = "Theroy";
 String Lab ="";
 int x;
 
 

 
/*        ******** Tuesday , Wednesday, Thusday,Friday, Saturday******** */ 
                        
                        
} // (public class routine extends HttpServlet)------->{doGet(request, response);}-----> [1st Try] ------> [2nd Try] -->while loop
statement.close();
result.close();
	             
	             
System.out.println("BIJOY Bijoy Bijoy ");

	             
	             
	             try (Statement tue = conn.createStatement() ) {
		             String search = "Select * from subject_table";
		           //  System.out.println("Test 1 ");
		             ResultSet out = tue.executeQuery(search);
		          //   System.out.println("Test 2 ");

		             int con=0;
		             while(out.next()){
		            	
			         //    System.out.println("Test 3 ");

			            // System.out.println("Test 4 ");

		            	 String  subject_name; 
		                 String subjectId1,teacher1,teacher2,teacher3;
		                 subjectId1 = out.getString("SubjectID");
		                 subject_name = out.getString("SubjectName");
		                 teacher1 = out.getString("TeacherID1");
		                 teacher2 = out.getString("TeacherID2");
		                 teacher3 = out.getString("TeacherID3");
		                 
		                 String Day="";
		                 int x=1;
		                 for(x=1;x<=5;x++) {
		                 	 
		                                 	 
		                 	if(x==1) {
		                 		Day ="Tuesday";
		                 		
		                 	}
		                 	else if(x==2) {
		                 		Day ="Wednesday";
		                 		
		                 	}
		                 	else if(x==3) {
		                 		Day ="Thursday";
		                 	}
		                 	else  if(x==4) {
		                 		Day ="Friday";
		                 	}
		                 	else if(x==5) {
		                 		Day ="Saturday";
		                 	}
		                  


		                 
			           //  System.out.println("Test 5 ");

		                 
		              //   System.out.println("Bijoy Bijoy Bijoy");

		                 
		                 System.out.println(""+subject_name);
		                 
		                 System.out.println(""+teacher1);

		                 System.out.println(""+teacher2);
		                 System.out.println(""+teacher3);
		                 
/*----------------------------------------------------------------------------- Teacher ID 1 -----------------------------------------------------*/		                 

try{
if(teacher1==null) {

// 

}

else if(teacher1!=null) {
	
	

	 String Time ="9:00";
	// String Day="Tuesday";
	 //String Teacher ="";
	 String Type = "Theroy";
	 String Lab ="";
	// int x;
//
System.out.println(" Techer 2 not null bijoy ");

PreparedStatement stor2 = conn.prepareStatement("SELECT * FROM  routinetable WHERE Subject =? and Day=?  and Teacher1 =? and Time=?");
stor2.setString(1,subject_name);//1st value into UserID 
stor2.setString(2,Day);

stor2.setString(3,teacher1);

stor2.setString(4,Time);

ResultSet rs1 = stor2.executeQuery();
if(rs1.next()) {
System.out.println("Subject is avabilale in routine  Table........ "); 
}
else {
 
 
 
 System.out.println("Subject is avabilale not routine  Table........!! "); 
 

 
 String[] arts1 = {"English","Education","History","Music","Geography"};
   String[] commerce1 = {"Business", "Income Tax","Corporate Law","Economics","Auditing"};
  String[] science1 = {"Physics", "Chemistry","Mathematics","Biology","Computer"};

//  System.out.println();     // Which stream according to Subjects 
  String stm1="";
  
  for (int i = 0; i < 5; i++) {
       if (subject_name.equals(arts1[i])) {
          System.out.println("Arts");
         stm1="Arts";
           break;
       } else if (subject_name.equals(commerce1[i])) {
           System.out.println("Commerce");
           stm1="commerce";
           		
           break;
       } else if (subject_name.equals(science1[i])) {
           System.out.println("Science");
           stm1="Science";
           
           break;
       }
   }
 
 
	 if (subject_name.equalsIgnoreCase("English")) {
		 Lab="1";
		 
     // System.out.println("Lab number 1");
  } else if (subject_name.equalsIgnoreCase("History")) {
		 Lab="2";
     // System.out.println("Lab number 2");
  }
  
  else if (subject_name.equalsIgnoreCase("Music")) {
		 Lab="3";

      System.out.println("Lab number 3");
  }
	 
  else if (subject_name.equalsIgnoreCase("Geography")) {
		 Lab="4";
  }
  else if (subject_name.equalsIgnoreCase("Education")) {
		 Lab="5";
  }
  else if (subject_name.equalsIgnoreCase("Auditing")) {
		 Lab="6";
  }
  else if (subject_name.equalsIgnoreCase("Economics")) {
		 Lab="7";
  }
  else if (subject_name.equalsIgnoreCase("Corporate Law")) {
		 Lab="8";
  }
  else if (subject_name.equalsIgnoreCase("Income Tax")) {
		 Lab="9";
  }
  else if (subject_name.equalsIgnoreCase("Business")) {
		 Lab="10";
  }
  else if (subject_name.equalsIgnoreCase("Mathematics")) {
		 Lab="11";
  }
  else if (subject_name.equalsIgnoreCase("Physics")) {
		 Lab="12";
  }
  else if (subject_name.equalsIgnoreCase("Chemistry")) {
		 Lab="13";
  }
	 
  else if (subject_name.equalsIgnoreCase("Biology")) {
 	 Lab="14";
  }
  else if (subject_name.equalsIgnoreCase("Computer")) {
      Lab="15";
  } else {
      System.out.println("Lab number not assigned");
  }

 PreparedStatement add = conn.prepareStatement("insert into  routinetable(Stream,Subject,Day,Time,Teacher1,Room,Type) values(?,?,?,?,?,?,?)");
 
//   String Type = "Lab";

 System.out.println(""+subject_name);
 
 System.out.println(""+teacher1);

//System.out.println(""+teacher2);

  
 //  String Stream =stm;
      add.setString(1,stm1);
      add.setString(2,subject_name);
      add.setString(3,Day);
      add.setString(4,Time); 
      add.setString(5,teacher1);
     //add.setString(6,teacher2);
      add.setString(6,Lab);	//room   		  
    // lau.setString(8,"Group1");
      add.setString(7,Type);

  int cc=   add.executeUpdate();
 if(cc>0) {

   	 PrintWriter pn = response.getWriter();
			 pn.print("Update Sucessful Teacher2!! ");  
 }
 
 else {
	  System.out.println("Tacher 2 Not Add ");
 }
 
}

}
else {

//  System.out.println("Please Add Bijoy ***! ");

}
}
catch(Exception e) {

}
		  
/*----------------------------------------------------------------------------- Teacher ID 1 -----------------------------------------------------*/


/*----------------------------------------------------------------------------- Teacher ID 2 -----------------------------------------------------*/	                 
		                 

try{
if(teacher2==null) {

// 

}

else if(teacher2!=null) {
	
	

	 String Time ="11:00";
//	 String Day="Tuesday";
	 //String Teacher ="";
	 String Type = "Theroy";
	 String Lab ="";
	// int x;
//
System.out.println(" Techer 2 not null bijoy ");

PreparedStatement stor2 = conn.prepareStatement("SELECT * FROM  routinetable WHERE Subject =? and Day=?  and Teacher2 =? and Time=?");
stor2.setString(1,subject_name);//1st value into UserID 
stor2.setString(2,Day);

stor2.setString(3,teacher2);

stor2.setString(4,Time);

ResultSet rs1 = stor2.executeQuery();
if(rs1.next()) {
System.out.println("Subject is avabilale in routine  Table........ "); 
}
else {
 
 
 
 System.out.println("Subject is avabilale not routine  Table........!! "); 
 

 
 String[] arts1 = {"English","Education","History","Music","Geography"};
   String[] commerce1 = {"Business", "Income Tax","Corporate Law","Economics","Auditing"};
  String[] science1 = {"Physics", "Chemistry","Mathematics","Biology","Computer"};

//  System.out.println();     // Which stream according to Subjects 
  String stm1="";
  
  for (int i = 0; i < 5; i++) {
       if (subject_name.equals(arts1[i])) {
          System.out.println("Arts");
         stm1="Arts";
           break;
       } else if (subject_name.equals(commerce1[i])) {
           System.out.println("Commerce");
           stm1="commerce";
           		
           break;
       } else if (subject_name.equals(science1[i])) {
           System.out.println("Science");
           stm1="Science";
           
           break;
       }
   }
 
 
	 if (subject_name.equalsIgnoreCase("English")) {
		 Lab="1";
		 
     // System.out.println("Lab number 1");
  } else if (subject_name.equalsIgnoreCase("History")) {
		 Lab="2";
     // System.out.println("Lab number 2");
  }
  
  else if (subject_name.equalsIgnoreCase("Music")) {
		 Lab="3";

      System.out.println("Lab number 3");
  }
	 
  else if (subject_name.equalsIgnoreCase("Geography")) {
		 Lab="4";
  }
  else if (subject_name.equalsIgnoreCase("Education")) {
		 Lab="5";
  }
  else if (subject_name.equalsIgnoreCase("Auditing")) {
		 Lab="6";
  }
  else if (subject_name.equalsIgnoreCase("Economics")) {
		 Lab="7";
  }
  else if (subject_name.equalsIgnoreCase("Corporate Law")) {
		 Lab="8";
  }
  else if (subject_name.equalsIgnoreCase("Income Tax")) {
		 Lab="9";
  }
  else if (subject_name.equalsIgnoreCase("Business")) {
		 Lab="10";
  }
  else if (subject_name.equalsIgnoreCase("Mathematics")) {
		 Lab="11";
  }
  else if (subject_name.equalsIgnoreCase("Physics")) {
		 Lab="12";
  }
  else if (subject_name.equalsIgnoreCase("Chemistry")) {
		 Lab="13";
  }
	 
  else if (subject_name.equalsIgnoreCase("Biology")) {
 	 Lab="14";
  }
  else if (subject_name.equalsIgnoreCase("Computer")) {
      Lab="15";
  } else {
      System.out.println("Lab number not assigned");
  }

 PreparedStatement add = conn.prepareStatement("insert into  routinetable(Stream,Subject,Day,Time,Teacher2,Room,Type) values(?,?,?,?,?,?,?)");
 
//   String Type = "Lab";

 System.out.println(""+subject_name);
 
 System.out.println(""+teacher1);

//System.out.println(""+teacher2);

  
 //  String Stream =stm;
      add.setString(1,stm1);
      add.setString(2,subject_name);
      add.setString(3,Day);
      add.setString(4,Time); 
      add.setString(5,teacher2);
     //add.setString(6,teacher2);
      add.setString(6,Lab);	//room   		  
    // lau.setString(8,"Group1");
      add.setString(7,Type);

  int cc=   add.executeUpdate();
 if(cc>0) {

   	 PrintWriter pn = response.getWriter();
			 pn.print("Update Sucessful Teacher2!! ");  
 }
 
 else {
	  System.out.println("Tacher 2 Not Add ");
 }
 
}

}
else {

//  System.out.println("Please Add Bijoy ***! ");

}
}
catch(Exception e) {

}


/* -----------------------------------------------------------------------Teacher Id 2 --------------------------------------------------------------*/

/* -----------------------------------------------------------------------Teacher Id 3 --------------------------------------------------------------*/




try{
if(teacher3==null) {

// 

}

else if(teacher3!=null) {
	
	

	 String Time ="1:00";
	// String Day="Tuesday";
	 //String Teacher ="";
	 String Type = "Theroy";
	 String Lab ="";
	// int x;
//
System.out.println(" Techer 2 not null bijoy ");

PreparedStatement stor2 = conn.prepareStatement("SELECT * FROM  routinetable WHERE Subject =? and Day=?  and Teacher3 =? and Time=?");
stor2.setString(1,subject_name);//1st value into UserID 
stor2.setString(2,Day);

stor2.setString(3,teacher3);

stor2.setString(4,Time);

ResultSet rs1 = stor2.executeQuery();
if(rs1.next()) {
System.out.println("Subject is avabilale in routine  Table........ "); 
}
else {
 
 
 
 System.out.println("Subject is avabilale not routine  Table........!! "); 
 

 
 String[] arts1 = {"English","Education","History","Music","Geography"};
   String[] commerce1 = {"Business", "Income Tax","Corporate Law","Economics","Auditing"};
  String[] science1 = {"Physics", "Chemistry","Mathematics","Biology","Computer"};

//  System.out.println();     // Which stream according to Subjects 
  String stm1="";
  
  for (int i = 0; i < 5; i++) {
       if (subject_name.equals(arts1[i])) {
          System.out.println("Arts");
         stm1="Arts";
           break;
       } else if (subject_name.equals(commerce1[i])) {
           System.out.println("Commerce");
           stm1="commerce";
           		
           break;
       } else if (subject_name.equals(science1[i])) {
           System.out.println("Science");
           stm1="Science";
           
           break;
       }
   }
 
 
	 if (subject_name.equalsIgnoreCase("English")) {
		 Lab="1";
		 
     // System.out.println("Lab number 1");
  } else if (subject_name.equalsIgnoreCase("History")) {
		 Lab="2";
     // System.out.println("Lab number 2");
  }
  
  else if (subject_name.equalsIgnoreCase("Music")) {
		 Lab="3";

      System.out.println("Lab number 3");
  }
	 
  else if (subject_name.equalsIgnoreCase("Geography")) {
		 Lab="4";
  }
  else if (subject_name.equalsIgnoreCase("Education")) {
		 Lab="5";
  }
  else if (subject_name.equalsIgnoreCase("Auditing")) {
		 Lab="6";
  }
  else if (subject_name.equalsIgnoreCase("Economics")) {
		 Lab="7";
  }
  else if (subject_name.equalsIgnoreCase("Corporate Law")) {
		 Lab="8";
  }
  else if (subject_name.equalsIgnoreCase("Income Tax")) {
		 Lab="9";
  }
  else if (subject_name.equalsIgnoreCase("Business")) {
		 Lab="10";
  }
  else if (subject_name.equalsIgnoreCase("Mathematics")) {
		 Lab="11";
  }
  else if (subject_name.equalsIgnoreCase("Physics")) {
		 Lab="12";
  }
  else if (subject_name.equalsIgnoreCase("Chemistry")) {
		 Lab="13";
  }
	 
  else if (subject_name.equalsIgnoreCase("Biology")) {
 	 Lab="14";
  }
  else if (subject_name.equalsIgnoreCase("Computer")) {
      Lab="15";
  } else {
      System.out.println("Lab number not assigned");
  }

 PreparedStatement add = conn.prepareStatement("insert into  routinetable(Stream,Subject,Day,Time,Teacher3,Room,Type) values(?,?,?,?,?,?,?)");
 
//   String Type = "Lab";

 System.out.println(""+subject_name);
 
 System.out.println(""+teacher1);

//System.out.println(""+teacher2);

  
 //  String Stream =stm;
      add.setString(1,stm1);
      add.setString(2,subject_name);
      add.setString(3,Day);
      add.setString(4,Time); 
      add.setString(5,teacher3);
     //add.setString(6,teacher2);
      add.setString(6,Lab);	//room   		  
    // lau.setString(8,"Group1");
      add.setString(7,Type);

  int cc=   add.executeUpdate();
 if(cc>0) {

   	 PrintWriter pn = response.getWriter();
			 pn.print("Update Sucessful Teacher3!! ");  
 }
 
 else {
	  System.out.println("Tacher 2 Not Add ");
 }
 
}

}

}
catch(Exception e) {

}




// work 1
/* -----------------------------------------------------------------------Teacher Id 3 --------------------------------------------------------------*/
   

/*                         Lab 3:00             tue wed                */

//check error 
System.out.println("Working .............................!!!!!! *********** ");

/*                                                                                   */





try (Statement jio = conn.createStatement() ) {
    
String sub3 = "Select * from subject_table";

ResultSet ou = jio.executeQuery(sub3);


while(ou.next()){ // it is run while info have in databases  one by one
    String  T1,T2,Sub; // all data come in string format like int vrchar, 
Sub = ou.getString("SubjectName");
 T1 = ou.getString("TeacherID1");
T2 = ou.getString("TeacherID2");
//  System.out.println("Subject "+Sub);
// System.out.println("Teacher2 : "+T2);
// System.out.println("Teacher3: "+T3);

if(T1==null) {
	//
}
else if(T1!=null&&T2!=null) {
	

	 PreparedStatement wow = conn.prepareStatement("SELECT * FROM  	routinetable 	 WHERE Subject =? and Day =? and Time =? and Teacher1=? and Teacher2 =?");
	// String day1="Monday";
	 
	 
	 String time1="2:00";
        wow.setString(1,Sub);
        wow.setString(2,Day);
        wow.setString(3,time1); 
        wow.setString(4,T1);
        wow.setString(5,T2);
       // neo.setString(5,Teacher2);
 
		 ResultSet	 yo= wow.executeQuery();
         
	//	 System.out.println("Test 3");
         
         if(yo.next()) { //2
        //	 System.out.println("Value is avabiable");    			    			
         }
         else  {   
        	 
        	 
        	  String[] arts1 = {"English","Education","History","Music","Geography"};
    	        String[] commerce1 = {"Business", "Income Tax","Corporate Law","Economics","Auditing"};
    	       String[] science1 = {"Physics", "Chemistry","Mathematics","Biology","Computer"};
    	    
    	     //  System.out.println();     // Which stream according to Subjects 
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
             
  
     //   	 System.out.println(stm1 + " " + Sub + " " + day1 + " " + time1 + " " + T2 + " " + T3);
        	    
    	     PreparedStatement lau = conn.prepareStatement("insert into  routinetable(Stream,Subject,Day,Time,Teacher1,Teacher2,Type,LabNo) values(?,?,?,?,?,?,?,?)");

       // String	 T1 ="";
        String Type2 ="Lab";
    	       lau.setString(1,stm1);
    	       lau.setString(2,Sub);
    	       lau.setString(3,Day);
    	       lau.setString(4,time1);
    	       lau.setString(5,T1);
    	       lau.setString(6,T2);
    	      // labu.setString(7,T3);
    	       lau.setString(7,Type2);	   		  
	         // lau.setString(8,"Group1");
    	       lau.setString(8,Lab3);
    	     int occ=  lau.executeUpdate();    
            //  System.out.println("oc : "+oc);
    	      /* if(oc>0) {
    	    	   System.out.println("Execute Update Successful !!");   
    	       }
    	       else {
    	    	   System.out.println("Execute Update Not Successful !!");   

    	       }*/
    	   
        //	 System.out.println("Please Insert Time 3:00      Monday        Here Yoooooooooo ");
        	//break; 
      
     } 
}

} // While Loop 
} // Try{}
catch(Exception e)
{
System.out.println(""+e);	

}	





























































    /*                                                            */







try (Statement lab = conn.createStatement() ) {
    
String sub3 = "Select * from subject_table";

ResultSet sujit = lab.executeQuery(sub3);


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
	 String day1="Monday";
	 
	 
	 String time1="3:00";
        jio.setString(1,Sub);
        jio.setString(2,Day);
        jio.setString(3,time1); 
        jio.setString(4,T2);
        jio.setString(5,T3);
       // neo.setString(5,Teacher2);
 
		 ResultSet	 ou= jio.executeQuery();
         
	//	 System.out.println("Test 3");
         
         if(ou.next()) { //2
        //	 System.out.println("Value is avabiable");    			    			
         }
         else  {   
        	 
        	 
        	  String[] arts1 = {"English","Education","History","Music","Geography"};
    	        String[] commerce1 = {"Business", "Income Tax","Corporate Law","Economics","Auditing"};
    	       String[] science1 = {"Physics", "Chemistry","Mathematics","Biology","Computer"};
    	    
    	     //  System.out.println();     // Which stream according to Subjects 
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
             
  
     //   	 System.out.println(stm1 + " " + Sub + " " + day1 + " " + time1 + " " + T2 + " " + T3);
        	    
    	     PreparedStatement labu = conn.prepareStatement("insert into  routinetable(Stream,Subject,Day,Time,Teacher1,Teacher2,Teacher3,Type,LabNo) values(?,?,?,?,?,?,?,?,?)");

        String	 T1 ="";
        String Type2 ="Lab";
    	       labu.setString(1,stm1);
    	       labu.setString(2,Sub);
    	       labu.setString(3,Day);
    	       labu.setString(4,time1);
    	       labu.setString(5,T1);
    	       labu.setString(6,T2);
    	       labu.setString(7,T3);
    	       labu.setString(8,Type2);	   		  
	         // lau.setString(8,"Group1");
    	       labu.setString(9,Lab3);
    	     int oc=  labu.executeUpdate();    
            //  System.out.println("oc : "+oc);
    	      /* if(oc>0) {
    	    	   System.out.println("Execute Update Successful !!");   
    	       }
    	       else {
    	    	   System.out.println("Execute Update Not Successful !!");   

    	       }*/
    	   
        //	 System.out.println("Please Insert Time 3:00      Monday        Here Yoooooooooo ");
        	//break; 
      
     } 
}

} // While Loop 
} // Try{}
catch(Exception e)
{
System.out.println(""+e);	

}	                 
/* lab 4:00 pm */ 



try (Statement four = conn.createStatement() ) {
    
String sub31 = "Select * from subject_table";

ResultSet woo = four.executeQuery(sub31);


while(woo.next()){ // it is run while info have in databases  one by one
    String  T1,T3,Sub; // all data come in string format like int vrchar, 
Sub = woo.getString("SubjectName");
 T1 = woo.getString("TeacherID1");
T3 = woo.getString("TeacherID3");
//  System.out.println("Subject "+Sub);
// System.out.println("Teacher2 : "+T2);
// System.out.println("Teacher3: "+T3);

if(T1==null&&T3==null) {
	//
}
else if(T1!=null&&T3!=null) {
	

	 PreparedStatement jio1 = conn.prepareStatement("SELECT * FROM  	routinetable 	 WHERE Subject =? and Day =? and Time =? and Teacher1=? and Teacher3 =?");
	 String day1="Monday";
	 
	 
	 String time1="4:00";
        jio1.setString(1,Sub);
        jio1.setString(2,Day);
        jio1.setString(3,time1); 
        jio1.setString(4,T1);
        jio1.setString(5,T3);
       // neo.setString(5,Teacher2);
 
		 ResultSet	 fup= jio1.executeQuery();
         
	//	 System.out.println("Test 3");
         
         if(fup.next()) { //2
        //	 System.out.println("Value is avabiable");    			    			
         }
         else  {   
        	 
        	 
        	  String[] arts1 = {"English","Education","History","Music","Geography"};
    	        String[] commerce1 = {"Business", "Income Tax","Corporate Law","Economics","Auditing"};
    	       String[] science1 = {"Physics", "Chemistry","Mathematics","Biology","Computer"};
    	    
    	     //  System.out.println();     // Which stream according to Subjects 
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
             
  
     //   	 System.out.println(stm1 + " " + Sub + " " + day1 + " " + time1 + " " + T2 + " " + T3);
        	    
    	     PreparedStatement labu1 = conn.prepareStatement("insert into  routinetable(Stream,Subject,Day,Time,Teacher1,Teacher2,Teacher3,Type,LabNo) values(?,?,?,?,?,?,?,?,?)");

      String	 T2 ="";
        String Type2 ="Lab";
    	       labu1.setString(1,stm1);
    	       labu1.setString(2,Sub);
    	       labu1.setString(3,Day);
    	       labu1.setString(4,time1);
    	       labu1.setString(5,T1);
    	       labu1.setString(6,T2);
    	       labu1.setString(7,T3);
    	       labu1.setString(8,Type2);	   		  
	         // lau.setString(8,"Group1");
    	       labu1.setString(9,Lab3);
    	     int oc1=  labu1.executeUpdate();    
            //  System.out.println("oc : "+oc);
    	      /* if(oc>0) {
    	    	   System.out.println("Execute Update Successful !!");   
    	       }
    	       else {
    	    	   System.out.println("Execute Update Not Successful !!");   

    	       }*/
    	   
        //	 System.out.println("Please Insert Time 3:00      Monday        Here Yoooooooooo ");
        	//break; 
      
     } 
}

} // While Loop 
}

/* lab 4:00 */



} // For loop 



/* -------------------------------------------------------------- Lab Tuesday add ------------------------------------- */


		               }// // While{}
		                 
 } // Try{}
		             
	             catch(Exception e)
					{
					System.out.println(""+e);	
					
					}	                 
		             
	             
	             
		            // } // Try{} 
	         //    catch(Exception e)
				//	{
				//	System.out.println(""+e);	
					
				//	}
		
	             
	/* Teacher Id2                          */             
      
	      /* Teacher Id2 */       

			 }//  (public class routine extends HttpServlet)------->{doGet(request, response);}-----> [1st Try] ------> [2nd Try]			 
			 catch(Exception e)
				{
				System.out.println(""+e);	
				
				} //(public class routine extends HttpServlet)------->{doGet(request, response);}-----> [1st Try] ------> [2nd Try]------>catch(Exception e)
			 
 
		/* Out put */  
			 
			 
		
			 
			 System.out.println("Filnal output Bijoy !!!!!!!-----------------");
			 
			 
			 try  {
				// String subject1 = request.getParameter("Stream");
              //  String strm123;
				 response.setContentType("text/html");
			       
	            // String re = "Select * from routinetable";
	             
	          /*   String re=    "SELECT r.Stream, r.Subject, r.Day, r.Time, " +
                         "(SELECT TeacherName FROM teachertable WHERE TeacherID = r.teacher1) AS Teacher1, " +
                         "(SELECT TeacherName FROM teachertable WHERE TeacherID = r.teacher2) AS Teacher2, " +
                         "(SELECT TeacherName FROM teachertable WHERE TeacherID = r.teacher3) AS Teacher3, " +
                         "r.Room, r.Type, r.GroupN, r.LabNo " +
                       //  "FROM routinetable r";
	            		 "FROM routinetable r WHERE r.Stream = ?"; */
	             
	             
	             
	             
	             String re ="SELECT r.Stream, r.Subject, r.Day, r.Time, " +
                         "(SELECT TeacherName FROM teachertable WHERE TeacherID = r.teacher1) AS Teacher1, " +
                         "(SELECT TeacherName FROM teachertable WHERE TeacherID = r.teacher2) AS Teacher2, " +
                         "(SELECT TeacherName FROM teachertable WHERE TeacherID = r.teacher3) AS Teacher3, " +
                         "r.Room, r.Type, r.GroupN, r.LabNo " +
                         "FROM routinetable r WHERE r.Stream = ?";
	             		
	             
	             
	             PreparedStatement statement = conn.prepareStatement(re);
	             
	             statement.setString(1,strm123); // Set the selected stream
	             ResultSet show = statement.executeQuery();
	             
	             
	            //  view.setString(1,strm123); // Set the selected stream
	             
	             
	             
	          //   ResultSet show = view.executeQuery(re);
	             
	       
	             
	             PrintWriter out = response.getWriter();
out.println("<table border='1'>");
out.println("<tr><th>Stream</th><th>Subject</th><th>Day</th><th>Time</th><th>Teacher1</th><th>Teacher2</th><th>Teacher3</th><th>Room</th><th>Type</th><th>GroupN</th><th>LabNo</th></tr>");

	           //  int count=0;
	             while(show.next()){ // it is run while info have in databases  one by one
	                 String  subject_name; /* all data come in string format like int vrchar, */

	                 String Stream,teacher1,teacher2,teacher3,Subject,Day1,Time,Room,Type,GroupN,LabNo;
	                 Stream = show.getString("Stream");
	                 Subject = show.getString("Subject");
	                 Day1 = show.getString("Day");
	                 Time = show.getString("Time");
	                 teacher1 = show.getString("Teacher1");
	                 teacher2 = show.getString("Teacher2");
	                 teacher3 = show.getString("Teacher3"); 
	                 Room = show.getString("Room"); 

	                 Type = show.getString("Type"); 
	                 GroupN = show.getString("GroupN");
	                 LabNo = show.getString("LabNo");
/*  

	                 System.out.println(""+Stream);
	                 System.out.println(""+Subject);
	                 System.out.println(""+Day1);
	                 System.out.println(""+Time);
	                 System.out.println(""+teacher1);
	                 System.out.println(""+teacher2);
	                 System.out.println(""+teacher3);
	                 System.out.println(""+Type);
	                 System.out.println(""+GroupN);
	                 System.out.println(""+LabNo);
	                 System.out.println("OK Bijoy ");
*/
	                 
	               
	                 
	                 
	                 

	                 out.println("<tr>");
	                 out.println("<td>" + show.getString("Stream") + "</td>");
	                 out.println("<td>" + show.getString("Subject") + "</td>");
	                 out.println("<td>" + show.getString("Day") + "</td>");
	                 out.println("<td>" + show.getString("Time") + "</td>");
	                 out.println("<td>" + show.getString("teacher1") + "</td>");
	                 out.println("<td>" + show.getString("teacher2") + "</td>");
	                 out.println("<td>" + show.getString("teacher3") + "</td>");
	                 out.println("<td>" + show.getString("Room") + "</td>");

	                 out.println("<td>" + show.getString("Type") + "</td>");
	                 out.println("<td>" + show.getString("GroupN") + "</td>");
	                 out.println("<td>" + show.getString("LabNo") + "</td>");
	                 out.println("</tr>");

	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                /* 
	                 
	                 out.println("<tr>");
	                 out.println("<td>" + show.getString("Stream") + "</td>");
	                 out.println("<td>" + show.getString("Subject") + "</td>");
	                 out.println("<td>" + show.getString("Day") + "</td>");
	                 out.println("<td>" + show.getString("Time") + "</td>");
	                 out.println("<td>" + (show.getString("Teacher1Name") != null ? show.getString("Teacher1Name") : "N/A") + "</td>");
	                 out.println("<td>" + (show.getString("Teacher2Name") != null ? show.getString("Teacher2Name") : "N/A") + "</td>");
	                 out.println("<td>" + (show.getString("Teacher3Name") != null ? show.getString("Teacher3Name") : "N/A") + "</td>");
	                 out.println("<td>" + show.getString("Room") + "</td>");
	                 out.println("<td>" + show.getString("Type") + "</td>");
	                 out.println("<td>" + show.getString("Group") + "</td>");
	                 out.println("<td>" + show.getString("LabNo") + "</td>");
	                 out.println("</tr>");
	                 
	                 */
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	                 
	             }
	             
	             
	             out.println("</table>");
			 }
			 catch (Exception e)
				{
				System.out.println(""+e);		
				}
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 /* Output */ 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
		} // (public class routine extends HttpServlet)------->{doGet(request, response);}--------> [1st Try] 
		
		
		catch (Exception e)
		{
		System.out.println(""+e);		
		}// (public class routine extends HttpServlet)------->{doGet(request, response);}--------> [1st Try] -------> (( catch (Exception e))

		
	}//doGet(request, response);

}// public class routine extends HttpServlet 

