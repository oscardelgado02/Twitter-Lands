package controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managers.ManageCountry;
import models.Country;
import models.User;

@WebServlet("/GetFollowedCountries")
public class GetFollowedCountries extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFollowedCountries() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Country> countries = Collections.emptyList();
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		User selected_user = (User) session.getAttribute("selected_user");

		if (session != null || user != null) {
		
			ManageCountry countryManager = new ManageCountry();
			countries = countryManager.getFollowedCountries(selected_user.getUser());
			countryManager.finalize();
		
		}
		
		session.setAttribute("f_countries",countries);
		request.setAttribute("countries",countries);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewFollowedCountries.jsp"); 
		dispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}