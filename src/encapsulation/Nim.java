package encapsulation;

public class Nim {
	
	private int pile0 = 0;
	private int pile1 = 0;
	private int pile2 = 0;
	
	public Nim(){
		this.pile0 = 10;
		this.pile1 = 10;
		this.pile2 = 10;
	}
	
	public Nim(int pileSize){
		this.pile0 = pileSize;
		this.pile1 = pileSize;
		this.pile2 = pileSize;
	}
	
//	void removePieces(int number, int targetPile) - fjerner number (>= 1) antall brikker fra haugen targetPile. IllegalArgumentException utløses hvis targetPile eller number er ugyldig. Siden man ikke kan gjøre trekk etter at spillet er over, må IllegalStateException utløses dersom metoden kalles etter det.
	public void removePieces(int number, int targetPile){
		if (isGameOver()){
			throw new IllegalStateException("Spillet er over.");
		}
		if (!(targetPile == 0 || targetPile == 1 || targetPile == 2)){
			throw new IllegalArgumentException("Du må velge enten 0, 1 eller 2 som argument.");
		}
		System.out.println(number);
		if (number <= 0){
			throw new IllegalArgumentException("Du må velge ett positivt tall for å si hvor mange brikker du tar bort.");
		}
		if(targetPile == 0){
			if(this.pile0 < number){
				throw new IllegalArgumentException("Du prøver å fjerne flere brikker enn det er igjen i haugen.");
			}
			this.pile0 -= number;
		}
		else if(targetPile == 1){
			if(this.pile1 < number){
				throw new IllegalArgumentException("Du prøver å fjerne flere brikker enn det er igjen i haugen.");
			}
			this.pile1 -= number;
		}
		else if(targetPile == 2){
			if(this.pile2 < number){
				throw new IllegalArgumentException("Du prøver å fjerne flere brikker enn det er igjen i haugen.");
			}
			this.pile2 -= number;
		}
	}
	
//	boolean isValidMove(int number, int targetPile) - returnerer true dersom argumentene representerer et lovlig trekk
	public boolean isValidMove(int number, int targetPile){
		if (isGameOver()){
			return false;
		}
		if(number < 1){
			return false;
		}
		if (targetPile == 0 && this.pile0 >= number){
			return true;			
		}
		if (targetPile == 1 && this.pile1 >= number){
			return true;			
		}
		if (targetPile == 2 && this.pile2 >= number){
			return true;			
		}
		return false;
	}
	
//	boolean isGameOver() - returnerer true dersom en av haugene har 0 brikker.
	public boolean isGameOver(){
		if(pile0 == 0 || pile1 == 0 || pile2 == 0){
			return true;
		}
		return false;
	}
	
//	int getPile(int targetPile) - returnerer antall brikker i haug targetPile. 
	public int getPile(int targetPile){
		if(targetPile == 0){
			return this.pile0;
		}
		else if(targetPile == 1){
			return this.pile1;
		}
		else{
			return this.pile2;
		}
	}
	
//	string toString() - returnerer en tekststreng som oppsummerer spillets tilstand
	public String toString(){
		String text = "Det er " + pile0 + " i den første haugen, " + pile1 + " i den andre haugen, og " + pile2 + " i den tredje haugen.";
		return text;
	}	
}
