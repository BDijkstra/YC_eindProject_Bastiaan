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
	public void plaatsBoot(int x, int y){
	
		// als alle velden nog geen boten bevatten plaats de boot
		
		// bereken all coordinaten
		
		// bekijk of er al boten zijn
		
		
		
		
	}

}
