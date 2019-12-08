package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client {
//
	public static int lastCodeClient;
//
	private int codeClient = 0;
	private String nom;
	private String telephone;
	private String whatsap;
	private int pointFidelite = 0;
	private String dateAbonnement;
	private int remise = 0;
	Ville saVille;
	private int typeCli = 0;
	private String email;
	//
	public Client(String nom){
		this.codeClient = (int)(Math.random()*100000+ 199999);
		this.nom = nom;
		telephone = "6" + (int)(Math.random()*999999 + 777777);
		whatsap  = telephone;
		pointFidelite = (int)(Math.random()*50);
		dateAbonnement = (int)(Math.random()*30 + 10) + "/" + (int)(Math.random()*11 + 10)+ "/20" + (int)(Math.random()*17 + 11);
		email = nom.substring(0,3) + "@gmail.com";
		lastCodeClient++;
	}
	public Client(int codeC, String nom, String tel, String whats, String dateAb, int pointFid, int type, String email ){
		codeClient = codeC;
		this.nom = nom;
		this.telephone = tel;
		this.whatsap = whats;
		this.dateAbonnement = dateAb;
		this.pointFidelite = pointFid;
		this.typeCli = type;
		this.email = email;
	}
	//

	public int getCodeClient() {
		return this.codeClient;
	}

	/**
	 * 
	 * @param codeClient
	 */
	public void setCodeClient(int codeClient) {
		this.codeClient = codeClient;
	}

	public String getNom() {
		return this.nom;
	}

	/**
	 * 
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * 
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getWhatsap() {
		return this.whatsap;
	}

	/**
	 * 
	 * @param whatsap
	 */
	public void setWhatsap(String whatsap) {
		this.whatsap = whatsap;
	}

	public int getPointFidelite() {
		return this.pointFidelite;
	}

	/**
	 * 
	 * @param pointFidelite
	 */
	public void setPointFidelite(int pointFidelite) {
		this.pointFidelite = pointFidelite;
	}

	public String getDateAbonnement() {
		return this.dateAbonnement;
	}

	/**
	 * 
	 * @param dateAbonnement
	 */
	public void setDateAbonnement(String dateAbonnement) {
		this.dateAbonnement = dateAbonnement;
	}

	public int getRemise() {
		return this.remise;
	}

	/**
	 * 
	 * @param remise
	 */
	public void setRemise(int remise) {
		this.remise = remise;
	}

	public int getTypeCli() {
		return this.typeCli;
	}

	/**
	 * 
	 * @param typeCli
	 */
	public void setTypeCli(int typeCli) {
		this.typeCli = typeCli;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	public static ArrayList<Produit> all(){
		ArrayList<Produit> tmp = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop", "root", "");
			Statement stmt = connection.createStatement();
			ResultSet set = stmt.executeQuery("select * from client");
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

}