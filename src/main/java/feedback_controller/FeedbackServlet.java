package feedback_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fd_bo.Feed_bo;
import feedback_Dao.JDBC_Opration;

/**
 * Servlet implementation class FeedbackServlet
 */
@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	PrintWriter pw=response.getWriter();
    	
    	String username = request.getParameter("username");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String feedback = request.getParameter("feedback");
     //   JDBC_Opration.storeFeedback(username, rating, feedback);
      //  response.sendRedirect("success.html");
   
        Feed_bo fb=new Feed_bo(username, rating, feedback);
    	
        int status = JDBC_Opration.storeFeedback(fb);
        
        if(status>0) {
        	
        	pw.print("Thank You For Feedback");
        	response.sendRedirect("home.html");
        }else {
        	
        	pw.print("Error !");
        	
        	response.sendRedirect("feedbackform.html");
        }
   
    
    }

    	
		
	
}
