package creature;

import javafx.scene.image.Image;

public class Orange extends Good {

    public Orange() {
        hp = 100;
        atkPoint = 30;
        fullHp = 100;
    }

    @Override
    public Image getImage() {
        return new Image("2.png");
    }

    public String toString() {
        return "二娃";
    }
}
