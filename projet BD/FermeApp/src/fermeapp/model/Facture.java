/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.model;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelferme.makers.ModelManager;

/**
 *
 * @author Notsawo
 */
public class Facture {
    private ObservableList<VenteOeuf> VenteOeufData = FXCollections.observableArrayList();
    private ObservableList<VentePoule> VentePouleData = FXCollections.observableArrayList();
    private ObservableList<VentePoussin> VentePoussinData = FXCollections.observableArrayList();

    public void persist() {
        if (VenteOeufData != null) {
            for (VenteOeuf v : VenteOeufData) {
               // ModelManager.getInstance().RegisterLivraisonOuef(
                       // v.get, partenaire, Integer.SIZE, Integer.MIN_VALUE, true, unite_vente)
            }
        }

    }
    
    public ObservableList<VenteOeuf> getVenteOeufData() {
        return VenteOeufData;
    }

    public void setVenteOeufData(ObservableList<VenteOeuf> VenteOeufData) {
        this.VenteOeufData = VenteOeufData;
    }

    public ObservableList<VentePoule> getVentePouleData() {
        return VentePouleData;
    }

    public void setVentePouleData(ObservableList<VentePoule> VentePouleData) {
        this.VentePouleData = VentePouleData;
    }

    public ObservableList<VentePoussin> getVentePoussinData() {
        return VentePoussinData;
    }

    public void setVentePoussinData(ObservableList<VentePoussin> VentePoussinData) {
        this.VentePoussinData = VentePoussinData;
    }
    
    
}
