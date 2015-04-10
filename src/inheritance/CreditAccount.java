package inheritance;

public class CreditAccount extends AbstractAccount{

	private double creditLine;
	
	public CreditAccount(double belop){
		if(belop < 0){
			throw new IllegalArgumentException("Kredittlinjen kan ikke være negativ");
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
			throw new IllegalArgumentException("Kredittgrensen din må være positiv");
		}
		if(this.balance + creditLine < 0){
			throw new IllegalStateException("DEn nye kredittgrensen må dekke ditt negative beløp i banken");
		}
		this.creditLine = creditLine;
	}

}
