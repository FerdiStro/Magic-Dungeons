package pack1;


import javax.swing.*;
import java.awt.*;

public class LabelM extends JLabel {
	
	private static final long serialVersionUID = 1L;

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
		Graphics2D g2d = (Graphics2D) g;
	

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			g.drawImage(Var.ibackM, 0, 0, 800 , 600, null);
			g.drawImage(Var.iheadline, 100 , Var.screenheight/2 -200, 609,168,null);
			
			
		
			if(Var.menuhoch == true){
			if(Var.menuanimation == 1){
				g.drawImage(Var.istart, Var.menux, Var.menuy , 200 ,  70, null);
				g.drawImage(Var.ioptionen, Var.menux, Var.menuy + 80, 200 , 70, null);
			}else if (Var.menuanimation == 2){
				g.drawImage(Var.istart1, Var.menux, Var.menuy , 200 ,  70, null);
				g.drawImage(Var.ioptionen, Var.menux, Var.menuy + 80, 200 , 70, null);
			}
			}else if(Var.menurunter == true){
			
			
			if(Var.menuanimation == 1){
				g.drawImage(Var.ioptionen, Var.menux, Var.menuy + 80, 200 , 70, null);
				g.drawImage(Var.istart, Var.menux, Var.menuy , 200 ,  70, null);
			}else if (Var.menuanimation == 2){
				g.drawImage(Var.ioptionen1, Var.menux, Var.menuy + 80, 200 , 70, null);
				g.drawImage(Var.istart, Var.menux, Var.menuy , 200 ,  70, null);
			}}
			
			repaint();
			
	}
}
