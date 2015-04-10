package encapsulation;

public class Account {
	
	private double penger;
	private double rente;
	
//	Account(double, double) - Konstrukt�ren skal ta inn startbel�pet og rentefoten (prosentpoeng). Ingen av disse kan v�re negative.
	public Account(double start, double rente){
		if(start < 0 || rente < 0){
			throw new IllegalArgumentException("Tallene kan ikke v�re negative!");
		}
		this.penger = start;
		this.rente = rente;
	}
	
//	double getBalance() - Returnerer bel�pet som st�r p� kontoen.
	public double getBalance(){
		return penger;
	}
	
//	double getInterestRate() - Returnerer renten p� kontoen.
	public double getInterestRate(){
		return rente;
	}
	
//	void setInterestRate(double) - Denne metoden tar inn en ikke-negativ verdi og setter renten til denne verdien.
	public void setInterestRate(double nyRente){
		if(nyRente < 0){
			throw new IllegalArgumentException("Den nye renten kan ikke v�re negativ!");
		}
		this.rente = nyRente;
	}
	
//	void deposit(double) - Denne metoden tar inn et ikke-negativt bel�p og �ker konto-bel�pet tilsvarende.
	public void deposit(double merPenger){
		if(merPenger < 0) throw new IllegalArgumentException("Du kan ikke sette inn negativt antall penger, bruk withdraw-metoden istedet");
		this.penger += merPenger;
	}
	
//	void withdraw(double) - Denne metoden tar inn et ikke-negativt bel�p og minsker konto-bel�pet tilsvarende. Dersom det nye konto-bel�pet er negativt, s� skal tilstanden ikke endre, og det skal utl�ses et unntak av typen IllegalStateException.
	public void withdraw(double mindrePenger){
		if(mindrePenger < 0) throw new IllegalArgumentException("Negative tall aksepteres ikke, skriv hvor mye penger du �nsker � ta ut");
		if(penger-mindrePenger < 0) throw new IllegalStateException("Du har ikke nok penger p� kontoen for � ta ut s� mye. Du har " + this.penger + " penger p� kontoen");
		this.penger -= mindrePenger;
	}
}