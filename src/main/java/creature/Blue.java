package creature;

import javafx.scene.image.Image;

public class Blue extends Good {

    public Blue() {
        hp = 100;
        atkPoint = 30;
    }

    @Override
    public Image getImage() {
        return new Image("6.png");
    }
}
