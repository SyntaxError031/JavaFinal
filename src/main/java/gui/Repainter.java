package gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Repainter implements Runnable{

    private ArrayList<String> logs;

    private Canvas canvas;
    private File file;

    public Repainter(Canvas canvas, File file) {
        this.canvas = canvas;
        this.file = file;
    }
    public void run() {
        replay(canvas, file);
    }


    public void replay(Canvas canvas, File file) {
        BufferedReader bfReader = null;
        try {
            bfReader = new BufferedReader(new FileReader(file));
            String tmp = null;
            //int line = 1;
            logs = new ArrayList<>();
            while ((tmp = bfReader.readLine()) != null) {
                logs.add(tmp);
                //line++;
            }
            bfReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LinkedHashSet<String> set = new LinkedHashSet<String>(logs.size());
        set.addAll(logs);
        logs.clear();
        logs.addAll(set);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        //gc.drawImage(new Image("1.png"), 85, 0);


        for (int i = 0; i < logs.size() - 1; i++) {
            Pattern pattern = Pattern.compile("(?<=\\()[^\\)]+");
            Matcher matcher = pattern.matcher(logs.get(i));
            while(matcher.find()){
                //System.out.println(matcher.group());
                String[] as = matcher.group().split(",");
                int x = Integer.valueOf(as[1]), y = Integer.valueOf(as[2]);
                double length = Double.valueOf(as[3]);
                //System.out.println(as[0] + " " + x + " " + y + " " + length);
                switch (as[0]) {
                    case "大娃":
                        gc.drawImage(new Image("1.png"), x * 85,y * 85); break;
                    case "二娃":
                        gc.drawImage(new Image("2.png"), x * 85,y * 85); break;
                    case "三娃":
                        gc.drawImage(new Image("3.png"), x * 85,y * 85); break;
                    case "四娃":
                        gc.drawImage(new Image("4.png"), x * 85,y * 85); break;
                    case "五娃":
                        gc.drawImage(new Image("5.png"), x * 85,y * 85); break;
                    case "六娃":
                        gc.drawImage(new Image("6.png"), x * 85,y * 85); break;
                    case "七娃":
                        gc.drawImage(new Image("7.png"), x * 85,y * 85); break;
                    case "爷爷":
                        gc.drawImage(new Image("grandpa.png"), x * 85,y * 85); break;
                    case "蛇精":
                        gc.drawImage(new Image("snake.png"), x * 85,y * 85); break;
                    case "蝎子":
                        gc.drawImage(new Image("scorpion.png"), x * 85,y * 85); break;
                    default: {
                        gc.drawImage(new Image("loluo.png"), x * 85, y * 85);
                    }break;
                }
                gc.setFill(Color.GREEN);
                gc.fillRect(x * 85, y * 85, length, 5);
            }

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // TODO: 刷新一次
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        }

        if (logs.get(logs.size()-1).equals("Win"))
            gc.drawImage(new Image("victory.png"), 130, 140);
        else
            gc.drawImage(new Image("defeat.png"), 100, 78);

    }
}
