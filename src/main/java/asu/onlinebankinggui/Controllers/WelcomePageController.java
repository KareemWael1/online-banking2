package asu.onlinebankinggui.Controllers;

import asu.onlinebankinggui.OnlineBankingSystem;
import javafx.fxml.FXML;
import java.io.IOException;
import static asu.onlinebankinggui.Controllers.ControllerUtility.changeScene;

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
}