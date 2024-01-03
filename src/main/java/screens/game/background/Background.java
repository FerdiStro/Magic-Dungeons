package screens.game.background;

import bussystem.BusSystem;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;

@Getter
@Setter
public class Background {
     private BusSystem busSystem;


     private BufferedImage background;
     private int width = 0;
     private int height= 0;


     public void setBusSystem(BusSystem busSystem) {
          this.busSystem = busSystem;
          width   = busSystem.get("screenWidth", Integer.class);
          height  = busSystem.get("screenHeight", Integer.class);

     }

}
