package creature;


import javafx.scene.image.Image;

enum Status {
    DEAD, LIVE;
}

public abstract class Creature {
    protected int hp;
    protected int atkPoint;
    protected Status status;
    protected int x;
    protected int y;

    public int getHp() { return hp; }
    public int getAtkPoint() { return atkPoint; }
    public Status getStatus() { return status; }
    public int getX() { return x; }
    public int getY() { return y; }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    abstract public Image getImage();

}
