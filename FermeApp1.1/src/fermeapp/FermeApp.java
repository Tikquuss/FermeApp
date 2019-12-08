/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp;

import fermeapp.view.Accueil_viewController;
import fermeapp.view.Entree_viewController;
import fermeapp.view.Nouveau_medicament_viewController;
import fermeapp.view.Nouvelle_Maladie_viewController;
import fermeapp.view.Personnel_viewController;
import fermeapp.view.Soins_viewController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author machine
 */
public class FermeApp extends Application {
    
    private Stage stage;
    private AnchorPane root;
    private Personnel_viewController personnel;
    private Soins_viewController soins;
    private Nouveau_medicament_viewController nouveau_medicament;
    private Entree_viewController entree;
    private Nouvelle_Maladie_viewController nouvelle_maladie;
    private Accueil_viewController accueil;
    

   
    
    @Override
    public void start(Stage stage) throws Exception {
       
        this.setStage(stage);
        this.getStage().setTitle("Accueil");
        this.getStage().setResizable(false);
        this.initAccueil();
        //this.getStage().show();
    }
    
    public void initPersonnel(){
        
        FXMLLoader loader = new FXMLLoader();
        
        try{
            
            loader.setLocation(getClass().getResource("view/personnel_view.fxml"));
            this.setRoot((AnchorPane)loader.load());
            Personnel_viewController P = loader.getController();
            P.setFermeApp(this);
            this.setPersonnel(P);
            this.getStage().setScene(new Scene(root));
            this.getStage().show();
            
        }catch(IOException e){
        
        
        }
    }
//**********************************************************
public void initEntree(){
        
        FXMLLoader loader = new FXMLLoader();
        
        try{
            
            loader.setLocation(getClass().getResource("view/entree_view.fxml"));
            this.setRoot((AnchorPane)loader.load());
            Entree_viewController E = loader.getController();
            E.setFermeApp(this);
            this.setEntree(E);
            this.getStage().setScene(new Scene(root));
            this.getStage().show();
            
        }catch(IOException e){
        
        
        }
    }
///*************/////////////*****************************
public void initAccueil(){
        
        FXMLLoader loader = new FXMLLoader();
        
        try{
            
            loader.setLocation(getClass().getResource("view/Accueil_view.fxml"));
            this.setRoot((AnchorPane)loader.load());
            Accueil_viewController A = loader.getController();
            A.setFermeApp(this);
            this.setAccueil(A);
            this.getStage().setScene(new Scene(root));
            this.getStage().show();
            
        }catch(IOException e){
        
        
        }
    }
/////////////////********************************************
    public void initSoins(){
        
           FXMLLoader loader = new FXMLLoader();
        
        try {
            loader.setLocation(getClass().getResource("view/Soins_view.fxml"));
            this.setRoot((AnchorPane)loader.load());
            Soins_viewController S = loader.getController();
            S.setFermeApp(this);
            this.setSoins(S);
            this.getStage().setScene(new Scene(root));
            this.getStage().show();
            
        } catch (IOException ex) {
            Logger.getLogger(FermeApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
    public void addMedicament(){
         FXMLLoader loader = new FXMLLoader();
         
         try {
            loader.setLocation(getClass().getResource("view/nouveau_medicament_view.fxml"));
//            this.setRoot((AnchorPane)loader.load());
            AnchorPane ancor = (AnchorPane)loader.load();
            Nouveau_medicament_viewController nm = loader.getController();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Enregistrer un Médicament");
            dialogStage.initOwner(this.getStage());
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
          
    
    public void addMaladie(){
        
        FXMLLoader loader = new FXMLLoader();

        try {
            loader.setLocation(getClass().getResource("view/nouvelle_Maladie_view.fxml"));
            AnchorPane anchor = (AnchorPane)loader.load();
            Nouvelle_Maladie_viewController n = loader.getController();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Enregistrer une Maladie");
            dialogStage.initOwner(this.getStage());
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
    
    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public AnchorPane getRoot() {
        return root;
    }

    public void setRoot(AnchorPane root) {
        this.root = root;
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

    public Accueil_viewController getAccueil() {
        return accueil;
    }

    public void setAccueil(Accueil_viewController accueil) {
        this.accueil = accueil;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
