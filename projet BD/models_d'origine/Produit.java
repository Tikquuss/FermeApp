package models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produit {

    private int idPro;
    private String nomPro;
    private float prixVente;
    private int quantite;
    private String description;
    private float prixAchat;
    private int codePro;
    private float prixAchatBis;
    private Categorie saCategorie;
    private String nomSaCategorie;
    private Fournisseur sonFournisseur;
    private boolean etat = false;


    public String getTaille() {
        return taille;
    }

    public void setNomSaCategorie(String nomSaCategorie) {
        this.nomSaCategorie = nomSaCategorie;

    }

    public String getCodeSonFournisseur() {
        return codeSonFournisseur;
    }

    public void setCodeSonFournisseur(String codeSonFournisseur) {
        this.codeSonFournisseur = codeSonFournisseur;
    }

    private String codeSonFournisseur;
    public ArrayList<Photo> sesPhoto;
    private String dateCreation;
    private String dateDernierArr;
    private String taille="moyen";
    private int supprimer;

    Statement stm;
    private PreparedStatement getidprophoto;

    public void setSaCategorie(Categorie saCategorie) {
        this.saCategorie = saCategorie;
    }


    public void setSonFournisseur(Fournisseur sonFournisseur) {
        this.sonFournisseur = sonFournisseur;
    }

    public Categorie getSaCategorie() {
        return saCategorie;
    }

    public Fournisseur getSonFournisseur() {
        return sonFournisseur;
    }

    public ArrayList<Photo> getSesPhoto() {
        return sesPhoto;
    }


    public boolean getEtat(){
        return etat;
    }
    public void setEtat(boolean etat){
        this.etat = etat;
    }

    public Produit() {
        initializeDB();
    }

    public Produit(int codePro) {
        initializeDB();
        this.codePro = codePro;
        try {
            this.load();
        } catch (SQLException ex) {
            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Produit(String name, String nomSaCategorie) {
//        initializeDB();
        this.nomSaCategorie = nomSaCategorie;
        this.prixVente = (int)(Math.random()*1000000) + 1000;
        this.quantite = (int)(Math.random()*500)+ 1;
        this.dateCreation = (int)(Math.random()*30 + 10) + "/" + (int)(Math.random()*11 + 10)+ "/20" + (int)(Math.random()*13 + 11);
        this.dateDernierArr = (int)(Math.random()*30 + 10) + "/" + (int)(Math.random()*11 + 10)+ "/20" + (int)(Math.random()*17 + 12);
        this.codeSonFournisseur = "XCF" + (int)(Math.random()*1000 + 1999);
        this.nomPro = name;
//        try {
//            this.load();
//        } catch (SQLException ex) {
//            Logger.getLogger(Produit.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    public static ArrayList<Produit> find(String pattern){
        ArrayList<Produit> tmp = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop", "root", "");
            Statement stmt = connection.createStatement();
            ResultSet set = stmt.executeQuery("select * from produit where codePro like '%"+pattern+"%'  ");
            while(set.next()){
                Produit p = new Produit(set.getInt(1));
                p.load();
                tmp.add(p);
            }
            return tmp;
        } catch (SQLException ex) {
            Logger.getLogger(Categorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

    public void load() throws SQLException {
        String sql = "SELECT * FROM produit WHERE codePro = '" + codePro + "'";

        ResultSet result = stm.executeQuery(sql);
        ResultSetMetaData metadata = result.getMetaData();
        if(result.next()){
            idPro = result.getInt("idPro");

            nomPro = result.getString("nomPro");
            prixVente = result.getFloat("prixVente");
            quantite = result.getInt("quantite");
            description = result.getString("description");
            prixAchat = result.getFloat("prixAchat");
            prixAchatBis = result.getInt("prixAchatBis");
            dateCreation = result.getString("dateCreation");
            dateDernierArr = result.getString("dateDernierArr");
            taille = result.getString("taille");
            supprimer = result.getInt("supprimer");
            sonFournisseur = new Fournisseur(result.getInt("idFour"));
            saCategorie = new Categorie(result.getInt("idCa"));
        }

    }

    public void save() throws SQLException {
        int i = 0;
        codePro = 100100;
        do{
            codePro = Utilities.genId(100100, 999999);
            String sq = "SELECT count(*) FROM produit WHERE codePro = '" + codePro + "'";
            ResultSet result = stm.executeQuery(sq);
            result.next();
            i = result.getInt(1);
        }while(i>0);
        

        String sql = "INSERT INTO produit VALUES(null,"+codePro+",'" + nomPro + "',0," + prixVente + ",'" + description + "'," + sonFournisseur.getIdFour()+","+saCategorie.getIdCa()+"," + prixAchat + ",now(),now(),0,"+ prixAchatBis +"," + taille + ")";
        stm.executeUpdate(sql);
        load();
    }
    
    

    public void update() throws SQLException {
        stm.executeUpdate("UPDATE produit set "
                + "nomPro = '" + nomPro + "',"
                + "quantite = '" + quantite + "',"
                + "prixVente = " + prixVente + ","
                + "description = '" + description + "',"
                + "idFour = '" + sonFournisseur.getIdFour() + "',"
                + "idCa = '" + saCategorie.getIdCa() + "',"
                + "prixAchat = '" + prixAchat + "',"
                + "dateDernierArr='" + dateDernierArr + "',"
                + "dateCreation='" + dateCreation + "',"
                + "supprimer='" + supprimer + "',"
                + "taille='" + taille + "' where codePro = " + codePro);

    }

    public int getIdPro() {
        return this.idPro;

    }
    
    public ArrayList<Photo> getAllPhoto(){
        ArrayList<Photo> listPhoto = new ArrayList<>();
        try{
            getidprophoto.setString(1, Integer.toString(idPro));
            ResultSet resultSet = getidprophoto.executeQuery();
            while (resultSet.next()){
            	 Photo photo = new Photo(resultSet.getInt(1));
            	photo.load();
            	listPhoto.add(photo);
            }
            	
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        
    	return listPhoto;
    }

    /**
     *
     * @param idPro
     */
    public void setIdPro(int idPro) {
        this.idPro = idPro;
    }


    public String getNomPro() {
        return this.nomPro;
    }

    /**
     *
     * @param nomPro
     */
    public void setNomPro(String nomPro) {
        this.nomPro = nomPro;
    }

    public float getPrixVente() {
        return this.prixVente;
    }
    
    public void initializeDB(){
	        try{
	            Class.forName("com.mysql.jdbc.Driver");
	        }
	        catch(ClassNotFoundException ex){
	            System.err.println("SORRY WE COULDN'T CONNECT TO DB");
	        }
	        try{
	            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop","root","");
                    stm = connection.createStatement();
                    getidprophoto = connection.prepareStatement("select * from Photo where idPro = ?");
	        }
	        catch(SQLException e){
	            System.err.println("Sorry we couldn't connect to DB");
	        }
	    }

    /**
     *
     * @param prixVente
     */
    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    public int getQuantite() {
        return this.quantite;
    }

    /**
     *
     * @param quantite
     */
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescription() {
        return this.description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrixAchat() {
        return this.prixAchat;
    }

    /**
     *
     * @param prixAchat
     */
    public void setPrixAchat(float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public int getCodePro() {
        return this.codePro;
    }

    /**
     *
     * @param codePro
     */
    public void setCodePro(int codePro) {
        this.codePro = codePro;
    }

    public float getPrixAchatBis() {
        return this.prixAchatBis;
    }

    /**
     *
     * @param prixAchatBis
     */
    public void setPrixAchatBis(float prixAchatBis) {
        this.prixAchatBis = prixAchatBis;
    }

    /**
     *
     * @param dateDernierArr
     */
    public void setDateDernierArr(String dateDernierArr) {
        this.dateDernierArr = dateDernierArr;
    }



    /**
     *
     * @param taille
     */
    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public String getDateDernierArr() {
        return dateDernierArr;
    }


    /**
     *
     * @param supprimer
     */
    public void setSupprimer(int supprimer) {
        this.supprimer = supprimer;
    }
    
    public static ArrayList<Produit> find(String pattern, int tp){
        ArrayList<Produit> tmp = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop", "root", "");
            Statement stmt = connection.createStatement();
            /*ResultSet set = stmt.executeQuery("select * from produit where nomPro like '%"+pattern+"%' or codePro like '%"+pattern+"%'");
            while(set.next()){
                Produit c = new Produit(set.getInt(2));
                c.load();
                tmp.add(c);
            }*/
            if(tp==0){
                
            ResultSet set = stmt.executeQuery("select * from produit where nomPro like '%"+pattern+"%'");
                while(set.next()){
                    Produit c = new Produit(set.getInt(2));
                    c.load();
                    tmp.add(c);
                }
            }
            else{
                   
            ResultSet set = stmt.executeQuery("select * from produit where codePro like '%"+pattern+"%'");
                while(set.next()){
                    Produit c = new Produit(set.getInt(2));
                    c.load();
                    tmp.add(c); 
                }
            }
            return tmp;
        } catch (SQLException ex) {
            Logger.getLogger(Categorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

     public static ArrayList<Produit> all(){
        ArrayList<Produit> tmp = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop", "root", "");
            Statement stmt = connection.createStatement();
            ResultSet set = stmt.executeQuery("select * from produit");
            while(set.next()){
                Produit c = new Produit(set.getInt(2));
                c.load();
                tmp.add(c);
            }
            return tmp;
        } catch (SQLException ex) {
            Logger.getLogger(Categorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }
     
     public void addPhoto(Photo p){
         p.setIdPhoto(idPro);
         p.save();
     }
}
