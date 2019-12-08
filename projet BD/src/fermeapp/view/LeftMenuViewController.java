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

/**
 * FXML Controller class
 *
 * @author machine
 */
public class LeftMenuViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    FermeApp fermeApp;

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }
    
    public FermeApp getFermeApp() {
        return fermeApp;
    }

    @FXML
    private void onClickPersonnel(ActionEvent event) {
        this.getFermeApp().personnelShow();
    }

    @FXML
    private void onClickSoins(ActionEvent event) {
        this.getFermeApp().soinsShow();
    }

    @FXML
    private void onClickAliment(ActionEvent event) {
        
    }

    @FXML
    private void onClickEntree(ActionEvent event) {
        this.getFermeApp().entreeShow();
    }

    @FXML
    private void onClickPartenaire(ActionEvent event) {
        this.getFermeApp().partenaireShow();
    }

    @FXML
    private void onClickBilanJournalier(ActionEvent event) {
        this.getFermeApp().bilanJournalierShow();
    }

    @FXML
    private void onClickDepense(ActionEvent event) {
    }

    @FXML
    private void onClickArrivage(ActionEvent event) {
        this.getFermeApp().arrivageBandeShow();
    }

    @FXML
    private void onClickVente(ActionEvent event) {
        this.getFermeApp().venteShow();
    }

    @FXML
    private void onClickAccueil(ActionEvent event) {
        this.getFermeApp().principalStart();
    }
    
    
    
}
