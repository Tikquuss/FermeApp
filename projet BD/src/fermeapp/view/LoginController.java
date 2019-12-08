/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import fermeapp.controller.FermeApp;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import modelferme.Exceptions.LoginResponse;

/**
 * FXML Controller class
 *
 * @author Notsawo
 */
public class LoginController implements Initializable {

    FermeApp fermeApp;
    @FXML
    private Hyperlink forgotPassword;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXTextField Username;
    @FXML
    private Button Okbutton;
    private Button annulerButon;
    @FXML
    private Button quitterButon;
    @FXML
    private JFXButton changePhoto;
    @FXML
    private AnchorPane conteneur;
    @FXML
    private GridPane sousConteneur;
    @FXML
    private GridPane champs;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        champs.setPadding(new Insets(10));
        sousConteneur.setPadding(new Insets(10));
    }  
    
    @FXML
    void onSubmit(){
        //this.getFermeApp().principalStart();
        
       
        if(!password.getText().equals("") || !Username.getText().equals("")){
            LoginResponse login = modelferme.makers.ModelManager.getInstance().login(Username.getText(), password.getText());
            if(login.isSucces()){
                this.getFermeApp().principalStart();
            }
            else{
                Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Erreur");
            alert.setContentText("Voulez-vous quittez ?");
            alert.setHeaderText("Votre nom d'utilisateur ou votre mot de passe est incorrect");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                this.getFermeApp().getPrimaryStage().close();
            } else {
                this.Username.clear();
                this.password.clear();
            }
            }
            
        }
    }
    
    @FXML
    private void onQuit(ActionEvent event) {
        this.getFermeApp().getPrimaryStage().close();
    }
    
    @FXML
    private void onPhotoChange(ActionEvent event) {
        FileChooser f = new FileChooser();
        File file  = f.showOpenDialog(null);
        //f.getExtensionFilters().addAll(new ExtensionFilter("png"),new ExtensionFilter("jpg"));
        System.out.println(file.getName());
    }

    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }

    public Hyperlink getForgotPassword() {
        return forgotPassword;
    }

    public void setForgotPassword(Hyperlink forgotPassword) {
        this.forgotPassword = forgotPassword;
    }

    public JFXPasswordField getPassword() {
        return password;
    }

    public void setPassword(JFXPasswordField password) {
        this.password = password;
    }

    public JFXTextField getUsername() {
        return Username;
    }

    public void setUsername(JFXTextField Username) {
        this.Username = Username;
    }

    public Button getOkbutton() {
        return Okbutton;
    }

    public void setOkbutton(Button Okbutton) {
        this.Okbutton = Okbutton;
    }

    public Button getAnnulerButon() {
        return annulerButon;
    }

    public void setAnnulerButon(Button annulerButon) {
        this.annulerButon = annulerButon;
    }

    public Button getQuitterButon() {
        return quitterButon;
    }

    public void setQuitterButon(Button quitterButon) {
        this.quitterButon = quitterButon;
    }

    public JFXButton getChangePhoto() {
        return changePhoto;
    }

    public void setChangePhoto(JFXButton changePhoto) {
        this.changePhoto = changePhoto;
    }
}
