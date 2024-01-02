package config;



import logger.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;



public class ImageLoader {
    //todo: change the standard path var in settings screen. Easy handle Texture packs.
    private static final String STANDARD_PATH = "src/main/resources/";

    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(new File(STANDARD_PATH+path));
        }catch (Exception e){

            Logger.info("Standard-Path: "+STANDARD_PATH);
            Logger.error("Image can't load! Image-Name: " +  path);
            return null;
        }
    }
}
