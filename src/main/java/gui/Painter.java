package gui;

import javafx.scene.canvas.Canvas;
import space.BattleField;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Painter implements Runnable {

    private BattleField battleField;
    private Canvas canvas;
    private ArrayList<String> logs;

    public Painter(BattleField battleField, Canvas canvas) {
        this.battleField = battleField;
        this.canvas = canvas;
    }

    public void run() {

        while (!battleField.isEnd) {
            synchronized (battleField) {
                battleField.drawBattleField(canvas);
                System.out.println("draw battlefield");
            }
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("painter interrupted");
            }
        }
    }

//    public void replay(File file) {
//        BufferedReader bfReader = null;
//        try {
//            bfReader = new BufferedReader(new FileReader(file));
//            String tmp = null;
//            //int line = 1;
//            logs = new ArrayList<>();
//            while ((tmp = bfReader.readLine()) != null) {
//                logs.add(tmp);
//                //line++;
//            }
//            bfReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        GraphicsContext gc = canvas.getGraphicsContext2D();
//        //gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
//        gc.drawImage(new Image("1.png"), 0, 0);
//
//
//        for (int i = 0; i < logs.size(); i++) {
//            Pattern pattern = Pattern.compile("(?<=\\()[^\\)]+");
//            Matcher matcher = pattern.matcher(logs.get(i));
//            while(matcher.find()){
//                //System.out.println(matcher.group());
//                String[] as = matcher.group().split(",");
//                int x = Integer.valueOf(as[1]), y = Integer.valueOf(as[2]);
//                double length = Double.valueOf(as[3]);
//                //System.out.println(as[0] + " " + x + " " + y + " " + length);
//                switch (as[0]) {
//                    case "大娃":
//                        gc.drawImage(new Image("1.png"), x * 85,y * 85); break;
//                    case "二娃":
//                        gc.drawImage(new Image("2.png"), x * 85,y * 85); break;
//                    case "三娃":
//                        gc.drawImage(new Image("3.png"), x * 85,y * 85); break;
//                    case "四娃":
//                        gc.drawImage(new Image("4.png"), x * 85,y * 85); break;
//                    case "五娃":
//                        gc.drawImage(new Image("5.png"), x * 85,y * 85); break;
//                    case "六娃":
//                        gc.drawImage(new Image("6.png"), x * 85,y * 85); break;
//                    case "七娃":
//                        gc.drawImage(new Image("7.png"), x * 85,y * 85); break;
//                    case "爷爷":
//                        gc.drawImage(new Image("grandpa.png"), x * 85,y * 85); break;
//                    case "蛇精":
//                        gc.drawImage(new Image("snake.png"), x * 85,y * 85); break;
//                    case "蝎子":
//                        gc.drawImage(new Image("scorpion.png"), x * 85,y * 85); break;
//                    default: {
//                        System.out.println("draw");
//                        gc.drawImage(new Image("loluo.png"), x * 85, y * 85);
//                    }break;
//                }
//                gc.setFill(Color.GREEN);
//                gc.fillRect(x * 85, y * 85, length, 5);
//            }
//
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            // TODO: 刷新一次
//            //gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
//        }
//
//    }
}
