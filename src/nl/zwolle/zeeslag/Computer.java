package nl.zwolle.zeeslag;

public class Computer extends Speler {

	boolean shotSucceeded = false;
	int hitCoordinateX = -1;
	int hitCoordinateY = -1;
	boolean secondHit = false;
	boolean shootingPosition; // true = horizontaal, false = verticaal
	boolean deltaDirection; // true = naar rechts of boven, false = naar links of onder
	int computerX = 0;
	int computerY = 0;
	int rangeFromInitialHit =2;

	// overloaded method from Speler
	public void schietOpVakje(Bord b) {



		//check whether previous shot was a hit and continue to targeted shooting
		if (hitCoordinateX >= 0){
			targetedShot(b);

		}else{


			// else shoot at random coordinates, until the computer shot at a field that hasn't already been shot
			do{


				computerX = (int) (Math.random() * b.getBordBreedte());
				computerY = (int) (Math.random() * b.getBordLengte());



				if (b.checkGeldigheidCoordinaten(computerX, computerY) && !(b.vakjeArray[computerX][computerY].isBeschoten())){

					b.vakjeArray[computerX][computerY].setBeschoten(true);
					shotSucceeded =true;

					if (b.vakjeArray[computerX][computerY].isBevatBoot()) {
						System.out.println("Boem!");
						b.vakjeArray[computerX][computerY].boot.verliesLeven();
						hitCoordinateX = computerX;
						hitCoordinateY = computerY;
						if (b.vakjeArray[computerX][computerY].boot.isDood()){
							hitCoordinateX = -1;
							hitCoordinateY = -1;
							System.out.println("Boot gezonken");
						}

					} else {
						System.out.println("Plons");
					}
				}

			}while(!shotSucceeded);
			shotSucceeded = false;
		}
	}



	public void targetedShot(Bord b){

		if(secondHit == true){
			continuedTargetedShot(b);
		} else{



			do{

				//shoot at random field around previous hit coordinate

				// determine whether x or y is changed
				double randomizer = Math.random();

				if (randomizer>=0.0){
					computerX = hitCoordinateX +1;
					shootingPosition = true;
				} else if
				(randomizer>=0.25){
					computerX = hitCoordinateX -1;
					shootingPosition = true;
				} else if
				(randomizer>=0.50){
					computerX = hitCoordinateY +1;
					shootingPosition = false;
				} else if
				(randomizer>=0.75){
					computerX = hitCoordinateY -1;
					shootingPosition = false;
				}


				// check whether this coordinate is valid	


				if (b.checkGeldigheidCoordinaten(computerX, computerY) && !(b.vakjeArray[computerX][computerY].isBeschoten())){

					b.vakjeArray[computerX][computerY].setBeschoten(true);
					shotSucceeded =true;

					if (b.vakjeArray[computerX][computerY].isBevatBoot()) {
						b.vakjeArray[computerX][computerY].boot.verliesLeven();
						secondHit = true;


						System.out.println("Boem!");
						if (b.vakjeArray[computerX][computerY].boot.isDood()){
							hitCoordinateX = -1;
							hitCoordinateY = -1;
							secondHit = false;
							System.out.println("Boot gezonken");
						}

					} else {
						System.out.println("Plons");
						secondHit = false;
					}
				}

			}while(!shotSucceeded);
			shotSucceeded = false;
		}
	}



	public void continuedTargetedShot(Bord b){


		if(shootingPosition == true){
			if(deltaDirection == true){
				shootRightOfX(b);	
			} else if(deltaDirection == false){
				shootLeftOfX(b);
			}
		} else if(shootingPosition == false){
			if(deltaDirection == true){
				shootAboveofY(b);
			} else if(deltaDirection == false){
				shootBelowOfY(b);
			}
		}


	}


