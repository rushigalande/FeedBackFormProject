package feedback_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fd_bo.Feed_bo;
import feedback_Dao.JDBC_Opration;

/**
 * Servlet implementation class ShowFeedbackServletWeb
 */
@WebServlet("/ShowFeedbackServletWeb")
public class ShowFeedbackServletWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFeedbackServletWeb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 List<Feed_bo> feed = JDBC_Opration.retrieveFeedback();
		    response.setContentType("text/html");
		    StringBuilder sb = new StringBuilder();
		    sb.append("<html>");
		    sb.append("<head>");
		    sb.append("<meta charset='UTF-8'>");
		    sb.append("<title>Show Feedback</title>");
		    sb.append("<link rel='stylesheet' type='text/css' href='./css/table.css'>");
		    sb.append("</head>");
		    sb.append("<body>");
		    sb.append("<a href='home.html' class='back-button'>Back</a>");
		    sb.append("<h1>Feedback</h1>");
		    sb.append("<table border='1px' width='100%'> ");
		    sb.append("<tr>");
		    sb.append("<th>ID</th>");
		    sb.append("<th>Username</th>");
		    sb.append("<th>Rating</th>");
		    sb.append("<th>Feedback</th>");
		    sb.append("</tr>");
		    for (Feed_bo feedback :feed ) {
		      sb.append("<tr>");
		      sb.append("<td>" + feedback.getId() + "</td>");
		      sb.append("<td>" + feedback.getName() + "</td>");
		      sb.append("<td>" + feedback.getRating() + "</td>");
		      sb.append("<td>" + feedback.getFeedback() + "</td>");
		      sb.append("</tr>");
		    }
		    sb.append("</table>");
		    sb.append("</body>");
		    sb.append("</html>");
		    response.getWriter().println(sb.toString());
		  }
	}


