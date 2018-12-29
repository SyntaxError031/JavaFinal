package creature;

import javafx.scene.image.Image;

public class Grandpa extends Good {

    public Grandpa() {
        hp = 60;
        atkPoint = 10;
    }

    @Override
    public Image getImage() {
        return new Image("grandpa.png");
    }

    public String toString() {
        return "爷爷";
    }
}
