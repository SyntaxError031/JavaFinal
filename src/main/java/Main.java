import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("葫芦娃大战妖怪");
        primaryStage.setScene(new Scene(root, 1135, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
