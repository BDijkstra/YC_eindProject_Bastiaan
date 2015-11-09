package nl.zwolle.zeeslag;


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
	
	private int lengte;
	private boolean geraakt;
	
	
	private Type type;
	
	public Boot(Type type){
		this.type = type;
		lengte = type.getLengte();
	}

	

	

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

}
