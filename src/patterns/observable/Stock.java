package patterns.observable;

import java.util.ArrayList;
import java.util.Collection;

public class Stock {

	private String ticker;
	private double price;
	private Collection<StockListener> lytterListe;
	
//	Stock(String, double) - en konstruktør som tar inn en aksjekode (ticker) og en aksjekurs.
	public Stock(String ticker, double price){
		this.ticker = ticker;
		this.price = price;
		this.lytterListe = new ArrayList<StockListener>();
	}

//	String getTicker() - metode for å hente aksjekoden.
	public String getTicker() {
		return this.ticker;
	}

//	double getPrice() - metode for å hente aksjeprisen.
	public double getPrice() {
		return this.price;
	}

//	void setPrice(double) - endringsmetode for aksjeprisen. Dersom aksjekursen er negativ eller lik null, skal metoden utløse en IllegalArgumentException.
	public void setPrice(double newPrice) {
		if(price <= 0){
			throw new IllegalArgumentException("aksjekursen må være positiv");
		}
		for(StockListener lytter : lytterListe){
			lytter.stockPriceChanged(this, price, newPrice);
		}
		this.price = newPrice;
	}
	
//	void addStockListener(StockListener) - metode for å legge til nye observatører.
	public void addStockListener(StockListener lytter){
		lytterListe.add(lytter);
	}
	
//	void removeStockListener(StockListener) - metode for å fjerne observatører.
	public void removeStockListener(StockListener lytter){
		lytterListe.remove(lytter);
	}
}
