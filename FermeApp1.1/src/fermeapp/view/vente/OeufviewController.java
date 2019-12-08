/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view.vente;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import fermeapp.controller.FermeApp;
import fermeapp.model.VenteOeuf;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.util.StringConverter;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.ObservableList;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.ScrollEvent;

/**
 * FXML Controller class
 *
 * @author Notsawo
 */
public class OeufviewController implements Initializable {

    FermeApp fermeApp;
    
    @FXML
    private GridPane GridPaneGauche;
    @FXML
    private GridPane GridPaneDroite;
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
    @FXML
    private JFXButton ajouterButton;
    @FXML
    private JFXButton anulerButton;
    @FXML
    private JFXButton annulerVenteButton;
    @FXML
    private JFXButton validerFactureButton;
    @FXML
    private JFXTextField MontantTotalTextField;
    @FXML
    private JFXButton modifierButton;
    @FXML
    private JFXButton supprimerButton;
    @FXML
    private TableView<VenteOeuf> factureTableView;
    @FXML
    private TableColumn<VenteOeuf, String> unitéVenteColumn;
    @FXML
    private TableColumn<VenteOeuf, String> calibreColumn;
    @FXML
    private TableColumn<VenteOeuf, Integer> quantitéColumn;
    @FXML
    private TableColumn<VenteOeuf, Integer> prixUnitaireColumn;
    @FXML
    private TableColumn<VenteOeuf, Integer> prixTotalColumn;
    @FXML
    private JFXDatePicker dateAchatPicker;
    @FXML
    private JFXComboBox<String> modePaeimentCombo;
    @FXML
    private JFXTextField nomClientTextField;
    
    private ObservableList<VenteOeuf> VenteOeufData = FXCollections.observableArrayList();
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GridPaneGauche.setPadding(new Insets(10));
        GridPaneDroite.setPadding(new Insets(10));
        
        unitéVenteCombo.setItems(FXCollections.observableArrayList("Alvéole", "Oeuf"));
        unitéVenteCombo.getSelectionModel().select(0);
        calibreCombo.setItems(FXCollections.observableArrayList("Gros", "Moyen", "Petit"));
        calibreCombo.getSelectionModel().select(0);
        modePaeimentCombo.setItems(FXCollections.observableArrayList("Cash", "Mobile Money"));
        
        quantitéSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10000, 0));
        
        prixUnitaireSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(50, 10000, 0));
       
        prixUnitaireSpinner.setOnMousePressed(event -> {
            System.out.println("increment");
        });
        prixUnitaireSpinner.setOnDragDetected(event -> {
            System.out.println("increment 1");
        });
        
        prixUnitaireSpinner.setOnInputMethodTextChanged(event -> {
            try {
                Integer.parseInt(prixUnitaireSpinner.getValue()+"");
            } catch (NumberFormatException e) {
            }
            if(prixUnitaireSpinner.getValue()%10 != 0) {
                prixUnitaireSpinner.getValueFactory().setValue(prixUnitaireSpinner.getValue()/10);
            }
        });
        
        prixTotalTextField.setText("0");
        prixTotalTextField.setDisable(true);
        
        //ajouterButton 
        //anulerButton;
        //annulerVenteButton;
        //validerFactureButton;
        
        MontantTotalTextField.setText("0");
        MontantTotalTextField.setDisable(true);
        //prixTotalTextField.setEditable(false);
        //modifierButton;
        //supprimerButton;
        
        factureTableView.setItems(VenteOeufData);
        
        unitéVenteColumn.setCellValueFactory(cellData -> cellData.getValue().unitéVenteProperty());
        calibreColumn.setCellValueFactory(cellData -> cellData.getValue().calibreProperty());
        quantitéColumn.setCellValueFactory(cellData -> cellData.getValue().quantitéProperty());
        prixUnitaireColumn.setCellValueFactory(cellData -> cellData.getValue().prixUnitaireProperty());
        prixTotalColumn.setCellValueFactory(cellData -> cellData.getValue().prixTotalProperty());
        
        initDateAchatPicker();
        
        // modePaeimentCombo;
        // nomClientTextField;
        
        // TODO : Pour les prix unitaires, il faudra allé dans la base de donnée chercher les plus réssents
        // et les proposés à l'utilisateur
        // Initialize the facture table with the two columns.
    }  
    
    private void initDateAchatPicker(){
        //pour afficher/masquer une colonne indiquant les numéros de semaine. 
        dateAchatPicker.setShowWeekNumbers(false);
        //La date dans le champ de texte est automatiquement convertie au format local(dans mon cas, dd.MM.yyyy ). 
        //En définissant un StringConverter nous pouvons changer ceci, par exemple, en yyyy-MM-dd
        String pattern = "yyyy-MM-dd";
        dateAchatPicker.setPromptText(pattern.toLowerCase());
        dateAchatPicker.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override 
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override 
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        // Add some action (in Java 8 lambda syntax style).
        dateAchatPicker.setOnAction(event -> {
            LocalDate date = dateAchatPicker.getValue();
            System.out.println("Selected date: " + date);
        });
    }
    
