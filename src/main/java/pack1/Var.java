package pack1;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Var {
	static JFrame jf1, jf2;
	static int screenwidth = 800, screenheight = 600;
	static int g = -3, starty = 400;//schwerkraft 
	static int backgroundX1 = 0, backgroundX2 = 800, backgroundspeed = 7;
	static int x = 0, y = 400;
	static int speedup = 10, speeddown = 2, speedleft = 3, speedright = 2, sprunghoehe = 200, speedball = 5;
	static int armanimation, beinanimation, angriffanimation;
	static int schrott = 0, leben = 2;;
	
	
	
	static JButton btnresume, btnshop,btnoptionen,btnexit;
	static JButton btnmute;

	static int gegnerx[] = new int[5], gegnery[] = new int[5];
	//patickel System
	static int effecktx1[] = new int [10] , effeckty1[] = new int [10];
	static int effectspeed[] = new int [10];
	
	
	static int gegnerspeed[] = new int [5];
	static int schrottx1[] = new int [5], schrotty1[] = new int [5];
	static int schrottx2[] = new int [5], schrotty2[] = new int [5];
	static int schrottx3, schrotty3;
	static int schrottspeed1[] = new int [5], schrottspeed2[] = new int [2], schrottspeed3;

	static boolean moveup = false, movedown = false, moveleft = false, moveright = false  , angriff = false, angriffhelp = false;
	static boolean kollidiert = false, verloren =false;
	static boolean Backmove = false;
	static boolean kollH1 = false , kollhelpH1 = true;
	static boolean lbl1b = false, lbl2b= true;
	
	static Label lbl1;
	static LabelM lbl2;
	static LabelRot lblrot;

	static BufferedImage ib1, ib2;
	static BufferedImage ibody,ihead,iarm1, iarm2,iarmr1, iarmr2, ibein1, ibein2, ibeinr1, ibeinr2, iflamme1, iflamme2, iEffeckt1;
	static BufferedImage igegner1, iball, iAufladen1,  iAufladen2, iMeter;
	static BufferedImage ischrott1, ischrott2, ischrott3;
	static BufferedImage iherz1, iherz2, iherz3 , iherzleer1, iherzleer2 , iherzleer3;
	//Menu
	static BufferedImage iheadline, ibackM, istart,istart1, ioptionen, ioptionen1;
	static int menux = Var.screenwidth /2 - 100 , menuy = Var.screenheight /2;
	static int menuanimation = 0;
	static boolean menuhoch =  true , menurunter = false;
	//Anzeigen 
	static int meter = 0, ganzeigex = screenwidth / 2 -50, ganzeigey = screenheight -100;
	static int herzen = 3, herzenx = Var.screenwidth -50, herzeny = Var.screenheight - Var.screenheight + 10;
	//Hindernisse
	static BufferedImage ih001, ihkaputt001;
	static int H1x = 800 , H1y= 400;
	static int H1b = 60 , H1h = 70;
	static boolean kaputt = false;
	//Angriff Ball
	static BufferedImage ianball1, ianball2;
	static int Ballx = x;
	static int Bally = y;
	static int bx , by;
	static int p, p2;
	//BOSS
	static int gx = Var.screenwidth -100, gy = 250, gstarty = 400,wolkenanimation = 0,iiwolken = 0, gbeinanimation, Startangriff1 = 0;
	static BufferedImage ighead, igbody, igarm1, igarm2, igarmr1,  igarmr2, igbein1, igbein2, igbeinr1, igbeinr2,iwolke1,iwolke2,iboss1background, iwaffe1, ibossback;
	static int Bossspeed = 1,  Bossspeedtimer = 4, bossrotta = 0;
	static boolean Boss = false, helpb = false, gmoveleft = false, gmoveright = false, bossangriffleft = false, bossangriffright = false, bossmovec = false, bossmovec2 = true;


	
	public Var() {

		try {
			
			//BOSS
			iboss1background = ImageIO.read(new File("rsc/Hintergrund/Boss1.png"));
			ighead = ImageIO.read(new File("rsc/Boss/Head.png"));
			igbody = ImageIO.read(new File("rsc/Boss/Body.png"));
			igarm1 = ImageIO.read(new File("rsc/Boss/Arm1.png")); igarm2 = ImageIO.read(new File ("rsc/Boss/Arm2.png"));
			igarmr1 = ImageIO.read(new File("rsc/Boss/Armr1.png")); igarmr2 = ImageIO.read(new File("rsc/Boss/Armr2.png"));
			igbein1 = ImageIO.read(new File("rsc/Boss/Bein1.png")); igbein2 = ImageIO.read(new File ("rsc/Boss/Bein2.png"));
			igbeinr1= ImageIO.read(new File("rsc/Boss/Beinr1.png")); igbeinr2 = ImageIO.read(new File("rsc/Boss/Beinr2.png"));
			iwaffe1 = ImageIO.read(new File("rsc/Boss/Waffe1.png"));
			//BOSS//Effecte
			iwolke1 = ImageIO.read(new File("rsc/PatickelEffeckte/Wolken1.png"));
			iwolke2 = ImageIO.read(new File("rsc/PatickelEffeckte/Wolken2.png"));
			//Boss Label
			ibossback = ImageIO.read(new File("rsc/Hintergrund/Transperenz.png"));

			//Menu
			iheadline = ImageIO.read(new File("rsc/Menu/Headline.png"));
			
			ibackM = ImageIO.read(getClass().getResource("/main/resources/Menu/HintergrundM.png"));
			istart1 = ImageIO.read(new File("rsc/Menu/Start2.png")); 
			ioptionen = ImageIO.read(getClass().getResource("/main/resources/Menu/Optionen.png"));
			ioptionen1 = ImageIO.read(new File("rsc/Menu/Optionen2.png"));
			// background
			ib1 = ImageIO.read(new File("rsc/b1.0.png"));
			ib2 = ImageIO.read(new File("rsc/b1.1.png"));
			//Player 
			ihead = ImageIO.read(new File("rsc/Head.png"));
			ibody = ImageIO.read(new File("rsc/Body.png"));
			iarm1 = ImageIO.read(new File("rsc/Arm1.png")); iarm2 = ImageIO.read(new File ("rsc/Arm2.png"));
			iarmr1 = ImageIO.read(new File("rsc/Armr1.png")); iarmr2 = ImageIO.read(new File("rsc/Armr2.png"));
			ibein1 = ImageIO.read(new File("rsc/Bein1.png")); ibein2 = ImageIO.read(new File ("rsc/Bein2.png"));
			ibeinr1= ImageIO.read(new File("rsc/Beinr1.png")); ibeinr2 = ImageIO.read(new File("rsc/Beinr2.png"));
			//Feuerball
			iball = ImageIO.read(new File("rsc/Angriff/Ball.png"));
			ianball1 = ImageIO.read(new File("rsc/Animationen/AngriffBall1.png"));
			ianball2 = ImageIO.read(new File("rsc/Animationen/AngriffBall2.png"));
			
			iflamme1 = ImageIO.read(new File("rsc/Animationen/flamme.1.png"));
			iflamme2 = ImageIO.read(new File("rsc/Animationen/flamme.1.2.png"));
			// Der etste Gegener
			igegner1 = ImageIO.read(new File("rsc/gegner1.png"));
			//Schrott
			ischrott1 = ImageIO.read(new File("rsc/schrott1.png"));
			ischrott2 = ImageIO.read(new File("rsc/schrott2.png"));
			ischrott3 = ImageIO.read(new File("rsc/schrott3.png"));
			//Hindernisse 
			ih001 = ImageIO.read(new File("rsc/Hindernisse/H_001.png"));
			ihkaputt001 = ImageIO.read(new File ("rsc/Hindernisse/Hkaputt_001.png"));
			//Grafische Anzeigen 
			iAufladen1 = ImageIO.read(new File("rsc/GrapischeAnzeigen/Aufladenrot.png"));
			iAufladen2 = ImageIO.read(new File("rsc/GrapischeAnzeigen/Aufladengruen.png"));
			iMeter = ImageIO.read(new File("rsc/GrapischeAnzeigen/Meter.png"));			//Patickel
			iEffeckt1 =  ImageIO.read(new File("rsc/PatickelEffeckte/Patickel1.png"));
			//Herzen 
			iherz1 = ImageIO.read(new File("rsc/GrapischeAnzeigen/Herz1.png"));
			iherz2 = ImageIO.read(new File("rsc/GrapischeAnzeigen/Herz2.png"));
			iherz3 = ImageIO.read(new File("rsc/GrapischeAnzeigen/Herz3.png"));
			iherzleer1 = ImageIO.read(new File("rsc/GrapischeAnzeigen/Herzleer1.png"));
			iherzleer2 = ImageIO.read(new File("rsc/GrapischeAnzeigen/Herzleer2.png"));
			iherzleer3 = ImageIO.read(new File("rsc/GrapischeAnzeigen/Herzleer3.png"));

		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("Bilder konnten nicht geladen werden!!");
			Var.meter = 1000; 

		}
		effectspeed[0] = 3;
		effectspeed[1] = 4;
		effectspeed[2] = 3;
		effectspeed[3] = 4;
		effectspeed[4] = 3;
		effectspeed[5] = 4;
		effectspeed[6] = 3;
		effectspeed[7] = 4;
		effectspeed[8] = 3;
		effectspeed[9] = 4;
	
		
		gegnerspeed[0] = 3;
		gegnerspeed[1] = 4;
		gegnerspeed[2] = 3;
		gegnerspeed[3] = 4;
		gegnerspeed[4] = 4;

		schrottspeed1[0] = 2;
		schrottspeed1[1] = 3;
		schrottspeed1[2] = 2;
		schrottspeed1[3] = 4;
		schrottspeed1[4] = 3;
		
		schrottspeed2[0] = 4;
		schrottspeed2[1] = 5;
		
		schrottspeed3 = 6; 
		
	}

}
