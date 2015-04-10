package encapsulation;

import java.util.Scanner;

public class NimHoved {

	static Nim min;
	static Scanner scanner;
	
	private static void init(){
		min = new Nim();
		scanner = new Scanner(System.in);
	}
	
	private static void run(){
		while(scanner.hasNextLine()){
			String[] token = scanner.nextLine().split(" ");
			if (token[0].equals("removePieces")){
				int tall1 = Integer.parseInt(token[1]);
				int tall2 = Integer.parseInt(token[2]);
				min.removePieces(tall1, tall2);
			}
			else if(token[0].equals("isValidMove")){
				int tall1 = Integer.parseInt(token[1]);
				int tall2 = Integer.parseInt(token[2]);
				System.out.println(min.isValidMove(tall1, tall2));
			}
			else if(token[0].equals("isGameOver")){
				System.out.println(min.isGameOver());
			}
			else if(token[0].equals("getPile")){
				int tall1 = Integer.parseInt(token[1]);
				System.out.println(min.getPile(tall1));
			}
			else if(token[0].equals("toString")){
				System.out.println(min.toString());
			}
		}
	}
	
	public static void main(String[] args){
		init();
		run();
	}
}
