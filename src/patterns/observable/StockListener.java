package patterns.observable;

public interface StockListener {

	void stockPriceChanged(Stock stock, double gammel, double ny);
//	void stockPriceChanged(Stock, double, double)  - lyttermetode for å holde lytteren oppdatert på aksjekursen. Metoden skal ta inn et Stock-objekt, samt gammel og ny pris. Alle lyttere må implementere denne metoden.
}
