package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class Hindernisszusammen {
	Timer tim = new Timer();
	
	
		public Hindernisszusammen (){
	
		tim.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				
		//int Hitboxxa = Var.x , Hitboxxb =  Var.x +40;
		//int Hitboxya = Var.y +50, Hitboxyb = Var.y -45;
		for (int i = 0; i<= 4; i++){
			
		
			
			if(Var.x >= Var.H1x-40 && Var.x <= Var.H1x+60 ){
			if (Var.y >=  Var.H1y-63 ){
				System.out.println("zusammenstos2");
				
		
				Var.kollH1 = true;
				
				
				
				
			}		
			} 
			}
			}
		}, 0,15);
	}}
