/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view;

import fermeapp.controller.FermeApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Notsawo
 */
public class AccueilViewController implements Initializable {

    FermeApp fermeApp;
    
    @FXML
    private AnchorPane leftAnchorPane;
    @FXML
    private AnchorPane rigthAnchorPane;
    @FXML
    private ImageView accueil_menu_personnel;
    @FXML
    private ImageView acceuil_menu_soins;
    @FXML
    private ImageView acceuil_menu_stock_alimentaire;
    @FXML
    private ImageView acceuil_menu_entree;
    @FXML
    private ImageView accueil_menu_arrivage;
    @FXML
    private ImageView accueil_menu_partenaire;
    @FXML
    private ImageView accueil_menu_bilan;
    @FXML
    private ImageView accueil_menu_depense;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  


    
    
    
    public AnchorPane getLeftAnchorPane() {
        return leftAnchorPane;
    }

    public void setLeftAnchorPane(AnchorPane leftAnchorPane) {
        this.leftAnchorPane = leftAnchorPane;
    }

    public AnchorPane getRigthAnchorPane() {
        return rigthAnchorPane;
    }

    public void setRigthAnchorPane(AnchorPane rigthAnchorPane) {
        this.rigthAnchorPane = rigthAnchorPane;
    }

    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }

    @FXML
    private void initialize(MouseEvent event) {
    }


    @FXML
    private void handleSoins(ActionEvent event) {
        this.getFermeApp().soinsShow();
    }

    @FXML
    private void handleVente(ActionEvent event) {
        this.getFermeApp().venteShow();
    }

    @FXML
    private void handleAliment(ActionEvent event) {
        
    }
    
    @FXML
    private void handlePersonnel(ActionEvent event) {
        this.getFermeApp().personnelShow();
    }
    
    @FXML
    private void handlePartenaire(ActionEvent event) {
        this.getFermeApp().partenaireShow();
    }

    @FXML
    private void handleBilanJournalier(ActionEvent event) {
        this.getFermeApp().bilanJournalierShow();
    }

    @FXML
    private void handleArrivage(ActionEvent event) {
        this.getFermeApp().arrivageBandeShow();
    }

    @FXML
    private void handleDepense(ActionEvent event) {
    }

    @FXML
    private void handleEntree(ActionEvent event) {
        this.getFermeApp().entreeShow();
    }
}
