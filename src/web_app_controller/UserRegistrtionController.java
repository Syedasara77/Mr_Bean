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
import web_app_model.User;

/**
 * Servlet implementation class UserRegistrtionController
 */
@WebServlet("/UserRegistrationController")
public class UserRegistrtionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrtionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Registration.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("emailid")!=null) {
			String company = request.getParameter("company");
			String model = request.getParameter("model");
			String color = request.getParameter("color");
			String Dateofpurchase= request.getParameter("Dateofpurchase");
			String price = request.getParameter("price");
			String enginecapacity = request.getParameter("enginecapacity");
			String licenseplatenumber = request.getParameter("licenseplatenumber");
			String seatingcapacity = request.getParameter("seatingcapacity");
		DatabaseConnection db=new DatabaseConnection();
		Connection con = db.establishConnection();
		User user=new User();
		user.addRegistration(company, model, color, Dateofpurchase, price, enginecapacity, licenseplatenumber, seatingcapacity, con);
		request.setAttribute("MSG", "Data Saved");
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Registration.jsp");
		rd.forward(request, response);
		}	
	
	else {
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
}
}
