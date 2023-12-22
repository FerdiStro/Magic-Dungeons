package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class BossHit {
	public BossHit(){
		Timer time = new Timer();
		
		time.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run(){
						
						
				//System.out.println(Var.gx);
				//System.out.println(Var.x);
				//System.out.println(Var.bx);
				//System.out.println(Var.by);
				
			}
		},0,4);

		
	}
}
