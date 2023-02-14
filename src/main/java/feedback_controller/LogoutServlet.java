package feedback_controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	//	request.getSession().invalidate();
		
	//	response.sendRedirect("index.html");
		
		// HttpSession session = request.getSession();
		//    session.invalidate();
		//    response.sendRedirect("index.html");
		
		    
		    response.setContentType("text/html");
			
			PrintWriter pw=response.getWriter();
			
			pw.print("Logout suscessfully");
			
			HttpSession hs=request.getSession();
			hs.invalidate();
			
			response.sendRedirect("index.html");
			
	}

}
