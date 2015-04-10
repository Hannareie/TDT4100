package objectstructures;

public class PersonHoved {

	public static void main(String[] args) {
		Person erik = new Person("Erik", 'M');
		Person gunnar = new Person("Gunnar",'M');
		System.out.println(erik.getName());
		gunnar.setFather(erik);
		System.out.println(gunnar.getFather());
		System.out.println(erik.getChild(0));
	}
}
