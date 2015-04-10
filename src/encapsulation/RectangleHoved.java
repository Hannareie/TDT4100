package encapsulation;

import java.util.Scanner;


public class RectangleHoved {


	static Rectangle min;
	static Scanner scanner;
	
	
	static void init(){
		min = new Rectangle();
		scanner = new Scanner(System.in);
	}
	
	static void run(){
		while (scanner.hasNextLine()){
			String[] token = scanner.nextLine().split(" ");
			if(token[0].equals("getMinX")){
				System.out.println(min.getMinX());
			}
			if(token[0].equals("getMinY")){
				System.out.println(min.getMinY());
			}
			if(token[0].equals("getMaxX")){
				System.out.println(min.getMaxX());
			}
			if(token[0].equals("getMaxY")){
				System.out.println(min.getMaxY());
			}
			if(token[0].equals("getWidth")){
				System.out.println(min.getWidth());
			}
			if(token[0].equals("getHeight")){
				System.out.println(min.getHeight());
			}
			if(token[0].equals("isEmpty")){
				System.out.println(min.isEmpty());
			}
			if(token[0].equals("contains")){
				int tall1 = Integer.parseInt(token[1]);
				int tall2 = Integer.parseInt(token[2]);
				System.out.println(min.contains(tall1, tall2));
			}
			if(token[0].equals("add")){
				int tall1 = Integer.parseInt(token[1]);
				int tall2 = Integer.parseInt(token[2]);
				System.out.println(min.add(tall1, tall2));
			}
		}
	}
	public static void main(String[] args){
		init();
		run();
	}
}
