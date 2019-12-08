/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view.vente;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import fermeapp.controller.FermeApp;
import fermeapp.model.Facture;
import fermeapp.model.TableFacture;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import modelferme.bean.Livraison_Oeuf;
import modelferme.bean.Livrer_Poussin;
import modelferme.bean.Vendre;
import modelferme.makers.ModelManager;
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
    
    public static Facture factureFinale;
    public static int i;

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
        
        TableFactureData.addAll(convert());
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
    private void rechercher(KeyEvent event) {
        //TODO : mettre à jour le resultRechercheTableview, et donc le TableFactureData
        System.out.println("rechercher(MouseEvent event)");
        //TableFactureData.add(new TableFacture(i+"", i+"", 0, 0, i+""));
        i++;
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
    
     public static ObservableList<TableFacture> convert(){
        List<List> lazyFetchVentes = ModelManager.getInstance().lazyFetchVentes(LocalDate.now(), LocalDate.now());
        ObservableList<TableFacture> result = FXCollections.observableArrayList();
        List l1 = lazyFetchVentes.get(0);
        List l2 = lazyFetchVentes.get(1);
        List l3 = lazyFetchVentes.get(2);
        for(Object v : l1){
            Vendre vendre = (Vendre)v;
            TableFacture table = new TableFacture();
            table.setDate(new ReadOnlyStringWrapper(vendre.getDateVente().toString()));
            table.setMontant(vendre.getQuantite()*vendre.getPrixUnitaire());
            table.setNomClient(vendre.getPartenaire().getNom());
            table.setProduit("Poules");
            table.setQuantité(vendre.getQuantite());
            result.add(table);
        }
        
        for(Object v : l2){
            Livrer_Poussin vendre = (Livrer_Poussin)v;
            TableFacture table = new TableFacture();
            table.setDate(new ReadOnlyStringWrapper(vendre.getDate_livraison().toString()));
            table.setMontant(vendre.getMontant());
            table.setNomClient(vendre.getPartenaire().getNom());
            table.setProduit("Poussin");
            table.setQuantité(vendre.getQuantite());
            
            result.add(table);
        }
        
        for(Object v : l3){
            Livraison_Oeuf vendre = (Livraison_Oeuf)v;
            TableFacture table = new TableFacture();
            table.setDate(new ReadOnlyStringWrapper(vendre.getDateLivraison().toString()));
            table.setMontant(vendre.getMontant());
            table.setNomClient(vendre.getPartenaire().getNom());
            table.setProduit("Ouef");
            table.setQuantité(vendre.getQuantite());
            result.add(table);
        }
        
        return result.sorted();
        
         
    }
}
