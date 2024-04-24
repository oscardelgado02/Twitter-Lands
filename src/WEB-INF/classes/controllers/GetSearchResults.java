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
import managers.ManageUsers;
import models.Country;
import models.User;
import models.SearchInput;

@WebServlet("/GetSearchResults")
public class GetSearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSearchResults() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> searched_users = Collections.emptyList();
		List<Country> searched_countries = Collections.emptyList();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		SearchInput search = new SearchInput();
		
		try {
			if (session != null || user != null) {
				BeanUtils.populate(search, request.getParameterMap());
				
				System.out.println(search.getInput());
				if(search.getStatus()>0) {
					session.setAttribute("search",search);
				}
				
				search = (SearchInput) session.getAttribute("search");
				
				ManageUsers userManager = new ManageUsers();
				ManageCountry countryManager = new ManageCountry();
				
				searched_users = userManager.searchUsers(search.getInput());
				searched_countries = countryManager.searchCountries(search.getInput());
				userManager.finalize();
				countryManager.finalize();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("search",search);
		request.setAttribute("searched_users",searched_users);
		request.setAttribute("searched_countries",searched_countries);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewSearchResults.jsp"); 
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