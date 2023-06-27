package 消灭战舰游戏v2;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class GameHelperTest {

    @Test
    public void initWarship() {
        GameHelper gameHelper = new GameHelper();
        List<WarShip> list = new ArrayList<>();
        list.add(new WarShip());
        list.add(new WarShip());
        list.add(new WarShip());
        List<WarShip> shipList=gameHelper.initWarship(list);
        assert shipList.get(0).getName().equals("Warship1");
        assert shipList.get(1).getName().equals("Warship2");
        assert shipList.get(2).getName().equals("Warship3");

    }

    @Test
    public void randomPosition() {
        GameHelper gameHelper = new GameHelper();

        List<WarShip> list = new ArrayList<>();
        list.add(new WarShip("warship111", null));
        list.add(new WarShip("warship222", null));
        list.add(new WarShip("warship333", null));

        List<WarShip> listGenerate = gameHelper.randomPosition(list);
        assert listGenerate.size() == 3;

    }
}