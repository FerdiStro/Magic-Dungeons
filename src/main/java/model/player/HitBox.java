package model.player;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HitBox {
    private int x;
    private int y;
    private int width;
    private int height;
}
