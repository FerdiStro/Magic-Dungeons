package pack1;
import logger.Logger;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
	int i = 1;
	Integer h = Var.y;
	Integer b = Var.x;

	
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);


		
		
		Graphics2D g2d = (Graphics2D) g;
	

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(Var.lbl1b ==true){
		
		//HINTERGURND
		if(Var.Boss == false){
		g.drawImage(Var.ib1, Var.backgroundX1, 0, 800 , 600, null);
		g.drawImage(Var.ib2, Var.backgroundX2,0 ,800, 600, null);

		}else if(Var.Boss == true){
			g.drawImage(Var.iboss1background, 0, 0, 800, 600, null);

		}

		

		
		/*FLAMMEN
		
		if (pack1.Var.flammenanimation == 0) {
			g.drawImage(pack1.Var.iflamme1, pack1.Var.x -41 , pack1.Var.y +50 , 125, 180, null);
		} else if (pack1.Var.flammenanimation == 1) {
			g.drawImage(pack1.Var.iflamme2, pack1.Var.x -41, pack1.Var.y +50, 125, 180, null);

		}*/
		
		/*SCHROTT
		
		for (int i = 0; i <= 4; i++) {
			g.drawImage(pack1.Var.ischrott1, pack1.Var.schrottx1[i], pack1.Var.schrotty1[i], 48, 38, null);
		}
		for (int i = 0; i <= 1; i++) {
			g.drawImage(pack1.Var.ischrott2, pack1.Var.schrottx2[i], pack1.Var.schrotty2[i], 48, 38, null);
		}
		g.drawImage(pack1.Var.ischrott3, pack1.Var.schrottx3, pack1.Var.schrotty3, 48, 38, null);*/

			System.out.println("test");
		
		//Sneaken bewegung 
		if(Var.movedown == true){
			
			if(Var.moveleft == false && Var.moveright == false ){
				g.drawImage(Var.ibein2, Var.x+25, Var.y+50, 10, 35,null);
				g.drawImage(Var.ibein1, Var.x+5, Var.y+50, 10, 35,null);
			}else if(Var.beinanimation ==0){
					g.drawImage(Var.ibeinr1, Var.x+10, Var.y+50, 30, 40,null);
					g.drawImage(Var.ibein1, Var.x+2, Var.y+50, 10, 35,null);
				}else if (Var.beinanimation ==1){
					g.drawImage(Var.ibein2, Var.x+28, Var.y+50, 10, 35,null);
					g.drawImage(Var.ibeinr2, Var.x+5, Var.y+50, 30, 40,null);
					
								}
				
				//head
				g.drawImage(Var.ihead, Var.x+10, Var.y-5, 20, 25, null);
				//Arme
				if(Var.angriffanimation< 0){
				if(Var.moveleft == false && Var.moveright == false ){
					g.drawImage(Var.iarmr1, Var.x+25, Var.y+25, 10, 35,null);
					g.drawImage(Var.iarmr2, Var.x+5, Var.y+30, 10, 35,null);
				}else if (Var.armanimation == 0){
					g.drawImage(Var.iarmr1, Var.x+30, Var.y+20, 25, 35, null);
					g.drawImage(Var.iarm2, Var.x, Var.y+20, 10, 35,null );
				}else if (Var.armanimation ==1 ){
					
					g.drawImage(Var.iarmr2, Var.x-10, Var.y+20, 25,35, null);
					g.drawImage(Var.iarm1, Var.x+30, Var.y+20, 10,35, null);
				}
				}
				//body 
				g.drawImage(Var.ibody, Var.x+1, Var.y+20, 35, 50, null);
		}else if (Var.movedown == false){
			
			
		//Player	
			
		
			//Bein
		if(Var.moveleft == false && Var.moveright == false ){
			g.drawImage(Var.ibein2, Var.x+25, Var.y+50, 10, 35,null);
			g.drawImage(Var.ibein1, Var.x+5, Var.y+50, 10, 35,null);
		}else if(Var.beinanimation ==0){
				g.drawImage(Var.ibeinr1, Var.x+10, Var.y+50, 30, 40,null);
				g.drawImage(Var.ibein1, Var.x+2, Var.y+50, 10, 35,null);
			}else if (Var.beinanimation ==1){
				g.drawImage(Var.ibein2, Var.x+28, Var.y+50, 10, 35,null);
				g.drawImage(Var.ibeinr2, Var.x+5, Var.y+50, 30, 40,null);
				
							}
			
			//head
			g.drawImage(Var.ihead, Var.x+10, Var.y-25, 20, 25, null);
			
			//Arme
			if(Var.angriffanimation< 0){
			if(Var.moveleft == false && Var.moveright == false ){
				g.drawImage(Var.iarmr1, Var.x+25, Var.y+50, 10, 35,null);
				g.drawImage(Var.iarmr2, Var.x+5, Var.y+50, 10, 35,null);
			}else if (Var.armanimation == 0){
				g.drawImage(Var.iarmr1, Var.x+30, Var.y, 25, 35, null);
				g.drawImage(Var.iarm2, Var.x, Var.y, 10, 35,null );
			}else if (Var.armanimation ==1 ){
				
				g.drawImage(Var.iarmr2, Var.x-10, Var.y, 25,35, null);
				g.drawImage(Var.iarm1, Var.x+30, Var.y, 10,35, null);
			}
			}
			
		
			
			//body 
			g.drawImage(Var.ibody, Var.x+1, Var.y, 35, 50, null);
		}
		//Boss
		
		
		if(Var.Boss == true){

			g.drawImage(Var.ighead, Var.gx , Var.gy - Var.gstarty , 40, 40, null);
			g.drawImage(Var.igbody, Var.gx-20, Var.gy - Var.gstarty + 40 , 80, 120, null); 
			
			//boss/beine
			if( Var.gmoveleft == false && Var.gmoveright == false || Var.bossmovec ==  true){
				g.drawImage(Var.igbein1, Var.gx-10, Var.gy - Var.gstarty + 160,20,90, null);
				g.drawImage(Var.igbein2, Var.gx +30, Var.gy - Var.gstarty + 160, 20, 90, null);
			}else if(Var.gmoveleft == true || Var.gmoveright == true){
			if(Var.gstarty <= 0){
				
			if(Var.gbeinanimation == 0){
			g.drawImage(Var.igbein1, Var.gx-10, Var.gy - Var.gstarty + 160,20,90, null);
			g.drawImage(Var.igbeinr1, Var.gx +10 , Var.gy - Var.gstarty + 160-20, 40, 120, null);
			}else if(Var.beinanimation == 1 ){
				g.drawImage(Var.igbeinr2, Var.gx, Var.gy - Var.gstarty + 160-10,40,120, null);
				g.drawImage(Var.igbein2, Var.gx +30, Var.gy - Var.gstarty + 160, 20, 90, null);
			}
			}
			}
		
			
			
			
			
			//Boss//Animation//Landen//Wolken
			if(Var.gstarty  <= 0&&   Var.iiwolken<=100){
				Var.iiwolken +=1;
				g.drawImage(Var.iwolke1, Var.gx-15, Var.gy+220, 80,60,null);
			}
			
			
		
		}
		
		//Angriff
	
		if (Var.angriff == false){
			h = Var.y;
			b = Var.x;
		}
		if(Var.angriff == true){
			
			Var.p = h.intValue();
				Var.p2 = b.intValue();
				Var.bx = Var.p2 + Var.Ballx;
				Var.by = Var.p + 10;
			
		if( Var.angriff == true || Var.angriffhelp == true){
			if(Var.gx > Var.x){
			
			g.drawImage(Var.iball, Var.p2 + Var.Ballx,  Var.p +10 , 20, 20, null);
				Var.angriffhelp =  true;
			}
			if(Var.gx < Var.x){
				g.drawImage(Var.iball, Var.p2 - Var.Ballx,  Var.p +10 , 20, 20, null);
				Var.angriffhelp =  true;
			}
							
				
				
			}}else Var.angriff = false;
		
		
		
		//Angrif mit Ball //Animationnen
		if(Var.movedown == false){
		if(Var.angriff == true){
			if(Var.gx > Var.x){
				if(Var.angriffanimation == 0){
					g.drawImage(Var.iarmr1, Var.x+25, Var.y, 30, 30,null);
					g.drawImage(Var.iarmr1, Var.x-5, Var.y, 40, 30, null);
					 g.drawImage(Var.ianball1, Var.x +20, Var.y-5 , 40	,40,null);
					 
			 
				}else if (Var.angriffanimation == 1){
					g.drawImage(Var.iarmr1, Var.x+25, Var.y, 30, 30,null);
					g.drawImage(Var.iarmr1, Var.x-5, Var.y, 40, 30, null);
					g.drawImage(Var.ianball2, Var.x +20, Var.y-5 , 40	,40,null);
				}else if (Var.angriffanimation > 1){
					g.drawImage(Var.iarmr1, Var.x+25, Var.y, 30, 30,null);
					g.drawImage(Var.iarmr1, Var.x-5, Var.y, 40, 30, null);
				}
				
			}
			if(Var.gx < Var.x){
				if(Var.angriffanimation == 0){
					g.drawImage(Var.iarmr2, Var.x+5, Var.y+4, 30, 30,null);
					g.drawImage(Var.iarmr2, Var.x-20, Var.y+4, 40, 30, null);
					 g.drawImage(Var.ianball1, Var.x -20, Var.y-1 , 40	,40,null);
					 
			 
				}else if (Var.angriffanimation == 1){
					g.drawImage(Var.iarmr2, Var.x+5, Var.y+4, 30, 30,null);
					g.drawImage(Var.iarmr2, Var.x-20, Var.y+4, 40, 30, null);
					 g.drawImage(Var.ianball1, Var.x -20, Var.y -1 , 40	,40,null);
				}else if (Var.angriffanimation > 1){
					g.drawImage(Var.iarmr2, Var.x+5, Var.y, 30, 30,null);
					g.drawImage(Var.iarmr2, Var.x-20, Var.y, 40, 30, null);
				}
				
			}
			
			 }
		}else if(Var.movedown == true ){
			if(Var.angriffanimation == 0){
				g.drawImage(Var.iarmr1, Var.x+25, Var.y+20, 30, 30,null);
				g.drawImage(Var.iarmr1, Var.x-5, Var.y+20, 40, 30, null);
				 g.drawImage(Var.ianball1, Var.x +20, Var.y+15 , 40	,40,null);
				 
		 
			}else if (Var.angriffanimation == 1){
				g.drawImage(Var.iarmr1, Var.x+25, Var.y+20, 30, 30,null);
				g.drawImage(Var.iarmr1, Var.x-5, Var.y+20, 40, 30, null);
				g.drawImage(Var.ianball2, Var.x +20, Var.y+15 , 40	,40,null);
			}else if (Var.angriffanimation > 1){
				g.drawImage(Var.iarmr1, Var.x+25, Var.y+20, 30, 30,null);
				g.drawImage(Var.iarmr1, Var.x-5, Var.y+20, 40, 30, null);
			}
		}
		
		//Hindernisse
			
			if(Var.kaputt == false){
				 g.drawImage(Var.ih001, Var.H1x, Var.H1y, 60, 70, null);}
			else if (Var.kaputt == true){
				g.drawImage(Var.ihkaputt001, Var.H1x, Var.H1y, 60, 70, null);
			}
				
			
		//Grapische Anzeigen 
				//Angriff/ Auflade balken
					if( Var.angriff == true || Var.angriffhelp == true){
						g.drawImage(Var.iAufladen1, Var.ganzeigex , Var.ganzeigey, 100, 20,null);
					}else if (Var.angriff == false ){
						Var.angriff = false ; g.drawImage(Var.iAufladen2, Var.ganzeigex , Var.ganzeigey, 100, 20,null);
					}
					
		//Meteranzeige 
					g.drawImage(Var.iMeter, Var.ganzeigex, Var.ganzeigey+20, 100,20, null);
					 g.drawString("Meter: " + Var.meter , Var.ganzeigex , Var.ganzeigey +32);
					
			

		//Patickel
						if(Var.moveleft == true  && Var.y >= Var.screenheight -230 || Var.moveright == true && Var.y >= Var.screenheight -230 && Var.movedown == false){
			for(int i = 0; i< 9; i++){
				g.drawImage(Var.iEffeckt1, Var.x + Var.effecktx1[i] -3 , Var.y - Var.effeckty1[i]+100  , 5,5,null);
	}}
		//Herzen
						if(Var.herzen == 3 ){
							g.drawImage(Var.iherz3, Var.herzenx, Var.herzeny  , 20,20,null);
							g.drawImage(Var.iherz2, Var.herzenx-25, Var.herzeny  , 20,20,null);
							g.drawImage(Var.iherz1, Var.herzenx-50, Var.herzeny  , 20,20,null);
						}else if(Var.herzen == 2){
							g.drawImage(Var.iherzleer3, Var.herzenx, Var.herzeny  , 20,20,null);
							g.drawImage(Var.iherz2, Var.herzenx-25, Var.herzeny  , 20,20,null);
							g.drawImage(Var.iherz1, Var.herzenx-50, Var.herzeny  , 20,20,null);
							
						}else if(Var.herzen == 1){
							g.drawImage(Var.iherzleer3, Var.herzenx, Var.herzeny  , 20,20,null);
							g.drawImage(Var.iherzleer2, Var.herzenx-25, Var.herzeny  , 20,20,null);
							g.drawImage(Var.iherzleer1, Var.herzenx-50, Var.herzeny  , 20,20,null);
							
						}else if(Var.herzen == 0){
							g.drawImage(Var.iherzleer3, Var.herzenx, Var.herzeny  , 20,20,null);
							g.drawImage(Var.iherzleer2, Var.herzenx-25, Var.herzeny  , 20,20,null);
							g.drawImage(Var.iherzleer1, Var.herzenx-50, Var.herzeny  , 20,20,null);
							//neues Label mit Gameover
						}
						
						/*GEGNER

		for (int i = 0; i < 4; i++) {
			g.drawImage(pack1.Var.igegner1, pack1.Var.gegnerx[i], pack1.Var.gegnery[i], 80, 60, null);
		
		}*/
		}
				 
			
						
		repaint(); // fuer alle frames nicht nur fuer einen

	}
	
}
