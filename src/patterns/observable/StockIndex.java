package patterns.observable;

import java.util.ArrayList;

public class StockIndex implements StockListener{

	private String navn;
	private double indeks = 0;
	private ArrayList<Stock> observere = new ArrayList<Stock>();
	
//	StockIndex(String, Stock... ) - konstrukt�r som tar inn ingen, �n eller flere aksjer (Stock-objekter). Stock-parameteret defineres som et s�kalt varargs-parameter.  NB: StockIndex-objektet skal holdes oppdatert p� aksjekursene allerede fra det er instansiert. Dersom en indeks instansieres uten Stock-objekter, skal aksjeindeksen v�re 0.
	public StockIndex(String navn, Stock...stocks){
		this.navn = navn;
		for(Stock s : stocks){
			observere.add(s);
			indeks += s.getPrice();
			s.addStockListener(this);
		}
	}
	
//	void addStock(Stock) - metode for � legge til en aksjekurs i indeksen.
	public void addStock(Stock aksje){
		if(!observere.contains(aksje)){
			observere.add(aksje);
			indeks += aksje.getPrice();	
			aksje.addStockListener(this);
		}
	}
	
//	void removeStock(Stock) - metode for � fjerne en aksjekurs fra indeksen.
	public void removeStock(Stock aksje){
		if(observere.contains(aksje)){
			observere.remove(aksje);
			indeks -= aksje.getPrice();	
			aksje.removeStockListener(this);
		}
	}
	
//	double getIndex() - hentemetode for indeksen.
	public double getIndex(){
		return this.indeks;
	}

@Override
public void stockPriceChanged(Stock stock, double gammel, double ny) {
		if(observere.contains(stock)){
			observere.remove(stock);
			observere.add(stock);
			indeks += ny-gammel;
		}
	}
}