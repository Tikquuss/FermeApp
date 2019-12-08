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
import fermeapp.view.Arrivage_Bande_viewController;
import fermeapp.view.Bilan_journalier_viewController;
import fermeapp.view.Entree_viewController;
import fermeapp.view.LeftMenuViewController;
import fermeapp.view.LoginController;
import fermeapp.view.Nouveau_medicament_viewController;
import fermeapp.view.Nouvelle_Maladie_viewController;
import fermeapp.view.Partenaire_fournisseur_viewController;
import fermeapp.view.Personnel_viewController;
import fermeapp.view.Soins_viewController;
import fermeapp.view.vente.OeufviewController;
import fermeapp.view.vente.PouleviewController;
import fermeapp.view.vente.PoussinviewController;
import fermeapp.view.vente.VenteOeufEditDialogController;
import fermeapp.view.vente.VentePouleEditDialogController;
import fermeapp.view.vente.VentePoussinEditDialogController;
import fermeapp.view.vente.VenteviewController;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import modelferme.HibernateUtil;
//import javafx.stage.Window;

/**
 *
 * @author Notsawo
 */
public class FermeApp extends Application {
    
    private Stage primaryStage;
    private AnchorPane root = new AnchorPane();
    private AnchorPane leafRigth = new AnchorPane();
    private AnchorPane leafLeft = new AnchorPane();
    private Personnel_viewController personnel;
    private Soins_viewController soins;
    private Nouveau_medicament_viewController nouveau_medicament;
    private Entree_viewController entree;
    private Nouvelle_Maladie_viewController nouvelle_maladie;
    
    @Override
    public void start(Stage primaryStage) {
        this.setPrimaryStage(primaryStage);
        this.getPrimaryStage().setTitle("FermeApp");
        //this.getPrimaryStage().setResizable(false);
        this.primaryStage.getIcons().add(new Image("file:resources/images/henhouse_240px.png"));
        this.initLogin();
    } 
    
//Toutes les méthodes Init();
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
    
    public void initEntree(){
        
        FXMLLoader loader = new FXMLLoader();
        
        try{
            
            loader.setLocation(getClass().getResource("view/entree_view.fxml"));
            this.setRoot((AnchorPane)loader.load());
            Entree_viewController E = loader.getController();
            E.setFermeApp(this);
            this.setEntree(E);
            this.getPrimaryStage().setScene(new Scene(root));
            this.getPrimaryStage().show();
            
        }catch(IOException e){
        
        
        }
    }
    
