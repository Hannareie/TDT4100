package inheritance;

public abstract class AbstractAccount {

	protected double balance = 0;
//	void deposit(double) - øker kontobalansen med innskutt beløp. Merk at det innskutte beløpet må være positivt. Ved ulovlig innskudd skal en IllegalArgumentException utløses.
	public void deposit(double belop){
		if(belop < 0){
			throw new IllegalArgumentException("Du kan ikke legge inn ett negativt beløp. Prøv med withdraw-metoden");
		}
		balance += belop;
	}
	
//	void withdraw(double) -  Metoden kaller internalWithdraw(uttaksbeløp), som implementeres i hver subklasse. Hvis uttaksbeløpet er negativt skal metoden utløse en IllegalArgumentException. 
	public void withdraw(double belop){
		if(belop < 0){
			throw new IllegalArgumentException("Du kan ikke ta ut ett negativt beløp. Prøv med deposit-metoden");
		}
		internalWithdraw(belop);
	}
	
//	abstract void internalWithdraw(double) - minsker kontobalansen med beløpet som blir tatt ut. Merk at reglene for uttak er ulik for klassene som implementerer AbstractAccount, og må derfor implementeres i hver klasse. Hvis det ikke er mulig å ta ut det angitte beløpet skal metoden utløse en IllegalStateException.
	protected abstract void internalWithdraw(double belop);
	
//	double getbalance() - returnerer kontobalansen.
	public double getBalance(){
		return this.balance;
	}
}
