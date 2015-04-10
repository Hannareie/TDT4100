package interfaces;

import java.util.ArrayList;

public interface CardContainer {

//	getCardCount() - returnerer antall kort som dette objektet inneholder
	public int getCardCount();
	
//	getCard(int n) - returnerer kort nr. n i dette objektet
	public Card getCard(int n);
	
	public ArrayList<Card> cardList();
}
