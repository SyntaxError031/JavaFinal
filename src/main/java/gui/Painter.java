package gui;

import space.BattleField;

import javafx.scene.canvas.*;

import java.util.concurrent.TimeUnit;

public class Painter implements Runnable {

    private BattleField battleField;
    private Canvas canvas;

    public Painter(BattleField battleField, Canvas canvas) {
        this.battleField = battleField;
        this.canvas = canvas;
    }

    public void run() {

        while (!battleField.isEnd) {
            synchronized (battleField) {
                battleField.drawBattleField(canvas);
                System.out.println("draw battlefield");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("painter interrupted");
            }
        }
    }
}
