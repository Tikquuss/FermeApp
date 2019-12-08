package controllers.whatsapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class AWhatsappController implements Initializable {

    @FXML private Button btnExit;

    @FXML public void handleBtnExitClick(){
        ((Stage)(btnExit.getScene().getWindow())).close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) { }
}
