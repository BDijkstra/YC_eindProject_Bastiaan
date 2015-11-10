package nl.zwolle.zeeslag;

public class Speler {

	private String naam;
	protected Bord bord;
	private Boot[] bootArray;
	private int hoeveelheidBoten=-1;

	// Overloaded constructors met standaard waarden: Naam=AI, x=10, y=10 (grootte van het bord)
	public Speler() {
		this("AI");

	}

	public Speler(String naam) {
		this(naam,10,10);
		
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
	public void schietOpVakje(int x, int y) {

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
	public void nieuweBoot(int x, int y, boolean ligging, int bootID){
		Boot nieuwBoot = new Boot(bootID);
		nieuwBoot.plaatsBoot(bord, x, y, ligging);
		bootArray[hoeveelheidBoten+1]=nieuwBoot;
	}
	
	
}
