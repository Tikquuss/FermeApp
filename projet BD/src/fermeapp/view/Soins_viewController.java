/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import fermeapp.controller.FermeApp;
import fermeapp.model.Personnel;
import fermeapp.model.Soins;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import modelferme.Exceptions.Unauthorized;
import modelferme.Exceptions.ValidationException;
import modelferme.bean.Bande;
import modelferme.bean.Maladie;
import modelferme.bean.Medicament;
import modelferme.makers.ModelManager;

/**
 * FXML Controller class
 *
 * @author machine
 */
public class Soins_viewController implements Initializable {

    @FXML
    private JFXComboBox<Medicament> nom_Medicament;
    @FXML
    private JFXButton Btn_Enregistrer;
    @FXML
    private JFXButton Btn_Modifier;
    @FXML
    private JFXButton Btn_Supprimer;
    @FXML
    private Label lbl_title;
    @FXML
    private JFXComboBox<Maladie> nom_Maladie;
    @FXML
    private JFXButton btn_Ajouter_Med;
    @FXML
    private JFXButton btn_Ajouter_Mal;
    private FermeApp fermeApp;
    private JFXDatePicker dateSoins;
    private JFXTextField heureSoins;
    @FXML
    private TableView<Soins> soinsTableView;
    @FXML
    private TableColumn<Soins, String> nomMedicamentColumn;
    @FXML
    private TableColumn<Soins, String> nomMaladieColumn;
    @FXML
    private TableColumn<Soins, String> dateColumn;
    
    private ObservableList<Soins> soinsData = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox<Bande> bandeSoin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /* 
        ObservableList<String> Medicament = FXCollections.observableArrayList("Quinine","Amoxiciline", "Combiart");
        nom_Medicament.setItems(Medicament);
        */
        bandeSoin.getItems().addAll(Bande.all());
        nom_Maladie.getItems().addAll(Maladie.all());
        nom_Medicament.getItems().addAll(Medicament.all());
      /*  
        ObservableList<String> Maladie = FXCollections.observableArrayList("Grippe","Paludisme", "Lèpre");
        nom_Maladie.setItems(Maladie);
        
        soinsTableView.setItems(soinsData);
       /* nomMedicamentColumn.setCellValueFactory(cellData -> cellData.getValue().nomMedicamentProperty());
        nomMaladieColumn.setCellValueFactory(cellData -> cellData.getValue().nomMaladieProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        heureColumn.setCellValueFactory(cellData -> cellData.getValue().heureProperty());*/
    }
    
    
    public void loadData(){
        System.out.println("fermeapp.view.Soins_viewController.loadData()");
    }

    

    @FXML
    private void onClick_AddMed(ActionEvent event) {
        this.getFermeApp().addMedicament();
    }

    @FXML
    private void onClick_AddMal(ActionEvent event) {
        
        this.getFermeApp().addMaladie();
    }

    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }
    
    
    //**********************////***************/////////////*******************
    @FXML
    private void onSave(ActionEvent event) {
        
        try {
            ModelManager.getInstance().RegisterSoin(bandeSoin.getSelectionModel().getSelectedItem(), nom_Medicament.getSelectionModel().getSelectedItem(), nom_Maladie.getSelectionModel().getSelectedItem());
        } catch (ValidationException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Critical Error");
            HashMap<String, String> errors = ex.getErrors();
            String msg = "";
            for(String att : errors.keySet()){
                
                msg += att + " " + errors.get(att) + "\n";
            }
            alert.setHeaderText("Une erreur est survenue lors de la sauvegarde des données ");
            alert.setContentText(msg);
            Optional<ButtonType> result = alert.showAndWait();
            
        } catch (Unauthorized ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Critical Error");
            alert.setHeaderText("Une erreur est survenue lors de la sauvegarde des données ");
            Optional<ButtonType> result = alert.showAndWait();
            
        }
    }
    
}
