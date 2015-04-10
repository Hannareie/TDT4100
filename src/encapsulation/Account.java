package encapsulation;

public class Account {
	
	private double penger;
	private double rente;
	
//	Account(double, double) - Konstruktøren skal ta inn startbeløpet og rentefoten (prosentpoeng). Ingen av disse kan være negative.
	public Account(double start, double rente){
		if(start < 0 || rente < 0){
			throw new IllegalArgumentException("Tallene kan ikke være negative!");
		}
		this.penger = start;
		this.rente = rente;
	}
	
//	double getBalance() - Returnerer beløpet som står på kontoen.
	public double getBalance(){
		return penger;
	}
	
//	double getInterestRate() - Returnerer renten på kontoen.
	public double getInterestRate(){
		return rente;
	}
	
//	void setInterestRate(double) - Denne metoden tar inn en ikke-negativ verdi og setter renten til denne verdien.
	public void setInterestRate(double nyRente){
		if(nyRente < 0){
			throw new IllegalArgumentException("Den nye renten kan ikke være negativ!");
		}
		this.rente = nyRente;
	}
	
//	void deposit(double) - Denne metoden tar inn et ikke-negativt beløp og øker konto-beløpet tilsvarende.
	public void deposit(double merPenger){
		if(merPenger < 0) throw new IllegalArgumentException("Du kan ikke sette inn negativt antall penger, bruk withdraw-metoden istedet");
		this.penger += merPenger;
	}
	
//	void withdraw(double) - Denne metoden tar inn et ikke-negativt beløp og minsker konto-beløpet tilsvarende. Dersom det nye konto-beløpet er negativt, så skal tilstanden ikke endre, og det skal utløses et unntak av typen IllegalStateException.
	public void withdraw(double mindrePenger){
		if(mindrePenger < 0) throw new IllegalArgumentException("Negative tall aksepteres ikke, skriv hvor mye penger du ønsker å ta ut");
		if(penger-mindrePenger < 0) throw new IllegalStateException("Du har ikke nok penger på kontoen for å ta ut så mye. Du har " + this.penger + " penger på kontoen");
		this.penger -= mindrePenger;
	}
}