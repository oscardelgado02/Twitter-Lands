package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import managers.ManageUsers;
import models.User;

/**
 * Servlet implementation class FormController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   /*System.out.print("RegisterController: ");
		
	   try {
	
		   User user = new User();
		   BeanUtils.populate(user, request.getParameterMap());
		
		   if (user.isComplete()) {
			   
			   System.out.println(" user ok, forwarding to ViewLoginForm");
			   RequestDispatcher dispatcher = request.getRequestDispatcher("ViewLoginForm.jsp");
			   dispatcher.forward(request, response);
		   
		   } 
		   else {
		
			   System.out.println(" forwarding to ViewRegisterForm");
			   request.setAttribute("user",user);
			   RequestDispatcher dispatcher = request.getRequestDispatcher("ViewRegisterForm.jsp");
			   dispatcher.forward(request, response);
		   }
	   
	   } catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
	   }
	   
	   */
		User model = new User();
		
		String view = "ViewRegisterForm.jsp";
		try {
		   	BeanUtils.populate(model, request.getParameterMap());
			ManageUsers manager = new ManageUsers();
			
			if (manager.isComplete(model)) {
				manager.addUser(model.getUser(), model.getMail(), model.getPwd1(), model.getDate(), 
						model.getGender(), model.getCountry());
				manager.finalize();
				view = "ViewLoginForm.jsp";
			}else {
				view = "ViewRegisterForm.jsp";
			}
				
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}

		request.setAttribute("model", model);
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
