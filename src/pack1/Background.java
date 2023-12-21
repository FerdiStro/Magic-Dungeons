package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class Background {
	
	

	public Background() { 
		System.out.println(Var.Backmove);
		System.out.println(Var.moveright);
	
		
		
		Timer back = new Timer();
		Timer back1 = new Timer();
		
		
		
		
		

		
		back.scheduleAtFixedRate(new TimerTask() {
			
	
			
			@Override
			public void run() {
			
if(Var.Backmove == true){
	
	 if (Var.x > Var.screenwidth -100){
			Var.speedright = 0;
			
			
	 } else if(Var.x >  Var.screenwidth-600){
		
		
		Var.speedright = 1;
		
		
	}else Var.speedright = 2;

			
				if (Var.backgroundX1 > -Var.screenwidth +2) {
					Var.backgroundX1 -= 2;
					

				} else {
					Var.backgroundX1 = Var.screenwidth ;
					Var.meter += 100;
				}
				if (Var.backgroundX2 > -Var.screenwidth +2) {
					Var.backgroundX2 -= 2;
					

				} else {
					Var.backgroundX2 = Var.screenwidth ;
					Var.meter += 100;
				}
		
		
}
}
		}, 0, Var.backgroundspeed);

	
	}
}
