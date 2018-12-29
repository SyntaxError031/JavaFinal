package space;

import creature.Bad;
import creature.Creature;
import creature.Good;
import creature.Status;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class BattleField {

    private Block[][] blocks;
    private int row;
    private int col;
    private final int BLOCK_SIZE = 85;

    public BattleField(int row, int col) {
        blocks = new Block[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++)
                blocks[i][j] = new Block();
        }
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    public void drawBattleField(Canvas canvas) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        Creature creatureInblock;
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((creatureInblock = blocks[i][j].getCreature()) != null) {
                    //System.out.println("draw image on " + i + " " + j);
                    if (creatureInblock.getStatus() != Status.DEAD)
                        gc.drawImage(creatureInblock.getImage(), j * BLOCK_SIZE, i * BLOCK_SIZE);
                    else
                        gc.drawImage(new Image("grave.png"), j * BLOCK_SIZE, i * BLOCK_SIZE);
                }
            }
        }
    }

    /**
     * 清除战场上的生物
     * @param way int (0: 清除good  1: 清除bad  2: 清除全部)
     */
    public void clearBattleField(int way) {
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Creature creatureInBlock = blocks[i][j].getCreature();
                switch (way) {
                    case 0: {
                        if (creatureInBlock instanceof Good) {
                            blocks[i][j].eraseCreature();
                            //System.out.println("erase Good on " + i + " " + j);
                            creatureInBlock.setX(-1);
                            creatureInBlock.setY(-1);
                        }
                    } break;
                    case 1: {
                        if (creatureInBlock instanceof Bad) {
                            blocks[i][j].eraseCreature();
                            creatureInBlock.setX(-1);
                            creatureInBlock.setY(-1);
                        }
                    } break;
                    case 2: {
                        blocks[i][j].eraseCreature();
                        creatureInBlock.setX(-1);
                        creatureInBlock.setY(-1);
                    } break;
                }
            }
        }
    }

    public void setCreature(Creature creature, int x, int y) {
        blocks[y][x].putCreature(creature);
        creature.setX(x);
        creature.setY(y);
    }

    public Creature getCreature(int x, int y) {
        return blocks[y][x].getCreature();
    }

    public void eraseCreature(int x, int y) {
        blocks[y][x].eraseCreature();
    }
}
