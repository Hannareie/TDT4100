package objectstructures;

public class Partner {
	private String name;
	private Partner partner;
	
	public String getName(){
		return this.name;
	}
	
	public Partner getPartner(){
		return this.partner;
	}
	
	public Partner(String navn){
		this.name = navn;
	}
	
	public void setPartner(Partner person){
		Partner gammel = this.getPartner();
		if(this.partner == person){
			
		}
		else{
			if(gammel == null && person == null){
				throw new IllegalStateException("Denne personen kan ikke skille seg, personen er ikke i et partnerskap");
			}
			if(gammel == null){
				this.partner = person;
				person.setPartner(this);
			}
			else if(this.partner == person){
				
			}
			else if(person == null){
				this.partner = null;
				gammel.setPartner(null);
			}
			else{
				gammel.setPartner(null);
				setPartner(null);
				setPartner(person);
			}
		}
	}
}