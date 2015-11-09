package nl.zwolle.zeeslag;

public class Vakje {
	private boolean bevatBoot;
	private boolean beschoten;

	public boolean isBevatBoot() {
		return bevatBoot;
	}

	public void setBevatBoot(boolean bevatBoot) {
		this.bevatBoot = bevatBoot;
	}

	public boolean isBeschoten() {
		return beschoten;
	}

	public void setBeschoten(boolean beschoten) {
		this.beschoten = beschoten;
	}

	public boolean checkOfBootNogLeeft() {

		// haalt de lengte van het bootobject op en trekt daar 1 van af. Als de
		// lengte van de boot 0 is, word deze op 'dood' gezet.
		if (bevatBoot) {
			if (beschoten) {
				// if(boot.getLengte()==0){
				// int veranderLengte =boot.getLengte() -1;
				// boot.setLengte(veranderLengte);
				return false;
			}
		}

		return true;
	}
}
