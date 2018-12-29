package creature;

import javafx.scene.image.Image;

public class Loluo extends Bad {

    public Loluo() {
        hp = 60;
        atkPoint = 20;
    }

    public Image getImage() {
        return new Image("loluo.png");
    }
}
