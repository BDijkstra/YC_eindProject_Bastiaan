package nl.zwolle.zeeslag;

import java.util.Scanner;

public class Spel {

	public static void main(String[] args) {
		Speler speler = new Speler();
		
		int x=10;
		int y =10;
		
		Bord bord = new Bord(x,y);
		Boot z = new Boot(Type.Onderzeer);
		z.plaatsBoot(bord, 6, 6);	
		
		
		
		Scanner scan = new Scanner(System.in);
		 while(true){
		System.out.println("Welkom bij Zeeslag.");
		System.out.println("er is een bord van 10x10 gegenereerd, op welk vakje wilt u schieten? x?");
		x=scan.nextInt();
		System.out.println("y?");
		y=scan.nextInt();
		
		speler.schietOpVakje(bord, x, y);
		
		System.out.println("u schoot op vakje: "+x+"x"+y);
		 }
		

	}

}
