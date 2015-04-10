package interfaces;

public class StringGridHoved {

	public static void main(String[] args) {
		StringGridImpl min = new StringGridImpl(3,1);
		min.setElement(0,0,"0,0");
		min.setElement(0,1,"0,1");
		min.setElement(1,0,"1,0");
		min.setElement(1,1,"1,1");
		min.setElement(2,1,"2,1");
		min.setElement(3,1,"3,1");
		for(String s: min){
			System.out.println(s);
		}
	}

}
