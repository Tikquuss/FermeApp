/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import fermeapp.controller.FermeApp;
import fermeapp.model.Personnel;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import modelferme.Exceptions.Unauthorized;
import modelferme.Exceptions.ValidationException;
import modelferme.makers.ModelManager;

/**
 * FXML Controller class
 *
 * @author machine
 */
public class Personnel_viewController implements Initializable {
    
    private FermeApp fermeApp;
    @FXML
    private JFXDatePicker date_Recrutement_Personnel;
    @FXML
    private JFXTextField nom_Personnel;
    @FXML
    private JFXTextField prenom_Personnel;
    @FXML
    private JFXTextField username_Personnel;
    @FXML
    private JFXPasswordField password_Personnel;
    @FXML
    private JFXComboBox<String> etat_Personnel;
    @FXML
    private JFXButton Btn_Modifier_Personnel;
    @FXML
    private JFXButton Btn_Supprimer_Personnel;
    @FXML
    private JFXButton Btn_Ajouter_Personnel;
    @FXML
    private JFXButton Btn_Annuler_Personnel;
    @FXML
    private GridPane Grid_Pane_Control;
    @FXML
    private Label lbl_Nom;
    @FXML
    private Label lbl_Prenom;
    @FXML
    private Label lbl_Username;
    @FXML
    private Label lbl_Pass;
    @FXML
    private Label lbl_Etat;
    @FXML
    private Label lbl_Date_Recrut;
    @FXML
    private JFXButton Btn_Enregistrer_Personnel;
    @FXML
    private Label lbl_nouvelle_per;
    @FXML
    private GridPane Grid_Pane_Search;
    @FXML
    private Label lbl_MC;
    @FXML
    private JFXButton btn_Search;
    @FXML
    private Label lbl_Search_Per;
    @FXML
    private TableView<Personnel> personnelTableView;
    @FXML
    private TableColumn<Personnel, String> nomColumn;
    @FXML
    private TableColumn<Personnel, String> prenomColumn;
    @FXML
    private TableColumn<Personnel, String> userColumn;
    @FXML
    private TableColumn<Personnel, String> dateRecrutColumn;
    @FXML
    private TableColumn<Personnel, String> etatColumn;
    /**
     * Initializes the controller class.
     */
    private ObservableList<Personnel> personnelData = FXCollections.observableArrayList();
    @FXML
    private JFXButton btnAddPicture;
    @FXML
    private ImageView pictureView;
        
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> O = FXCollections.observableArrayList("Actif","Inactif");
        etat_Personnel.setItems(O);
        
        
        personnelTableView.setItems(personnelData);
        
        nomColumn.setCellValueFactory(cellData -> cellData.getValue().nomPersonnelProperty());
        prenomColumn.setCellValueFactory(cellData -> cellData.getValue().prenomPersonnelProperty());
        userColumn.setCellValueFactory(cellData -> cellData.getValue().usernameProperty());
        dateRecrutColumn.setCellValueFactory(cellData -> cellData.getValue().dateRecrutProperty());
        etatColumn.setCellValueFactory(cellData -> cellData.getValue().etatPersonnelProperty());
        
        
    }    

    public FermeApp getFermeApp() {
        return fermeApp;
    }

    public void setFermeApp(FermeApp fermeApp) {
        this.fermeApp = fermeApp;
    }

    @FXML
    private void onSave(ActionEvent event) {
        try {
            //        personnelData.add(new Personnel(nom_Personnel.getText(), prenom_Personnel.getText(), username_Personnel.getText(),
//        password_Personnel.getText(), etat_Personnel.getValue(), date_Recrutement_Personnel.getValue().toString()));
ModelManager.getInstance().RegisterGestionaire(nom_Personnel.getText()
        , prenom_Personnel.getText()
        , username_Personnel.getText(),
        password_Personnel.getText());        
        } catch (ValidationException ex) {
            Logger.getLogger(Personnel_viewController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Unauthorized ex) {
            Logger.getLogger(Personnel_viewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onAddPicture(ActionEvent event) {
        FileChooser f = new FileChooser();
        //f.getExtensionFilters().addAll(new ExtensionFilter("png"),new ExtensionFilter("jpg"));
        File file  = f.showOpenDialog(null);
        //System.out.println(file.getName());
        
        Image monImage = new Image(file.toString());
        pictureView = new ImageView(monImage);
    }
    
}
