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

import managers.ManageCountry;
import managers.ManageTweets;
import models.Country;
import models.Tweet;
import models.User;

@WebServlet("/GetCountryTweets")
public class GetCountryTweets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCountryTweets() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		List<Tweet> tweets = Collections.emptyList();
		User user = (User) session.getAttribute("user");
		Country country = new Country();
		
		try {
			if (session != null || user != null) {
				BeanUtils.populate(country, request.getParameterMap());
				ManageCountry countryManager = new ManageCountry();
				if(country.getId()>0) {
					country = countryManager.getCountry(country.getId());
					session.setAttribute("selected_country",country);
				}
				countryManager.finalize();
				ManageTweets tweetManager = new ManageTweets();
				country = (Country) session.getAttribute("selected_country");
				tweets = tweetManager.getCountryTweets(user.getUser(), country.getId());
				tweetManager.finalize();
				session.setAttribute("selected_tl","tlc");
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("tweets",tweets);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewFollowerTweets.jsp"); 
		dispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}