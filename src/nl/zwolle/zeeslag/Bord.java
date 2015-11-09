package nl.zwolle.zeeslag;



public class Bord {
	
	
	// bord instance variabelen
	private int bordBreedte;
	private int bordLengte;
	Vakje[][] vakjeArray;
	
	
	// bord constructor, maak bord dmv arraylist
	public Bord(int x, int y){
		
				
		bordBreedte = x;
		bordLengte =y;		
		vakjeArray = new Vakje[x][y];
		
		//Vul de ArrayList met Vakjes.
		for (int ix=0; ix< x; ix++){
			
			for (int iy=0; iy< y; iy++){
				vakjeArray[ix][iy] = new Vakje();
				
			}
		}
		
		
	}
	// kijk of de coordinaat geldig is
	public boolean checkGeldigheidCoordinaten(int x, int y){
		if (x>bordBreedte || y>bordLengte ){
			return false;
		}
				
		return true;
		
		
		
		
	}
	
}
