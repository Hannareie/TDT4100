package interfaces;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card>{
	
	private Iterator<Card> it;
	
	public CardContainerIterator(CardContainer it){
		this.it = it.cardList().iterator();
	}

	@Override
	public boolean hasNext() {
		return it.hasNext();
	}

	@Override
	public Card next() {
		return it.next();
	}
}
