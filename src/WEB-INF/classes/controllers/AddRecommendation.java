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

@WebServlet("/AddRecommendation")
public class AddRecommendation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRecommendation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Recommendation> recommendations = Collections.emptyList();
		
		Recommendation recommendation = new Recommendation();
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		try {
			if (session != null || user != null) {
				BeanUtils.populate(recommendation, request.getParameterMap());
				//System.out.println(event.getName());
				//System.out.println(event.getLocation());
				//System.out.println(event.getInfo());
				//System.out.println(event.getCountryId());
				//System.out.println(event.getDate());
				ManageRecommendations managerecommendations = new ManageRecommendations();
				recommendations = managerecommendations.getRecommendations();
				managerecommendations.addRecommendation(recommendation, user.getUser());
				managerecommendations.finalize();
			}
		}
		catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("user",user);
		request.setAttribute("recommendations",recommendations);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewAddRecommendation.jsp"); 
		dispatcher.include(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
