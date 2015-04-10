package encapsulation;

import java.util.Date;

public class Person {
	private String Name;
	private String Email;
	private Date Birthday;
	private char Gender;
	
	private boolean erBokstaver(String name) {
	    char[] tegn = name.toCharArray();

	    for (char x : tegn) {
	        if(!Character.isLetter(x)) {
	            return false;
	        }
	    }

	    return true;
	}
	
	public Person(){
		
	}
	
	private boolean ettNavn(String navn){
		if(navn.indexOf(" ") == -1){
			return true;
		}
		return false;
	}
	
	private boolean tredjeNavn(String navn){
		int mellomrom = navn.indexOf(" ");
		if(navn.indexOf(" ", mellomrom) == -1){
			return true;
		}
		return false;
	}
	
//	setName(String) - oppdaterer navnet (fornavn og etternavn med mellomrom mellom), dersom det er gyldig i henhold til kravene over. Det er greit om navnet som settes, ikke stemmer med e-post-adressen.
	public void setName(String name){
		int mellomrom = name.indexOf(" ");
		if(ettNavn(name)){
			throw new IllegalArgumentException("Du kan ikke ha bare ett navn");
		}
		String fornavn = name.substring(0, mellomrom);
		String etternavn = name.substring(mellomrom, name.length());
		if(tredjeNavn(name)){
			throw new IllegalArgumentException("Du kan bare ha to navn");
		}
		if(fornavn.length() < 3 || etternavn.length() < 3){
			throw new IllegalArgumentException("Navnene må ha minst tre bokstaver!");
		}
		this.Name = name;
	}
	public String getName(){
		return this.Name;
	}
	
//	setEmail(String) - oppdaterer e-post-adressen, etter å ha sjekket at den stemmer med navnet.
	public void setEmail(String email){
		if(email == "-1"){
			this.Email = email;
		}
		else{	
			int forstePunktum = email.indexOf(".");
			if(forstePunktum == -1){
				throw new IllegalArgumentException("Du må desverre ha to navn.");
			}
			int alfa = email.indexOf("@");
			if(alfa == -1){
				throw new IllegalArgumentException("Skriv krøllalfa mellom navnet og domenet.");
			}
			int andrePunktum = email.indexOf(".", alfa);
			if(andrePunktum == -1){
				throw new IllegalArgumentException("Du må bruke et punktum for å skille mellom domenet og landskoden.");
			}
			String fornavn = email.substring(0, forstePunktum);
			String etternavn = email.substring(forstePunktum+1, alfa);
			String navn = fornavn + " " + etternavn;
			String land = email.substring(andrePunktum+1, email.length());
			if (land.length() != 2){
				throw new IllegalStateException("Landskoden må være to siffer.");
			}
			if (!navn.toLowerCase().equals(this.Name.toLowerCase())){
				throw new IllegalStateException("Navnet stemmer ikke!");
			}
			if(!erBokstaver(fornavn) || !erBokstaver(etternavn)){
				throw new IllegalArgumentException("Navn kan bare inneholde bokstaver");
			}
		}
		this.Email = email;
	}
	public String getEmail(){
		return this.Email;
	}
	
//	setBirthday(Date) - oppdaterer fødselsdatoen
	public void setBirthday(Date date){
		@SuppressWarnings("deprecation")
		Date idag = new Date(99, 1, 24);
		if(date.before(idag)){
			this.Birthday = date;
		}
		else{
			throw new IllegalArgumentException("Den datoen har ikke skjedd enda!");
		}
	}
	public Date getBirthday(){
		return this.Birthday;
	}
	
//	setGender(char) - oppdaterer kjønnet
	public void setGender(char gender){
		if(gender == 'M'  || gender == 'F' || gender == '\0'){
			this.Gender = gender;
		}
		else{
			throw new IllegalArgumentException("Gender må være M, F, eller 0");			
		}
	}
	public char getGender(){
		return this.Gender;
	}
	public static void main(String[] args){
		Person min = new Person();
		min.setName("Ola Nordmann");
		min.setEmail("ola.nordmann@ntnu.no");
	}
}