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

import managers.ManageUsers;
import models.User;

@WebServlet("/EditUserInfo")
public class EditUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	User user = new User();
		HttpSession session = request.getSession(false);
		user = (User) session.getAttribute("user");
		User new_user = new User();
		
			try {
				if (session != null || user != null) {
					BeanUtils.populate(new_user, request.getParameterMap());
					ManageUsers manageUsers = new ManageUsers();
					
					if(manageUsers.isValid(new_user)) {
						System.out.println(new_user.getUser());
						System.out.println(new_user.getMail());
						System.out.println(new_user.getPwd1());
						System.out.println(new_user.getDate());
						System.out.println(new_user.getGender());
						System.out.println(new_user.getCountry());
						manageUsers.editUser(new_user.getMail(), new_user.getPwd1(), new_user.getDate(), new_user.getGender(), new_user.getCountry(), new_user.getUser());
						user = manageUsers.getUser(user.getUser());
					}
					manageUsers.finalize();
				}
			}
			
			catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		session.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewEditUserInfo.jsp"); 
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