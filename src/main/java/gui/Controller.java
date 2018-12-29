package gui;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import queue.*;
import space.World;

public class Controller {

    private World world;

    @FXML
    private Canvas canvas;

    @FXML
    public void goodChangShe() {
        ChangShe changShe = new ChangShe();
        changeFormation(changShe, true);
    }

    @FXML
    public void goodChongE() {
        ChongE chongE = new ChongE();
        changeFormation(chongE, true);
    }

    @FXML
    public void goodFangYuan() {
        FangYuan fangYuan = new FangYuan();
        changeFormation(fangYuan, true);
    }

    @FXML
    public void goodFengShi() {
        FengShi fengShi = new FengShi();
        changeFormation(fengShi, true);
    }

    @FXML
    public void badChangShe() {
        ChangShe changShe = new ChangShe();
        changeFormation(changShe, false);
    }

    @FXML
    public void badChongE() {
        ChongE chongE = new ChongE();
        changeFormation(chongE, false);
    }

    @FXML
    public void badFangYuan() {
        FangYuan fangYuan = new FangYuan();
        changeFormation(fangYuan, false);
    }

    @FXML
    public void badFengShi() {
        FengShi fengShi = new FengShi();
        changeFormation(fengShi, false);
    }


    public void initialize() {
        world = new World();
    }

    private void changeFormation(ZhenFa zhenFa, boolean left) {
        if (left)
            world.getBattleField().clearBattleField(0);
        else
            world.getBattleField().clearBattleField(1);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0 , 0, canvas.getWidth(), canvas.getHeight());
        world.changeZhenFa(zhenFa, left);
        world.getBattleField().drawBattleField(canvas);
    }
}
