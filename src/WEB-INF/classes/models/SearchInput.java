package models;

public class SearchInput implements java.io.Serializable {

private static final long serialVersionUID = 1L;
	
	private String input = "";
	private int status = 0;
	
	public SearchInput() {
		
	}
	
	public String getInput() {
		return this.input;
	}
	
	public void setInput(String input) {
		this.input = input;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
}
