package nl.zwolle.zeeslag;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Spel {

	public static void main(String[] args) {
		
		int x;
		int y;
		
		
		
		
		
		//Boot z = new Boot(2);
		
		Speler speler1 = new Speler("Speler1",10,10);
		speler1.nieuweBoot(2, 3, false, 1);
		//speler1.nieuweBoot(6, 6, false, 1);
		
		
		Speler speler2 = new Speler("Speler2",10,10);
		speler2.nieuweBoot(2, 3, false, 1);
		//speler2.nieuweBoot(6, 6, false, 1);
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welkom bij Zeeslag.");
		System.out.println("Beide spelers hebben een bord van 10x10 vakjes met 2 slagschepen elk");
		while(true){
			
			System.out.println("Speler 1 mag schieten, geef coordinaten aub. x?");
			int tempX= scan.nextInt();
			System.out.println("y?");
			int tempY= scan.nextInt();
			speler1.schietOpVakje(speler2.getBord(),tempX, tempY);
			System.out.println(speler1.getBord().toString());
			
			if(speler2.spelerHeeftVerloren()){
				System.out.println("Alle boten van de tegenstander zijn vernietigd, u hebt gewonnen!");
				break;
			}
			
			System.out.println("Speler 2 mag schieten, geef coordinaten aub. x?");
			tempX= scan.nextInt();
			System.out.println("y?");
			tempY= scan.nextInt();
			speler2.schietOpVakje(speler1.getBord(),tempX, tempY);
			System.out.println(speler2.getBord().toString());
			
			if(speler1.spelerHeeftVerloren()){
				System.out.println("Alle boten van de tegenstander zijn vernietigd, u hebt gewonnen!");
				break;
			}
			
			
		}

		
		
		
		
		/* 
		System.out.println("Welkom bij Zeeslag.");
		System.out.println("Hoe groot moet het bord zijn? x?");
		int bordX= scan.nextInt();
		System.out.println("y?");
		int bordY= scan.nextInt();
		Speler speler = new Speler("Henk",bordX,bordY);
		System.out.println("plaats een boot op het bord");
		for(String naam: Boot.bootNamen){
			System.out.println(naam);
		}
		
		
		z.plaatsBoot(speler.getBord(), 6, 6, false);	
		
		while(true){
		System.out.println("op welk vakje wilt u schieten? x?");
		x=scan.nextInt();
		System.out.println("y?");
		y=scan.nextInt();
		
		speler.schietOpVakje(x, y);
		System.out.println(speler.getBord().toString());
		System.out.println("u schoot op vakje: "+x+"x"+y);
		
		 }*/
		

	}

}
