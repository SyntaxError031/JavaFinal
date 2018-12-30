package gui;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import queue.*;
import space.World;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

;

public class Controller {

    private World world;
    private boolean replay = false;
    private int cnt = 0;

    @FXML
    private Canvas canvas;

    @FXML
    private GridPane pane;

    @FXML
    private void goodChangShe() {
        if (world.getBattleField().isStart || replay)
            return;
        ChangShe changShe = new ChangShe();
        changeFormation(changShe, true);
    }

    @FXML
    private void goodChongE() {
        if (world.getBattleField().isStart || replay)
            return;
        ChongE chongE = new ChongE();
        changeFormation(chongE, true);
    }

    @FXML
    private void goodFangYuan() {
        if (world.getBattleField().isStart || replay)
            return;
        FangYuan fangYuan = new FangYuan();
        changeFormation(fangYuan, true);
    }

    @FXML
    private void goodFengShi() {
        if (world.getBattleField().isStart || replay)
            return;
        FengShi fengShi = new FengShi();
        changeFormation(fengShi, true);
    }

    @FXML
    private void badChangShe() {
        if (world.getBattleField().isStart || replay)
            return;
        ChangShe changShe = new ChangShe();
        changeFormation(changShe, false);
    }

    @FXML
    private void badChongE() {
        if (world.getBattleField().isStart || replay)
            return;
        ChongE chongE = new ChongE();
        changeFormation(chongE, false);
    }

    @FXML
    private void badFangYuan() {
        if (world.getBattleField().isStart || replay)
            return;
        FangYuan fangYuan = new FangYuan();
        changeFormation(fangYuan, false);
    }

    @FXML
    private void badFengShi() {
        if (world.getBattleField().isStart || replay)
            return;
        FengShi fengShi = new FengShi();
        changeFormation(fengShi, false);
    }

    @FXML
    private void handleKeyPress(KeyEvent event) {
        pane.setFocusTraversable(true);
        System.out.println("按下" + event.getCode());
        if (event.getCode() == KeyCode.SPACE && !replay) {
            world.getBattleField().isStart = true;
            String data = "";
            for (int i = 0; i < world.getBattleField().getRow(); i++) {
                for (int j = 0; j < world.getBattleField().getCol(); j++) {
                    if (world.getBattleField().getCreature(j, i) != null)
                        data += ("(" + world.getBattleField().getCreature(j, i).toString() + "," + j + "," + i + "," + 85 + ")");
                }
            }
            data += "\r\n";
            try {
                File file = new File("game.log");
                if (!file.exists())
                    file.createNewFile();
                FileWriter fileWriter = new FileWriter(file.getName(),false);
                fileWriter.write(data);
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            world.start();
        }
        else if ((world.getBattleField().isEnd || !world.getBattleField().isStart) && event.getCode() == KeyCode.L)
            fileOpen();
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

    private void fileOpen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("打开游戏记录");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("LOG", "*.log"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            //GraphicsContext gc = canvas.getGraphicsContext2D();
            //gc.drawImage(new Image("1.png"), 0, 0);
            //Repainter repainter = new Repainter();
            //repainter.replay(gc, file);
            ExecutorService exec = Executors.newSingleThreadExecutor();
            exec.execute(new Repainter(canvas, file));
            replay = true;
            exec.shutdown();
            replay = false;
        }
    }
}
