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
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import modelferme.Exceptions.ValidationException;
import modelferme.makers.ModelManager;

/**
 * FXML Controller class
 *
 * @author machine
 */
public class Nouveau_medicament_viewController implements Initializable {
    
    @FXML
    private Label lbl_title;
    @FXML
    private JFXButton btn_Enregistrer;
    @FXML
    private JFXButton btn_Annuler;
    
    private Stage dialog;
    @FXML
    private JFXTextField nom_field;
    @FXML
    private JFXTextArea description_field;
    
    private Soins_viewController soin;
    
    
    ///////////////////////////***********************\\\\\\\\\\\\\\\\\\\\

    public Stage getDialog() {
        return dialog;
    }

    public Soins_viewController getSoin() {
        return soin;
    }

    public void setSoin(Soins_viewController soin) {
        this.soin = soin;
    }
    

    public void setDialog(Stage dialog) {
        this.dialog = dialog;
    }
    
    
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
            
            try {
                ModelManager.getInstance().RegisterMedicament(lbl_title.getText(), description_field.getText() ,"");
                this.getSoin().loadData();
                this.getDialog().close();
            } catch (ValidationException ex) {
                String err = "";
                Set<String> keySet = ex.getErrors().keySet();
                for(String att : keySet){
                    err += att + " : " + ex.getErrors().get(att);
                }
                Alert a = new Alert(AlertType.ERROR);
                a.setContentText(err);
                a.showAndWait();
                
            }
        }
        else{
            Alert a = new Alert(AlertType.ERROR);
            a.setContentText("nom invalide");
            a.showAndWait();
        }
        
    }
    
    private boolean validate_data(){
        boolean result = false;
        return !this.nom_field.getText().isEmpty(); 
    }

    @FXML
    private void cancel(ActionEvent event) {
        this.getDialog().close();
    }
   

   
    
}
