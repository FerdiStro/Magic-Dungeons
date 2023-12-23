package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class BossHit {
	public BossHit(){
		Timer time = new Timer();
		
		time.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run(){
						
						
				//System.out.println(pack1.Var.gx);
				//System.out.println(pack1.Var.x);
				//System.out.println(pack1.Var.bx);
				//System.out.println(pack1.Var.by);
				
			}
		},0,4);

		
	}
}
