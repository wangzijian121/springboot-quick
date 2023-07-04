package 消灭战舰游戏v2;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameTest {


    @Test
    public void testPlay() {
    }

    @Test
    public void checkHit() {
        Game game = new Game();
        List<WarShip> warShipList = new ArrayList<>();
        List<Point> list = new ArrayList<>();
        list.add(new Point(5, 6));
        WarShip warShip = new WarShip("Test", list);
        warShipList.add(warShip);
        game.setWarShipList(warShipList);

        Boolean testA = game.checkHit(new Point(5, 6));
        Boolean testB = game.checkHit(new Point(5, 7));
        assert testA == true;
        assert testB == false;

    }

    @Test
    public void checkSinking() {
    }

    @Test
    public void testOver() {
    }
}