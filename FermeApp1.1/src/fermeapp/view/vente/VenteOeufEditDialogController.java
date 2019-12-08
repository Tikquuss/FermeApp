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
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

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
        
        quantitéSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10000, venteOeuf.getQuantité()));
        
        prixUnitaireSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(50, 10000, venteOeuf.getPrixUnitaire()));

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
        quantitéSpinner.getValueFactory().setValue(venteOeuf.getQuantité());
        prixUnitaireSpinner.getValueFactory().setValue(venteOeuf.getPrixUnitaire());
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
        if (isInputValid()) {
            venteOeuf.setUnitéVente(unitéVenteCombo.getValue());
            venteOeuf.setCalibre(calibreCombo.getValue());
            venteOeuf.setQuantité(quantitéSpinner.getValue());
            venteOeuf.setPrixUnitaire(prixUnitaireSpinner.getValue());
            venteOeuf.setPrixTotal(Integer.parseInt(prixTotalTextField.getText()));
            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        return true;
        /*
        String errorMessage = "";

        if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
            errorMessage += "No valid first name!\n";
        }
        if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
            errorMessage += "No valid last name!\n";
        }
        if (streetField.getText() == null || streetField.getText().length() == 0) {
            errorMessage += "No valid street!\n";
        }

        if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
            errorMessage += "No valid postal code!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(postalCodeField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }

        if (cityField.getText() == null || cityField.getText().length() == 0) {
            errorMessage += "No valid city!\n";
        }

        if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
            errorMessage += "No valid birthday!\n";
        } else {
            if (!DateUtil.validDate(birthdayField.getText())) {
                errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
            }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
        //*/
    }
}
