package pack1;
import java.util.Timer;
import java.util.TimerTask;

public class Hindernisszusammen {
	Timer tim = new Timer();
	
	
		public Hindernisszusammen (){
	
		tim.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				
		//int Hitboxxa = pack1.Var.x , Hitboxxb =  pack1.Var.x +40;
		//int Hitboxya = pack1.Var.y +50, Hitboxyb = pack1.Var.y -45;
		for (int i = 0; i<= 4; i++){
			
		
			
			if(Var.x >= Var.H1x-40 && Var.x <= Var.H1x+60 ){
			if (Var.y >=  Var.H1y-63 ){
				System.out.println("Hitbox H1");
				
		
				Var.kollH1 = true;
				
				
				
				
			}		
			} 
			}
			}
		}, 0,15);
	}}
