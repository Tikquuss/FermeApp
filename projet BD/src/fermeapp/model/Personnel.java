/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author machine
 */
public class Personnel {
    
    private StringProperty nomPersonnel;
    private StringProperty prenomPersonnel;
    private StringProperty Username;
    private StringProperty password;
    private StringProperty etatPersonnel;
    private StringProperty dateRecrut;

    public Personnel(String nomPersonnel, String prenomPersonnel, String Username, String password, String etatPersonnel, String dateRecrut) {
        this.nomPersonnel = new SimpleStringProperty(nomPersonnel);
        this.prenomPersonnel = new SimpleStringProperty(prenomPersonnel);
        this.Username = new SimpleStringProperty(Username);
        this.password = new SimpleStringProperty(password);
        this.etatPersonnel = new SimpleStringProperty(etatPersonnel);
        this.dateRecrut = new SimpleStringProperty(dateRecrut);
    }
    
    

    public String getNomPersonnel() {
        return nomPersonnel.get();
    }
    
    public StringProperty nomPersonnelProperty() {
        return nomPersonnel;
    }
    
    public void setNomPersonnel(StringProperty nomPersonnel) {
        this.nomPersonnel = nomPersonnel;
    }

    public String getPrenomPersonnel() {
        return prenomPersonnel.get();
    }
    
    public StringProperty prenomPersonnelProperty() {
        return prenomPersonnel;
    }
    
    public void setPrenomPersonnel(StringProperty prenomPersonnel) {
        this.prenomPersonnel = prenomPersonnel;
    }

    public String getUsername() {
        return Username.get();
    }
    
    public StringProperty usernameProperty() {
        return Username;
    }

    public void setUsername(StringProperty Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password.get();
    }
    
     public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(StringProperty password) {
        this.password = password;
    }

    public String getEtatPersonnel() {
        return etatPersonnel.get();
    }
    
     public StringProperty etatPersonnelProperty() {
        return etatPersonnel;
    }
    
    public void setEtatPersonnel(String etatPersonnel) {
        this.etatPersonnel.set(etatPersonnel);
    }

    public String getDateRecrut() {
        return dateRecrut.get();
    }
    
    public StringProperty dateRecrutProperty() {
        return dateRecrut;
    }
    
    public void setDateRecrut(StringProperty dateRecrut) {
        this.dateRecrut = dateRecrut;
    }
    
    
}
