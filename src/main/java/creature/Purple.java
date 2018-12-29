package creature;

import javafx.scene.image.Image;

public class Purple extends Good {

    public Purple() {
        hp = 100;
        atkPoint = 50;
    }

    @Override
    public Image getImage() {
        return new Image("7.png");
    }

    public String toString() {
        return "七娃";
    }
}
