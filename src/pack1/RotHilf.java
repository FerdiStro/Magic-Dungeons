package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class RotHilf {
	public RotHilf(){
		Timer  t = new Timer();
		
		t.scheduleAtFixedRate(new TimerTask(){
			@Override
			public  void run(){
				if(Var.gmoveleft == false && Var.gmoveright == false && Var.Boss == true && Var.gmoveleft == false && Var.gmoveright == false && Var.gstarty <= 0 && Var.bossmovec2 == true|| Var.bossmovec == true && Var.bossmovec2 == true){
					if(Var.gx > Var.x || Var.bossmovec== true){
					if(Var.Startangriff1 == 4){
						if(Var.bossrotta != -90){
						Var.bossmovec = true;
						}else if(Var.bossrotta == -90){
							Var.bossmovec = false;
						}
				if(Var.bossrotta ==  -90){
					Var.bossmovec = false;	
				}else if(Var.bossrotta != -90){
					Var.bossrotta -= 9;
						
				}
			}else if(Var.Startangriff1 != 4){
				Var.Startangriff1 += 1;

			
			}}}
			if(Var.bossrotta == -90){
				Var.bossmovec2	= false;
	
			}
			if(Var.bossmovec2 == false){
				Var.bossrotta += 9;
				if(Var.bossrotta== 0){
					Var.bossmovec2 = true;
					Var.bossmovec = false;
					Var.Startangriff1 = 0;
				}
			}
			}
			
		}, 0, 100 );
		
		
	}

}
