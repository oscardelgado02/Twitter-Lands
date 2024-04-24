package utils;

public class Pair {
	private float rate;  
    private String uname; 
    
    public Pair(float rate, String uname) //Constructor of the class  
    {  
        this.rate = rate;  
        this.uname = uname;  
    }
    
    public float getRate() {
    	return rate;
    }
    
    public void setRate(float rate) {
    	this.rate = rate;
    }
    
    public String getUname() {
    	return uname;
    }
    
    public void setUname(String uname) {
    	this.uname = uname;
    }
}
