package encapsulation;

public class UpOrDownCounter {
	private int end;
	private int counter;
	
	public UpOrDownCounter(int start, int end){
		if (start == end){
			throw new IllegalArgumentException("Start og slutt er lik, det kan de ikke være.");
		}
		this.counter = start;
		this.end = end;
	}
	
	public int getCounter(){
		return counter;
	}
	
	public boolean count(){
		if (!(counter==end)){
			if(counter<end){
				counter += 1;
			}
			else{
				counter -= 1;
			}
		}
		return (!(counter == end));
	}

}
