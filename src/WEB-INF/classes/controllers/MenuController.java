package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

/**
 * Servlet implementation class MenuController
 */
@WebServlet("/MenuController")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("MenuController: ");
		
		//List<Country> countries = Collections.emptyList();
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user!=null) {
		
			System.out.println("forwarding to ViewMenuLogged");
			//ManageCountry countryManager = new ManageCountry();
	    	//countries = countryManager.getFollowedCountries(user.getUser());
			session.setAttribute("selected_user",user);
	    	//session.setAttribute("f_countries",countries);
	    	//countryManager.finalize();
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewMenuLogged.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			System.out.println("forwarding to ViewMenuNotLogged ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewMenuNotLogged.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
