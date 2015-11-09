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

	//instance variables
	private int lengte;
	private boolean geraakt;
	private boolean ligging; // true = horizontaal, false = verticaal

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
	}



	//getters en setters

	public int getLengte() {
		return lengte;
	}

	public void setLengte(int lengte) {
		this.lengte = lengte;
	}

	public boolean isGeraakt() {
		return geraakt;
	}

	public void setGeraakt(boolean geraakt) {
		this.geraakt = geraakt;
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

		for (int ix = x; ix<=xMax; ix++){
			for (int iy = y; iy<=yMax; iy++){

				if (b.vakjeArray[ix][iy].isBevatBoot()){
					legalePlaats = false;
					break;
				}


			}


		}
		if (legalePlaats){


			// plaats boot op elk vakje
			for (int ix = x; ix<=xMax; ix++){
				for (int iy = y; iy<=yMax; iy++){

					b.vakjeArray[ix][iy].isBevatBoot();

				}


			}


		}
	}

}


