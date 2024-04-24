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

import managers.ManageEvents;
import models.Event;
import models.User;

@WebServlet("/CreateEvent")
public class CreateEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateEvent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Event event = new Event();
		HttpSession session = request.getSession(false);
		User user = (User) session.getAttribute("user");
		
			try {
				if (session != null || user != null) {
					BeanUtils.populate(event, request.getParameterMap());
					//System.out.println(event.getName());
					//System.out.println(event.getLocation());
					//System.out.println(event.getInfo());
					//System.out.println(event.getCountryId());
					//System.out.println(event.getDate());
					ManageEvents manageevents = new ManageEvents();
					manageevents.addEvent(event);
					manageevents.finalize();
				}
			}
			
			catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		request.setAttribute("event",event);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ViewCreateEvent.jsp"); 
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
