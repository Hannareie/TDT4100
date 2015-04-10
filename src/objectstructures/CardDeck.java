package objectstructures;

import interfaces.Card;

import java.util.ArrayList;

public class CardDeck {

	private ArrayList<Card> kortene = new ArrayList<Card>();
	private int cardCount;
	
//	CardDeck(int n) - fyller kortstokken med de n første kortene av hver kortfarge, totalt n * 4 kort, med spar 1 som første kort (indeks nr. 0), spar 2 som andre (nr. 1), spar 3 som tredje (nr. 2), spar 4 som fjerde (nr. 3), ..., hjerter 1 som fjortende (nr. 13), hjerter 2 som femtende (nr. 4) osv. i.e. først alle spar, så hjerter, så ruter og så kløver, alle i stigende rekkefølge. 
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
	
//	getCard(int n) - returnerer kort nr. n eller utløser et IllegalArgumentException hvis n ikke er gyldig
	public Card getCard(int n){
		if(n > this.getCardCount()){
			throw new IllegalArgumentException("Du har ikke så mange kort i stokken!");
		}
		return this.kortene.get(n);
	}
	
//	deal(CardHand, int n) - flytter n kort fra kortstokken (CardDeck-objektet) til korthånda (CardHand-objektet, som er første argument), ved å ta ett og ett kort med høyeste gyldige indeks, fjerne det fra CardDeck-objektet og legge det til CardHand-objektet
	public void deal(CardHand hand, int n){
		for(int i = 0; i < n; i++){
			Card kort = this.getCard(this.kortene.size()-1);
			this.kortene.remove(kort);
			this.cardCount --;
			hand.addCard(kort);
		}
	}
	
//	shufflePerfectly() - stokker kortstokken ved å dele den i to like store deler og flette de to delene perfekt, slik at kortet på toppen forblir på toppen og kortet på bunnen forblir på bunnen (se http://en.wikipedia.org/wiki/Out_shuffle)
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
