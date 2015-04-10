package objectstructures;

import interfaces.Card;

import java.util.ArrayList;

public class CardDeck {

	private ArrayList<Card> kortene = new ArrayList<Card>();
	private int cardCount;
	
//	CardDeck(int n) - fyller kortstokken med de n f�rste kortene av hver kortfarge, totalt n * 4 kort, med spar 1 som f�rste kort (indeks nr. 0), spar 2 som andre (nr. 1), spar 3 som tredje (nr. 2), spar 4 som fjerde (nr. 3), ..., hjerter 1 som fjortende (nr. 13), hjerter 2 som femtende (nr. 4) osv. i.e. f�rst alle spar, s� hjerter, s� ruter og s� kl�ver, alle i stigende rekkef�lge. 
	public CardDeck(int n){
		for(int i = 0; i < n; i++){
			this.kortene.add(new Card('S', i+1));
			this.cardCount ++;
		}
		for(int i = 0; i < n; i++){
			this.kortene.add(new Card('H', i+1));
			this.cardCount ++;
		}
		for(int i = 0; i < n; i++){
			this.kortene.add(new Card('D', i+1));
			this.cardCount ++;
		}
		for(int i = 0; i < n; i++){
			this.kortene.add(new Card('C', i+1));
			this.cardCount ++;
		}
	}
	
//	getCardCount() - returnerer hvor mange Card-objekter som CardDeck-objektet inneholder
	public int getCardCount(){
		return this.cardCount;
	}
	
//	getCard(int n) - returnerer kort nr. n eller utl�ser et IllegalArgumentException hvis n ikke er gyldig
	public Card getCard(int n){
		if(n > this.getCardCount()){
			throw new IllegalArgumentException("Du har ikke s� mange kort i stokken!");
		}
		return this.kortene.get(n);
	}
	
//	deal(CardHand, int n) - flytter n kort fra kortstokken (CardDeck-objektet) til korth�nda (CardHand-objektet, som er f�rste argument), ved � ta ett og ett kort med h�yeste gyldige indeks, fjerne det fra CardDeck-objektet og legge det til CardHand-objektet
	public void deal(CardHand hand, int n){
		for(int i = 0; i < n; i++){
			Card kort = this.getCard(this.kortene.size()-1);
			this.kortene.remove(kort);
			this.cardCount --;
			hand.addCard(kort);
		}
	}
	
//	shufflePerfectly() - stokker kortstokken ved � dele den i to like store deler og flette de to delene perfekt, slik at kortet p� toppen forblir p� toppen og kortet p� bunnen forblir p� bunnen (se http://en.wikipedia.org/wiki/Out_shuffle)
	public void shufflePerfectly(){
		int midten = this.getCardCount()/2;
		for(int i = 0; i < midten; i++){
			this.kortene.add(this.getCard(0));
			this.kortene.remove(0);
			this.kortene.add(this.getCard(midten-(i+1)));
			this.kortene.remove(midten-(i+1));
		}
	}
}
