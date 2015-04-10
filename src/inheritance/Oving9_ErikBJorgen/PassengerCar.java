package inheritance;

public class PassengerCar extends TrainCar{

	private int passasjerer;
	
//	PassengerCar(int, int) - her tas inn hvor mye en tom vogn veier (som i TrainCar), og hvor mange passasjerer det er i vogna. 
	public PassengerCar(int dodVekt, int antall) {
		super(dodVekt);
		this.setPassengerCount(antall);
	}
	
//	setPassengerCount() - setter en ny verdi for antall passasjerer.
	public void setPassengerCount(int antall){
		this.vekt = antall*80;
		this.passasjerer  = antall;
	}
	
//	int getPassengerCount() - returner antall passasjerer.
	public int getPassengerCount(){
		return this.passasjerer;
	}

}
