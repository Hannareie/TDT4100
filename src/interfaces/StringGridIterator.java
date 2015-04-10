package interfaces;

import java.util.Iterator;

public class StringGridIterator implements Iterator<String> {

	private StringGrid grid;
	private int rad;
	private int kolonne;
	private boolean rowMajor;
	
//	StringGridIterator(StringGrid, boolean) - konstrukt�r som tar inn StringGrid-objektet som StringGridIterator-klassen skal iterere over i tillegg til en logisk verdi som angir om iterasjonen skal v�re bortover f�rst (rowMajor=true) eller nedover f�rst (rowMajor=false).
	public StringGridIterator(StringGrid grid, boolean rowMajor){
		this.grid = grid;
		this.rowMajor = rowMajor;
		this.rad = 0;
		this.kolonne = 0;
	}

//	boolean hasNext() - returnerer true s� lenge det er flere String-objekter igjen i StringGrid-objektet som ikke enn� er blitt iterert over (mao. sjekk om du har kommet til siste rute i rutenettet).
	@Override
	public boolean hasNext() {
		if(rowMajor){
			if(this.rad == this.grid.getRowCount()-1 && this.kolonne == this.grid.getColumnCount()){ return false;}
			else{ return true;}			
		}
		else{
			if(this.rad == this.grid.getRowCount() && this.kolonne == this.grid.getColumnCount()-1){ return false;}
			else{ return true;}			
		}
	}

//	String next() - returnerer det neste String-objektet i rutenettet. Hvilken String som er den neste, avhenger av hvordan rutenettet skal itereres (mao. om rowMajor=true eller rowMajor=false).
	@Override
	public String next() {
		if(!rowMajor){
			if(this.rad != this.grid.getRowCount()){
				rad ++;
				return grid.getElement(rad-1, kolonne);
			}
			else{
				rad = 1;
				kolonne ++;
				return grid.getElement(rad-1, kolonne);
			}
		}
		else{
			if(this.kolonne != this.grid.getColumnCount()){
				kolonne ++;
				return grid.getElement(rad, kolonne-1);
			}
			else{
				kolonne = 1;
				rad ++;
				return grid.getElement(rad, kolonne-1);
			}			
		}
	}
	
//	void remove() - denne metoden skal bare kaste et unntak av typen UnsupportedOperationException siden det ikke skal v�re mulig � fjerne String-objekter fra rutenettet.
	public void remove(){
		throw new UnsupportedOperationException("Gj�r dette p� en annen m�te.");
	}
}
