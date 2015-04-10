package stateandbehavior;
import java.util.*;

public class RPNCalc {
	
	private List<Double> stack;
	
	public RPNCalc(){
		
	}
	
//	void push(double) - legg argumentet p� toppen av stacken.
	public void push(double argument){
		stack.add(argument);
	}
	
//	double pop() - returner verdien p� toppen av stacken. Verdien skal ogs� fjernes fra stacken. Dersom stacken er tom, s� skal Double.NaN returneres.
	public double pop(){
		int siste = stack.size();
		double poppet = (double) stack.get(siste);
		stack.remove(siste);
		return poppet;
	}
	
//	double peek(int) - returner verdien i stacken som st�r p� plassen gitt i argumentet, telt fra toppen. Det vil si, peek(0) skal returnere verdien p� toppen av stacken, peek(1) skal returnere verdien nest �verst i stacken osv. Verdien skal ikke fjernes av stacken. Dersom det er for f� elementer p� stacken, s� skal Double.NaN returneres.
	public double peek(int plass){
		if(plass > stack.size()){
			return Double.NaN;
		}
		return (double) stack.get(stack.size() - plass);
	}
	
//	int getSize() - returner antallet elementer i stacken.
	public int getSize(){
		return stack.size();
	}
	
//	void performOperation(char) - utf�r den angitte operasjonen p� de to �verste verdiene i stacken. De to verdiene skal fjernes fra stacken og resultatet skal legges �verst. Bruk eksisterende metoder for � utf�re dette der det er mulig.
//	Metoden m� st�tte '+' (pluss), '-' (minus), '*' (multiplikasjon) og '/' (divisjon), men kan ogs� st�tte andre operatorer, f.eks. '~' (swap) for � bytte de to �verste operandene, 'p' eller 'pi' (pi) for � legge pi p� stacken (bruker ingen operander), '|' (absolutt-verdi, bruker �n operand). Pr�v � h�ndtere manglende operander p� en m�te som gir mening for operasjonen.
	public void performOperation(char operator){
		
	}
//	private RPNCalc min = new RPNCalc();
//	min.push(3.3);
}
