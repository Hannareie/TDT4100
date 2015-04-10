package interfaces;

public class Vararg {


	
	public static void printTall(int... i){
		for(int j : i){
			System.out.println(j);
		}
	}
	
	public static void main(String[] args) {
		printTall(1,4,3,2,5,4);
	}
}
