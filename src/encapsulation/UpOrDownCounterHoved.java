package encapsulation;


import java.util.Scanner;


public class UpOrDownCounterHoved {

	static UpOrDownCounter min;
	static Scanner scanner;
	
	static void init(){
		scanner = new Scanner(System.in);
	}
	
	static void run(){
		while(scanner.hasNextLine()){
			String[] token = scanner.nextLine().split(" ");
			if(token[0].equals("UpOrDownCounter")){
				int tall1 = Integer.parseInt(token[1]);
				int tall2 = Integer.parseInt(token[2]);
				min = new UpOrDownCounter(tall1, tall2);
			}
			else if(token[0].equals("getCounter")){
				System.out.println(min.getCounter());
			}
			else if(token[0].equals("count")){
				System.out.println(min.count());
			}
		}
	}
	
	public static void main(String[] args){
		init();
		run();
	}

}
