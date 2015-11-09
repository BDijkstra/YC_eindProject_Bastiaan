package nl.zwolle.zeeslag;

//Een enum klasse die elk type schip een vaste lengte geeft
enum Type {Vliegdekschip(5),Slagschip(4),Onderzeer(3), Torpedojager(3), Patrouilleship(2);
	private int lengte;

	Type (int lengte){
		this.lengte=lengte;
	}

	public int getLengte() {
		return lengte;
	}

}


public class Boot {

	// static variabelen
	private static int idCounter = 1;
	
	//instance variables
	private int levens;
	private int lengte;
	private boolean dood;
	
	private boolean ligging; // true = horizontaal, false = verticaal
	private int id;

	// coordinaten van de gehele boot
	private int xMin;
	private int xMax;
	private int yMin;
	private int yMax;




	private Type type;


	// Constructor die de lengte vanuit de Type Enum op de lengte van het boot object set.
	public Boot(Type type){
		this.type = type;
		lengte = type.getLengte();
		setLevens(lengte);
		
		this.id = idCounter;
		idCounter++;
		
	}



	//getters en setters

	public int getLengte() {
		return lengte;
	}

	public void setLengte(int lengte) {
		this.lengte = lengte;
	}

	public int getLevens() {
		return levens;
	}

	public void setLevens(int levens) {
		this.levens = levens;
	}
	public boolean isDood() {
		return dood;
	}



	public void setDood(boolean dood) {
		this.dood = dood;
	}



	//plaats boot
	public void plaatsBoot(Bord b, int x, int y){

		boolean legalePlaats = true;
		// als alle velden nog geen boten bevatten plaats de boot

		// bereken alle coordinaten
		xMin = x;
		yMin = y;

		if (ligging){
			xMax = x+ lengte;
			yMax = y;

		}else{
			yMax = y+ lengte;
			xMax = x;
		}

		// bekijk of er al boten zijn op die posities
		// en of de boot niet buiten het veld valt.

		for (int ix = xMin; ix<=xMax; ix++){
			for (int iy = yMin; iy<=yMax; iy++){

				if (b.vakjeArray[ix][iy].isBevatBoot() || !(b.checkGeldigheidCoordinaten(ix, iy))){
					legalePlaats = false;
					break;
				}
			}
		}
		// als dat niet zo is, plaats boot op elk vakje
		if (legalePlaats){
			
			for (int ix = xMin; ix<=xMax; ix++){
				for (int iy = yMin; iy<=yMax; iy++){

					b.vakjeArray[ix][iy].setBevatBoot(true, this);

				}
			}
		}
	}
	
	public void verliesLeven(){
		levens--;
		if (levens <= 0){
			dood = true;
		}
	}



	


	
	
	

}


