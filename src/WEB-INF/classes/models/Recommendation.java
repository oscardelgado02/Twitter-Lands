package models;

public class Recommendation implements java.io.Serializable{
	private static final long serialVersionUID = 1L;

	 private int id;
	 private String name;
	 private String location;
	 private String info;
	 private int country_id;
	 private float total_rate;
	 private float rate;
	 private String uname;

	 public Recommendation() {
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
	 
	 public float getTotalRate() {
		 return this.total_rate;
	 }
	 
	 public void setTotalRate(float total_rate) {
		 this.total_rate = total_rate;
	 }
	 
	 public float getRate() {
		 return this.rate;
	 }
	 
	 public void setRate(float rate) {
		 this.rate = rate;
	 }
	 
	 public String getUname() {
		 return this.uname;
	 }
	 
	 public void setUname(String uname) {
		 this.uname = uname;
	 }
}
