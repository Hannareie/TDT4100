package inheritance;

public class CreditAccount extends AbstractAccount{

	private double creditLine;
	
	public CreditAccount(double belop){
		if(belop < 0){
			throw new IllegalArgumentException("Kredittlinjen kan ikke v�re negativ");
		}
		this.creditLine = belop;
	}
	
	@Override
	protected void internalWithdraw(double belop) {
		if(this.balance - belop + creditLine < 0){
			throw new IllegalStateException("Du kan ikke overstige kredittgrensen din.");
		}
		this.balance -= belop;
	}

	public double getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(double creditLine) {
		if(creditLine < 0){
			throw new IllegalArgumentException("Kredittgrensen din m� v�re positiv");
		}
		if(this.balance + creditLine < 0){
			throw new IllegalStateException("DEn nye kredittgrensen m� dekke ditt negative bel�p i banken");
		}
		this.creditLine = creditLine;
	}

}
