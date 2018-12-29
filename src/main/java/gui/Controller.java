package gui;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import queue.*;
import space.World;

;

public class Controller {

    private World world;

    @FXML
    private Canvas canvas;

    @FXML
    private GridPane pane;

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

    @FXML
    private void handleKeyPress(KeyEvent event) {
        pane.setFocusTraversable(true);
        System.out.println("按下" + event.getCode());
        if (event.getCode() == KeyCode.SPACE)
            world.start();
    }


    public void initialize() {
        world = new World(canvas);
    }

    private void changeFormation(ZhenFa zhenFa, boolean left) {
        if (left)
            world.getBattleField().clearBattleField(0);
        else
            world.getBattleField().clearBattleField(1);
        //GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.clearRect(0 , 0, canvas.getWidth(), canvas.getHeight());
        world.changeZhenFa(zhenFa, left);
        world.getBattleField().drawBattleField(canvas);
    }
}
