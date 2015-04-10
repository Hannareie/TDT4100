package interfaces;

public class Person1 implements Named {

	private String givenName;
	private String familyName;
	
	public Person1(String gName, String fName){
		this.givenName = gName;
		this.familyName = fName;
	}
	
	public void setGivenName(String navn) {
		this.givenName = navn;
	}

	
	public String getGivenName() {
		return this.givenName;
	}

	public void setFamilyName(String navn) {
		this.familyName = navn;
		
	}

	public String getFamilyName() {
		return this.familyName;
	}

	public void setFullName(String navn) {
		this.givenName = navn.substring(0, navn.indexOf(" "));
		this.familyName = navn.substring(navn.indexOf(" ")+1);
		
	}

	public String getFullName() {
		return( this.givenName + this.familyName);
	}

}
