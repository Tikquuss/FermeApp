package models;

/**
 *
 * @author Carole
 */
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Photo{
    public Photo()
    {
        this.idPhoto=0;
    }
    public Photo(String lienPhoto){
        this.lienPhoto = lienPhoto;
    }
    
    public Photo(int id){
        this.idPhoto = id;
    }
   
    private int idPhoto = 0;
    private String lienPhoto="";
    private String couleur="";
    private int IdProduit=0;
    private int photoDefaut = 0;

    public int getPhotoDefaut() {
        return photoDefaut;
    }

    public void setPhotoDefaut(int photoDefaut) {
        this.photoDefaut = photoDefaut;
    }
    
    public int getIdPhoto() {
	return this.idPhoto;
	}
    
    public void setIdPhoto(int idPhoto) {
	this.idPhoto = idPhoto;
    }
    public String getLienPhoto() {
	return this.lienPhoto;
    }
    
    public void setLienPhoto(String lienPhoto) {
	this.lienPhoto = lienPhoto;
    }

    public String getCouleur() {
	return this.couleur;
    }
    public void setCouleur(String couleur) {
	this.couleur = couleur;
    }
    public void setIdProduit(int IdProduit){
        this.IdProduit= IdProduit;
    }
    public int getIdProduit(){
        return this.IdProduit;
    }
    public void load(){
        try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch (ClassNotFoundException ex){
		System.err.println("SORRY CLASS COULD'NT BE LOADED.");
	}
        try{
                
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop","root","");
		Statement statement = (Statement) connection.createStatement();
                String select = "select * from  photo where idphoto='"+this.getIdPhoto()+"';";
		ResultSet RS=statement.executeQuery(select);
                while(RS.next()){
                    this.setLienPhoto(RS.getString("lienPhoto"));
                    this.setCouleur(RS.getString("couleur"));
                    this.setIdProduit(RS.getInt("idPro"));
                    this.setPhotoDefaut(RS.getInt("photoDefaut"));
               }
                        
             }catch(SQLException e){
                System.err.println("erreur" +e.getMessage());
             }
       
   }
    public void save(){ 
        try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch (ClassNotFoundException ex){
		System.err.println("erreur."+ex.getMessage());
	}
        try{
                
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop","root","");
            Statement statement = (Statement) connection.createStatement();
            String add = "insert into photo(IdPhoto,LienPhoto,Couleur,idPro,photoDefaut) values (null,'"+this.getLienPhoto()+"','"+this.getCouleur()+"',"+this.getIdProduit()+","+this.getPhotoDefaut()+")";
            statement.executeUpdate(add);
        }
        catch(SQLException ex){
            System.err.println("message erreur" +ex.getMessage());
        }
    }
public void update()
        {
            try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException ex){
			System.err.println("SORRY CLASS COULD'NT BE LOADED.");
		}
            try{
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop","root","");
		Statement statement = (Statement) connection.createStatement();
		String update = "update photo set lienphoto = '"+this.getLienPhoto()+"' where idphoto = '"+this.getIdPhoto()+"';";
		String update1 = "update photo set couleur = '"+this.getCouleur()+"' where idPhoto = '"+this.getIdPhoto()+"';";
		String update2 = "update photo set idpro = '"+this.getIdProduit()+"' where idphoto = '"+this.getIdPhoto()+"';";
		String update3 = "update photo set photodefaut = '"+this.getPhotoDefaut()+"' where idphoto = '"+this.getIdPhoto()+"';";
                statement.executeUpdate(update);
                statement.executeUpdate(update1);
		statement.executeUpdate(update2);
		statement.executeUpdate(update3);

			connection.close();
	}catch (SQLException ex){
            System.err.println("erreur" +ex.getMessage());
	}
    }}

    

