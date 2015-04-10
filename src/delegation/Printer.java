package delegation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Printer {

	private Map<Employee, ArrayList<String>> oversikt = new HashMap<Employee, ArrayList<String>>();
	
//	void printDocument(String document, Employee employee) - skriver documentet til konsollen og tar vare på dokumentet i employee sin historikk
	public void printDocument(String document, Employee employee){
		ArrayList<String> ny = new ArrayList<String>();
		if(oversikt.containsKey(employee)){
			ny = oversikt.get(employee);
		}
		ny.add(document);
		oversikt.put(employee, ny);
	}
	
//	List<String> getPrintHistory(Employee employee) - returnerer en List<String> med alle dokumentene som har blitt printet av employee i rekkefølgen de har blitt printet
	public List<String> getPrintHistory(Employee employee){
		if(oversikt.get(employee) == null){
			return new ArrayList<String>();
		}
		return oversikt.get(employee);
	}
}
