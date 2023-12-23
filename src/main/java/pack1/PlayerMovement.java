package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class PlayerMovement {
	Timer movement;

	public PlayerMovement() {
		movement = new Timer();
		movement.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() { 
				
				if (Var.moveup == true && Var.y > Var.starty-Var.sprunghoehe  ) {






						Var.y -= Var.speedup;


					}




				//schwerkraft
				int Vargh = Var.g;
				if (Var.y <= Var.starty ){

					if(Var.y <=  Var.starty-Var.sprunghoehe){


						 Vargh = Var.g -1;
						 Var.y -= Vargh;
					}

					Var.y -= Vargh;


				}
				if(Var.y < Var.starty-Var.sprunghoehe){
					Var.moveup = false ;
				}
				//System.out.println("Y =  "+pack1.Var.y);
				//System.out.println("Schwerkraft = "+Vargh);


				//Ducken

				if (Var.movedown == true ){

					if (Var.moveleft == true) {
						if (Var.x > -35) {

							Var.x -= Var.speedleft-2;
						}
					}
					if (Var.moveright == true) {
						if (Var.x <= 800) {
							Var.x += Var.speedright-2;
						}
					}

				}
					if (Var.angriffhelp == true) {

						if (Var.Ballx > Var.screenwidth + 50){

							Var.angriff = false;

							if(Var.Ballx > Var.screenwidth +50 ){
								Var.Ballx = 0 ;
								Var.angriff = false;
								Var.angriffhelp = false;

							}
						}

							Var.Ballx += Var.speedball;
							//System.out.println("Ball X : " + pack1.Var.Ballx);
							//System.out.println("Ball Y : " + pack1.Var.Bally);




						//Animation zum schiesen


					}

				if (Var.moveleft == true) {
					if (Var.x > -35) {
						Var.x -= Var.speedleft;
					}
				}
				if (Var.moveright == true) {
					if (Var.x <= 800) {
						Var.x += Var.speedright;
					}
				}
				
				
				//Angriff 
				
				
				
				
				
				
					
			}

		}, 0, 10);

	}

}
