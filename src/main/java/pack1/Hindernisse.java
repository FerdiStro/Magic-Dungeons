package pack1;
import java.util.Timer;
import java.util.TimerTask;

public class Hindernisse {
	Timer back;

	public Hindernisse() { 
		back = new Timer();
		back.scheduleAtFixedRate(new TimerTask() {
						@Override
			
			public void run() {
				if(Var.Backmove == true){
				if (Var.H1x > -798) {
					Var.H1x -= 2;
					//System.out.println("HX: "+ Var.H1x + " X: "+ Var.x);
					//System.out.println("HY: "+ Var.H1y + " Y: "+ Var.y);


				} }}
		}, 0, Var.backgroundspeed);

	}

}
