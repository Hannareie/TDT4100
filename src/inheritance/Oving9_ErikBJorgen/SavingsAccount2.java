package inheritance;

public class SavingsAccount2 extends AbstractAccount{

	private int uttak;
	private double gebyr;
	
	public SavingsAccount2(int uttak, double gebyr){
		this.uttak = uttak;
		this.gebyr = gebyr;
	}
	
	
	@Override
	protected void internalWithdraw(double belop) {
		if(uttak > 0){
			if(this.balance - belop < 0){
				throw new IllegalStateException("Du kan ikke enda opp med negativ balanse i kontoen din");
			}
			this.balance -= belop;
			uttak --;
		}
		else{
			if(this.balance - belop - gebyr < 0){
				throw new IllegalStateException("Du kan ikke ende opp med nagativ balanse i kontoen din");
			}
			this.balance -= belop + gebyr;
		}
	}
}
