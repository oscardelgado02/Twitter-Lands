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

import managers.ManageRecommendations;
import models.Country;
import models.Recommendation;
import models.User;

@WebServlet("/GetCountryRecommendations")
public class GetCountryRecommendations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCountryRecommendations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Recommendation> recommendations = Collections.emptyList();
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Country country = (Country) session.getAttribute("selected_country");

		if (session != null || user != null) {
		
			ManageRecommendations recomManager = new ManageRecommendations();
			recommendations = recomManager.getCountryRecommendations(country.getId());
			recomManager.finalize();
		
		}
		
		request.setAttribute("recommendations",recommendations);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewCountryRecommendations.jsp"); 
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