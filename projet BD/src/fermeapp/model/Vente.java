/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Notsawo
 */
public class Vente {
    private IntegerProperty quantité;
    private IntegerProperty prixUnitaire;
    private IntegerProperty prixTotal;
    
    public Vente(int quantité, int prixUnitaire) {
        this.quantité = new SimpleIntegerProperty(quantité);
        this.prixUnitaire = new SimpleIntegerProperty(prixUnitaire);
        this.prixTotal = new SimpleIntegerProperty(prixUnitaire*quantité);
    }
    
    public Vente() {
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

    public int getPrixUnitaire() {
        return prixUnitaire.intValue();
    }

    public void setPrixUnitaire(int prixUnitaire) {
        this.prixUnitaire = new SimpleIntegerProperty(prixUnitaire);
    }
    
    public ObservableValue<Integer> prixUnitaireProperty() {
        return new ReadOnlyObjectWrapper(prixUnitaire.get());
    }

    public int getPrixTotal() {
        return prixTotal.intValue();
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = new SimpleIntegerProperty(prixTotal);
    }
    
    public ObservableValue<Integer> prixTotalProperty() {
        return new ReadOnlyObjectWrapper(prixTotal.get());
    }
}
