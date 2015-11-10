package nl.zwolle.zeeslag;

import java.util.Scanner;

public class Spel {

	public static void main(String[] args) {
		
		int x;
		int y;
		
		
		
		
		//Bord bord = new Bord(x,y);
		Boot z = new Boot(Type.Onderzeer);
		
		

		
		
		
		Scanner scan = new Scanner(System.in);
		 
		System.out.println("Welkom bij Zeeslag.");
		System.out.println("Hoe groot moet het bord zijn? x?");
		int bordX= scan.nextInt();
		System.out.println("y?");
		int bordY= scan.nextInt();
		Speler speler = new Speler("Henk",bordX,bordY);
		z.plaatsBoot(speler.getBord(), 6, 6, false);	
		
		while(true){
		System.out.println("op welk vakje wilt u schieten? x?");
		x=scan.nextInt();
		System.out.println("y?");
		y=scan.nextInt();
		
		speler.schietOpVakje(x, y);
		System.out.println(speler.getBord().toString());
		System.out.println("u schoot op vakje: "+x+"x"+y);
		
		 }
		

	}

}
