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
public class VentePoussin extends Vente{
   private StringProperty nbJour;

    public VentePoussin(String nbJour, int quantité, int prixUnitaire){
        super(quantité, prixUnitaire);
        this.nbJour = new SimpleStringProperty(nbJour);
    }

    public VentePoussin(VentePoussin vp) {
        this(vp.getNbJour(), vp.getQuantité(), vp.getPrixUnitaire());
    }
    
    public String toString(){
        return this.getNbJour() + " " + super.toString();
    }
    
    public String getNbJour() {
        return nbJour.get();
    }
    
    public StringProperty nbJourProperty() {
        return nbJour;
    }

    public void setNbJour(String nbJour) {
        this.nbJour = new SimpleStringProperty(nbJour);
    }
}
