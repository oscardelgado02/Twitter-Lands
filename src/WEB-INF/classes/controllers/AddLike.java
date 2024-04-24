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

import managers.ManageTweets;
import models.Tweet;
import models.User;

/**
 * Servlet implementation class AddTweetFromUser
 */
@WebServlet("/AddLike")
public class AddLike extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLike() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        Tweet tweet = new Tweet();
        ManageTweets tweetManager = new ManageTweets();
        HttpSession session = request.getSession(false);
        User user = (User) session.getAttribute("user");
        
        try {
            
            if (session != null || user != null)
                //tweet.setUid(0);
                BeanUtils.populate(tweet, request.getParameterMap());
                tweet.setUname(user.getUser());
                tweetManager.addLikes(user.getUser(), tweet.getId());
                tweet = tweetManager.getTweet(tweet.getId());
                tweetManager.finalize();

        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        request.setAttribute("tweet", tweet);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
