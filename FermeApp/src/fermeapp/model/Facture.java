/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fermeapp.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Notsawo
 */
public class Facture {
    private ObservableList<VenteOeuf> VenteOeufData = FXCollections.observableArrayList();
    private ObservableList<VentePoule> VentePouleData = FXCollections.observableArrayList();
    private ObservableList<VentePoussin> VentePoussinData = FXCollections.observableArrayList();
}
