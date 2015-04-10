package objectstructures;

public class Card {
	
	private char farge;
	private int verdi;
	
//	Card(char, int) - konstruktøren initialiserer kortfarge og tallverdi med henholdsvis første og andre argument. Konstruktøren må utløse unntak av typen IllegalArgumentException hvis en (eller begge) av disse verdiene er ugyldige.
	public Card(char farge, int verdi){
		if(sjekkKort(farge, verdi)){
			this.farge = farge;
			this.verdi = verdi;
		}
		else{
			throw new IllegalArgumentException("Fargen må være S, H, D, eller C. Verdien må være mellom 1 og 13.");
		}
	}
	
	private boolean sjekkKort(char farge, int verdi){
		return (farge == 'S' || farge == 'H' || farge == 'D' || farge == 'C') && (verdi > 0 && verdi < 14);
	}
	
//	getSuit() - returnerer kortfargen som en char, en av 'S', 'H', 'D' eller 'C'.
	public char getSuit(){
		return this.farge;
	}
	
//	getFace() - returnerer tallverdien som en int mellom 1 og 13 (inklusive)
	public int getFace(){
		return this.verdi;
	}
	
//	toString() - returnerer en streng som består av <suit><face> e.g. for spar ess skal "S1" returneres.
	public String toString(){
		String type = Character.toString(this.getSuit());
		String tall = Integer.toString(this.getFace());
		return (type + tall);
	}
}