package asu.onlinebankinggui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static asu.onlinebankinggui.Controllers.ControllerUtility.addData;

public class OnlineBankingSystem extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OnlineBankingSystem.class.getResource("WelcomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Online Banking System");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(Objects.requireNonNull(OnlineBankingSystem.class.getResourceAsStream("/asu/onlinebankinggui/images/BankIcon.png"))));
        OnlineBankingSystem.stage = stage;
        addData();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static Stage getStage(){
        return stage;
    }
}