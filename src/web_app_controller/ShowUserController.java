package web_app_controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_app_model.DatabaseConnection;
import web_app_model.User;

/**
 * Servlet implementation class ShowUserController
 */
@WebServlet("/ShowUserRegistration")
public class ShowUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("emailid")!=null) {
		try {
			DatabaseConnection db=new DatabaseConnection();
			Connection con=db.establishConnection();
			User user=new User();
			ResultSet results=user.ShowRegistration(con);
			request.setAttribute("results", results);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/ShowUserRegistration.jsp");
			rd.forward(request,response);
			
		}catch(Exception e) {
		e.printStackTrace();	
		}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);	
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
