package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class Verloren {
Timer loose;
private int temp=0, temp1=0;
	public Verloren() {
		loose = new Timer();
		loose.scheduleAtFixedRate(new TimerTask(){

			@Override
			public void run() {
				
				if(Var.verloren){
					if(temp>=0&& temp<=55){
						temp++;
					}
						else if(temp==56){
							System.out.println("Verloren");
					}//Explosion & Verlieren | Spiel programmieren | Java | #08 [ger/1080p60] 3.38Minuten
					
				}
			
				
			}
			
		},0,15);
		
	}

}
