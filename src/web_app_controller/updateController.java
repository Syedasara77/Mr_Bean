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
 * Servlet implementation class updateController
 */
@WebServlet("/updateController")
public class updateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String company= request.getParameter("company");
		String model = request.getParameter("model");
		String color = request.getParameter("color");
		String Dateofpurchase= request.getParameter("Dateofpurchase");
		String price = request.getParameter("price");
		String enginecapacity = request.getParameter("enginecapacity");
		String licenseplatenumber = request.getParameter("licenseplatenumber");
		String seatingcapacity = request.getParameter("seatingcapacity");
		request.setAttribute("company", company);
		request.setAttribute("model", model);
		request.setAttribute("color", color);
		request.setAttribute("Dateofpurchase", Dateofpurchase);
		request.setAttribute("price", price);
		request.setAttribute("enginecapacity", enginecapacity);
		request.setAttribute("licenseplatenumber", licenseplatenumber);
		request.setAttribute("seatingcapacity", seatingcapacity);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/updateReg.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String company= request.getParameter("company");
		String model = request.getParameter("model");
		String color = request.getParameter("color");
		String Dateofpurchase= request.getParameter("Dateofpurchase");
		String price = request.getParameter("price");
		String enginecapacity = request.getParameter("enginecapacity");
		String licenseplatenumber = request.getParameter("licenseplatenumber");
		String seatingcapacity = request.getParameter("seatingcapacity");
		HttpSession session = request.getSession();
		if(session.getAttribute("emailid")!=null) {
		try {
			DatabaseConnection db=new DatabaseConnection();
			Connection con=db.establishConnection();
			User user=new User();
			user.updateReg(model, color, Dateofpurchase, price, enginecapacity, licenseplatenumber, seatingcapacity, company, con);
			request.setAttribute("UpdateMsg","Record updated!!");
			ResultSet results = user.ShowRegistration(con);
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
}