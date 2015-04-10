package delegation;

import java.util.function.BinaryOperator;

public interface Employee {

//	double doCalculations(BinaryOperator<Double> operation, double value1, double value2) - regner ut resultatet av å utføre operation med argumentene value1 og value2
	double doCalculations(BinaryOperator<Double> operation, double value1, double value2);

//	void printDocument(String document) - Printer document. Hvordan dette gjøres avhenger av den spesifikke implementasjonen.
	void printDocument(String document);
	
//	int getTaskCount() - returnerer hvor mange oppgaver (beregninger og printinger) som har blitt utført av eller på vegne av dette Employee-objektet
	int getTaskCount();
	
//	int getResourceCount() - antallet employees til rådighet, inkludert Employee-objektet metoden blir kalt på. En Employee skal altså medregne seg selv i antall ressurser den ansatte har til rådighet. Dette tallet skal inkludere alle Employee-objekter nedover i hierarkiet.
	int getResourceCount();
}
