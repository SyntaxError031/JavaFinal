package creature;

import javafx.scene.image.Image;

public class Loluo extends Bad {

    private int index;

    public Loluo(int i) {
        hp = 60;
        atkPoint = 20;
        index = i;
    }

    public Image getImage() {
        return new Image("loluo.png");
    }

    public String toString() {
        return "喽啰" + index;
    }
}
