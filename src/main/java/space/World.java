package space;

import creature.*;
import gui.Painter;
import javafx.scene.canvas.Canvas;
import queue.ZhenFa;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class World {

    private static BattleField battleField;
    private ArrayList<Good> goods;
    private ArrayList<Bad> bads;
    private Canvas canvas;

    public World(Canvas canvas) {
        this.canvas = canvas;
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
            bads.add(new Loluo(i));

        Creature.setBattleField(battleField);
        Creature.setCanvas(canvas);
    }

    public BattleField getBattleField() { return battleField; }

    public void changeZhenFa(ZhenFa zhenFa, boolean left) {
        if (left)
            zhenFa.arrangeCreatures(goods, battleField, true);
        else
            zhenFa.arrangeCreatures(bads, battleField, false);
    }

    public void start() {
        ExecutorService draw = Executors.newSingleThreadExecutor();
            draw.execute(new Painter(battleField, canvas));
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < goods.size(); i++)
            exec.execute(goods.get(i));
        for (int i = 0; i < bads.size(); i++)
            exec.execute(bads.get(i));
        draw.shutdown();
        exec.shutdown();
    }
}
