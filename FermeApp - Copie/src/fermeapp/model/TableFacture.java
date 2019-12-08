/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Notsawo
 */
public class TableFacture {
    private StringProperty nomClient;
    private StringProperty produit;
    private IntegerProperty quantité;
    private IntegerProperty montant;
    private StringProperty date;
    
    public TableFacture(String nomClient, String produit, int quantité, int montant, String date) {
        this.nomClient = new SimpleStringProperty(nomClient);
        this.produit = new SimpleStringProperty(produit);
        this.quantité = new SimpleIntegerProperty(quantité);
        this.montant = new SimpleIntegerProperty(montant);
        this.date = new SimpleStringProperty(date);
    }
    
    public TableFacture() {
    }
    
    public String toString(){
        return "";
        //return this.getQuantité() + " " + this.getPrixUnitaire() + " " + this.getPrixTotal();
    }

    public String getNomClient() {
        return nomClient.get();
    }
    
    public StringProperty nomClientProperty() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = new SimpleStringProperty(nomClient);
    }

    public String getProduit() {
        return produit.get();
    }
    
    public StringProperty produitProperty() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = new SimpleStringProperty(produit);
    }

    public String getDate() {
        return date.get();
    }
    
    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(StringProperty date) {
        this.date = date;
    }
    
    public int getQuantité() {
        return quantité.intValue();
    }
    
    public ObservableValue<Integer> quantitéProperty() {
        return new ReadOnlyObjectWrapper(quantité.get());
    }

    public void setQuantité(int quantité) {
        this.quantité = new SimpleIntegerProperty(quantité);
    }

    public int getMontant() {
        return montant.intValue();
    }

    public void setMontant(int montant) {
        this.montant = new SimpleIntegerProperty(montant);
    }
    
    public ObservableValue<Integer> montantProperty() {
        return new ReadOnlyObjectWrapper(montant.get());
    }
}
