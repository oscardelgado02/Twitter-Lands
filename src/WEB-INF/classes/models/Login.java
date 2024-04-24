package models;

public class Login {

	private String user = "";
	private String password = "";
	private boolean[] error = {false, false};
	
	public String getUser(){
		return user;
	}
	
	public void setUser(String user){
		this.user = user;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public boolean[] getError() {
		return error;
	}
	
	public void setError(int idx) {
		this.error[idx] = true;
	}
	
	public boolean isComplete() {		
	    return(hasValue(getUser())
	    		&& hasValue(getPassword()));
	}
	
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}
	
}