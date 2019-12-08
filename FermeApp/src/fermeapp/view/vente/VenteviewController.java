/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view.vente;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import fermeapp.controller.FermeApp;
import fermeapp.model.TableFacture;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author Notsawo
 */
public class VenteviewController implements Initializable {
    
    FermeApp fermeApp;
    
    @FXML
    private Button oeufButton;
    @FXML
    private JFXButton poulesButton;
    @FXML
    private JFXButton poussinButton;
    @FXML
    private JFXButton ModifierPUButton;
    @FXML
    private JFXButton GererProduitButton;
    @FXML
    private JFXButton modifierParametresButton;
    @FXML
    private JFXButton listeFactureButton;
    @FXML
    private JFXTextField RechercheTextField;
    @FXML
    private TableView<TableFacture> resultRechercheTableview;
    @FXML
    private TableColumn<TableFacture, String> produitColumn;
    @FXML
    private TableColumn<TableFacture, Integer> montantColumn;
    @FXML
    private TableColumn<TableFacture, Integer>  quantitéColumn;
    @FXML
    private TableColumn<TableFacture, String> dateColumn;
    @FXML
    private TableColumn<TableFacture, String> nomClientColumn;
    
    private ObservableList<TableFacture> TableFactureData = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        resultRechercheTableview.setItems(TableFactureData);
        
        nomClientColumn.setCellValueFactory(cellData -> cellData.getValue().nomClientProperty());
        produitColumn.setCellValueFactory(cellData -> cellData.getValue().produitProperty());
        quantitéColumn.setCellValueFactory(cellData -> cellData.getValue().quantitéProperty());
        montantColumn.setCellValueFactory(cellData -> cellData.getValue().montantProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        
        // TODO : Mettre dans les 0-10 vente recentes
    } 
    
    @FXML
    private void Onclick(ActionEvent event) {
        if(event.getSource().equals(this.oeufButton)){
            this.getFermeApp().oeufVente();
        }
        if(event.getSource().equals(this.poulesButton)){
            this.getFermeApp().PouleVente();
        }
        if(event.getSource().equals(this.poussinButton)){
            this.getFermeApp().poussinVente();
        }
    }
   
    @FXML
    private void gererProduit(ActionEvent event) {
    }

    @FXML
    private void modifierParametre(ActionEvent event) {
    }

    @FXML
    private void listerFacture(ActionEvent event) {
    }

    @FXML
    private void ModifierPU(ActionEvent event) {
    }
    
    @FXML
    private void rechercher(KeyEvent event) {
        //TODO : mettre à jour le resultRechercheTableview, et donc le TableFactureData
        System.out.println("rechercher(MouseEvent event)");
    }
    
    private void retour(ActionEvent event){
        this.getFermeApp().principalStart();
    }

    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }
}
