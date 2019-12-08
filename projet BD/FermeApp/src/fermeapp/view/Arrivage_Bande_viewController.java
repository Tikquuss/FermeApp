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
import fermeapp.controller.FermeApp;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import modelferme.Exceptions.Unauthorized;
import modelferme.Exceptions.ValidationException;
import modelferme.bean.Fournisseur;
import modelferme.bean.Race;
import modelferme.makers.ModelManager;

/**
 * FXML Controller class
 *
 * @author machine
 */
public class Arrivage_Bande_viewController implements Initializable {
    
     private FermeApp fermeApp;
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
    private JFXComboBox<Fournisseur> om_fournisseur_combo;
    @FXML
    private JFXTextField quantite_field;
    @FXML
    private JFXDatePicker date_field;
    @FXML
    private JFXTextField montant_field;
    private JFXTextField nom_bande_field;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        om_fournisseur_combo.getItems().addAll(Fournisseur.all());
    }    

    @FXML
    private void onSave(ActionEvent event) {
         try {
             ModelManager.getInstance().RegisterBande("les nani"+ Math.random()
                     , Integer.parseInt(quantite_field.getText())
                     ,Integer.parseInt(montant_field.getText()),
                     om_fournisseur_combo.getSelectionModel().getSelectedItem(),
                     new Race(),
                     date_field.getValue());
         } catch (Unauthorized ex) {
             Logger.getLogger(Arrivage_Bande_viewController.class.getName()).log(Level.SEVERE, null, ex);
         } catch (ValidationException ex) {
             Logger.getLogger(Arrivage_Bande_viewController.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }
}
