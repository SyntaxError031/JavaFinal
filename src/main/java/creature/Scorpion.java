package creature;

import javafx.scene.image.*;

public class Scorpion extends Bad {

    public Scorpion() {
        hp = 100;
        atkPoint = 50;
    }

    public Image getImage() {
        return new Image("scorpion.png");
    }

    public String toString() {
        return "蝎子";
    }
}
