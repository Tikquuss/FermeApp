/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view.vente;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import fermeapp.model.VenteOeuf;
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
public class VenteOeufEditDialogController implements Initializable {

    private Stage dialogStage;
    public static VenteOeuf venteOeuf = new VenteOeuf();
    private boolean okClicked = false;
    
    @FXML
    private JFXComboBox<String> unitéVenteCombo;
    @FXML
    private JFXComboBox<String> calibreCombo;
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
        unitéVenteCombo.setItems(FXCollections.observableArrayList("Alvéole", "Oeuf"));
        if(venteOeuf.getUnitéVente().equals("Alvéole"))
            unitéVenteCombo.getSelectionModel().select(0);
        else if(venteOeuf.getUnitéVente().equals("Oeuf"))
            unitéVenteCombo.getSelectionModel().select(1);
        
        calibreCombo.setItems(FXCollections.observableArrayList("Gros", "Moyen", "Petit"));
        switch (venteOeuf.getCalibre()) {
            case "Gros":
                calibreCombo.getSelectionModel().select(0);
                break;
            case "Moyen":
                calibreCombo.getSelectionModel().select(1);
                break;
            case "Petit":
                calibreCombo.getSelectionModel().select(2);
                break;
            default:
                break;
        }
        
        utillForComponent.initSpinner(quantitéSpinner, 1, 10000, 50, 1);
        quantitéSpinner.getEditor().setText(venteOeuf.getQuantité()+"");
        utillForComponent.initSpinner(prixUnitaireSpinner, 50, 10000, 50, 10);
        prixUnitaireSpinner.getEditor().setText(venteOeuf.getPrixUnitaire()+"");

        prixTotalTextField.setText(venteOeuf.getPrixTotal()+"");
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
    public void setVenteOeuf(VenteOeuf venteOeuf) {
        this.venteOeuf = venteOeuf;
        unitéVenteCombo.setValue(venteOeuf.getUnitéVente());
        calibreCombo.setValue(venteOeuf.getCalibre());
        quantitéSpinner.getEditor().setText(venteOeuf.getQuantité()+"");
        prixUnitaireSpinner.getEditor().setText(venteOeuf.getPrixUnitaire()+"");
        prixTotalTextField.setText(venteOeuf.getPrixTotal()+"");
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
        venteOeuf.setUnitéVente(unitéVenteCombo.getValue());
        venteOeuf.setCalibre(calibreCombo.getValue());
        venteOeuf.setQuantité(Integer.parseInt(quantitéSpinner.getEditor().getText()));
        venteOeuf.setPrixUnitaire(Integer.parseInt(prixUnitaireSpinner.getEditor().getText()));
        venteOeuf.setPrixTotal(Integer.parseInt(prixTotalTextField.getText()));
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
