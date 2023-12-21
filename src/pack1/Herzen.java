package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class Herzen {

	Timer timer = new Timer();
	
	public Herzen() {
		timer.scheduleAtFixedRate(new TimerTask() {
	
			@Override
			public void run() {

				if(Var.kollH1 == true && Var.kollhelpH1 == true){
					
		
			Var.kaputt = true;
			Var.herzen -=1;
			Var.kollhelpH1 = false;
		}

			}

		}, 0, 9);
		
	
	}
	

}
