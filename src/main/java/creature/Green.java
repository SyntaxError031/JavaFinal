package creature;

import javafx.scene.image.Image;

public class Green extends Good {

    public Green() {
        hp = 100;
        atkPoint = 50;
        fullHp = 100;
    }

    @Override
    public Image getImage() {
        return new Image("4.png");
    }

    public String toString() {
        return "四娃";
    }
}
