package interfaces;

import interfaces.Card;

import java.util.ArrayList;

public class CardHand implements CardContainer {
	
	private ArrayList<Card> kortene = new ArrayList<Card>();
	private int cardCount;
	
	public CardHand(){
	}
	
//	getCardCount() - returnerer hvor mange Card-objekter som CardDeck-objektet inneholder
	public int getCardCount(){
		return this.cardCount;
	}
	
//	getCard(int n) - returnerer kort nr. n eller utløser et IllegalArgumentException hvis n ikke er gyldig
	public Card getCard(int n){
		if(n > this.getCardCount()){
			throw new IllegalArgumentException("Du har ikke så mange kort i stokken!");
		}
		return this.kortene.get(n);
	}
	
//	addCard(Card) - legger argumentet til dette CardHand-objektet
	public void addCard(Card kort){
		this.kortene.add(kort);
		this.cardCount ++;
	}
	
//	play(int n) - returnerer og fjerner kort nr. n (første kort har nr. 0) fra dette CardHand-objektet (som om det ble spilt ut)
	public Card play(int n){
		if(n > this.getCardCount()){
			throw new IllegalArgumentException("Du har ikke så mange kort i stokken!");
		}
		Card temp = this.kortene.get(n);
		this.kortene.remove(n);
		this.cardCount --;
		return temp;
	}
	
	public ArrayList<Card> cardList() {
		return this.kortene;
	}
}
