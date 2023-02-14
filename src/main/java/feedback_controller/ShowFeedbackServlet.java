package feedback_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import feedback_Dao.JDBC_Opration;

/**
 * Servlet implementation class ShowFeedbackServlet
 */
@WebServlet("/ShowFeedbackServlet")
public class ShowFeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFeedbackServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<FeedbackServlet> feedbacks = JDBC_Opration.retrieveFeedback();
        request.setAttribute("feedbacks", feedbacks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ShowFeedbackServletWeb");
        dispatcher.forward(request, response);
      }
}
