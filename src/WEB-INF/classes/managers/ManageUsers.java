package managers;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;

import models.Login;
import models.User;
import utils.DB;

public class ManageUsers {
	
	private DB db = null ;
	
	public ManageUsers() {
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
		
	// Add new user
	public void addUser(String name, String mail, String pwd, String born_date, String gender, int country_id) {
		String query = "INSERT INTO user(username, email, _password, birthday_date, gender, country_id, admin_check) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setString(1,name);
			statement.setString(2,mail);
			statement.setString(3,pwd);
			statement.setString(4, born_date);
			statement.setString(5, gender);
			statement.setInt(6, country_id);
			statement.setInt(7, 0);
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*Check if all the fields are filled correctly */
	public boolean isComplete(User user) {
		user.checkUser(this);
	    return(hasValue(user.getUser()) &&
	    	   hasValue(user.getMail()) &&
	    	   hasValue(user.getPwd1()) &&
	           hasValue(user.getPwd2()) &&
	           hasValue(user.getDate()) &&
	           hasValue(user.getGender()));
	}
	
	/*Check if all the fields are valid */
	public boolean isValid(User user) {
		if(user.getUser().equals("")) return false;
		System.out.println("Buen user");
		if(user.getMail().equals("")) return false;
		System.out.println("Buen mail");
		if(user.getPwd1().equals("")) return false;
		System.out.println("Buen pwd");
		if(user.getDate().equals("")) return false;
		System.out.println("Buen Date");
		if(user.getCountry()==0) return false;
		System.out.println("Buen Country");
		if(user.getGender().equals("")) return false;
		System.out.println("Buen Gender");
		return true;
	}
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
	
	public boolean existUser(String name) {
			
		try {
			//Used to get size of the database
			ResultSet result;
			result = db.prepareStatement("SELECT username FROM user WHERE username =" + "'"+name+"'").executeQuery();
			//return hasValue(result.getString(1));
			if(result.next()) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean existLogin(Login login) {
		
		try {
			//Used to get size of the database
			ResultSet result;
			result = db.prepareStatement("SELECT username FROM user WHERE username =" + "'"+login.getUser()+"'").executeQuery();
			
			if(result.next()) {
			}else {
				login.setError(0);
				return false;
			}
			
			
			result = db.prepareStatement("SELECT username FROM user WHERE username =" + "'"+login.getUser()+
					"'" + "AND _password=" + "'"+login.getPassword()+"'").executeQuery();
			//return hasValue(result.getString(1));
			if(result.next()) {
				return true;
			}else {
				login.setError(1);
				return false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
		
	
	// TODO: add other methods
	// Follow a user
		public void followUser(String uname, String fname) {
			String query = "INSERT INTO follow (username_follower,username_followed) VALUES (?,?)";
			PreparedStatement statement = null;
			try {
				statement = db.prepareStatement(query);
				statement.setString(1,uname);
				statement.setString(2,fname);
				statement.executeUpdate();
				statement.close();
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Unfollow a user
		public void unfollowUser(String uname, String fname) {
			String query = "DELETE FROM follow WHERE username_follower = ? AND username_followed = ?";
			PreparedStatement statement = null;
			try {
				statement = db.prepareStatement(query);
				statement.setString(1,uname);
				statement.setString(2,fname);
				statement.executeUpdate();
				statement.close();
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void editUser(String mail, String pwd, String born_date, String gender, int country_id, String name) {
			String query = "UPDATE user SET email = ?, _password = ?, birthday_date = ?, gender = ?, country_id = ? WHERE username = ?;";
			 PreparedStatement statement = null;
			 try {
				 statement = db.prepareStatement(query);
				 statement.setString(1,mail);
				 statement.setString(2,pwd);
				 statement.setString(3,born_date);
				 statement.setString(4,gender);
				 statement.setInt(5,country_id);
				 statement.setString(6,name);
				 statement.executeUpdate();
				 statement.close();
				 
				 
			} catch (SQLException e) {
				e.printStackTrace();
			} 
	    }
		
		
		
		// Get all the users
		public List<User> getUsers(Integer start, Integer end) {
			 String query = "SELECT username FROM user ORDER BY username ASC LIMIT ?,?;";
			 PreparedStatement statement = null;
			 List<User> l = new ArrayList<User>();
			 try {
				 statement = db.prepareStatement(query);
				 statement.setInt(1,start);
				 statement.setInt(2,end);
				 ResultSet rs = statement.executeQuery();
				 while (rs.next()) {
					 User user = new User();
					 user.setUser(rs.getString("username"));
					 l.add(user);
				 }
				 rs.close();
				 statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return  l;
		}
		
		public User getUser(String uname) {
			 String query = "SELECT username, email, _password, birthday_date, gender, country_id, admin_check FROM user WHERE username = ?;";
			 PreparedStatement statement = null;
			 User user = new User();
			 try {
				 statement = db.prepareStatement(query);
				 statement.setString(1,uname);
				 ResultSet rs = statement.executeQuery();
				 while (rs.next()) {
					 user.setUser(rs.getString("username"));
					 user.setMail(rs.getString("email"));
					 user.setPwd1(rs.getString("_password"));
					 user.setPwd2(rs.getString("_password"));
					 user.setDate(rs.getString("birthday_date"));
					 user.setGender(rs.getString("gender"));
					 user.setCountry(rs.getInt("country_id"));
					 user.setAdmin(rs.getInt("admin_check"));
				 }
				 rs.close();
				 statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return  user;
		}
		
		public List<User> getNotFollowedUsers(String uname, Integer start, Integer end) {
			 String query = "SELECT username FROM user WHERE username NOT IN (SELECT username FROM user,follow WHERE username = username_followed AND username_follower = ?) AND username <> ? ORDER BY username LIMIT ?,?;";
			 PreparedStatement statement = null;
			 List<User> l = new ArrayList<User>();
			 try {
				 statement = db.prepareStatement(query);
				 statement.setString(1, uname);
				 statement.setString(2, uname);
				 statement.setInt(3,start);
				 statement.setInt(4,end);
				 ResultSet rs = statement.executeQuery();
				 while (rs.next()) {
					 User user = new User();
					 user.setUser(rs.getString("username"));
					 l.add(user);
				 }
				 rs.close();
				 statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return  l;
		}
		
		public List<User> getFollowedUsers(String uname) {
			 String query = "SELECT username FROM user,follow WHERE username = username_followed AND username_follower = ? ORDER BY username;";
			 PreparedStatement statement = null;
			 List<User> l = new ArrayList<User>();
			 try {
				 statement = db.prepareStatement(query);
				 statement.setString(1,uname);
				 ResultSet rs = statement.executeQuery();
				 while (rs.next()) {
					 User user = new User();
					 user.setUser(rs.getString("username"));
					 l.add(user);
				 }
				 rs.close();
				 statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return  l;
		}
		
		public List<User> getFollowers(String uname) {
			 String query = "SELECT username FROM user,follow WHERE username = username_follower AND username_followed = ? ORDER BY username;";
			 PreparedStatement statement = null;
			 List<User> l = new ArrayList<User>();
			 try {
				 statement = db.prepareStatement(query);
				 statement.setString(1,uname);
				 ResultSet rs = statement.executeQuery();
				 while (rs.next()) {
					 User user = new User();
					 user.setUser(rs.getString("username"));
					 l.add(user);
				 }
				 rs.close();
				 statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return  l;
		}
		
		public List<User> getCountryFollowers(int id) {
			 String query = "SELECT username FROM user,country_user WHERE username = username_user AND ID_country = ? ORDER BY username;";
			 PreparedStatement statement = null;
			 List<User> l = new ArrayList<User>();
			 try {
				 statement = db.prepareStatement(query);
				 statement.setInt(1,id);
				 ResultSet rs = statement.executeQuery();
				 while (rs.next()) {
					 User user = new User();
					 user.setUser(rs.getString("username"));
					 l.add(user);
				 }
				 rs.close();
				 statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return  l;
		}
		
		public int getNumFollowers(String uname) {
		String query = "SELECT COUNT(*) FROM follow WHERE username_followed = ?;";
		 PreparedStatement statement = null;
		 int followers = 0;
		 try {
			 statement = db.prepareStatement(query);
			 statement.setString(1,uname);
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
		
		public List<User> searchUsers(String input) {
			 String query = "SELECT username FROM user WHERE LOCATE(?, username);";
			 PreparedStatement statement = null;
			 List<User> l = new ArrayList<User>();
			 try {
				 statement = db.prepareStatement(query);
				 statement.setString(1,input);
				 ResultSet rs = statement.executeQuery();
				 while (rs.next()) {
					 User user = new User();
					 user.setUser(rs.getString("username"));
					 l.add(user);
				 }
				 rs.close();
				 statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return  l;
		}
		
		/*public boolean checkUser(String user) {
			
			String query = "SELECT username from user where username=?";
			PreparedStatement statement = null;
			ResultSet rs = null;
			boolean output = false;
			try {
				
				statement = db.prepareStatement(query);
				statement.setString(1,user);
				rs = statement.executeQuery();
				if (rs.isBeforeFirst()) {
					output = true;
				}
				rs.close();
				statement.close();
				return output;
				
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return output;
			
		}*/
		
		public boolean checkMail(String mail) {
			
			String query = "SELECT email from user where email=?";
			PreparedStatement statement = null;
			ResultSet rs = null;
			boolean output = false;
			try {
				
				statement = db.prepareStatement(query);
				statement.setString(1,mail);
				rs = statement.executeQuery();
				if (rs.isBeforeFirst()) {
					output = true;
				}
				rs.close();
				statement.close();
				return output;
				
			} catch (SQLIntegrityConstraintViolationException e) {
				System.out.println(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return output;
			
		}
}
