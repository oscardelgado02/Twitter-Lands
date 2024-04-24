package models;

public class Country implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	 private int id;
	 private String name;

	 public Country() {

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
}
