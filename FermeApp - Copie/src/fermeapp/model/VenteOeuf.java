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
public class VenteOeuf extends Vente{
    private StringProperty unitéVente;
    private StringProperty calibre;

    public VenteOeuf(String unitéVente, String calibre, int quantité, int prixUnitaire) {
        super(quantité, prixUnitaire);
        this.unitéVente = new SimpleStringProperty(unitéVente);
        this.calibre = new SimpleStringProperty(calibre);
    }
    
    public VenteOeuf(VenteOeuf vo) {
        this(vo.getUnitéVente(), vo.getCalibre(), vo.getQuantité(), vo.getPrixUnitaire());
    }

    public VenteOeuf() {
    }

    public String toString(){
        return this.getCalibre() + " " + this.getUnitéVente()+ " " + super.toString();
    }
    
    public String getUnitéVente() {
        return unitéVente.get();
    }

    public void setUnitéVente(String unitéVente) {
        this.unitéVente.set(unitéVente);
    }
    
    public StringProperty unitéVenteProperty() {
        return unitéVente;
    }

    public String getCalibre() {
        return calibre.get();
    }

    public void setCalibre(String calibre) {
        this.calibre.set(calibre);
    }  
    
    public StringProperty calibreProperty() {
        return calibre;
    }
}
