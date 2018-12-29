package space;

import creature.*;
import queue.ZhenFa;

import java.util.ArrayList;

public class World {

    private static BattleField battleField;
    private ArrayList<Good> goods;
    private ArrayList<Bad> bads;

    public World() {
        battleField = new BattleField(8, 11);
        goods = new ArrayList<>();
        goods.add(new Red());
        goods.add(new Orange());
        goods.add(new Yellow());
        goods.add(new Green());
        goods.add(new Indigo());
        goods.add(new Blue());
        goods.add(new Purple());
        goods.add(new Grandpa());
        bads = new ArrayList<>();
        bads.add(new Snake());
        bads.add(new Scorpion());
        for (int i = 0; i < 6; i++)
            bads.add(new Loluo());
    }

    public BattleField getBattleField() { return battleField; }


    public void changeZhenFa(ZhenFa zhenFa, boolean left) {
        if (left)
            zhenFa.arrangeCreatures(goods, battleField, true);
        else
            zhenFa.arrangeCreatures(bads, battleField, false);
    }
}
