package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Categorie {

    private int idCa;
    private String nomCa;
    private static PreparedStatement loadstmt, savestmt, updatestmt, getidcaprod/*,getnamestmt,setnamestmt,getidstmt*/;
    private static Statement stmt;
    private static Connection connection;
    static{
        initializeDB();
    }
    public Categorie() {
        this.nomCa = "Inconnu";
    }
	public Categorie(String name) {
		this.nomCa = name;
	}

    public Categorie(int id) {
        this.idCa = id;
    }
	public Categorie(int id, String name) {
		this.idCa = id;
		this.nomCa = name;
	}

    public ArrayList<Produit> getAllProd() {
        ArrayList<Produit> listProd = new ArrayList<>();
        try {
            getidcaprod.setString(1, Integer.toString(idCa));
            ResultSet resultSet = getidcaprod.executeQuery();
            while (resultSet.next()) {
                Produit prod = new Produit(resultSet.getInt(2));
                prod.load();
                listProd.add(prod);
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return listProd;
    }

    private static void initializeDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.err.println("SORRY WE COULDN'T CONNECT TO DB");
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop", "root", "");
            savestmt = connection.prepareStatement("insert into categorie(nomCa) values(?)");
            loadstmt = connection.prepareStatement("select * from categorie where idCa = ?");
            updatestmt = connection.prepareStatement("update categorie set nomCa = ? where idCa = ?");
            getidcaprod = connection.prepareStatement("select * from produit where idCa = ?");
            stmt = connection.createStatement();
            /*
             * 
             * getnamestmt = connection.prepareStatement("select nomCa from Categorie where idCa = ?");
            setnamestmt = connection.prepareStatement("update Categorie set nomCa = ? where idCa = ?");
            getidstmt = connection.prepareStatement("select idCa from Categorie where nomCa = ?");
             * */
        } catch (SQLException e) {
            System.err.println("Sorry we couldn't connect to DB");
        }
    }

    public int getIdCa() {
        /*try{
			initializeDB();
			getidstmt.setString(1, this.nomCa);
			ResultSet resultSet = getidstmt.executeQuery(); 
			while(resultSet.next())
				this.idCa = Integer.parseInt(resultSet.getString(1));	
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}*/
        return this.idCa;
    }
    
    public static ArrayList<Categorie> getAll(){
        ArrayList<Categorie> tmp = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet set = stmt.executeQuery("select * from categorie");
            while(set.next()){
                Categorie c = new Categorie(set.getInt(1));
                c.load();
                tmp.add(c);
            }
            return tmp;
        } catch (SQLException ex) {
            Logger.getLogger(Categorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }
    
    public static ArrayList<Categorie> find(String pattern){
        ArrayList<Categorie> tmp = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet set = stmt.executeQuery("select * from categorie where nomCa like '%"+pattern+"%'");
            while(set.next()){
                Categorie c = new Categorie(set.getInt(1));
                c.load();
                tmp.add(c);
            }
            return tmp;
        } catch (SQLException ex) {
            Logger.getLogger(Categorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }
    public static ArrayList<Categorie> find(int pattern){
        ArrayList<Categorie> tmp = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet set = stmt.executeQuery("select * from categorie where idCa like '%"+pattern+"%'");
            while(set.next()){
                Categorie c = new Categorie(set.getInt(1));
                c.load();
                tmp.add(c);
            }
            return tmp;
        } catch (SQLException ex) {
            Logger.getLogger(Categorie.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

    /**
     *
     * @param idCa
     */
    public void setIdCa(int idCa) {
        this.idCa = idCa;
    }

    public String getNomCa() {
        /*try{
			initializeDB();
			this.getIdCa();
			getnamestmt.setString(1, Integer.toString(this.idCa));
			ResultSet resultSet = getnamestmt.executeQuery(); 
			while(resultSet.next())
				nomCa = resultSet.getString(1);
			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}*/
        return this.nomCa;
    }

    /**
     *
     * @param nomCa
     */
    public void setNomCa(String nomCa) {
        /*try{
			initializeDB();
			this.getIdCa();
			setnamestmt.setString(1, nomCa);
			setnamestmt.setString(2, Integer.toString(this.idCa));
			setnamestmt.executeUpdate();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}*/
        this.nomCa = nomCa;

    }

    public void save() {
        try {
            initializeDB();
            // savestmt.setString(1, Integer.toString(this.idCa));
            savestmt.setString(1, this.nomCa);
            savestmt.executeUpdate();
            ResultSet set = savestmt.executeQuery("select last_insert_id()");
            set.next();
            setIdCa(set.getInt(1));
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void update() {
        try {

            this.getIdCa();
            this.getNomCa();
            updatestmt.setString(1, this.nomCa);
            updatestmt.setString(2, Integer.toString(this.idCa));
            updatestmt.executeUpdate();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void load() {
        try {

            String one, two;
            this.getIdCa();
            loadstmt.setString(1, Integer.toString(this.idCa));
            ResultSet resultSet = loadstmt.executeQuery();
            while (resultSet.next()) {
                one = resultSet.getString(1);
                two = resultSet.getString(2);

                setIdCa(resultSet.getInt(1));
                setNomCa(resultSet.getString(2));
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
