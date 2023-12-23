package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class Systemout {
	public  Systemout(){
		Timer  t = new Timer();
		
		
		t.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run(){
				//Player
				//System.out.println("--Player:   X: "+pack1.Var.x+" Y: "+pack1.Var.y+"   ---   ");
				//Boss 1
				//System.out.println("--Gegner:   X: "+pack1.Var.gx+" Y: "+pack1.Var.gy+"   ---   ");
			}
		}, 0, 1000);
	}

}
