package creature;

import javafx.scene.image.Image;

public class Blue extends Good {

    public Blue() {
        hp = 100;
        atkPoint = 30;
        fullHp = 100;
    }

    @Override
    public Image getImage() {
        return new Image("6.png");
    }

    public String toString() {
        return "六娃";
    }
}
