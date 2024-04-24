package managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import models.Country;
import models.User;
import utils.DB;

public class ManageCountry {
private DB db = null ;
	
	public ManageCountry() {
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
	// Get all the users
			public List<Country> getCountries(Integer start, Integer end) {
				 String query = "SELECT ID,_name FROM country ORDER BY ID ASC LIMIT ?,?;";
				 PreparedStatement statement = null;
				 List<Country> l = new ArrayList<Country>();
				 try {
					 statement = db.prepareStatement(query);
					 statement.setInt(1,start);
					 statement.setInt(2,end);
					 ResultSet rs = statement.executeQuery();
					 while (rs.next()) {
						 Country country = new Country();
						 country.setId(rs.getInt("ID"));
						 country.setName(rs.getString("_name"));
						 l.add(country);
					 }
					 rs.close();
					 statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				return  l;
			}
			
			public List<User> getFollowers(Integer ID, Integer start, Integer end) {
				 String query = "SELECT username_user FROM country_user WHERE ID_country = ? ORDER BY username_user LIMIT ?,?;";
				 PreparedStatement statement = null;
				 List<User> l = new ArrayList<User>();
				 try {
					 statement = db.prepareStatement(query);
					 statement.setInt(1,ID);
					 statement.setInt(2,start);
					 statement.setInt(3,end);
					 ResultSet rs = statement.executeQuery();
					 while (rs.next()) {
						 User user = new User();
						 user.setUser(rs.getString("username_user"));
						 l.add(user);
					 }
					 rs.close();
					 statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				return  l;
			}
			
			public Country getCountry(Integer id) {
				 String query = "SELECT ID,_name FROM country WHERE ID = ?;";
				 PreparedStatement statement = null;
				 Country country = new Country();
				 try {
					 statement = db.prepareStatement(query);
					 statement.setInt(1,id);
					 ResultSet rs = statement.executeQuery();
					 while (rs.next()) {
						 country.setId(rs.getInt("ID"));
						 country.setName(rs.getString("_name"));
					 }
					 rs.close();
					 statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				return  country;
			}
			
			public Country getEmptyCountry() {
				 
				 Country country = new Country();
				 country.setId(0);
				 country.setName("");
				 return  country;
			}
			
			public List<Country> getFollowedCountries(String uname) {
				 String query = "SELECT c.ID, c._name FROM country AS c JOIN country_user as f ON f.username_user = ? AND f.ID_country = c.ID ORDER BY c.ID;";
				 PreparedStatement statement = null;
				 List<Country> l = new ArrayList<Country>();
				 try {
					 statement = db.prepareStatement(query);
					 statement.setString(1,uname);
					 ResultSet rs = statement.executeQuery();
					 while (rs.next()) {
						 Country country = new Country();
						 country.setName(rs.getString("c._name"));
						 country.setId(rs.getInt("c.ID"));
						 l.add(country);
					 }
					 rs.close();
					 statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				return  l;
			}
			
			public int getNumFollowers(int id) {
				String query = "SELECT COUNT(*) FROM country_user WHERE ID_country = ?;";
				 PreparedStatement statement = null;
				 int followers = 0;
				 try {
					 statement = db.prepareStatement(query);
					 statement.setInt(1,id);
					 ResultSet rs = statement.executeQuery();
					 while (rs.next()) {
						 followers = rs.getInt("COUNT(*)");
					 }
					 rs.close();
					 statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				return  followers;
				}
			
			public List<Country> searchCountries(String input) {
				 String query = "SELECT ID,_name FROM country WHERE LOCATE(?, _name);";
				 PreparedStatement statement = null;
				 List<Country> l = new ArrayList<Country>();
				 try {
					 statement = db.prepareStatement(query);
					 statement.setString(1,input);
					 ResultSet rs = statement.executeQuery();
					 while (rs.next()) {
						 Country country = new Country();
						 country.setId(rs.getInt("ID"));
						 country.setName(rs.getString("_name"));
						 l.add(country);
					 }
					 rs.close();
					 statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} 
				return  l;
			}
			
			// Follow a country
			public void followCountry(String uname, int id) {
                String query = "INSERT IGNORE INTO country_user VALUES (?,?)";
                
                PreparedStatement statement = null;
                try {
                    statement = db.prepareStatement(query);
                    statement.setString(1,uname);
                    statement.setInt(2,id);
                    statement.executeUpdate();
                    statement.close();
                } catch (SQLIntegrityConstraintViolationException e) {
                    System.out.println(e.getMessage());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
            // Unfollow a country
            public void unfollowCountry(String uname, int id) {
                String query = "DELETE FROM country_user WHERE username_user = ? AND ID_country = ?";
                PreparedStatement statement = null;
                try {
                    statement = db.prepareStatement(query);
                    statement.setString(1,uname);
                    statement.setInt(2,id);
                    statement.executeUpdate();
                    statement.close();
                } catch (SQLIntegrityConstraintViolationException e) {
                    System.out.println(e.getMessage());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
			
}