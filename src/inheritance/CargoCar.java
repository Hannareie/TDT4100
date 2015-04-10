package inheritance;

public class CargoCar extends TrainCar {

//	CargoCar(int, int) - her tas inn hvor mye en tom vogn veier (som i TrainCar), og hvor mye vogna sin last veier.
	public CargoCar(int dodVekt, int vekt) {
		super(dodVekt);
		this.setCargoWeight(vekt);
	}
	
//	setCargoWeight(int)  - setter en ny verdi for vekten til lasten.
	public void setCargoWeight(int vekt){
		this.vekt = vekt;
	}

//	int getCargoWeight() - returnerer hvor mye lasten veier.
	public int getCargoWeight(){
		return this.vekt;
	}
}
