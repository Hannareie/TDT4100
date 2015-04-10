package interfaces;

public interface Named {

	
//	setGivenName(String) og String getGivenName() for � sette og hente fornavn
	public void setGivenName(String navn);
	public String getGivenName();
	
//	setFamilyName(String) og String getFamilyName() for � sette og hente etternavn
	public void setFamilyName(String navn);
	public String getFamilyName();
	
//	setFullName(String) og String getFullName() for � sette og hente personens hele navn. Argumentet til set-metoden skal v�re fornavn og etternavn skilt med mellomrom. Tilsvarende skal get-metoden returnere fornavn og etternavn skilt med mellomrom.
	public void setFullName(String navn);
	public String getFullName();
}
