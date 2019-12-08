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
import fermeapp.model.VentePoule;
import fermeapp.model.VentePoussin;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import util.utillForComponent;

/**
 * FXML Controller class
 *
 * @author Notsawo
 */
public class PoussinviewController implements Initializable {
    
  FermeApp fermeApp;
    
    @FXML
    private GridPane GridPaneGauche;
    @FXML
    private GridPane GridPaneDroite;
    @FXML
    private JFXComboBox<String> ageCombo;
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
    private TableView<VentePoussin> factureTableView;
    @FXML
    private TableColumn<VentePoussin, String> agePoussinColumn;
    @FXML
    private TableColumn<VentePoussin, Integer> quantitéColumn;
    @FXML
    private TableColumn<VentePoussin, Integer> prixUnitaireColumn;
    @FXML
    private TableColumn<VentePoussin, Integer> prixTotalColumn;
    @FXML
    private JFXDatePicker dateAchatPicker;
    @FXML
    private JFXComboBox<String> modePaeimentCombo;
    @FXML
    private JFXTextField nomClientTextField;
    
    private ObservableList<VentePoussin> VentePoussinData = FXCollections.observableArrayList();
    @FXML
    private JFXButton poulesButton;
    @FXML
    private JFXButton oeufsButton;
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GridPaneGauche.setPadding(new Insets(10));
        GridPaneDroite.setPadding(new Insets(10));
        ageCombo.setItems(FXCollections.observableArrayList("Demarrage", "15 jours"));
        ageCombo.getSelectionModel().select(0);
        
        utillForComponent.initSpinner(quantitéSpinner, 1, 10000, 50, 1);
        utillForComponent.initSpinner(prixUnitaireSpinner, 50, 10000, 50, 10);
        
        
        prixTotalTextField.setText("0");
        prixTotalTextField.setDisable(true);
        
        //ajouterButton 
        //anulerButton;
        //annulerVenteButton;
        //validerFactureButton;
        
        MontantTotalTextField.setText("0");
        MontantTotalTextField.setDisable(true);
        
        //modifierButton;
        //supprimerButton;
        
        factureTableView.setItems(VentePoussinData);
        
        agePoussinColumn.setCellValueFactory(cellData -> cellData.getValue().nbJourProperty());
        quantitéColumn.setCellValueFactory(cellData -> cellData.getValue().quantitéProperty());
        prixUnitaireColumn.setCellValueFactory(cellData -> cellData.getValue().prixUnitaireProperty());
        prixTotalColumn.setCellValueFactory(cellData -> cellData.getValue().prixTotalProperty());
        
        utillForComponent.initDateAchatPicker(dateAchatPicker);
        
        modePaeimentCombo.setItems(FXCollections.observableArrayList("Cash", "Mobile Money"));
        modePaeimentCombo.getSelectionModel().select(0);
        
        // nomClientTextField;
        
        // TODO : Pour les prix unitaires, il faudra allé dans la base de donnée chercher les plus réssents
        // et les proposés à l'utilisateur
        // Initialize the facture table with the two columns.
    }  
    
// Les écouteurs
    
    // Ecouteur du GridPaneGauche;
    // Ecouteur du GridPaneDroite;
    // Ecouteur du unitéVenteCombo;
    // Ecouteur du calibreCombo;
    
    // Ecouteur du quantitéSpinner; 
    // Ecouteur du prixUnitaireSpinner;
    @FXML
    private void surveiller(KeyEvent event) {
        int prixTotal = Integer.parseInt(quantitéSpinner.getEditor().getText())*Integer.parseInt(prixUnitaireSpinner.getEditor().getText());
        prixTotalTextField.setText(prixTotal+"");
    }
    
    @FXML
    private void G(MouseEvent event) {
        int prixTotal = Integer.parseInt(quantitéSpinner.getEditor().getText())*Integer.parseInt(prixUnitaireSpinner.getEditor().getText());
        prixTotalTextField.setText(prixTotal+"");
    }
    // Ecouteur du prixTotalTextField;
    // Ecouteur du ajouterButton;
    @FXML
    private void handleAjouter() {
        if(!prixUnitaireSpinner.getEditor().getText().equalsIgnoreCase("0")){
            VentePoussinData.add(new VentePoussin(
                ageCombo.getValue(), 
                Integer.parseInt(quantitéSpinner.getEditor().getText()), 
                Integer.parseInt(prixUnitaireSpinner.getEditor().getText())
            ));
            
            int prixTotal = Integer.parseInt(quantitéSpinner.getEditor().getText())*Integer.parseInt(prixUnitaireSpinner.getEditor().getText());
            prixTotalTextField.setText(prixTotal+"");
            if(!MontantTotalTextField.getText().equals(""))
                prixTotal = Integer.parseInt(MontantTotalTextField.getText()) + prixTotal;
            MontantTotalTextField.setText(prixTotal+""); 
        }else{
            // TODO : une fenetre d'erreur
        }   
    }
    
    // Ecouteur du anulerButton;
    @FXML
    private void handleAnnuler(ActionEvent event) {
        quantitéSpinner.getEditor().setText("0");
        prixUnitaireSpinner.getEditor().setText("0");
        prixTotalTextField.setText("0");
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
        String errorMessage = "";

        if (nomClientTextField.getText() == null || nomClientTextField.getText().length() == 0) {
            errorMessage += "Saisissez le nom du client\n";
        }
        if (MontantTotalTextField.getText() == null || MontantTotalTextField.getText().equals("0")) {
            errorMessage += "Aucune vente selectionné!\n";
        }
        
        if (errorMessage.length() == 0) {
            // TODO :  generer une facture
            System.out.println(VentePoussinData);
            VentePoussinData.forEach((vp) -> {
                System.out.println(vp);
            });
            
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText(errorMessage);
            alert.showAndWait();
        }
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
        VentePoussin vp  = factureTableView.getSelectionModel().getSelectedItem();
        
        VentePoussin vpp  = new VentePoussin(vp);
        int selectedIndex = factureTableView.getSelectionModel().getSelectedIndex();
        if (vp != null) {
            if (fermeApp.showModifierFactureDialog(vp)){
                factureTableView.refresh();
                int prixTotal = Integer.parseInt(MontantTotalTextField.getText()) - vpp.getQuantité()*vpp.getPrixUnitaire();
                vp = new VentePoussin(factureTableView.getItems().get(selectedIndex));
                prixTotal = prixTotal + vp.getQuantité()*vp.getPrixUnitaire();
                MontantTotalTextField.setText(prixTotal+""); 
           }
       } else {
           Alert alert = new Alert(AlertType.WARNING);
           alert.initOwner(fermeApp.getPrimaryStage());
           alert.setTitle("No Selection");
           alert.setHeaderText("Aucune vente selectionnée");
           alert.setContentText("SVP selectionnéz une vente dans la table");
           alert.showAndWait();
       }
    }
    
    // Ecouteur du supprimerButton;
    @FXML
    void handleDeleteVente() {
        int selectedIndex = factureTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            int prixTotal = Integer.parseInt(MontantTotalTextField.getText()) - factureTableView.getSelectionModel().getSelectedItem().getPrixTotal() ;
            MontantTotalTextField.setText(prixTotal+""); 
            factureTableView.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(fermeApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("Aucune vente sélectionnée");
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
    @FXML
    private void handleAjouterFacture(ActionEvent event) {
        // TODO : Sauvegarder la facture 
        if(event.getSource().equals(oeufsButton)){
            this.getFermeApp().oeufVente();
        }
        if(event.getSource().equals(poulesButton)){
           this.getFermeApp().poussinVente();
        }
    }

    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    } 

}
