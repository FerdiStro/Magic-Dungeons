package pack1;

import java.util.Timer;
import java.util.TimerTask;

public class GegnerKollision {
	Timer kollision;
	private int temp = 0;

	public GegnerKollision() {
		kollision = new Timer();
		kollision.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {

				for (int i = 0; i <= 4; i++) {
					if (temp == 0) {
						if (Var.x > Var.gegnerx[i] - 50 && Var.x <= Var.gegnerx[i] + 73 && Var.y > Var.gegnery[i] - 70
								&& Var.y <= Var.gegnery[i] + 35) {

							Var.kollidiert = true;
							Var.gegnery[i] = -100;

							if (Var.leben >= 1) {
								Var.leben -= 1;
							}
							if (Var.leben == 0) {
								Var.verloren = true;
							}
							if (Var.leben > 0) {
								Var.verloren = false;
							}

							temp++;
						}
					}
				}
				if (temp >= 1 && temp <= 65) {
					temp++;
				} else if (temp == 66) {
					temp = 0;
					
				}
			}

		}, 0, 15);

	}

}
