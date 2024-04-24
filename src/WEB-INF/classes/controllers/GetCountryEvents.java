package controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managers.ManageEvents;
import models.Country;
import models.Event;
import models.User;

@WebServlet("/GetCountryEvents")
public class GetCountryEvents extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCountryEvents() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		List<Event> events = Collections.emptyList();
		User user = (User) session.getAttribute("user");
		Country country = (Country) session.getAttribute("selected_country");
		
		if (session != null || user != null) {
			if(country.getId()>0) {
				ManageEvents eventManager = new ManageEvents();
				events = eventManager.getCountryEvents(country.getId());
				eventManager.finalize();
				session.setAttribute("selected_tl","tle");
			}
		}

		request.setAttribute("events",events);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ViewCountryEvents.jsp"); 
		dispatcher.forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}