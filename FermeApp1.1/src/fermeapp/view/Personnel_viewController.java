/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import fermeapp.FermeApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author machine
 */
public class Personnel_viewController implements Initializable {
    
    private FermeApp fermeApp;
    @FXML
    private JFXDatePicker date_Recrutement_Personnel;
    @FXML
    private JFXTextField ID_Personnel;
    @FXML
    private JFXTextField nom_Personnel;
    @FXML
    private JFXTextField prenom_Personnel;
    @FXML
    private JFXTextField username_Personnel;
    @FXML
    private JFXPasswordField password_Personnel;
    @FXML
    private JFXComboBox<String> etat_Personnel;
    @FXML
    private JFXButton Btn_Enregister_Personnel;
    @FXML
    private JFXButton Btn_Modifier_Personnel;
    @FXML
    private JFXButton Btn_Supprimer_Personnel;
    @FXML
    private JFXButton Btn_Ajouter_Personnel;
    @FXML
    private JFXButton Btn_Annuler_Personnel;
    /**
     * Initializes the controller class.
     */
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> O = FXCollections.observableArrayList("Actif","Inactif");
        
        etat_Personnel.setItems(O);
    }    

    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }

    @FXML
    private void onSave(ActionEvent event) {
        
        System.out.print( nom_Personnel.getText());
    }
    
}
