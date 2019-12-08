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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import modelferme.Exceptions.ValidationException;
import modelferme.bean.Fournisseur;

/**
 * FXML Controller class
 *
 * @author machine
 */
public class Partenaire_fournisseur_viewController implements Initializable {
    
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
    private JFXTextField telephone;
    @FXML
    private JFXTextField adresse;
    @FXML
    private JFXTextField nom;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
       
    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }

    @FXML
    private void onSave(ActionEvent event) {
        String nom1 = nom.getText();
        String telephone1 = telephone.getText();
        String adresse1 = adresse.getText();
        try {
                boolean RegisterMaladie = modelferme.makers.ModelManager.getInstance().RegisterFournisseur(nom1, telephone1, adresse1);
            ObservableList<Fournisseur> observableArrayList = FXCollections.observableArrayList(modelferme.bean.Fournisseur.all());
            } catch (ValidationException ex) {
                Alert a = new Alert(Alert.AlertType.ERROR);
                String content = "";
                for(String att : ex.getErrors().keySet()){
                    content += att + ":" +ex.getErrors().get(att);
                }
                a.setContentText(content);
                a.showAndWait();
            }
    }
}
