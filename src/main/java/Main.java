import bussystem.BusSystem;
import logger.Logger;
import pack1.Label;
import pack1.PlayerMovement;
import pack1.*;
import screens.Gui;

import screens.Test;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException, UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());



		//state System init
		BusSystem busSystem =  new BusSystem();


		//Testing Performance on linux
//		Toolkit.getDefaultToolkit().sync();






//		new Var();
//		new KeyHandler();
//		new LabelRot();
//		new Label();
////		new LabelM();
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




      	new Gui(busSystem);



		
	}

}
