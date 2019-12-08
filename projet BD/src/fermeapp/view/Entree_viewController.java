/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import fermeapp.controller.FermeApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author machine
 * 
 */

   
public class Entree_viewController implements Initializable {
    
    private FermeApp fermeApp;
    @FXML
    private Label lbl_id_Entree;
    @FXML
    private Label lbl_Quantite;
    @FXML
    private Label lbl_Total_Defec;
    @FXML
    private Label lbl_Date;
    @FXML
    private JFXDatePicker date_Recrutement_Personnel;
    @FXML
    private JFXTextField txt_id_Entree;
    @FXML
    private JFXTextField txt_Quantite;
    @FXML
    private JFXTextField txt_Total_Defec;
    @FXML
    private JFXButton btn_Enregistrer;
    @FXML
    private JFXButton btn_Modifier;
    @FXML
    private JFXButton btn_Supprimer;
    @FXML
    private JFXButton btn_Ajouter;
    @FXML
    private JFXButton btn_Annuler;
    @FXML
    private Label nouvelle_Entree_title;
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
}
