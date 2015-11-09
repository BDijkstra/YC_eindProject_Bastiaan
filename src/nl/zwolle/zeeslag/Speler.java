package nl.zwolle.zeeslag;

public class Speler {

	private String naam;
	
	
	public Speler(){
		this("AI");
		
	}
	
	public Speler(String naam){
		this.naam = naam;
	}
	
	public void schietOpVakje(Bord b, int x, int y){
	
		
		if(b.checkGeldigheidCoordinaten(x, y)){
			
		b.vakjeArray[x][y].setBeschoten(true);
		
		
		if (b.vakjeArray[x][y].isBevatBoot()){
			System.out.println("Boem!");
		} else{
			System.out.println("Plons");
		}
		
		
		
		
		
	}
	
	
}
