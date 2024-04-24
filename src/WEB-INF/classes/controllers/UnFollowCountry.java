package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import managers.ManageCountry;
import models.Country;
import models.User;

/**
 * Servlet implementation class FollowUser
 */
@WebServlet("/UnFollowCountry")
public class UnFollowCountry extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnFollowCountry() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Country country = new Country();
        ManageCountry countryManager = new ManageCountry();
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        
        try {
            
            if (session != null || user != null)
                BeanUtils.populate(country, request.getParameterMap());
            countryManager.unfollowCountry(user.getUser(),country.getId());
            countryManager.finalize();

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
