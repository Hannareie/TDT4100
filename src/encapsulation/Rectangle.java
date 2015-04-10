package encapsulation;

public class Rectangle {
	
	private int minX = 0;
	private int minY = 0;
	private int maxX = 0;
	private int maxY = 0;
	
	public Rectangle(){
		
	}
	
	public Rectangle(int minX, int minY, int maxX, int maxY){
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
//	int getMinX() og int getMinY() - returnerer henholdsvis x- og y-koordinatene til punktet med lavest x,y-verdier som er inneholdt i dette rektanglet. Dersom dette rektanglet er tomt, så skal 0 returneres.
	public int getMinX(){
		return this.minX;
	}
	
	public int getMinY(){
		return this.minY;
	}
	
//	int getMaxX() og int getMaxY() - returnerer henholdsvis x- og y-koordinatene til punktet med høyest x,y-verdier som er inneholdt i dette rektanglet. Dersom dette rektanglet er tomt, så skal 0 returneres.
	public int getMaxX(){
		return this.maxX;
	}
	
	public int getMaxY(){
		return this.maxY;
	}
	
//	int getWidth() og int getHeight() - returnerer henholdsvis bredden og høyden til rektanglet. Begge skal returnere 0, dersom dette rektanglet er tomt.
	public int getWidth(){
		return(this.maxY - this.minY);
	}
	
	public int getHeight(){
		return(this.maxX - this.minX);
	}
	
//	boolean isEmpty() - returnerer true om rektanglet er tomt, dvs. om bredden og/eller høyden er 0.
	public boolean isEmpty(){
		if(getWidth() == 0 && getHeight() == 0){
			return true;
		}
		return false;
	}
	
//	boolean contains(int x, int y) - returnerer true om punktet x,y er inneholdt i dette rektanglet, og false ellers.
	public boolean contains(int x, int y){
		if((minX^2) < (x^2) && (minY^2) < (y^2) && (maxX^2) > (x^2) && (maxY^2) > (y^2)){
			return true;
		}
		return false;
	}
	
//	boolean contains(Rectangle rect) - returnerer true om hele rect, dvs. alle punktene i rect er inneholdt i dette rektanglet, og false ellers. Dersom rect er tomt, så skal false returneres.
	public boolean contains(Rectangle rect){
		if(contains(rect.minX, rect.minY) && contains(rect.maxX, rect.maxY)){
			return true;
		}
		return false;
	}
	
//	boolean add(int x, int y) - utvider (om nødvendig) dette rektanglet slik at det (akkurat) inneholder punktet x,y. Etter kallet skal altså contains(x, y) altså returnere true. Returnerer true om dette rektanglet faktisk ble endret, ellers false.
	public boolean add(int x, int y){
		if(contains(x, y)){
			return false;
		}
		else{
			if((minX^2) > (x^2)){
				minX = x;
			}
			if((minY^2) > (y^2)){
				minY = y;
			}
			if((maxX^2) < (x^2)){
				maxX = x;
			}
			if((maxY^2) < (y^2)){
				maxY = y;
			}
			return true;
		}
	}
	
//	boolean add(Rectangle rect) - utvider (om nødvendig) dette rektanglet slik at det (akkurat) inneholder hele rect-argumentet. Returnerer true om dette rektanglet faktisk ble endret, ellers false. Dersom rect er tomt, så skal dette rektanglet ikke endres.
	public boolean add(Rectangle rect){
		if(contains(rect)){
			return false;
		}
		else{
			if(minX > rect.minX){
				minX = rect.minX;
			}
			if(minY > rect.minY){
				minY = rect.minY;
			}
			if(maxX < rect.maxX){
				maxX = rect.maxX;
			}
			if(maxY < rect.maxY){
				maxY = rect.maxY;
			}
		return true;
		}
	}
	
//	Rectangle union(Rectangle rect) - returnerer et nytt Rectangle-objekt som tilsvarer kombinasjonen av dette rektanglet og rect-argumentet. Alle punktene som finnes i ett av rektanglene skal altså være inneholdt i rektanglet som returneres.
	public Rectangle union(Rectangle rect){
		int lavX = minX;
		int lavY = minY;
		int hoyX = maxX;
		int hoyY = maxY;
		if(minX > rect.minX){
			lavX = rect.minX;
		}
		if(minY > rect.minY){
			lavY = rect.minY;
		}
		if(maxX < rect.maxX){
			hoyX = rect.maxX;
		}
		if(maxY < rect.maxY){
			hoyY = rect.maxY;
		}
		Rectangle temp = new Rectangle(lavX, lavY, hoyX, hoyY);
		return temp;
	}

}