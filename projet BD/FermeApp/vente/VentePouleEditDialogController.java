/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view.vente;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import fermeapp.model.VentePoule;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.utillForComponent;

/**
 * FXML Controller class
 *
 * @author Notsawo
 */
public class VentePouleEditDialogController implements Initializable {

    private Stage dialogStage;
    public static VentePoule ventePoule;
    private boolean okClicked = false;
    
    @FXML
    private JFXComboBox<String> typeCombo;
    @FXML
    private Spinner<Integer> quantitéSpinner;
    @FXML
    private Spinner<Integer> prixUnitaireSpinner;
    @FXML
    private JFXTextField prixTotalTextField;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        typeCombo.setItems(FXCollections.observableArrayList("Poule de chair", "Pondeuse"));
        typeCombo.getSelectionModel().select(ventePoule.getType().equals("Poule de chair") ? 0 : 1);
        
        utillForComponent.initSpinner(quantitéSpinner, 1, 10000, 50, 1);
        quantitéSpinner.getEditor().setText(ventePoule.getQuantité()+"");
        utillForComponent.initSpinner(prixUnitaireSpinner, 50, 10000, 50, 10);
        prixUnitaireSpinner.getEditor().setText(ventePoule.getPrixUnitaire()+"");

        prixTotalTextField.setText(ventePoule.getPrixTotal()+"");
        prixTotalTextField.setDisable(true);
    }   
    
    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Sets the person to be edited in the dialog.
     *
     * @param person
     */
    public void setVentePoule(VentePoule ventePoule) {
        this.ventePoule = ventePoule;
        typeCombo.setValue(ventePoule.getType());
        quantitéSpinner.getEditor().setText(ventePoule.getQuantité()+"");
        prixUnitaireSpinner.getEditor().setText(ventePoule.getPrixUnitaire()+"");
        prixTotalTextField.setText(ventePoule.getPrixTotal()+"");
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleOk() {
        ventePoule.setType(typeCombo.getValue());
        ventePoule.setQuantité(Integer.parseInt(quantitéSpinner.getEditor().getText()));
        ventePoule.setPrixUnitaire(Integer.parseInt(prixUnitaireSpinner.getEditor().getText()));
        ventePoule.setPrixTotal(Integer.parseInt(prixTotalTextField.getText()));
        okClicked = true;
        dialogStage.close();
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    @FXML
    private void surveiller(KeyEvent event) {
        int prixTotal = Integer.parseInt(quantitéSpinner.getEditor().getText())*Integer.parseInt(prixUnitaireSpinner.getEditor().getText());
        prixTotalTextField.setText(prixTotal+"");
    }
    @FXML
    private void surveiller(MouseEvent event) {
        int prixTotal = Integer.parseInt(quantitéSpinner.getEditor().getText())*Integer.parseInt(prixUnitaireSpinner.getEditor().getText());
        prixTotalTextField.setText(prixTotal+"");
    }
}