     public void initSoins(){
        
           FXMLLoader loader = new FXMLLoader();
        
        try {
            loader.setLocation(getClass().getResource("view/Soins_view.fxml"));
            this.setRoot((AnchorPane)loader.load());
            Soins_viewController S = loader.getController();
            S.setFermeApp(this);
            this.setSoins(S);
            this.getPrimaryStage().setScene(new Scene(root));
            this.getPrimaryStage().show();
            
        } catch (IOException ex) {
            Logger.getLogger(FermeApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
     
     public void initPersonnel(){
        
        FXMLLoader loader = new FXMLLoader();
        
        try{
            
            loader.setLocation(getClass().getResource("view/personnel_view.fxml"));
            this.setRoot((AnchorPane)loader.load());
            Personnel_viewController P = loader.getController();
            P.setFermeApp(this);
            this.setPersonnel(P);
            this.getPrimaryStage().setScene(new Scene(root));
            this.getPrimaryStage().show();
            
        }catch(IOException e){
        
        
        }
    }
  ////////*****************************************
    
    public void principalStart(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/accueilView.fxml"));
            this.setRoot((AnchorPane)loader.load());
            AccueilViewController c = loader.getController();
            this.setLeafLeft(c.getLeftAnchorPane());
            this.setLeafRigth(c.getRigthAnchorPane());
            c.setFermeApp(this);
            this.getPrimaryStage().setScene(new Scene(this.getRoot()));
            this.getPrimaryStage().show();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void addMaladie(){
        
        FXMLLoader loader = new FXMLLoader();

        try {
            loader.setLocation(getClass().getResource("/fermeapp/view/nouvelle_Maladie_view.fxml"));
            AnchorPane anchor = (AnchorPane)loader.load();
            Nouvelle_Maladie_viewController n = loader.getController();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Enregistrer une Maladie");
            dialogStage.initOwner(this.getPrimaryStage());
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene c = new Scene(anchor);
            dialogStage.setScene(c);
            n.setDialog(dialogStage);
            n.setSoin(soins);
            dialogStage.showAndWait();
        } catch (IOException ex) {
            Logger.getLogger(FermeApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addMedicament(){
         FXMLLoader loader = new FXMLLoader();
         
         try {
            loader.setLocation(getClass().getResource("/fermeapp/view/nouveau_medicament_view.fxml"));
//            this.setRoot((AnchorPane)loader.load());
            AnchorPane ancor = (AnchorPane)loader.load();
            Nouveau_medicament_viewController nm = loader.getController();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Enregistrer un Médicament");
            dialogStage.initOwner(this.getPrimaryStage());
            dialogStage.initModality(Modality.WINDOW_MODAL);
            Scene c = new Scene(ancor);
            dialogStage.setScene(c);
            nm.setDialog(dialogStage);
            nm.setSoin(soins);
            dialogStage.showAndWait();
//            nm.setFermeApp(this);
//            this.setNouveau_medicament(nm);
//            this.getStage().setScene(new Scene(root));
//            this.getStage().show();;
           
        } catch (IOException ex) {
            Logger.getLogger(FermeApp.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
          
    
    public void venteShow(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/vente/Venteview.fxml"));
            this.getLeafRigth().getChildren().clear();
            this.getLeafRigth().getChildren().add((AnchorPane)loader.load());
            ((VenteviewController)loader.getController()).setFermeApp(this);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        leftMenuShow();
        this.getPrimaryStage().show();
    }
    
    public void leftMenuShow(){
        FXMLLoader loader1 = new FXMLLoader();
        try{
            loader1.setLocation(getClass().getResource("/fermeapp/view/leftMenuView.fxml"));
            this.getLeafLeft().getChildren().clear();
            this.getLeafLeft().getChildren().add((AnchorPane)loader1.load());
            ((LeftMenuViewController)loader1.getController()).setFermeApp(this);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
     public void bilanJournalierShow(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/bilan_journalier_view.fxml"));
            this.getLeafRigth().getChildren().clear();
            this.getLeafRigth().getChildren().add((AnchorPane)loader.load());
            ((Bilan_journalier_viewController)loader.getController()).setFermeApp(this);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        leftMenuShow();
        this.getPrimaryStage().show();
    }
    
    public void arrivageBandeShow(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/arrivage_Bande_view.fxml"));
            this.getLeafRigth().getChildren().clear();
            this.getLeafRigth().getChildren().add((AnchorPane)loader.load());
            ((Arrivage_Bande_viewController)loader.getController()).setFermeApp(this);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        leftMenuShow();
        this.getPrimaryStage().show();
    }
    
    
     
    public void personnelShow(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/personnel_view.fxml"));
            this.getLeafRigth().getChildren().clear();
            this.getLeafRigth().getChildren().add((AnchorPane)loader.load());
            ((Personnel_viewController)loader.getController()).setFermeApp(this);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        leftMenuShow();
        this.getPrimaryStage().show();
    }
    
    public void partenaireShow(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/partenaire_fournisseur_view.fxml"));
            this.getLeafRigth().getChildren().clear();
            this.getLeafRigth().getChildren().add((AnchorPane)loader.load());
            ((Partenaire_fournisseur_viewController)loader.getController()).setFermeApp(this);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        leftMenuShow();
        this.getPrimaryStage().show();
    }
    
    
     
    public void entreeShow(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/entree_view.fxml"));
            this.getLeafRigth().getChildren().clear();
            this.getLeafRigth().getChildren().add((AnchorPane)loader.load());
            ((Entree_viewController)loader.getController()).setFermeApp(this);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        leftMenuShow();
        this.getPrimaryStage().show();
    }
    
    
    
    public void soinsShow(){
        FXMLLoader loader = new FXMLLoader();
        try{
            loader.setLocation(getClass().getResource("/fermeapp/view/Soins_view.fxml"));
            this.getLeafRigth().getChildren().clear();
            this.getLeafRigth().getChildren().add((AnchorPane)loader.load());
            ((Soins_viewController)loader.getController()).setFermeApp(this);
        }
        catch(IOException e){
            e.printStackTrace();
        }

        leftMenuShow();
        this.getPrimaryStage().show();
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
            dialogStage.setScene(new Scene((AnchorPane)loader.load()));

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
            dialogStage.setScene(new Scene((AnchorPane)loader.load()));

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
            dialogStage.setScene(new Scene((AnchorPane)loader.load()));

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

    

    public Personnel_viewController getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel_viewController personnel) {
        this.personnel = personnel;
    }
    
    public Soins_viewController getSoins() {
        return soins;
    }

    public void setSoins(Soins_viewController soins) {
        this.soins = soins;
    }
    
    public Nouveau_medicament_viewController getNouveau_medicament() {
        return nouveau_medicament;
    }

    public void setNouveau_medicament(Nouveau_medicament_viewController nouveau_medicament) {
        this.nouveau_medicament = nouveau_medicament;
    }
    
    public Entree_viewController getEntree() {
        return entree;
    }

    public void setEntree(Entree_viewController entree) {
        this.entree = entree;
    }

    public Nouvelle_Maladie_viewController getNouvelle_maladie() {
        return nouvelle_maladie;
    }

    public void setNouvelle_maladie(Nouvelle_Maladie_viewController nouvelle_maladie) {
        this.nouvelle_maladie = nouvelle_maladie;
    }

    private Window getStage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
}
