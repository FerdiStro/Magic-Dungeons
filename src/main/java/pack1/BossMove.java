package pack1;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class BossMove {
	private int temp = 0;
	public BossMove(){
		//Boolean ob boss da oder nicht da ist
		
		Random random = new Random();
		Timer  a1 = new Timer();
		Timer a2 = new Timer();
		int angriff = 0;
		
		//int angriff = random.nextInt(4); //Sagt welcher angriff statt findet
		System.out.println(angriff);
		
		//Bein
		Timer rotb  = new Timer();
		rotb.scheduleAtFixedRate(new TimerTask(){
			@Override 
			public void run(){
				if (temp == 0){
					Var.gbeinanimation = 0;
					temp++;
					
				}else if (temp==1){
					Var.gbeinanimation=1;
					temp--;
				}			
			}	
		}, 0, 250);
		
		
		
		a1.scheduleAtFixedRate(new TimerTask() {
			
			
				@Override
				public void run() {
				//Ab wie viel meter Boss kommt 	(200)	
				if(Var.meter == 100){
					Var.Backmove = false;
					Var.Boss = true;
					Var.speedright =3;}
				
			if(Var.Boss == true && Var.gstarty  >= 0){	
				//System.out.println("XXXXXXXXXXX  TEST XXXXXXXXXXXXXXX");
				Var.gstarty -=2;
			   
			}
			if(Var.Boss == true && Var.helpb == false && Var.gstarty <= 0 ){
				if(Var.x > 100){
				Var.x -= Var.speedleft *2 ;
				if(Var.x <= 100){
					Var.helpb = true;
				
				}
				}
				
			}
				
			}
			},0, Var.Bossspeedtimer);
			
			

			a2.scheduleAtFixedRate(new TimerTask() {
			
			
				@Override
				public void run() {	
				
			if(Var.helpb == true && Var.gstarty <=0){
				 //Angriff 1
				if(angriff == 0){
					if(Var.x < Var.gx){
						Var.gmoveleft = true;
						Var.bossangriffleft = true;
						}
						if(Var.gx < Var.x -100){
						Var.gmoveright = true;
						Var.bossangriffright = true;
						
						}else Var.gmoveright = false;
					
					
				}			
				//Angriff 2
				if(angriff == 1){		
				}				
				//Angriff 3
				else if(angriff ==2){					
				}
				//Angriff 4
				else if(angriff == 3){				
				}
				//Angriff 5
				else if(angriff == 4){			
				}
			}	
			//Move
				if(Var.bossmovec == true ){
					
				}else if(Var.bossmovec == false ){
				if(Var.gmoveleft == true){
					if(Var.gx > Var.x + 100){
						Var.gx -= Var.Bossspeed;
								}else Var.gmoveleft = false;
				}
				if(Var.gmoveright == true){
					if(Var.gx < Var.x - 100){
					Var.gx += Var.Bossspeed;}
								}else Var.gmoveright = false;
				}}
				},0, Var.Bossspeedtimer);
				
				//Angriff | Left 
					/*if(pack1.Var.bossangriffleft == true){
						if(pack1.Var.bossrotta < 90){
							pack1.Var.bossrotta ++;
							if(pack1.Var.bossrotta <= 90-5){
							pack1.Var.bossrotta = 0;
						}
						}
						
					}*/
			
				//Angriff | Right 
		
				
				
			
			
			

	}}
