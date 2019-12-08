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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.collections.ObservableList;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import modelferme.bean.Calibre;
import modelferme.bean.Partenaire;
import modelferme.bean.Production_Oeuf;
import util.utillForComponent;

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
    private JFXComboBox<Calibre> calibreCombo;
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
    private TableColumn<VenteOeuf, String> entreposColumn;
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
    
    private ObservableList<VenteOeuf> VenteOeufData = FXCollections.observableArrayList();
    @FXML
    private JFXButton pouleButton;
    @FXML
    private JFXButton poussinButton;
    @FXML
    private JFXComboBox<Production_Oeuf> entreposCombo;
    @FXML
    private JFXComboBox<Partenaire> nomClientCombo;
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GridPaneGauche.setPadding(new Insets(10));
        GridPaneDroite.setPadding(new Insets(10));
        
        unitéVenteCombo.setItems(FXCollections.observableArrayList("Alvéole", "Oeuf"));
        unitéVenteCombo.getSelectionModel().select(0);
        calibreCombo.setItems(FXCollections.observableArrayList(Calibre.all()));
        calibreCombo.getSelectionModel().select(0);
        nomClientCombo.setItems(FXCollections.observableArrayList(Partenaire.all()));
        entreposCombo.setItems(FXCollections.observableArrayList(Production_Oeuf.all()));
        
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
        
        factureTableView.setItems(VenteOeufData);
        
        unitéVenteColumn.setCellValueFactory(cellData -> cellData.getValue().unitéVenteProperty());
        entreposColumn.setCellValueFactory(cellData -> cellData.getValue().calibreProperty());
        quantitéColumn.setCellValueFactory(cellData -> cellData.getValue().quantitéProperty());
        prixUnitaireColumn.setCellValueFactory(cellData -> cellData.getValue().prixUnitaireProperty());
        prixTotalColumn.setCellValueFactory(cellData -> cellData.getValue().prixTotalProperty());
        
        utillForComponent.initDateAchatPicker(dateAchatPicker);
        
        modePaeimentCombo.setItems(FXCollections.observableArrayList("Cash", "Mobile Money"));
        modePaeimentCombo.getSelectionModel().select(0);
        // nomClientTextField;
        //nomClientTextField.appendText("name");//TODO
        
        // TODO : Pour les prix unitaires, il faudra allé dans la base de donnée chercher les plus réssents
        // et les proposés à l'utilisateur
        // Initialize the facture table with the two columns.
    } 
    
    
// Les écouteurs
    
    // Ecouteur du GridPaneGauche;
    // Ecouteur du GridPaneDroite;
    // Ecouteur du unitéVenteCombo;
    // Ecouteur du calibreCombo;
    
    // Ecouteur du quantitéSpinner; // Ecouteur du prixUnitaireSpinner;
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
            VenteOeufData.add(new VenteOeuf(
                unitéVenteCombo.getValue(), 
                calibreCombo.getValue().getName(), 
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

        //if (nomClientTextField.getText() == null || nomClientTextField.getText().length() == 0) {
          //  errorMessage += "Saisissez le nom du client\n";
        //}
        if (MontantTotalTextField.getText() == null || MontantTotalTextField.getText().equals("0")) {
            errorMessage += "Aucune vente selectionné!\n";
        }
        
        if (errorMessage.length() == 0) {
            // TODO :  generer une facture 
            VenteviewController.factureFinale.persist();
            this.getFermeApp().produireFacture();
            System.out.println(VenteOeufData);
            VenteOeufData.forEach((vo) -> {
                System.out.println(vo);
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
    // Ecouteur du modifierButton;
    @FXML
    private void handleModifier() {
        VenteOeuf vo  = factureTableView.getSelectionModel().getSelectedItem();
        VenteOeuf voo  = new VenteOeuf(vo);
        int selectedIndex = factureTableView.getSelectionModel().getSelectedIndex();
        if (vo != null) {
            boolean b = fermeApp.showModifierFactureDialog(vo);
            if (b){
                factureTableView.refresh();
                int prixTotal = Integer.parseInt(MontantTotalTextField.getText()) - voo.getQuantité()*voo.getPrixUnitaire();
                vo = new VenteOeuf(factureTableView.getItems().get(selectedIndex));
                prixTotal = prixTotal + vo.getQuantité()*vo.getPrixUnitaire();
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
     
    
    
    @FXML
    private void handleAjouterFacture(ActionEvent event) {
        // TODO : Sauvegarder la facture 
        //VenteviewController.factureFinale.setVenteOeufData(VenteOeufData);
        if(event.getSource().equals(pouleButton)){
            this.getFermeApp().PouleVente();
        }
        if(event.getSource().equals(poussinButton)){
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