package creature;


import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import space.BattleField;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public abstract class Creature implements Runnable{
    protected int hp;
    protected int fullHp;
    protected int atkPoint;
    protected Status status = Status.LIVING;
    protected int x;
    protected int y;
    static protected BattleField bf;
    static protected Canvas canvas;

    public int getHp() { return hp; }
    public int getFullHp() { return fullHp; }
    public int getAtkPoint() { return atkPoint; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
    public int getX() { return x; }
    public int getY() { return y; }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public static void setBattleField(BattleField battleField) {
        bf = battleField;
    }
    public static void setCanvas(Canvas c) {
        canvas = c;
    }
    abstract public Image getImage();


    protected void move() {
        Random random = new Random();
        int direction = random.nextInt(4);

        if (this.getStatus() == Status.DEAD || this.getStatus() == Status.STOP)
            return;

        synchronized (bf) {
            if (direction == 0) {
                if (x - 2 < 0 || bf.getCreature(x - 2, y) != null)
                    return;
                else {
                    bf.eraseCreature(x, y);
                    x -= 2;
                }
            }
            else if (direction == 1) {
                if (x + 2 >= bf.getCol() || bf.getCreature(x + 2, y) != null)
                    return;
                else {
                    bf.eraseCreature(x, y);
                    x += 2;
                }
            }
            else if (direction == 2) {
                if (y - 2 < 0 || bf.getCreature(x, y - 2) != null)
                    return;
                else {
                    bf.eraseCreature(x, y);
                    y -= 2;
                }
            }
            else {
                if (y + 2 >= bf.getRow() || bf.getCreature(x, y + 2) != null)
                    return;
                else {
                    bf.eraseCreature(x, y);
                    y += 2;
                }
            }
            System.out.println(this.toString() + " has moved");
            bf.setCreature(this, x, y);
            //bf.drawBattleField(canvas);
            if (hasAliveBad() && !hasAliveGood())
                status = Status.STOP;
            if (hasAliveGood() && !hasAliveBad()) {
                status = Status.STOP;
                bf.win = true;
            }

        }
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("interrupted");
        }
    }

    protected void attack() {}

    public void run() {
        while (!bf.isEnd) {
            move();
            attack();
        }
    }

    protected ArrayList<Creature> creatureToAttack() {
        ArrayList<Creature> attackList = new ArrayList<>();
        int xMin = Math.max(x - 2, 0), xMax = Math.min(x + 2, bf.getCol() - 1);
        int yMin = Math.max(y - 2, 0), yMax = Math.min(y + 2, bf.getRow() - 1);

        for (int i = yMin; i <= yMax; i++) {
            for (int j = xMin; j <= xMax; j++) {
                if (x != j && y != i && bf.getCreature(j, i) != null && bf.getCreature(j, i).getStatus() != Status.DEAD)
                    attackList.add(bf.getCreature(j, i));
            }
        }

        return attackList;
    }

    protected boolean hasAliveGood() {
        for (int i = 0; i < bf.getRow(); i++)
            for (int j = 0; j < bf.getCol(); j++)
                if (bf.getCreature(j, i) != null && bf.getCreature(j, i).getStatus() != Status.DEAD
                        && bf.getCreature(j, i) instanceof Good)
                    return true;
        return false;
    }

    protected boolean hasAliveBad() {
        for (int i = 0; i < bf.getRow(); i++)
            for (int j = 0; j < bf.getCol(); j++)
                if (bf.getCreature(j, i) != null && bf.getCreature(j, i).getStatus() != Status.DEAD
                        && bf.getCreature(j, i) instanceof Bad)
                    return true;
        return false;
    }

}
