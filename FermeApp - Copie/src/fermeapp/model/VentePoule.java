/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Notsawo
 */
public class VentePoule extends Vente{
    private StringProperty type;

    public VentePoule(String type, int quantité, int prixUnitaire){
        super(quantité, prixUnitaire);
        this.type = new SimpleStringProperty(type);
    }

    public VentePoule(VentePoule vp) {
        this(vp.getType(), vp.getQuantité(), vp.getPrixUnitaire());
    }
    
    public String toString(){
        return this.getType() + " " + super.toString();
    }
    
    public String getType() {
        return type.get();
    }
    
    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type = new SimpleStringProperty(type);
    }   
}
