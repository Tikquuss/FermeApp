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
public class Soins {
    private StringProperty nomMedicament;
    private StringProperty nomMaladie;
    private StringProperty heure;
    private StringProperty date;

    public Soins(String nomMedicament, String nomMaladie, String heure, String date) {
        this.nomMedicament = new SimpleStringProperty(nomMedicament);
        this.nomMaladie = new SimpleStringProperty(nomMaladie);
        this.heure = new SimpleStringProperty(heure);
        this.date = new SimpleStringProperty(date);
    }

    public StringProperty getNomMedicament() {
        return nomMedicament;
    }
    
    public String nomMedicamentProperty() {
        return nomMedicament.get();
    }

    public void setNomMedicament(StringProperty nomMedicament) {
        this.nomMedicament = nomMedicament;
    }

    public StringProperty getNomMaladie() {
        return nomMaladie;
    }
    
    public String nomMaladieProperty() {
        return nomMaladie.get();
    }
    
    public void setNomMaladie(StringProperty nomMaladie) {
        this.nomMaladie = nomMaladie;
    }

    public StringProperty getHeure() {
        return heure;
    }
    
    public String heureProperty() {
        return heure.get();
    }
    
    public void setHeure(StringProperty heure) {
        this.heure = heure;
    }

    public StringProperty getDate() {
        return date;
    }
    
    public String dateProperty() {
        return date.get();
    }
    
    public void setDate(StringProperty date) {
        this.date = date;
    }
    
    
    
    
    
    
    
    
    
}
