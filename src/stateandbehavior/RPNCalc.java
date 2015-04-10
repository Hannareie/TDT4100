package stateandbehavior;
import java.util.*;

public class RPNCalc {
	
	private List<Double> stack;
	
	public RPNCalc(){
		
	}
	
//	void push(double) - legg argumentet på toppen av stacken.
	public void push(double argument){
		stack.add(argument);
	}
	
//	double pop() - returner verdien på toppen av stacken. Verdien skal også fjernes fra stacken. Dersom stacken er tom, så skal Double.NaN returneres.
	public double pop(){
		int siste = stack.size();
		double poppet = (double) stack.get(siste);
		stack.remove(siste);
		return poppet;
	}
	
//	double peek(int) - returner verdien i stacken som står på plassen gitt i argumentet, telt fra toppen. Det vil si, peek(0) skal returnere verdien på toppen av stacken, peek(1) skal returnere verdien nest øverst i stacken osv. Verdien skal ikke fjernes av stacken. Dersom det er for få elementer på stacken, så skal Double.NaN returneres.
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
	
//	void performOperation(char) - utfør den angitte operasjonen på de to øverste verdiene i stacken. De to verdiene skal fjernes fra stacken og resultatet skal legges øverst. Bruk eksisterende metoder for å utføre dette der det er mulig.
//	Metoden må støtte '+' (pluss), '-' (minus), '*' (multiplikasjon) og '/' (divisjon), men kan også støtte andre operatorer, f.eks. '~' (swap) for å bytte de to øverste operandene, 'p' eller 'pi' (pi) for å legge pi på stacken (bruker ingen operander), '|' (absolutt-verdi, bruker én operand). Prøv å håndtere manglende operander på en måte som gir mening for operasjonen.
	public void performOperation(char operator){
		
	}
//	private RPNCalc min = new RPNCalc();
//	min.push(3.3);
}
