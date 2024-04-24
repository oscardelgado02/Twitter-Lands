package managers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Event;
import models.User;
import utils.DB;

public class ManageEvents {
private DB db = null ;
	
	public ManageEvents() {
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
	
	/* Add a event */
	public void addEvent(Event event) {
		String query = "INSERT INTO event (ID,_name,location,info,countryID,date) VALUES (?,?,?,?,?,?)";
		PreparedStatement statement = null;
		try {
			statement = db.prepareStatement(query);
			statement.setInt(1,event.getId());
			statement.setString(2,event.getName());
			statement.setString(3,event.getLocation());
			statement.setString(4,event.getInfo());
			statement.setInt(5,event.getCountryId());
			statement.setString(6,event.getDate());
			statement.executeUpdate();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* Delete existing event */
	public void deleteEvent(Integer id) {
		String query = "DELETE FROM event WHERE ID = ?";
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
	
	
	/* Get events from a country given start and end*/
	public List<Event> getCountryEventsLimit(Integer id,Integer start, Integer end) {
		 String query = "SELECT event.ID,event._name,event.location,event.info,event.date FROM event INNER JOIN country ON event.countryID = country.ID WHERE country.ID = ? ORDER BY event.date DESC LIMIT ?,? ;";
		 PreparedStatement statement = null;
		 List<Event> l = new ArrayList<Event>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,id);
			 statement.setInt(2,start);
			 statement.setInt(3,end);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 Event event = new Event();
				 event.setId(rs.getInt("event.ID"));
				 event.setName(rs.getString("event._name"));
				 event.setLocation(rs.getString("event.location"));
				 event.setInfo(rs.getString("event.info"));
				 event.setDate(rs.getString("event.date"));
				 l.add(event);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	/* Get events from a country without start and end*/
	public List<Event> getCountryEvents(Integer id) {
		 String query = "SELECT event.ID,event._name,event.location,event.info,event.date FROM event INNER JOIN country ON event.countryID = country.ID WHERE country.ID = ? ORDER BY event.date DESC;";
		 PreparedStatement statement = null;
		 List<Event> l = new ArrayList<Event>();
		 try {
			 statement = db.prepareStatement(query);
			 statement.setInt(1,id);
			 ResultSet rs = statement.executeQuery();
			 while (rs.next()) {
				 Event event = new Event();
				 event.setId(rs.getInt("event.ID"));
				 event.setName(rs.getString("event._name"));
				 event.setLocation(rs.getString("event.location"));
				 event.setInfo(rs.getString("event.info"));
				 event.setDate(rs.getString("event.date"));
				 l.add(event);
			 }
			 rs.close();
			 statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return  l;
	}
	
	public List<User> getEventFollowers(Integer ID,Integer start, Integer end) {
        String query = "SELECT username_user FROM event_user WHERE ID_event = ? ORDER BY ID_event ASC LIMIT ?,? ;";
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
}
