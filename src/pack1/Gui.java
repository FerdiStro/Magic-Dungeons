package pack1;

import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class Gui {

	public Gui() {
		//Frame Game
		Var.jf1 = new JFrame();
		Var.jf1.setSize(Var.screenwidth,Var.screenheight);
		Var.jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Var.jf1.setLocationRelativeTo(null);
		Var.jf1.setLayout(null);
		Var.jf1.setTitle("Game");
		Var.jf1.setResizable(false);   	//Verhindert das Gros bzw klein ziehen des Fensters 
		Var.jf1.addKeyListener(new KeyHandler());
		Var.jf1.requestFocus();
		Var.jf1.addKeyListener((KeyListener) new KeyHandler());
		Var.jf1.setVisible(true);
		//Frame Menue
	
		//Spiel
		Var.lbl1 = new Label ();
		Var.lbl1.setBounds(0,0,Var.screenwidth,Var.screenheight);	
		
		Var.jf1.add(Var.lbl1);
		//Menue
		Var.lbl2 = new LabelM ();
		Var.lbl2.setBounds(0,0,Var.screenwidth , Var.screenheight);
		
		Var.jf1.add(Var.lbl2);
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			
		
			
			@Override
			public void run() {
				
				Var.lbl2.setVisible(Var.lbl2b);
			}
		}, 0, 9);
	}

}
