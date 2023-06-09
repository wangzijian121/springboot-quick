package 消灭战舰游戏;

import org.junit.Assert;
import org.junit.Test;
import 消灭战舰游戏v1.Game;

public class GameTest {

    @Test
    public void check() {


        int[] nums = {1, 1, 1, 0, 0, 0, 0};
        Game game = new Game();
        game.setNums(nums);
        //是否击中
        String res = game.check(1);
        Assert.assertEquals("击中", res);
        //没击中
        String res2 = game.check(5);
        Assert.assertEquals("没击中", res2);

    }

    @Test
    public void scanTest() {
        int[] nums = {1, 1, 1, 0, 0, 0, 0};
        Game game = new Game();
        game.setNums(nums);
        //根据弦号 判断 是否击沉
        Assert.assertEquals(false, game.scan(1));
        Assert.assertEquals(true, game.scan(2));
    }

}