package inheritance;

public class TrainCar {
	
	private int dodVekt;
	protected int vekt;

//	TrainCar(int) - en konstruktør som tar inn hvor mye en tom vogn veier.
	public TrainCar(int vekt){
		this.dodVekt = vekt;
	}
	
//	int getTotalWeight - returnerer vognas totale vekt. Merk at denne også skal kunne kalles på subklasser og fortsatt returnere totalvekta toil vogna (stikkord: redefinering).
	public int getTotalWeight(){
		return this.vekt + dodVekt;
	}
	
//	setDeadWeight(int) - setter hvor mye en tom vogn veier. Altså vekten til kun vognen, uten passasjerer eller last.
	public void setDeadWeight(int vekt){
		this.dodVekt = vekt;
	}
	
//	int getDeadWeight() - returnerer hvor mye en tom vogn veier. Altså vekten til kun vognen, uten passasjerer eller last.
	public int getDeadWeight(){
		return this.dodVekt;
	}
}
