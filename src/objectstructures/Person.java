package objectstructures;

import java.util.ArrayList;


public class Person {

	
	private String name;
	private char gender;
	private Person mother;
	private Person father;
	private ArrayList<Person> child = new ArrayList<Person>();
	private int childCount;
	
	public Person(String navn, char kjonn){
		this.name = navn;
		this.gender = kjonn;
	}
//	getName() - returnerer navnet knyttet til dette Person-objektet
	public String getName() {
		return name;
	}
//	getGender() - returnerer tegnet som representerer kjønnet, enten 'F' eller 'M'
	public char getGender() {
		return gender;
	}
//	getMother() - returnerer Person-objektet som er moren, evt. null
	public Person getMother() {
		return mother;
	}
//	getFather() - returnerer Person-objektet som er faren, evt. null
	public Person getFather() {
		return father;
	}
//	getChild(int n) - returnerer barn nr. n (altså et Person-objekt), evt. utløser (et passende) unntak om n er for stor (eller liten)
	public Person getChild(int n) {
		if(n < 0 || n > childCount){
			throw new IllegalArgumentException("Du må kalle getChild med en gyldig indeks!");
		}
		return child.get(n);
	}
//	getChildCount() - returnerer antall barn dette Person-objektet har
	public int getChildCount(){
		return childCount;
	}
//	setMother(Person) - setter argumentet (en kvinne) som moren til Person-objektet som metoden kalles på. Argumentet får samtidig registrert Person-objektet som metoden kalles på, som sitt barn.
	public void setMother(Person mor){
		if(mor.getGender() == 'M'){
			throw new IllegalArgumentException("Denne personen er feil kjønn");
		}
		if(mor == this){
			throw new IllegalArgumentException("Du kan ikke være din egen mor");
		}
		Person gammel = this.getMother();
		this.mother = mor;
		mor.addChild(this);
		if(gammel != null && gammel != mor){
			gammel.removeChild(this);
		}
	}
//	setFather(Person) - setter argumentet (en mann) som faren til Person-objektet som metoden kalles på. Argumentet får samtidig registrert Person-objektet som metoden kalles på, som sitt barn.
	public void setFather(Person far){
		if(far.getGender() == 'F'){
			throw new IllegalArgumentException("Denne personen er feil kjønn");
		}
		if(far == this){
			throw new IllegalArgumentException("Du kan ikke være din egen far");
		}
		Person gammel = this.getFather();
		this.father = far;
		far.addChild(this);
		if(gammel != null && gammel != far){
			gammel.removeChild(this);
		}
	}
//	addChild(Person) - oppretter en kobling til et barn (et annet Person-objekt). Dersom Person-objektet som metoden kalles på, er en kvinne, så skal denne bli barnets mor, og motsatt, dersom Person-objektet som metoden kalles på, er en mann, så skal denne bli barnets far.
	public void addChild(Person barn){
		for(Person p : child){
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
	private boolean finnesBarn(Person barn){
		for(Person p : this.child){
			if(p == barn){
				return true;
			}
		}
		return false;
	}
//	removeChild(Person) - fjerner en kobling til et barn (et annet Person-objekt). Dersom Person-objektet som metoden kalles på, er moren til argumentet, så skal mother-koblingen fjernes, og motsatt, dersom Person-objektet som metoden kalles på, er argumentets far, så skal father-koblingen fjernes.
	public void removeChild(Person barn){
		if(finnesBarn(barn)){
			this.child.remove(barn);
			this.childCount --;
		}
	}
}