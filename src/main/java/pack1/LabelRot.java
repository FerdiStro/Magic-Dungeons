package pack1;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.Timer;

public class LabelRot extends JLabel{
	
		Timer t1;
 private static final long serialVersionUID = 1L;
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform old = g2d.getTransform();
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g2d.rotate(Math.toRadians(Var.bossrotta+90),Var.gx + 40, Var.gy-5-Var.gstarty);
		
			g.drawImage(Var.iwaffe1, Var.gx+10+Var.bossrotta, Var.gy-5-Var.gstarty+100,150,50,null);	
				 
		
	
			

			
		
	
		//g2d.setTransform(old);

		
	
		
	/*if(Var.bossrotta < 90){
			Var.bossrotta =+ 1;
			if(Var.bossrotta <= 90-5){
				
			Var.bossrotta =- 90;
		}

		}		*/
		
	
	//repaint();*/
	
	
	}
	
}