package screens;

import bussystem.HitBoxList;
import bussystem.clock.GameClock;

public interface GameScreen {

    void setGameClock(GameClock gameClock);

    void setHitBoxList(HitBoxList hitBoxList);

    HitBoxList getHitBoxList();

}
