package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import managers.ManageCountry;
import managers.ManageUsers;
import models.Country;
import models.User;

/**
 * Servlet implementation class GetUserInfo
 */
@WebServlet("/GetCountryInfo")
public class GetCountryInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCountryInfo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		Country selected_country = new Country();
		int followers = 0;
		
		try {
			if (session != null || user != null) {
				BeanUtils.populate(selected_country, request.getParameterMap());
				ManageUsers userManager = new ManageUsers();
				ManageCountry countryManager = new ManageCountry();
				
				if(selected_country.getId()>0) {
					selected_country = countryManager.getCountry(selected_country.getId());
					session.setAttribute("selected_country",selected_country);
				}
				
				selected_country = (Country) session.getAttribute("selected_country");
				user = userManager.getUser(user.getUser());
				followers = countryManager.getNumFollowers(selected_country.getId());
				userManager.finalize();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("user",user);
		request.setAttribute("followers",followers);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewCountryInfo.jsp"); 
		dispatcher.include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}