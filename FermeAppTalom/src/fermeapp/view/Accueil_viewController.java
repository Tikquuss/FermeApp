/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view;

import fermeapp.FermeApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author machine
 */
public class Accueil_viewController implements Initializable {

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
    
    private FermeApp fermeApp;
    @FXML
    private ImageView accueil_menu_personnel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setFermeApp(FermeApp fermeApp){
        this.fermeApp = fermeApp;
    }
    public FermeApp getFermeApp(){
        return fermeApp;
    }
    
    private void accueil_menu_personnel(ActionEvent event){
        this.getFermeApp().initPersonnel();
    }
}
