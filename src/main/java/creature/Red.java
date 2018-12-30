package creature;

import javafx.scene.image.Image;

public class Red extends Good {

    public Red() {
        hp = 100;
        atkPoint = 60;
        fullHp = 100;
    }

    @Override
    public Image getImage() {
        return new Image("1.png");
    }

    public String toString() {
        return "大娃";
    }
}
