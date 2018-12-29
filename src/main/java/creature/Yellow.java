package creature;

import javafx.scene.image.Image;

public class Yellow extends Good {

    public Yellow() {
        hp = 150;
        atkPoint = 30;
    }

    @Override
    public Image getImage() {
        return new Image("3.png");
    }
}
