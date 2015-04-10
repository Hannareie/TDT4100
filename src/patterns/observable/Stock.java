package patterns.observable;

import java.util.ArrayList;
import java.util.Collection;

public class Stock {

	private String ticker;
	private double price;
	private Collection<StockListener> lytterListe;
	
//	Stock(String, double) - en konstrukt�r som tar inn en aksjekode (ticker) og en aksjekurs.
	public Stock(String ticker, double price){
		this.ticker = ticker;
		this.price = price;
		this.lytterListe = new ArrayList<StockListener>();
	}

//	String getTicker() - metode for � hente aksjekoden.
	public String getTicker() {
		return this.ticker;
	}

//	double getPrice() - metode for � hente aksjeprisen.
	public double getPrice() {
		return this.price;
	}

//	void setPrice(double) - endringsmetode for aksjeprisen. Dersom aksjekursen er negativ eller lik null, skal metoden utl�se en IllegalArgumentException.
	public void setPrice(double newPrice) {
		if(price <= 0){
			throw new IllegalArgumentException("aksjekursen m� v�re positiv");
		}
		for(StockListener lytter : lytterListe){
			lytter.stockPriceChanged(this, price, newPrice);
		}
		this.price = newPrice;
	}
	
//	void addStockListener(StockListener) - metode for � legge til nye observat�rer.
	public void addStockListener(StockListener lytter){
		lytterListe.add(lytter);
	}
	
//	void removeStockListener(StockListener) - metode for � fjerne observat�rer.
	public void removeStockListener(StockListener lytter){
		lytterListe.remove(lytter);
	}
}
