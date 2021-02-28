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
 * Servlet implementation class deleteController
 */
@WebServlet("/deleteController")
public class deleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("emailid")!=null) {
		String company = request.getParameter("company");
		System.out.println(company);
		try {
			DatabaseConnection db=new DatabaseConnection();
			Connection con = db.establishConnection();
			User user=new User();
			user.deleteReg(company, con);
			ResultSet result = user.ShowRegistration(con);
			request.setAttribute("results", result);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/ShowUserRegistration.jsp");
			rd.forward(request,response);
		}catch(Exception e) {
			System.out.println(e);
		}
	}else {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
	}

}
