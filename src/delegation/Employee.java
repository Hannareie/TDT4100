package delegation;

import java.util.function.BinaryOperator;

public interface Employee {

//	double doCalculations(BinaryOperator<Double> operation, double value1, double value2) - regner ut resultatet av � utf�re operation med argumentene value1 og value2
	double doCalculations(BinaryOperator<Double> operation, double value1, double value2);

//	void printDocument(String document) - Printer document. Hvordan dette gj�res avhenger av den spesifikke implementasjonen.
	void printDocument(String document);
	
//	int getTaskCount() - returnerer hvor mange oppgaver (beregninger og printinger) som har blitt utf�rt av eller p� vegne av dette Employee-objektet
	int getTaskCount();
	
//	int getResourceCount() - antallet employees til r�dighet, inkludert Employee-objektet metoden blir kalt p�. En Employee skal alts� medregne seg selv i antall ressurser den ansatte har til r�dighet. Dette tallet skal inkludere alle Employee-objekter nedover i hierarkiet.
	int getResourceCount();
}
