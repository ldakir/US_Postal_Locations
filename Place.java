

public class Place {
	private String zip;
	private String town;
	private String state;
	
	
	public Place(String t, String s, String z) {
		this.zip=z;
		this.town=t;
		this.state=s;
		
	}
	
	public String getZip() {
		return this.zip;
	}//getZip()
	
	public String getTown() {
		return this.town;
	}//getTown()
	
	public String getState() {
		return this.state;
	}//getState()
	
	public String toString() {
		return this.town + ", " + this.state + " " + this.zip;
	}
		
}//Class Place
