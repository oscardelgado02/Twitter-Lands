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
import models.User;

/**
 * Servlet implementation class GetUserInfo
 */
@WebServlet("/GetUserInfo")
public class GetUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserInfo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		User selected_user = new User();
		ManageCountry countryManager = new ManageCountry();
		int followers = 0;
		
		try {
			if (session != null || user != null) {
				BeanUtils.populate(selected_user, request.getParameterMap());
				ManageUsers userManager = new ManageUsers();
				
				if(!selected_user.getUser().equals("")) {
					selected_user = userManager.getUser(selected_user.getUser());
					session.setAttribute("selected_user",selected_user);
				}
				
				selected_user = (User) session.getAttribute("selected_user");
				System.out.println(selected_user.getUser());
				user = userManager.getUser(user.getUser());
				followers = userManager.getNumFollowers(selected_user.getUser());
				userManager.finalize();
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("user",user);
		request.setAttribute("country",countryManager.getCountry(user.getCountry()));
		request.setAttribute("followers",followers);
		countryManager.finalize();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewUserInfo.jsp"); 
		dispatcher.include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
