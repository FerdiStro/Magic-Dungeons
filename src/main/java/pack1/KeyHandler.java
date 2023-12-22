package pack1;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class KeyHandler implements KeyListener {

Timer timer;
		
	@Override
	public void keyPressed(KeyEvent e) {
		if(Var.lbl1b == true){

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			
			if(Var.moveright == true){
		
			}
			if (Var.y >= Var.y - Var.sprunghoehe){
			
				Var.moveup = true;
			}
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_A) {
				if(Var.x > 0 ){
				
			}
			Var.Backmove = false;		
			Var.moveleft = true;
		
			
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			
				
			if(Var.Boss == false){
			Var.Backmove = true;
			}
			Var.moveright = true;
			
			
		}
	if (e.getKeyCode() == KeyEvent.VK_S) {
		Var.movedown = true;
			
			
		}
	if (e.getKeyCode() == KeyEvent.VK_Q) {
		Var.angriff = false;
		
		
	}
	

	}
		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP && Var.menuhoch == false) {
			Var.menurunter = false;	
			Var.menuhoch = true;
			}
		if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN && Var.menurunter == false) {
			Var.menuhoch = false;
			Var.menurunter = true;
			}
		
		if(Var.lbl2b == true){
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			
			Var.lbl1b = false;
			Var.lbl2b = true;
		
		}}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(Var.lbl1b == true){
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			
			Var.moveup = false;
		
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_A) {
			if(Var.x > 0 ){
		
			}
			Var.Backmove= false;
			Var.moveleft = false;
		
		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			if(Var.Boss == false){
			Var.Backmove = false;
			}
			Var.moveright = false;
			
				
			}
	if (e.getKeyCode() == KeyEvent.VK_S) {
			Var.movedown = false;
			
			
		}
	if (e.getKeyCode() == KeyEvent.VK_Q) {
		Var.angriff = true;
		
		
	}
	
		}	
		if ( e.getKeyCode() == KeyEvent.VK_UP &&Var.menuhoch == false) {
			Var.menurunter = true;	
			Var.menuhoch = false;
			}
		if ( e.getKeyCode() == KeyEvent.VK_DOWN && Var.menuhoch == true) {
			Var.menuhoch = true;
			Var.menurunter = false;
			}
		if(Var.lbl2b == true && Var.menuhoch == true){
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			Var.lbl1b = true;
			Var.lbl2b = false;
		}}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
