package feedback_Dao;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	public class Fd_Con {
		
			
		
		public static Connection getConnection()
		
		{  
		    Connection conn=null;  
		    try{  
		        Class.forName("com.mysql.jdbc.Driver"); 
		       // Class.forName("com.mysql.cj.jdbc.Driver"); 
		        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback_db","root","root");  
		        
		    } catch(Exception e){
		    	
		    	System.out.println(e);
		    	
		    }  
		    return conn;  
		}  
	}

