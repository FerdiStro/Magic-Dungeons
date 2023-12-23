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
					//System.out.println("HX: "+ pack1.Var.H1x + " X: "+ pack1.Var.x);
					//System.out.println("HY: "+ pack1.Var.H1y + " Y: "+ pack1.Var.y);


				} }}
		}, 0, Var.backgroundspeed);

	}

}
