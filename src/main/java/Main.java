import bussystem.BusSystem;
import screens.Gui;


import javax.swing.*;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());



		//state System init
		BusSystem busSystem =  new BusSystem();
		new Gui(busSystem);
//		new Test(busSystem);


		//Testing Performance on linux
//		Toolkit.getDefaultToolkit().sync();






//		new Var();
////		new KeyHandler();
//		new LabelRot();
//		new Label();
//		new Background();
//		new PlayerMovement();
//		new ArmAnimation();
//		new GegnerMovement();//		new SchrottMovement();
//		new GegnerKollision();
//		new SchrottKollision();
//		new Hindernisse();
//		new Hindernisszusammen();
//		new PatickelSystem();
//		new Herzen();
//		new BossMove();
//		new BossHit();
//		new RotHilf();
//		new Systemout();		//Consolen ausgabe







		
	}

}
