package creature;

import javafx.scene.image.Image;

public class Snake extends Bad {

    public Snake() {
        hp = 150;
        atkPoint = 60;
        fullHp = 150;
    }

    public Image getImage() {
        return new Image("snake.png");
    }

    public String toString() {
        return "蛇精";
    }
}