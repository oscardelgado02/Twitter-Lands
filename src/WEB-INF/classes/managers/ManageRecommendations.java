package managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Recommendation;
//Deberiamos usar la clase tweet para obtener el uName del autor. (Recommendation extends Tweet).
import utils.DB;

public class ManageRecommendations {
private DB db = null ;
	
	public ManageRecommendations() {
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
	
	/* Create a recommendation */
	public void createRecommendation(Recommendation recommendation, String uname) {
		String query = "INSERT INTO recommendation (_name,location,countryID,total_rate) VALUES (?,?,?,0);";
		String query2 = "SELECT ID FROM recommendation ORDER BY ID DESC LIMIT 0, 1;";
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		try {
			//QUERY1
			statement = db.prepareStatement(query);
			statement.setString(1,recommendation.getName());
			statement.setString(2,recommendation.getLocation());
			statement.setInt(3,recommendation.getCountryId());
			
			statement.executeUpdate();
			statement.close();
			//QUERY2
			statement2 = db.prepareStatement(query2);
			ResultSet rs = statement2.executeQuery();
			while(rs.next()) {
				recommendation.setId(rs.getInt("ID"));
			}
			rs.close();
			statement2.close();
			//ADD RECOMMENDATION
			addRecommendation(recommendation, uname);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* Add a recommendation */
	public void addRecommendation(Recommendation recommendation, String uname) {
		String query = "INSERT INTO user_recommendation (username_user, ID_recommendation, rate, info) VALUES (?,?,?,?);";
		PreparedStatement statement = null;
		try {
			//QUERY1
			statement = db.prepareStatement(query);
			
			statement.setString(1,uname);
			statement.setInt(2,recommendation.getId());
			statement.setFloat(3,recommendation.getRate());
			statement.setString(4,recommendation.getInfo());
			
			statement.executeUpdate();
			statement.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		updateTotalRate(recommendation.getId()); //update the total rate
	}
	
	/* Delete recommendation */
	public void deleteRecommendation(Integer id) {
		String query = "DELETE FROM recommendation WHERE ID = ?";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,id);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/* Get recommendations from a country given start and end*/
	public List<Recommendation> getCountryRecommendationsLimit(Integer id,Integer start, Integer end) {
		 String query = "SELECT recommendation.ID,recommendation._name,recommendation.location,recommendation.total_rate,country.ID FROM recommendation INNER JOIN country ON recommendation.countryID = country.ID WHERE country.ID = ? ORDER BY recommendation.total_rate DESC LIMIT ?,? ;";
		 PreparedStatement statement = null;
		 List<Recommendation> l = new ArrayList<Recommendation>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,id);
			 statement.setInt(2,start);
			 statement.setInt(3,end);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 Recommendation recommendation = new Recommendation();
				 recommendation.setId(rs.getInt("recommendation.ID"));
				 recommendation.setName(rs.getString("recommendation._name"));
				 recommendation.setTotalRate(rs.getInt("recommendation.total_rate"));
				 recommendation.setLocation(rs.getString("recommendation.location"));
				 recommendation.setInfo(rs.getString("recommendation.info"));
				 recommendation.setCountryId(rs.getInt("country.ID"));
				 l.add(recommendation);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	/* Get recommendations from a country without start and end*/
	public List<Recommendation> getCountryRecommendations(Integer id) {
		 String query = "SELECT recommendation.ID,recommendation._name,recommendation.location,recommendation.total_rate,country.ID FROM recommendation INNER JOIN country ON recommendation.countryID = country.ID WHERE country.ID = ? ORDER BY recommendation.total_rate DESC;";
		 PreparedStatement statement = null;
		 List<Recommendation> l = new ArrayList<Recommendation>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,id);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 Recommendation recommendation = new Recommendation();
				 recommendation.setId(rs.getInt("recommendation.ID"));
				 recommendation.setName(rs.getString("recommendation._name"));
				 recommendation.setTotalRate(rs.getInt("recommendation.total_rate"));
				 recommendation.setLocation(rs.getString("recommendation.location"));
				 recommendation.setCountryId(rs.getInt("country.ID"));
				 l.add(recommendation);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	/* Get recommendations of users from a country*/
	public List<Recommendation> getUserRecommendationsByRecomId(Integer id) {
		 String query = "SELECT recommendation.ID,recommendation._name,recommendation.location,user_recommendation.username_user,user_recommendation.rate,user_recommendation.info FROM recommendation INNER JOIN user_recommendation INNER JOIN country ON recommendation.countryID = country.ID AND recommendation.ID = user_recommendation.ID_recommendation WHERE recommendation.ID = ? ORDER BY recommendation.total_rate DESC;";
		 PreparedStatement statement = null;
		 List<Recommendation> l = new ArrayList<Recommendation>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,id);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 Recommendation recommendation = new Recommendation();
				 recommendation.setId(rs.getInt("recommendation.ID"));
				 recommendation.setName(rs.getString("recommendation._name"));
				 recommendation.setLocation(rs.getString("recommendation.location"));
				 recommendation.setUname(rs.getString("user_recommendation.username_user"));
				 recommendation.setRate(rs.getFloat("user_recommendation.rate"));
				 recommendation.setInfo(rs.getString("user_recommendation.info"));
				 l.add(recommendation);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	/* Get all recommendations*/
	public List<Recommendation> getRecommendations() {
		 String query = "SELECT ID,_name,location,total_rate,countryID FROM recommendation ORDER BY _name;";
		 PreparedStatement statement = null;
		 List<Recommendation> l = new ArrayList<Recommendation>();
		 try {
			 statement = db.prepareStatement(query);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 Recommendation recommendation = new Recommendation();
				 recommendation.setId(rs.getInt("ID"));
				 recommendation.setName(rs.getString("_name"));
				 recommendation.setLocation(rs.getString("location"));
				 recommendation.setTotalRate(rs.getFloat("total_rate"));
				 recommendation.setCountryId(rs.getInt("countryID"));
				 l.add(recommendation);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	/* Get events from a country given start and end*/
	public Recommendation getRecommendation(int id) {
		 String query = "SELECT ID,_name,location,total_rate,countryID FROM recommendation WHERE ID = ?;";
		 PreparedStatement statement = null;
		 Recommendation recommendation = new Recommendation();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,id);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 recommendation.setId(rs.getInt("ID"));
				 recommendation.setName(rs.getString("_name"));
				 recommendation.setLocation(rs.getString("location"));
				 recommendation.setTotalRate(rs.getFloat("total_rate"));
				 recommendation.setCountryId(rs.getInt("countryID"));
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  recommendation;
	}
	
	public float updateTotalRate(int id) {
		String query = "SELECT AVG(rate) FROM user_recommendation WHERE ID_recommendation = ?;";
		String update_query = "UPDATE recommendation SET total_rate = ? WHERE ID = ?;";
		 PreparedStatement statement = null;
		 PreparedStatement update_statement = null;
		 float totalrate = 0;
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,id);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 totalrate= rs.getFloat("AVG(rate)");
			 }
			 rs.close();
			 statement.close();
			 
			 update_statement = db.prepareStatement(update_query);
			 update_statement.setFloat(1,totalrate);
			 update_statement.setInt(2,id);
			 update_statement.executeUpdate();
			 update_statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return  totalrate;
	}
}
