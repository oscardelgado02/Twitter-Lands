package managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Tweet;
import utils.DB;


public class ManageTweets {
	
private DB db = null ;
	
	public ManageTweets() {
		try {
			db = new DB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void finalize() {
		try {
			db.disconnectBD();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	/* Add a tweet */
    public void addTweet(Tweet tweet) {
        String query = "INSERT INTO tweet (userName,_timestamp,content,countryID,likes) VALUES (?,CURRENT_TIMESTAMP,?,?,?);";
        PreparedStatement statement = null;
        try {
            statement = db.prepareStatement(query);
            statement.setString(1,tweet.getUname());
            statement.setString(2,tweet.getContent());
            statement.setInt(3,tweet.getCountryId());
			statement.setInt(4,0);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	/* Delete existing tweet */
	public void deleteTweet(Integer id,String uname) {
		String query_like = "DELETE FROM like_tweet WHERE tweet_ID = ?";
		String query_tweet = "DELETE FROM tweet WHERE tweetID = ? AND userName=?";
		PreparedStatement statement_like = null;
		PreparedStatement statement_tweet = null;
		try {
			statement_like = db.prepareStatement(query_like);
			statement_like.setInt(1,id);
			statement_like.executeUpdate();
			statement_like.close();
			
			statement_tweet = db.prepareStatement(query_tweet);
			statement_tweet.setInt(1,id);
			statement_tweet.setString(2,uname);
			statement_tweet.executeUpdate();
			statement_tweet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/* Get tweets from a user given start and end*/
	public List<Tweet> getUserTweetsLimit(String uname,Integer start, Integer end) {
		 String query = "SELECT tweet.tweetID,tweet.userName,tweet._timestamp,tweet.content,tweet.likes,user.username FROM tweet INNER JOIN user ON tweet.userName = user.username where tweet.userName = ? ORDER BY tweet._timestamp DESC LIMIT ?,? ;";
		 PreparedStatement statement = null;
		 List<Tweet> l = new ArrayList<Tweet>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setString(1,uname);
			 statement.setInt(2,start);
			 statement.setInt(3,end);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 Tweet tweet = new Tweet();
       		     tweet.setId(rs.getInt("tweet.tweetID"));
				 tweet.setPostDateTime(rs.getTimestamp("tweet._timestamp"));
				 tweet.setContent(rs.getString("tweet.content"));
				 tweet.setUname(rs.getString("user.username"));
				 tweet.setLikes(rs.getInt("tweet.likes"));
				 l.add(tweet);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	/* Get tweets from a user without start and end*/
	public List<Tweet> getUserTweets(String uname) {
		 String query = "SELECT tweet.tweetID,tweet.userName,tweet._timestamp,tweet.content,tweet.likes,user.username FROM tweet INNER JOIN user ON tweet.userName = user.username where tweet.userName = ? ORDER BY tweet._timestamp DESC;";
		 PreparedStatement statement = null;
		 List<Tweet> l = new ArrayList<Tweet>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setString(1,uname);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 Tweet tweet = new Tweet();
       		     tweet.setId(rs.getInt("tweet.tweetID"));
				 tweet.setPostDateTime(rs.getTimestamp("tweet._timestamp"));
				 tweet.setContent(rs.getString("tweet.content"));
				 tweet.setUname(rs.getString("user.username"));
				 tweet.setLikes(rs.getInt("tweet.likes"));
				 l.add(tweet);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	/* Get tweets from a user given start and end*/
	public Tweet getTweet(int id) {
		 String query = "SELECT tweet.tweetID,tweet.userName,tweet._timestamp,tweet.content,tweet.countryID,tweet.likes FROM tweet where tweet.tweetID = ?";
		 PreparedStatement statement = null;
		 Tweet t = new Tweet();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,id);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
       		     t.setId(rs.getInt("tweet.tweetID"));
				 t.setPostDateTime(rs.getTimestamp("tweet._timestamp"));
				 t.setContent(rs.getString("tweet.content"));
				 t.setUname(rs.getString("tweet.userName"));
				 t.setCountryId(rs.getInt("tweet.countryID"));
				 t.setLikes(rs.getInt("tweet.likes"));
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  t;
	}
	
	/* Get tweets from a user given start and end*/
	public List<Tweet> getFollowersTweets(String uname) {
		 String query = "SELECT t.tweetID, t.userName, t.content, t._timestamp, t.likes FROM tweet AS t JOIN user AS u1 JOIN user AS u2 JOIN follow as f ON u1.username = ? AND u1.username = f.username_follower AND u2.username = f.username_followed AND t.userName = u2.username ORDER BY t._timestamp DESC;";
		 PreparedStatement statement = null;
		 List<Tweet> l = new ArrayList<Tweet>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setString(1,uname);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 Tweet tweet = new Tweet();
       		     tweet.setId(rs.getInt("t.tweetID"));
				 tweet.setPostDateTime(rs.getTimestamp("t._timestamp"));
				 tweet.setContent(rs.getString("t.content"));
				 tweet.setUname(rs.getString("t.username"));
				 tweet.setLikes(rs.getInt("t.likes"));
				 l.add(tweet);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	public List<Tweet> getCountryTweets(String uname, Integer ID) {
        String query = "SELECT t.tweetID, t.userName, t.content, t._timestamp, t.countryID, t.likes FROM tweet AS t JOIN country AS c ON c.ID = ? AND t.countryID = c.ID ORDER BY t._timestamp DESC;";
        PreparedStatement statement = null;
        List<Tweet> l = new ArrayList<Tweet>();
        try {
            statement = db.prepareStatement(query);
            statement.setInt(1,ID);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Tweet tweet = new Tweet();
                tweet.setId(rs.getInt("t.tweetID"));
                tweet.setPostDateTime(rs.getTimestamp("t._timestamp"));
                tweet.setContent(rs.getString("t.content"));
                tweet.setCountryId(rs.getInt("t.countryID"));
                tweet.setUname(rs.getString("t.userName"));
				tweet.setLikes(rs.getInt("t.likes"));
                l.add(tweet);
            }
            rs.close();
            statement.close();
       } catch (SQLException e) {
           e.printStackTrace();
       } 
       return  l;
   }
	
	public void addLikes(String uname, Integer ID) {
        String query = "INSERT IGNORE INTO like_tweet VALUES (?, ?)";
        String query2 = "DELETE FROM like_tweet WHERE tweet_ID = ? AND uname = ?";
        int like_done=0;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        try {
            statement = db.prepareStatement(query);
            statement.setInt(1,ID);
            statement.setString(2,uname);            
            like_done = statement.executeUpdate();
            statement.close();
            
            if(like_done==0) {
            	statement2 = db.prepareStatement(query2);
                statement2.setInt(1,ID);
                statement2.setString(2,uname);            
                statement2.executeUpdate();
                statement2.close();
            }                     
            
       } catch (SQLException e) {
           e.printStackTrace();
       }
       updateLikes(ID); //update the likes counter
   }
	
	public int updateLikes(int id) {
		 String query = "SELECT COUNT(*) FROM like_tweet WHERE tweet_ID = ?;";
		 String update_query = "UPDATE tweet SET likes = ? WHERE tweetID = ?;";
		 PreparedStatement statement = null;
		 PreparedStatement update_statement = null;
		 int total_likes = 0;
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,id);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 total_likes= rs.getInt("COUNT(*)");
			 }
			 rs.close();
			 statement.close();
			 
			 update_statement = db.prepareStatement(update_query);
			 update_statement.setInt(1,total_likes);
			 update_statement.setInt(2,id);
			 update_statement.executeUpdate();
			 update_statement.close();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return  total_likes;
	}
	
	
}