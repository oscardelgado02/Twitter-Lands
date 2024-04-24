package models;

public class Event implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	 private int id;
	 private String name;
	 private String location;
	 private String info;
	 private int country_id;
	 private String date;

	 public Event() {

	 }

	 public Integer getId() {
		 return this.id;
	 }
	 
	 public void setId(Integer id) {
		 this.id = id;
	 }
	 
	 public String getName() {
		 return this.name;
	 }
	 
	 public void setName(String name) {
		 this.name = name;
	 }
	 
	 public String getLocation() {
		 return this.location;
	 }
	 
	 public void setLocation(String location) {
		 this.location = location;
	 }
	 
	 public String getInfo() {
		 return this.info;
	 }
	 
	 public void setInfo(String info) {
		 this.info = info;
	 }
	 
	 public Integer getCountryId() {
		 return this.country_id;
	 }
	 
	 public void setCountryId(Integer country_id) {
		 this.country_id = country_id;
	 }
	 
	 public String getDate() {
		 return this.date;
	 }
	 
	 public void setDate(String date) {
		 this.date = date;
	 }
}
