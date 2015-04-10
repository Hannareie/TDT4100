package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Train {

	private List<TrainCar> vogner = new ArrayList<TrainCar>();
	private List<CargoCar> lasteVogner = new ArrayList<CargoCar>();
	private List<PassengerCar> personVogner = new ArrayList<PassengerCar>();
	public Train(){
		
	}
	
//	addTrainCar(TrainCar) - denne metoden skal ta inn en togvogn og knytte den til dette lokomotivet.
	public void addTrainCar(TrainCar vogn){
		vogner.add(vogn);
		if(vogn instanceof CargoCar){
			lasteVogner.add((CargoCar) vogn);
		}
		else if(vogn instanceof PassengerCar){
			personVogner.add((PassengerCar) vogn);
		}
	}
	
//	boolean contains(TrainCar) - Sjekker om lokomotivet har TrainCar-argument knyttet til seg.
	public boolean contains(TrainCar vogn){
		return vogner.contains(vogn);
	}
	
//	int getTotalWeight() - returner alle vognene sin totale vekt. Vi tar ikke høyde for lokomotivet sin eventuelle vekt.
	public int getTotalWeight(){
		int i = 0;
		for(TrainCar vogn : vogner){
			i += vogn.getTotalWeight();
		}
		return i;
	}
	
//	int getPassengerCount() - tilsvarende PassengerCar sin metode, men returnerer antallet for alle vognene.
	public int getPassengerCount(){
		int i = 0;
		for(PassengerCar vogn : personVogner){
			i += vogn.getPassengerCount();
		}
		return i;
	}
	
//	int getCargoWeight() - tilsvarende CargoCar sin metode, men returnerer lastevekten for alle vognene.
	public int getCargoWeight(){
		int i = 0;
		for(CargoCar vogn : lasteVogner){
			i += vogn.getCargoWeight();
		}
		return i;
	}
	
//	String toString() - toString-metoden skal sette sammen en String med oversikt over alle vognene som er knyttet til den. For hver vogn skal vogntype og totalvekt være med. Passasjervogner skal i tillegg ha med antall passasjerer og lastevogner skal ha med hvor mye lasten veier.
	public String toString(){
		String s = "";
		for(TrainCar vogn : vogner){
			s += "Den neste vognen er en ";
			if(vogn instanceof CargoCar){
				s += "lastevogn med " + ((CargoCar) vogn).getCargoWeight() + " vekt på lasten.";
			}
			else if(vogn instanceof PassengerCar){
				s += "passasjervogn med " + ((PassengerCar) vogn).getPassengerCount() + " passasjerer.";
			}
			s += "Totalvekten er " + vogn.getTotalWeight() + ".";
		}
		return s;
	}
}
