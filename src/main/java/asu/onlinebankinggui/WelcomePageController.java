package asu.onlinebankinggui;

import javafx.fxml.FXML;
import java.io.IOException;
import static asu.onlinebankinggui.ControllerUtility.changeScene;

public class WelcomePageController {

    @FXML
    protected void onLoginButtonClick() throws IOException {
        changeScene("LoginPage.fxml");
    }

    @FXML
    protected void onSignupButtonClick() throws IOException {
        changeScene("SignupPage.fxml");
    }

    @FXML
    protected void onExitButtonClick(){
        OnlineBankingSystem.getStage().close();
    }

    @FXML
    protected void onTest() throws IOException{
        changeScene("MyInventoryPage.fxml");
    }
}