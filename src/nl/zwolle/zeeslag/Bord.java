package nl.zwolle.zeeslag;

public class Bord {

	// bord instance variabelen
	private int bordBreedte;
	private int bordLengte;
	// getters and setters

	public int getBordBreedte() {
		return bordBreedte;
	}

	public void setBordBreedte(int bordBreedte) {
		this.bordBreedte = bordBreedte;
	}

	public int getBordLengte() {
		return bordLengte;
	}

	public void setBordLengte(int bordLengte) {
		this.bordLengte = bordLengte;
	}

	Vakje[][] vakjeArray;

	// bord constructor, maak bord dmv arraylist
	public Bord(int x, int y) {

		bordBreedte = x;
		bordLengte = y;
		vakjeArray = new Vakje[x][y];

		// Vul de ArrayList met Vakjes.
		for (int ix = x - 1; ix >= 0; ix--) {

			for (int iy = y - 1; iy >= 0; iy--) {

				vakjeArray[ix][iy] = new Vakje();

			}
		}

	}

	// kijk of de coordinaat geldig is, dus binnen de het veld valt.
	public boolean checkGeldigheidCoordinaten(int x, int y) {
		if (x > bordBreedte || y > bordLengte) {
			return false;
		}

		return true;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int i = bordBreedte - 1; i >= 0; i--) {
			Vakje[] losVakjeArray = vakjeArray[i];
			for (int j = 0; j < bordLengte; j++) {
				Vakje vakje = losVakjeArray[j];
				sb.append(vakje.toString());
				sb.append(" ");
			}
			sb.append("\n");
		}

		String output = sb.toString();

		return output;
	}

}
