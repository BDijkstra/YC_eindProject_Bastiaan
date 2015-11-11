package nl.zwolle.zeeslag;

public class Speler {

	protected String naam;
	protected Bord bord;
	protected Boot[] bootArray= new Boot[5];
	protected int hoeveelheidBoten = 0;

	// Overloaded constructors met standaard waarden: Naam=AI, x=10, y=10
	// (grootte van het bord)
	public Speler() {
		this("AI");

	}

	public Speler(String naam) {
		this(naam, 10, 10);

	}

	public Speler(String naam, int xCoordinaat, int yCoordinaat) {
		bord = new Bord(xCoordinaat, yCoordinaat);
		this.naam = naam;
	}

	public Boot[] getBootArray() {
		return bootArray;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Bord getBord() {
		return bord;
	}

	// als coordinaat geldig is en niet al eerder is beschoten, schiet
	public void schietOpVakje(Bord bord, int x, int y) {
		
		//user ingegeven coordinaten worden -1 geshift zodat ze in de array passen.
//		int x = xCoordinaat-1;
//		int y = yCoordinaat-1;

		if (bord.checkGeldigheidCoordinaten(x, y) && !(bord.vakjeArray[x][y].isBeschoten())) {

			bord.vakjeArray[x][y].setBeschoten(true);

			if (bord.vakjeArray[x][y].isBevatBoot()) {
				System.out.println("Boem!");
				bord.vakjeArray[x][y].boot.verliesLeven();
				if (bord.vakjeArray[x][y].boot.isDood()) {
					System.out.println("Boot gezonken");
				}

			} else {
				System.out.println("Plons");
			}

		}

	}
	
	public void nieuweBoot(int x, int y, boolean ligging, int bootID) {
		
		Boot nieuwBoot = new Boot(bootID);
		
		if(nieuwBoot.plaatsBoot(bord, x, y, ligging)){
		//nieuwBoot.plaatsBoot(bord, x, y, ligging);
		bootArray[hoeveelheidBoten] = nieuwBoot;
		hoeveelheidBoten++;}
		else{
			//geeft foutmelding
		}
	}

	public boolean spelerHeeftVerloren() {

		int teller = 0;
		for (Boot boot : bootArray) {
			if (boot.isDood()) {
				teller++;
			}
		}
		if (teller == hoeveelheidBoten) {
			return true;
		}
		return false;
	}

}
