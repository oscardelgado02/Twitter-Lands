package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import managers.ManageRecommendations;
import models.Recommendation;
import models.User;

@WebServlet("/GetUserRecommendationsByCountry")
public class GetUserRecommendationsByCountry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserRecommendationsByCountry() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		List<Recommendation> recommendations = Collections.emptyList();
		User user = (User) session.getAttribute("user");
		Recommendation recommendation = new Recommendation();
		
		try {
			if (session != null || user != null) {
				BeanUtils.populate(recommendation, request.getParameterMap());
				ManageRecommendations recommendationManager = new ManageRecommendations();
				if(recommendation.getId()>0) {
					recommendation = recommendationManager.getRecommendation(recommendation.getId());
					session.setAttribute("selected_recommendation",recommendation);
				}
				
				recommendation = (Recommendation) session.getAttribute("selected_recommendation");
				recommendations = recommendationManager.getUserRecommendationsByRecomId(recommendation.getId());
				recommendationManager.finalize();
				session.setAttribute("selected_tl","tlr");
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("recommendations",recommendations);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewUserRecommendationsByCountry.jsp"); 
		dispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}