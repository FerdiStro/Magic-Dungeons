package pack1;
import java.util.Timer;
import java.util.TimerTask;

public class PatickelSystem {
	Timer eins;
	private int temp = 0;
	
	public PatickelSystem() {
	
		for(int i = 0; i <9; i++){
			Var.effecktx1[i] = 5 +temp;
			Var.effeckty1[i] = Var.y +temp;
			
			temp += 5;
		}
		
		eins = new Timer();
		eins.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				for(int i = 0 ; i< 9; i++){
					Var.effeckty1[i] += Var.effectspeed[i];
					if(Var.effeckty1[i] >= 40 || Var.effeckty1[i] <= 20){
						Var.effeckty1[i]= 23;
					}
					if(Var.effeckty1[i] >= 40 && Var.effeckty1[i]<= 500){
					
						//System.out.println(pack1.Var.effeckty1[1] );
					
						
					
					}
				}
					}
				
			
			
		
			}, 0, 40);
	}		
	
	

	}

