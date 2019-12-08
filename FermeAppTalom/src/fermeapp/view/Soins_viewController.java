/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import fermeapp.FermeApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author machine
 */
public class Soins_viewController implements Initializable {

    @FXML
    private JFXDatePicker date_Recrutement_Personnel;
    @FXML
    private JFXTextField prenom_Personnel;
    @FXML
    private JFXComboBox<String> nom_Medicament;
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
    @FXML
    private JFXComboBox<String> nom_Maladie;
    @FXML
    private JFXButton btn_Ajouter_Med;
    @FXML
    private JFXButton btn_Ajouter_Mal;
    private FermeApp fermeApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void loadData(){
        System.out.println("fermeapp.view.Soins_viewController.loadData()");
    }

    @FXML
    private void onSave(ActionEvent event) {
    }

    @FXML
    private void onClick_AddMed(ActionEvent event) {
        this.getFermeApp().addMedicament();
    }

    @FXML
    private void onClick_AddMal(ActionEvent event) {
        
        this.getFermeApp().addMaladie();
    }

    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }
    
}
