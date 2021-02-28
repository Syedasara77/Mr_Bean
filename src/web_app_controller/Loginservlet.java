package web_app_controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_app_model.DatabaseConnection;
import web_app_model.Login;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String)request.getParameter("Email");
		String password = (String)request.getParameter("Password");
		Login login=new Login();
		DatabaseConnection dbConnection=new DatabaseConnection();
		Connection con = dbConnection.establishConnection();
		boolean result = login.verifyLogin(email, password,con);
		HttpSession session = request.getSession(true);
		if(result==true) {
			session.setAttribute("emailid", email);
			RequestDispatcher rd1 = request.getRequestDispatcher("WEB-INF/views/Registration.jsp");
			rd1.forward(request, response);
			
		
		}else {
			request.setAttribute("errormsg", "Invalidusername/password");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		    rd.include(request, response);
		
		}
	}

}
