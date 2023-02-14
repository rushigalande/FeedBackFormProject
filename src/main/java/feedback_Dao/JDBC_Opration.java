package feedback_Dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fd_bo.Feed_bo;
import feedback_controller.FeedbackServlet;

	public class JDBC_Opration {
	  public static boolean authenticateAdmin(String username, String password) {
		  Connection con = null;
		  try {
		    con = Fd_Con.getConnection();
		    PreparedStatement stmt = con.prepareStatement("SELECT * FROM admin WHERE username=? AND password=?");
		    stmt.setString(1, username);
		    stmt.setString(2, password);
		    ResultSet rs = stmt.executeQuery();
		    if (rs.next()) {
		      return true;
		    } else {
		      return false;
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		    return false;
		  } finally {
		    if (con != null) {
		      try {
		        con.close();
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		    }
		  }
	  }
	  public static int storeFeedback(Feed_bo fb) {
	   
		int status=0;  
		  try {
			  
			  Connection con = Fd_Con.getConnection();
		      PreparedStatement stmt = con.prepareStatement("INSERT INTO feedback (username, rating, feedback) VALUES (?, ?, ?)");
		      stmt.setString(1, fb.getName());
		      stmt.setInt(2, fb.getRating());
		      stmt.setString(3, fb.getFeedback());
		      status = stmt.executeUpdate();
		      
			
		} catch (Exception e) {
			
		}
		  
		  return status;
	  }
	  
	  
	  public static List retrieveFeedback() {
		  
		  List<Feed_bo> Feed=new ArrayList<Feed_bo>();
		  try {
		  Connection con = Fd_Con.getConnection();
		  PreparedStatement stmt = con.prepareStatement("SELECT * FROM feedback");
		  ResultSet rs = stmt.executeQuery();
		
		  while (rs.next()) {
		  Feed_bo f = new Feed_bo();
		  
		  f.setId(rs.getInt(1));
		  f.setName(rs.getString(2));
		  f.setRating(rs.getInt(3));
		  f.setFeedback(rs.getString(4));
		  Feed.add(f);
		  }
		 
		  } catch (SQLException e) {
		  e.printStackTrace();
		  
		  }
		return Feed;
		  }




	  }


