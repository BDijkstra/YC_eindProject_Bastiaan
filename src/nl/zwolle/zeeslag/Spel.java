package nl.zwolle.zeeslag;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Spel {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int x;
		int y;

		while (true) {

			System.out.println("Welkom bij Zeeslag.");
			System.out.println("Selecteer tegenstander: " + "\n1. Mens" + "\t2. Computer");
			System.out.println("Type het getal hier onder aub..");
			int input = scan.nextInt();

			switch (input) {
			case 1: spel1v1();
				break;
			case 2: // stuur weg naar te bouwen methode die mens vs computer
					// afhandeld
				break;
			}

			System.out.println("Wilt u opnieuw spelen? y/n");
			String answer = scan.next();
			if (answer.equals("n")) {
				break;
			}
			if (answer.equals("y")) {
				continue;
			} else {
				System.out.println("Tot ziens!");
				break;
			}
		}

		// Boot z = new Boot(2);

		Speler speler1 = new Speler("Speler1", 10, 10);
		speler1.nieuweBoot(2, 3, false, 1);
		speler1.nieuweBoot(6, 6, false, 1);

		Speler speler2 = new Speler("Speler2", 10, 10);
		speler2.nieuweBoot(2, 3, false, 1);
		speler2.nieuweBoot(6, 6, false, 1);

		System.out.println("Beide spelers hebben een bord van 10x10 vakjes met 2 slagschepen elk");
		while (true) {

			System.out.println("Speler 1 mag schieten, geef coordinaten aub. x?");
			int tempX = scan.nextInt();
			System.out.println("y?");
			int tempY = scan.nextInt();
			speler1.schietOpVakje(speler2.getBord(), tempX, tempY);
			System.out.println(speler2.getBord().toString());

			if (speler2.spelerHeeftVerloren()) {
				System.out.println("Alle boten van de tegenstander zijn vernietigd, u hebt gewonnen!");
				break;
			}

			System.out.println("Speler 2 mag schieten, geef coordinaten aub. x?");
			tempX = scan.nextInt();
			System.out.println("y?");
			tempY = scan.nextInt();
			speler2.schietOpVakje(speler1.getBord(), tempX, tempY);
			System.out.println(speler1.getBord().toString());

			if (speler1.spelerHeeftVerloren()) {
				System.out.println("Alle boten van de tegenstander zijn vernietigd, u hebt gewonnen!");
				break;
			}

		}

	}
	
	public static void spel1v1(){
		
	}

}
