/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author machine
 */
public class Nouvelle_Maladie_viewController implements Initializable {

    @FXML
    private Label lbl_title;
    @FXML
    private JFXButton btn_Enregistrer;
    @FXML
    private JFXButton btn_Annuler;
    @FXML
    private JFXTextField nom_field_maladie;
    @FXML
    private JFXTextArea description_field_maladie;
    
    private Stage dialog;
    
    private Soins_viewController soin;

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void save(ActionEvent event) {
        if(this.validate_data()){
            
            //after save
            this.getSoin().loadData();
            this.getDialog().close();
            System.out.println("Cette méthode marche bien");
        }
        else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("nom invalide");
            a.showAndWait();
        }
        
        
    }
    private boolean validate_data(){
        boolean result = false;
        return !this.nom_field_maladie.getText().isEmpty(); 
    }

    @FXML
    private void cancel(ActionEvent event) {
        this.getDialog().close();
    }

    
    public Stage getDialog() {
        return dialog;
    }

    public void setDialog(Stage dialog) {
        this.dialog = dialog;
    }

    public Soins_viewController getSoin() {
        return soin;
    }

    public void setSoin(Soins_viewController soin) {
        this.soin = soin;
    }
    
    
}