// Les écouteurs
    
    // Ecouteur du GridPaneGauche;
    // Ecouteur du GridPaneDroite;
    // Ecouteur du unitéVenteCombo;
    // Ecouteur du calibreCombo;
    
    // Ecouteur du quantitéSpinner; 
    // Ecouteur du prixUnitaireSpinner;
    @FXML
    private void surveiller(InputMethodEvent event) {
        if(prixUnitaireSpinner.getValue()%10 != 0) {
            prixUnitaireSpinner.getValueFactory().setValue(prixUnitaireSpinner.getValue()/10);
        }
    }

    @FXML
    private void surveiller(ScrollEvent event) {
        if(prixUnitaireSpinner.getValue()%10 != 0) {
            prixUnitaireSpinner.getValueFactory().setValue(prixUnitaireSpinner.getValue()/10);
        }
    }  
    // Ecouteur du prixTotalTextField;
    // Ecouteur du ajouterButton;
    @FXML
    private void handleAjouter() {
        VenteOeufData.add(new VenteOeuf(unitéVenteCombo.getValue(), calibreCombo.getValue(), quantitéSpinner.getValue(), prixUnitaireSpinner.getValue()));
        int prixTotal = quantitéSpinner.getValue()*prixUnitaireSpinner.getValue();
        prixTotalTextField.setText(prixTotal+"");
        if(!MontantTotalTextField.getText().equals(""))
            prixTotal = Integer.parseInt(MontantTotalTextField.getText()) + prixTotal;
        MontantTotalTextField.setText(prixTotal+"");    
    }
    // Ecouteur du anulerButton;
    @FXML
    private void handleAnnuler(ActionEvent event) {
    }
    // Ecouteur du annulerVenteButton;
    @FXML
    private void handleRetour(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Annulation de vente");
        alert.setContentText("Voulez-vous vraiment annuler cette vente");
        alert.setHeaderText("Tout les informations concernant la vente seront perdus");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            this.getFermeApp().venteShow();
        } 
    }
    // Ecouteur du validerFactureButton;
    @FXML
    private void handleValiderFacture(ActionEvent event) {
    }
    // Ecouteur du MontantTotalTextField;
    private void ValiderFacture(ActionEvent event) {
        String errorMessage = "";

        if (nomClientTextField.getText() == null || nomClientTextField.getText().length() == 0) {
            errorMessage += "Saisissez le nom du client\n";
        }
        if (MontantTotalTextField.getText() == null || MontantTotalTextField.getText().length() == 0) {
            errorMessage += "Aucune vente selectionné!\n";
        }else{
            try {
                Integer.parseInt(MontantTotalTextField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid postal code (must be an integer)!\n";
            }
        }
        if (errorMessage.length() == 0) {
            // TODO :  generer une facture
        } else {
            // Show the error message.
            //Stage stage = new Stage();
            Alert alert = new Alert(AlertType.INFORMATION);
            //alert.initOwner(stage);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText(errorMessage);
            alert.showAndWait();
        }
        
    }
    // Ecouteur du modifierButton;
    @FXML
    private void handleModifier() {
       VenteOeuf vo  = factureTableView.getSelectionModel().getSelectedItem();
       if (vo != null) {
           boolean okClicked = fermeApp.showModifierFactureDialog(vo);
           if (okClicked) {
             factureTableView.refresh();
           }
       } else {
           Alert alert = new Alert(AlertType.WARNING);
           alert.initOwner(fermeApp.getPrimaryStage());
           alert.setTitle("No Selection");
           alert.setHeaderText("No Person Selected");
           alert.setContentText("Please select a person in the table.");
           alert.showAndWait();
       }
    }
    // Ecouteur du supprimerButton;
    @FXML
    void handleDeleteVente() {
        int selectedIndex = factureTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            factureTableView.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(fermeApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("Aucune vente sélectionner");
            alert.setContentText("S'il vous plait selectionner une vente dans la facture");
            alert.showAndWait();
        }
    }
    // Ecouteur du factureTableView;
    // Ecouteur du unitéVenteColumn;
    // Ecouteur du calibreColumn;
    // Ecouteur du quantitéColumn;
    // Ecouteur du prixUnitaireColumn;
    // Ecouteur du prixTotalColumn;
    // Ecouteur du dateAchatPicker;
    // Ecouteur du modePaeimentCombo;
    // Ecouteur du nomClientTextField;
        
     /**
    * Called when the user clicks the new button. Opens a dialog to edit
    * details for a new person.
    */

    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }
}