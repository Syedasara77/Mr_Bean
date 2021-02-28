package web_app_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
 * Servlet implementation class Search
 */
@WebServlet("/search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		  PrintWriter out = response.getWriter();


		  String  model  = request.getParameter("model");
		  String  color  = request.getParameter("color");
		  String  Dateofpurchase  = request.getParameter("Dateofpurchase");
		  String  price = request.getParameter("price");
		  try {
          DatabaseConnection db=new DatabaseConnection();
          Connection con= db.establishConnection();
		  ArrayList<String> al=null;
		  ArrayList<ArrayList<String>> search =new ArrayList<ArrayList<String>>();
		  User user=new User();
		  ResultSet rs = user.search(model, color, Dateofpurchase, price, con);


		  while(rs.next()){
		  al  = new ArrayList<String>();
		  
		  al.add(rs.getString(1));
		  al.add(rs.getString(2));
		  al.add(rs.getString(3));
		  al.add(rs.getString(4));
		  al.add(rs.getString(5));
		  al.add(rs.getString(6));
		  al.add(rs.getString(7));
		  al.add(rs.getString(8));
		  System.out.println("al :: "+al);
		  search.add(al);
		  }

		  request.setAttribute("Search",search);
		  RequestDispatcher rs1 = request.getRequestDispatcher("WEB-INF/views/viewSearch.jsp");
		  rs1.forward(request, response);
		  } catch (Exception e) {
		  e.printStackTrace();
		  }
		  }


	}


