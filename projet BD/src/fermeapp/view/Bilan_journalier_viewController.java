/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import fermeapp.controller.FermeApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author machine
 */
public class Bilan_journalier_viewController implements Initializable {
    private FermeApp fermeApp;
    @FXML
    private JFXTextField prenom_Personnel;
    @FXML
    private JFXButton Btn_Enregistrer;
    @FXML
    private JFXButton Btn_Modifier;
    @FXML
    private JFXButton Btn_Supprimer;
    @FXML
    private JFXButton Btn_Ajouter;
    @FXML
    private JFXButton Btn_Annuler;
    @FXML
    private Label lbl_title;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onSave(ActionEvent event) {
    }

    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }
    
}
