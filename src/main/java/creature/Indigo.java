package creature;

import javafx.scene.image.Image;

public class Indigo extends Good {

    public Indigo() {
        hp = 100;
        atkPoint = 50;
    }

    @Override
    public Image getImage() {
        return new Image("5.png");
    }
}
