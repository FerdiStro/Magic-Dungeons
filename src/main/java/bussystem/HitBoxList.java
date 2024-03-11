package bussystem;

import model.player.HitBox;

import java.util.HashMap;
import java.util.Map;

public class HitBoxList {

    private static   Map<String, HitBox> hitBoxList = new HashMap<>();



    public static void remove(String key){
        hitBoxList.remove(key);

    }
    public static void add(String key, HitBox hitBox){
       hitBoxList.put(key, hitBox);
    }
    public static Map<String, HitBox> get(){
        return hitBoxList;
    }
}
