package objectstructures;

import java.util.ArrayList;


public class Person1 {

	
	private String name;
	private char gender;
	private Person1 mother;
	private Person1 father;
	private ArrayList<Person1> child = new ArrayList<Person1>();
	private int childCount;
	
	public Person1(String navn, char kjonn){
		this.name = navn;
		this.gender = kjonn;
	}
//	getName() - returnerer navnet knyttet til dette Person-objektet
	public String getName() {
		return name;
	}
//	getGender() - returnerer tegnet som representerer kj�nnet, enten 'F' eller 'M'
	public char getGender() {
		return gender;
	}
//	getMother() - returnerer Person-objektet som er moren, evt. null
	public Person1 getMother() {
		return mother;
	}
//	getFather() - returnerer Person-objektet som er faren, evt. null
	public Person1 getFather() {
		return father;
	}
//	getChild(int n) - returnerer barn nr. n (alts� et Person-objekt), evt. utl�ser (et passende) unntak om n er for stor (eller liten)
	public Person1 getChild(int n) {
		if(n < 0 || n > childCount){
			throw new IllegalArgumentException("Du m� kalle getChild med en gyldig indeks!");
		}
		return child.get(n);
	}
//	getChildCount() - returnerer antall barn dette Person-objektet har
	public int getChildCount(){
		return childCount;
	}
//	setMother(Person) - setter argumentet (en kvinne) som moren til Person-objektet som metoden kalles p�. Argumentet f�r samtidig registrert Person-objektet som metoden kalles p�, som sitt barn.
	public void setMother(Person1 mor){
		if(mor.getGender() == 'M'){
			throw new IllegalArgumentException("Denne personen er feil kj�nn");
		}
		if(mor == this){
			throw new IllegalArgumentException("Du kan ikke v�re din egen mor");
		}
		Person1 gammel = this.getMother();
		this.mother = mor;
		mor.addChild(this);
		if(gammel != null && gammel != mor){
			gammel.removeChild(this);
		}
	}
//	setFather(Person) - setter argumentet (en mann) som faren til Person-objektet som metoden kalles p�. Argumentet f�r samtidig registrert Person-objektet som metoden kalles p�, som sitt barn.
	public void setFather(Person1 far){
		if(far.getGender() == 'F'){
			throw new IllegalArgumentException("Denne personen er feil kj�nn");
		}
		if(far == this){
			throw new IllegalArgumentException("Du kan ikke v�re din egen far");
		}
		Person1 gammel = this.getFather();
		this.father = far;
		far.addChild(this);
		if(gammel != null && gammel != far){
			gammel.removeChild(this);
		}
	}
//	addChild(Person) - oppretter en kobling til et barn (et annet Person-objekt). Dersom Person-objektet som metoden kalles p�, er en kvinne, s� skal denne bli barnets mor, og motsatt, dersom Person-objektet som metoden kalles p�, er en mann, s� skal denne bli barnets far.
	public void addChild(Person1 barn){
		for(Person1 p : child){
			if(p == barn){
				return;
			}
		}
		this.childCount ++;
		this.child.add(barn);
		if(this.getGender() == 'M'){
			barn.setFather(this);
		}
		else{
			barn.setMother(this);
		}
		
	}
	private boolean finnesBarn(Person1 barn){
		for(Person1 p : this.child){
			if(p == barn){
				return true;
			}
		}
		return false;
	}
//	removeChild(Person) - fjerner en kobling til et barn (et annet Person-objekt). Dersom Person-objektet som metoden kalles p�, er moren til argumentet, s� skal mother-koblingen fjernes, og motsatt, dersom Person-objektet som metoden kalles p�, er argumentets far, s� skal father-koblingen fjernes.
	public void removeChild(Person1 barn){
		if(finnesBarn(barn)){
			this.child.remove(barn);
			this.childCount --;
		}
	}
}
