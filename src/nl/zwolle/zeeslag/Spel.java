package nl.zwolle.zeeslag;

import java.util.Scanner;

public class Spel {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Speler test = new Speler();
		test.nieuweBoot(4, 4, true, 2);
		System.out.println(test.bord.toString(true));

		while (true) {

			System.out.println("Welkom bij Zeeslag.");
			System.out.println("Selecteer tegenstander: " + "\n1. Mens" + "\t2. Computer");
			System.out.println("Type het getal hier onder aub..");
			int input = scan.nextInt();

			switch (input) {
			case 1:
				spel1v1();
				break;
			case 2:
				spelMensVsComputer();
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
		
	}

	public static void spel1v1() {
		Scanner scan = new Scanner(System.in);
		int x = 0;
		int y = 0;
		int hoeveelheidBoten = 0;

		System.out.println("1v1 spel geselecteerd, Hoe groot moet het bord zijn? x?");
		x = scan.nextInt();
		System.out.println("y?");
		y = scan.nextInt();
		System.out.println("Met hoeveel boten moet het spel gespeeld worden? (Max 5)");
		hoeveelheidBoten = scan.nextInt();
		Speler speler1 = new Speler("Speler1", x, y);
		Speler speler2 = new Speler("Speler2", x, y);

		System.out.println("Speler 1 mag nu boten plaatsen.");

		spelerPlaatstBoten(speler1, hoeveelheidBoten);

		System.out.println("Speler 2 mag nu boten plaatsen.");

		spelerPlaatstBoten(speler2, hoeveelheidBoten);

		while (true) {
			System.out.println("Speler 1 mag schieten, geef coordinaten aub. x?");
			int tempX = scan.nextInt();
			System.out.println("y?");
			int tempY = scan.nextInt();
			speler1.schietOpVakje(speler2.getBord(), tempX, tempY);
			System.out.println(speler2.getBord().toString(false));

			if (speler2.spelerHeeftVerloren()) {
				System.out.println("Alle boten van de tegenstander zijn vernietigd, u hebt gewonnen!");
				break;
			}

			System.out.println("Speler 2 mag schieten, geef coordinaten aub. x?");
			tempX = scan.nextInt();
			System.out.println("y?");
			tempY = scan.nextInt();
			speler2.schietOpVakje(speler1.getBord(), tempX, tempY);
			System.out.println(speler1.getBord().toString(false));

			if (speler1.spelerHeeftVerloren()) {
				System.out.println("Alle boten van de tegenstander zijn vernietigd, u hebt gewonnen!");
				break;
			}
		}
		
	}

	public static void spelMensVsComputer() {
		Scanner scan = new Scanner(System.in);
		int x = 0;
		int y = 0;
		int hoeveelheidBoten = 0;

		System.out.println("vs Computer geselecteerd, Hoe groot moet het bord zijn? x?");
		x = scan.nextInt();
		System.out.println("y?");
		y = scan.nextInt();
		System.out.println("Met hoeveel boten moet het spel gespeeld worden? (Max 5)");
		hoeveelheidBoten = scan.nextInt();
		Speler speler1 = new Speler("Speler1", x, y);
		Computer computer = new Computer(x, y);

		computerPlaatstBoten(computer, hoeveelheidBoten, x, y);

		spelerPlaatstBoten(speler1, hoeveelheidBoten);

		while (true) {
			System.out.println("Speler 1 mag schieten, geef coordinaten aub. x?");
			int tempX = scan.nextInt();
			System.out.println("y?");
			int tempY = scan.nextInt();
			speler1.schietOpVakje(computer.getBord(), tempX, tempY);
			System.out.println(computer.getBord().toString(false));

			if (computer.spelerHeeftVerloren()) {
				System.out.println("Alle boten van de tegenstander zijn vernietigd, u hebt gewonnen!");
				break;
			}

			if (speler1.spelerHeeftVerloren()) {
				System.out.println("De computer heeft al uw boten vernietigd, u hebt verloren...");
				break;
			}
		}
		

	}

	public static void computerPlaatstBoten(Computer computer, int hoeveelheidBoten, int maxBordX, int maxBordY) {
		int x = 0;
		int y = 0;
		int richting = 0;
		boolean ligging = false;

		for (int i = 0; i < hoeveelheidBoten; i++) {

			while (true) {
				x = (int) (Math.random() * maxBordX);
				y = (int) (Math.random() * maxBordY);
				richting = (int) (Math.random() * 2);

				computer.nieuweBoot(x, y, ligging, i);
				switch (richting) {
				case 0:
					ligging = true;
					break;
				case 1:
					ligging = false;
					break;
				}
				if (computer.nieuweBoot(x, y, ligging, i)) {

					break;
				} else {

				}
			}
		}
	}

	// laat de speler een variabel aantal boten plaatsen op het bord
	public static void spelerPlaatstBoten(Speler speler, int hoeveelheidBoten) {
		Scanner scan = new Scanner(System.in);
		int x = 0;
		int y = 0;
		for (int i = 0; i < hoeveelheidBoten; i++) {

			while (true) {
				System.out.println("Bord van " + speler.getNaam() + ": ");
				System.out.println(speler.bord.toString(true));

				System.out.println("Plaats een boot: een " + Boot.bootNamen[i] + " met lengte " + Boot.bootLengten[i]);
				System.out.println("Wat is de startpositie?");
				System.out.println("x?");
				x = scan.nextInt();
				System.out.println("y?");
				y = scan.nextInt();
				System.out.println("Wat is de ligging?\n" + " 1: naar rechts vanaf startpunt\n"
						+ "2: naar beneden vanaf startpunt");

				int richting = scan.nextInt();
				boolean ligging = false;
				switch (richting) {
				case 1:
					ligging = true;
					break;
				case 2:
					ligging = false;
					break;
				}

				if (speler.nieuweBoot(x, y, ligging, i)) {
					System.out.println("Boot is geplaatst.");
					break;
				} else {
					System.out.println("Ongeldige plaats voor deze boot, probeer opnieuw..");
				}

			}
			
		}
	}
	
}