	public void shootRightOfX(Bord b){

		computerX = hitCoordinateX + rangeFromInitialHit; //+ for right or up, - for left or down
		computerY = hitCoordinateY;


		if (!b.checkGeldigheidCoordinaten(computerX, computerY) || b.vakjeArray[computerX][computerY].isBeschoten()){

			deltaDirection = false; // turn shootingposition around
			rangeFromInitialHit =1; // reset 
			shootLeftOfX(b);

		} else if (b.vakjeArray[computerX][computerY].isBevatBoot()){

			b.vakjeArray[computerX][computerY].boot.verliesLeven();
			System.out.println("Boem!");
			rangeFromInitialHit += 1;

			if (b.vakjeArray[computerX][computerY].boot.isDood()){
				hitCoordinateX = -1;
				hitCoordinateY = -1;
				secondHit = false;
				rangeFromInitialHit =2; ///
				System.out.println("Boot gezonken");
			}
		} else { // als mis

			deltaDirection = false;
			rangeFromInitialHit =1;
			System.out.println("Plons");
		}

	}



	private void shootLeftOfX(Bord b) {
		computerX = hitCoordinateX - rangeFromInitialHit; //+ for right or up, - for left or down
		computerY = hitCoordinateY;


		if (!b.checkGeldigheidCoordinaten(computerX, computerY) || b.vakjeArray[computerX][computerY].isBeschoten()){

			deltaDirection = true; // turn shootingposition around
			rangeFromInitialHit =1; // reset 
			shootLeftOfX(b);

		} else if (b.vakjeArray[computerX][computerY].isBevatBoot()){

			b.vakjeArray[computerX][computerY].boot.verliesLeven();
			System.out.println("Boem!");
			rangeFromInitialHit += 1;

			if (b.vakjeArray[computerX][computerY].boot.isDood()){
				hitCoordinateX = -1;
				hitCoordinateY = -1;
				secondHit = false;
				rangeFromInitialHit =2;
				System.out.println("Boot gezonken");
			}
		} else { // als mis

			deltaDirection = true;
			rangeFromInitialHit =1;
			System.out.println("Plons");
		}

	}

	public void shootAboveofY(Bord b){

		computerX = hitCoordinateX; 
		computerY = hitCoordinateY+ rangeFromInitialHit; //+ for right or up, - for left or down;


		if (!b.checkGeldigheidCoordinaten(computerX, computerY) || b.vakjeArray[computerX][computerY].isBeschoten()){

			deltaDirection = false; // turn shootingposition around
			rangeFromInitialHit =1; // reset 
			shootBelowOfY(b);

		} else if (b.vakjeArray[computerX][computerY].isBevatBoot()){

			b.vakjeArray[computerX][computerY].boot.verliesLeven();
			System.out.println("Boem!");
			rangeFromInitialHit += 1;

			if (b.vakjeArray[computerX][computerY].boot.isDood()){
				hitCoordinateX = -1;
				hitCoordinateY = -1;
				secondHit = false;
				rangeFromInitialHit =2;
				System.out.println("Boot gezonken");
			}
		} else { // als mis

			deltaDirection = false;
			rangeFromInitialHit =1;
			System.out.println("Plons");
		}

	}



	private void shootBelowOfY (Bord b) {
		computerX = hitCoordinateX; 
		computerY = hitCoordinateY- rangeFromInitialHit; //+ for right or up, - for left or down;


		if (!b.checkGeldigheidCoordinaten(computerX, computerY) || b.vakjeArray[computerX][computerY].isBeschoten()){

			deltaDirection = true; // turn shootingposition around
			rangeFromInitialHit =1; // reset 
			shootAboveofY(b);

		} else if (b.vakjeArray[computerX][computerY].isBevatBoot()){

			b.vakjeArray[computerX][computerY].boot.verliesLeven();
			System.out.println("Boem!");
			rangeFromInitialHit += 1;

			if (b.vakjeArray[computerX][computerY].boot.isDood()){
				hitCoordinateX = -1;
				hitCoordinateY = -1;
				secondHit = false;
				rangeFromInitialHit =2;
				System.out.println("Boot gezonken");
			}
		} else { // als mis

			deltaDirection = true;
			rangeFromInitialHit =1;
			System.out.println("Plons");
		}

	}

}
















