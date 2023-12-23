package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class ArmAnimation{
	Timer rot, rotb, ang, men;
	
	private int temp = 0;
	private int temp1 = 0;
	private int temp2 = 0;
	private int temp3 = 0;
	


	public ArmAnimation() {
		//Arm
		Var.angriffanimation = -1;
		rot = new Timer();
		rot.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if(temp == 0){
					Var.armanimation = 0;
					temp++;
				}else if(temp==1){
					Var.armanimation= 1;
					temp--;
				}

			}

		},0,250);
		//Bein
		rotb  = new Timer();
		rotb.scheduleAtFixedRate(new TimerTask(){
			@Override 
			public void run(){
				if (temp1 == 0){
					Var.beinanimation = 0;
					temp1++;
					
				}else if (temp1==1){
					Var.beinanimation=1;
					temp1--;
				}
									
			}
			
		}, 0, 250);
		//Angriff
		ang = new Timer();
		ang.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run(){
				if(Var.angriff == true || Var.angriffhelp == true){
					//System.out.println(pack1.Var.angriffanimation);
					
					
					
					if (temp2== 0){
						Var.angriffanimation = 0;
						temp2 += 1;
						
					}else if (temp2==1){
						Var.angriffanimation =1;
						temp2 += 1;
						
					}else if (temp2 == 2){
						Var.angriffanimation =2;
						temp2 += 1;
						
					}else if (temp2 == 3){
						Var.angriffanimation = 3;
						temp2 = 4;
						
					}else if (temp2 == 4){
						Var.angriffanimation = -1;
					}

				}
					if(Var.angriff ==  false && Var.angriffhelp == false){
						temp2 = 0;
					}
							}
		
		}, 0,50);
		//Menu
		men =new Timer();
		men.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run(){
				if (temp3 == 0){
					Var.menuanimation = 1;
					temp3++;
				}else if(temp3 == 1){
					Var.menuanimation = 2;
					temp3--;
					}
				
				
			}
			
		}, 0,400);
	
	
	
}}
