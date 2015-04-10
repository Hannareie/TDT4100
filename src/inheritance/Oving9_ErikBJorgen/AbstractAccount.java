package inheritance;

public abstract class AbstractAccount {

	protected double balance = 0;
//	void deposit(double) - �ker kontobalansen med innskutt bel�p. Merk at det innskutte bel�pet m� v�re positivt. Ved ulovlig innskudd skal en IllegalArgumentException utl�ses.
	public void deposit(double belop){
		if(belop < 0){
			throw new IllegalArgumentException("Du kan ikke legge inn ett negativt bel�p. Pr�v med withdraw-metoden");
		}
		balance += belop;
	}
	
//	void withdraw(double) -  Metoden kaller internalWithdraw(uttaksbel�p), som implementeres i hver subklasse. Hvis uttaksbel�pet er negativt skal metoden utl�se en IllegalArgumentException. 
	public void withdraw(double belop){
		if(belop < 0){
			throw new IllegalArgumentException("Du kan ikke ta ut ett negativt bel�p. Pr�v med deposit-metoden");
		}
		internalWithdraw(belop);
	}
	
//	abstract void internalWithdraw(double) - minsker kontobalansen med bel�pet som blir tatt ut. Merk at reglene for uttak er ulik for klassene som implementerer AbstractAccount, og m� derfor implementeres i hver klasse. Hvis det ikke er mulig � ta ut det angitte bel�pet skal metoden utl�se en IllegalStateException.
	protected abstract void internalWithdraw(double belop);
	
//	double getbalance() - returnerer kontobalansen.
	public double getBalance(){
		return this.balance;
	}
}
