package objectstructures;

import java.util.ArrayList;

public class Person {
	
	private String name;
	private char gender;
	private Person mother;
	private Person father;
	private ArrayList<Person> children = new ArrayList<Person>();
	
	public Person(String name, char gender) {
		if(gender == 'M' || gender == 'F'){
			this.gender = gender;
		}
		this.name = name;
	}
		
	public void addChild(Person child){
		if(!this.children.contains(child)){
			if((this.getGender() == 'M') && !(this.name.equals(child.getName()))){
				this.children.add(child);
				child.setFather(this);
			}
			if((this.getGender() == 'F') && !(this.name.equals(child.getName()))){
				this.children.add(child);
				child.setMother(this);
			}
		}
	}
	
	public void removeChild(Person child){
		if(this.children.contains(child)){
			this.children.remove(child);
			if(child.father == this){
				child.father = null;
			}
			else if (child.mother == this){
				child.mother = null;
			}
		}
	}

	public void setFather(Person newFather) {
		if(newFather!=null){
			if((newFather.getGender() == 'M') && !(this.name.equals(newFather.getName()))){
				if(this.father!=null){
					Person oldFather = this.father;
					oldFather.removeChild(this);
				}
				newFather.addChild(this);
				this.father = newFather;
			}
			else{
				throw new IllegalArgumentException("Dette ble feil");
			}
			
		}
		else{
			if(this.father!=null){
				this.father.removeChild(this);				
			}
		}
	}
	
	public void setMother(Person newMother) {
		// denne metoden virker på akkurat samme måte som setFather()
		if(newMother!=null){
			if((newMother.getGender() == 'F') && !(this.name.equals(newMother.getName()))){
				if(this.mother!=null){
					Person oldMother = this.mother;
					oldMother.removeChild(this);
				}
				this.mother = newMother;
				this.mother.children.add(this);
			}
			else{
				throw new IllegalArgumentException("Dette ble feil");
			}
			
		}
		else{
			if(this.mother!=null){
				this.mother.removeChild(this);				
			}
		}
	}

	public String getName() {
		return this.name;
	}

	public char getGender() {
		return this.gender;
	}

	public Person getMother() {
		return this.mother;
	}

	public Person getFather() {
		return this.father;
	}

	public Person getChild(int num) {
		return this.children.get(num);
	}

	public int getChildCount() {
		return this.children.size();
	}
	
//	@Override
//	public String toString(){
//		return name;
//	}
//	
	

}