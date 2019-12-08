/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.controller;

import fermeapp.model.VenteOeuf;
import fermeapp.model.VentePoule;
import fermeapp.model.VentePoussin;
import fermeapp.view.AccueilViewController;
import fermeapp.view.LoginController;
import fermeapp.view.vente.OeufviewController;
import fermeapp.view.vente.PouleviewController;
import fermeapp.view.vente.PoussinviewController;
import fermeapp.view.vente.VenteOeufEditDialogController;
import fermeapp.view.vente.VentePouleEditDialogController;
import fermeapp.view.vente.VentePoussinEditDialogController;
import fermeapp.view.vente.VenteviewController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Notsawo
 */
public class FermeApp extends Application {
    
    private Stage primaryStage;
    private AnchorPane root = new AnchorPane();
    private AnchorPane leafRigth = new AnchorPane();
    private AnchorPane leafLeft = new AnchorPane();
    
    @Override
    public void start(Stage primaryStage) {
        this.setPrimaryStage(primaryStage);
        this.getPrimaryStage().setTitle("FermeApp");
        //this.getPrimaryStage().setResizable(false);
        this.primaryStage.getIcons().add(new Image("file:resources/images/henhouse_240px.png"));
        this.initLogin();
    } 
    
    public void initLogin(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/Login.fxml"));
            this.setRoot((AnchorPane)loader.load());
            ((LoginController)loader.getController()).setFermeApp(this);
            this.getPrimaryStage().setScene(new Scene(this.getRoot()));
            this.getPrimaryStage().show();
        }catch(IOException e){
           e.printStackTrace();
        }
    }
    
    public void principalStart(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/accueilView.fxml"));
            this.setRoot((AnchorPane)loader.load());
            AccueilViewController c = loader.getController();
            this.setLeafLeft(c.getLeftAnchorPane());
            this.setLeafRigth(c.getRigthAnchorPane());
            c.setFermeApp(this);
            this.getPrimaryStage().setScene(new Scene(this.getRoot(), 1150, 500));
            this.getPrimaryStage().show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void venteShow(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/vente/Venteview.fxml"));
            this.getLeafRigth().getChildren().clear();
            this.getLeafRigth().getChildren().add((AnchorPane)loader.load());
            ((VenteviewController)loader.getController()).setFermeApp(this);
            this.getPrimaryStage().show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        //this.getLeafLeft().getChildren().clear();
    }
    
    public void oeufVente(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/vente/Oeufview.fxml"));
            this.getLeafRigth().getChildren().clear();
            this.getLeafRigth().getChildren().add((AnchorPane)loader.load());
            ((OeufviewController)loader.getController()).setFermeApp(this);
            this.getPrimaryStage().show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    } 
    
    public void poussinVente(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/vente/Poussinview.fxml"));
            this.getLeafRigth().getChildren().clear();
            this.getLeafRigth().getChildren().add((AnchorPane)loader.load());
            ((PoussinviewController)loader.getController()).setFermeApp(this);
            this.getPrimaryStage().show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void PouleVente(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/vente/Pouleview.fxml"));
            this.getLeafRigth().getChildren().clear();
            this.getLeafRigth().getChildren().add((AnchorPane)loader.load());
            ((PouleviewController)loader.getController()).setFermeApp(this);
            this.getPrimaryStage().show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public boolean showModifierFactureDialog(VenteOeuf vo) {
        VenteOeufEditDialogController.venteOeuf = vo;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fermeapp/view/vente/VenteOeufEditDialog.fxml"));
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Modifier la vente");
            
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.setResizable(false);
            dialogStage.setScene(new Scene((AnchorPane)loader.load(), 400, 300));

            VenteOeufEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            //controller.setVenteOeuf(vo);
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    } 
    
    public boolean showModifierFactureDialog(VentePoussin vp) {
        VentePoussinEditDialogController.ventePoussin = vp;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fermeapp/view/vente/VentePoussinEditDialog.fxml"));
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Modifier la vente");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.setResizable(false);
            dialogStage.setScene(new Scene((AnchorPane)loader.load(), 400, 300));

            VentePoussinEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            //controller.setVentePoussin(vp);
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean showModifierFactureDialog(VentePoule vp) {
        VentePouleEditDialogController.ventePoule = vp;
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fermeapp/view/vente/VentePouleEditDialog.fxml"));
            
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Modifier la vente");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            dialogStage.setResizable(false);
            dialogStage.setScene(new Scene((AnchorPane)loader.load(), 400, 300));

            VentePouleEditDialogController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            //controller.setVentePoule(vp);
            dialogStage.showAndWait();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public AnchorPane getRoot() {
        return root;
    }

    public void setRoot(AnchorPane root) {
        this.root = root;
    } 

    public AnchorPane getLeafRigth() {
        return leafRigth;
    }

    public void setLeafRigth(AnchorPane leafRigth) {
        this.leafRigth = leafRigth;
    }

    public AnchorPane getLeafLeft() {
        return leafLeft;
    }

    public void setLeafLeft(AnchorPane leafLeft) {
        this.leafLeft = leafLeft;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
