/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view;

import fermeapp.controller.FermeApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Notsawo
 */
public class AccueilViewController implements Initializable {

    FermeApp fermeApp;
    
    @FXML
    private AnchorPane leftAnchorPane;
    @FXML
    private AnchorPane rigthAnchorPane;
    @FXML
    private Button venteButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

    @FXML
    private void handleVente(ActionEvent event) {
        this.getFermeApp().venteShow();
    }
    
    public AnchorPane getLeftAnchorPane() {
        return leftAnchorPane;
    }

    public void setLeftAnchorPane(AnchorPane leftAnchorPane) {
        this.leftAnchorPane = leftAnchorPane;
    }

    public AnchorPane getRigthAnchorPane() {
        return rigthAnchorPane;
    }

    public void setRigthAnchorPane(AnchorPane rigthAnchorPane) {
        this.rigthAnchorPane = rigthAnchorPane;
    }

    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }
}
