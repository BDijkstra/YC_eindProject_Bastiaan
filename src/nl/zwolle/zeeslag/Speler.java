package nl.zwolle.zeeslag;

public class Speler {

	private String naam;

	public Speler() {
		this("AI");

	}

	public Speler(String naam) {
		this.naam = naam;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	
	//als coordinaat geldig is en niet al eerder is beschoten, schiet
	public void schietOpVakje(Bord b, int x, int y) {

		if (b.checkGeldigheidCoordinaten(x, y) && !(b.vakjeArray[x][y].isBeschoten())){

		
			b.vakjeArray[x][y].setBeschoten(true);

			if (b.vakjeArray[x][y].isBevatBoot()) {
				System.out.println("Boem!");
				b.vakjeArray[x][y].o.verliesLeven();
				if (b.vakjeArray[x][y].o.isDood()){
					System.out.println("Boot gezonken");
				}
			
			} else {
				System.out.println("Plons");
			}

		}

	}
}
