/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view.vente;

import com.jfoenix.controls.JFXButton;
import fermeapp.controller.FermeApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
/**
 * FXML Controller class
 *
 * @author Notsawo
 */
public class VenteviewController implements Initializable {
    
    FermeApp fermeApp;
    
    @FXML
    private JFXButton oeufButton;
    @FXML
    private JFXButton poulesButton;
    @FXML
    private JFXButton poussinButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    } 
    
    @FXML
    private void Onclick(ActionEvent event) {
        if(event.getSource().equals(this.getOeufButton())){
            this.getFermeApp().oeufVente();
        }
        if(event.getSource().equals(this.getPoulesButton())){
            this.getFermeApp().PouleVente();
        }
        if(event.getSource().equals(this.getPoussinButton())){
            this.getFermeApp().poussinVente();
        }
    }
   
    private void retour(ActionEvent event){
        this.getFermeApp().principalStart();
    }

    public JFXButton getOeufButton() {
        return oeufButton;
    }

    public void setOeufButton(JFXButton oeufButton) {
        this.oeufButton = oeufButton;
    }

    public JFXButton getPoulesButton() {
        return poulesButton;
    }

    public void setPoulesButton(JFXButton poulesButton) {
        this.poulesButton = poulesButton;
    }

    public JFXButton getPoussinButton() {
        return poussinButton;
    }

    public void setPoussinButton(JFXButton poussinButton) {
        this.poussinButton = poussinButton;
    }

    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }
}
