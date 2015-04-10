package interfaces;

public class Person2 implements Named {

	private String fullName;
	
	public Person2(String fName){
		this.fullName = fName;
	}
	
	public void setGivenName(String navn) {
		String familyName = fullName.substring(fullName.indexOf(" "));
		String givenName = navn;
		this.fullName = givenName + familyName;
	}

	
	public String getGivenName() {
		String givenName = fullName.substring(0, fullName.indexOf(" "));
		return givenName;
	}

	public void setFamilyName(String navn) {
		String givenName = fullName.substring(0, fullName.indexOf(" "));
		String familyName = navn;
		this.fullName = givenName + familyName;
		
	}

	public String getFamilyName() {
		String familyName = fullName.substring(fullName.indexOf(" ")+1);
		return familyName;
	}

	public void setFullName(String navn) {
		this.fullName = navn;
		
	}

	public String getFullName() {
		return this.fullName;
	}

}
