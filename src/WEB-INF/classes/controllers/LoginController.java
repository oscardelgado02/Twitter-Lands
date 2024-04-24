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
import models.Login;
import models.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.print("LoginController: ");
		
		List<Country> countries = Collections.emptyList();
		
		Login login = new Login();
		ManageUsers manager = new ManageUsers();
		User user = new User();
		
	    try {
			
	    	BeanUtils.populate(login, request.getParameterMap());
			
	    	if (login.isComplete() && manager.existLogin(login)) {
		    	
	    		System.out.println("login OK, forwarding to ViewLoginDone ");
		    	HttpSession session = request.getSession();
		    	
		    	ManageCountry countryManager = new ManageCountry();
		    	
		    	user = manager.getUser(login.getUser());
		    	countries = countryManager.getFollowedCountries(user.getUser());
		    	session.setAttribute("user",user);
		    	session.setAttribute("username",user.getUser());
		    	session.setAttribute("selected_tl","tl");
		    	session.setAttribute("f_countries",countries);
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("ViewLoginDone.jsp");
			    dispatcher.forward(request, response);
			    
		    } 
			else {
		     
				System.out.println("user is not logged, forwarding to ViewLoginForm ");
			    request.setAttribute("login",login);
			    RequestDispatcher dispatcher = request.getRequestDispatcher("ViewLoginForm.jsp");
			    dispatcher.forward(request, response);
		    	
		    }
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	    
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

