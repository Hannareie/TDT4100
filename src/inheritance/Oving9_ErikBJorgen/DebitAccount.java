package inheritance;

public class DebitAccount extends AbstractAccount {

	public DebitAccount(){
		
	}
	@Override
	protected void internalWithdraw(double belop) {
		if(this.balance - belop < 0){
			throw new IllegalStateException("Du kan ikke enda opp med negativ balanse i kontoen din");
		}
		this.balance -= belop;
	}

}
