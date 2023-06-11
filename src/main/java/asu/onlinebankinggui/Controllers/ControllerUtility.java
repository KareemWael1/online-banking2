package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.OnlineBankingSystem;
import asu.onlinebankinggui.source.src.Bill;
import asu.onlinebankinggui.source.src.Shop;
import asu.onlinebankinggui.source.src.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ControllerUtility {
    public static User user;

    public static void changeScene(String fxmlFile) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(OnlineBankingSystem.class.getResource(fxmlFile));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Stage stage = OnlineBankingSystem.getStage();
        stage.setScene(scene);
        stage.show();
    }

    public static ButtonType confirmation(String text){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, text, ButtonType.YES, ButtonType.CANCEL);
        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
                Objects.requireNonNull(ControllerUtility.class.getResource("/asu/onlinebankinggui/css/main.css")).toExternalForm());
        dialogPane.getStyleClass().add("dialog-pane");
        alert.getDialogPane().lookupButton(ButtonType.YES).setId("yes");
        alert.getDialogPane().lookupButton(ButtonType.CANCEL).setId("cancel");
        Stage stage = (Stage) dialogPane.getScene().getWindow();
        stage.getIcons().add(new Image(Objects.requireNonNull(OnlineBankingSystem.class.getResourceAsStream("/asu/onlinebankinggui/images/BankIcon.png"))));
        alert.showAndWait();
        return alert.getResult();
    }

    public static void addData(){
        User.signUp("Ziad", "Amerr", "ziad", "12345678");
        User.signUp("Kareem", "Wael", "kimo", "aaaaaaaa");

        User user1 = User.getUser("ziad");
        User user2 = User.getUser("kimo");

        user1.login("ziad", "12345678");
        user2.login("kimo", "aaaaaaaa");

        user1.createAccount("EGP", "Checking");
        user2.createAccount("USD", "Savings");

        user1.useAccount(user1.getAccountNums().get(0));
        user2.useAccount(user2.getAccountNums().get(0));

        Shop.addNewItem("Gift", 10, 100);
        Shop.addNewItem("Cup", 5, 50);

        Shop.addBill("Electricity_May_2023", 200, user1.getAccountNumber());
        Shop.addBill("Gas_April_2023", 133, user1.getAccountNumber());

        user1.deposit(200);
        user2.deposit(1000);
        user1.buy("Gift");
        user1.logout();
        user2.logout();
    }
}
