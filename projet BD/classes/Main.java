/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nivekiba
 */
public class Main {
    
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        boolean cont = true;
        do{
        int choix = 0;
        System.out.println("\n\n\n\n\n1.   categorie");
        System.out.println("2.   fournisseur");
        System.out.println("3.   produit");
        try{
            choix = sc.nextInt();
        }catch(InputMismatchException t){
            cont = false;
        }
        System.out.println();System.out.println();System.out.println();System.out.println();
        
        if(choix == 1){
            System.out.println("1.   creer");
            System.out.println("2.   modifier");
            System.out.println("3.   lister");
            System.out.println("4.   rechercher");
            choix = sc.nextInt();
            switch(choix){
                case 1:
                    insertcategorie();
                    break;
                case 2:
                    modifiercategorie();
                    break;
                case 3:
                    listercategorie();
                    break;
                case 4:
                    recherchercategorie();
                    break;
            }
        }
        else if(choix == 2){
            System.out.println("1.   creer");
            System.out.println("2.   modifier");
            System.out.println("3.   lister");
            System.out.println("4.   rechercher");
            choix = sc.nextInt();
            switch(choix){
                case 1:
                    insertfourni();
                    break;
                case 2:
                    modifierfourni();
                    break;
                case 3:
                    listerfourni();
                    break;
                case 4:
                    rechercherfourni();
                    break;
            }
        }
        else if(choix == 3){
            System.out.println("1.   creer");
            System.out.println("2.   rechercher");
            System.out.println("3.   ajouter photos");
            choix = sc.nextInt();
            switch(choix){
                case 1:
                    insertprod();
                    break;
                case 2:
                    recherherprod();
                    break;
                case 3:
                    ajouterphoto();
                    break;
            }
        }
        }while(cont);
        
    }

    private static void insertcategorie() {
        System.out.println("\nEntrer le no de la categorie");
        String nom = sc.next();
        Categorie c = new Categorie();
        c.setNomCa(nom);
        c.save();
    }

    private static void insertfourni() {
        Fournisseur four = new Fournisseur();
        System.out.println("\nEntrer le nom");
        String nom = sc.next();sc.nextLine();
        System.out.println("\nEntrer son adresse");
        String addr = sc.next();sc.nextLine();
        System.out.println("\nEntrer son numero de telephone");
        String num = sc.next();sc.nextLine();
        System.out.println("\nEntrer son numero whatsapp si different du numero precedent");
        String what = sc.next();sc.nextLine();
        System.out.println("\nEntrer le site web du fournisseur si existant");
        String sitew = sc.next();sc.nextLine();
        four.setNomFour(nom);
        four.setAdresse(addr);
        four.setTelFour(num);
        four.setWhatsap(what);
        four.setSiteWeb(sitew);
        four.save();
    }

    private static void modifierfourni() {
        for(Fournisseur b : Fournisseur.getAll())
            System.out.println(b.getIdFour()+") "+b.getNomFour()+" => "+b.getSiteWeb());
        
        System.out.print("Choisir la categorie a modifier : ");
        int id = sc.nextInt();
        
        Fournisseur f = new Fournisseur(id);
        System.out.println("entrer le nouveau nom : ");
        String nom = sc.next();
        f.setNomFour(nom);
        System.out.println("entrer le nouveau site web : ");
        String site = sc.next();
        f.setSiteWeb(site);
        
        f.update();
        listerfourni();
    }

    private static void modifiercategorie() {
        Categorie d = new Categorie(5);
        d.setNomCa("une nouvelle categorie");
        d.update();
        listercategorie();
    }

    private static void insertprod() {
        Produit p = new Produit();
        System.out.println("\nEntrer le nom du produit");
        p.setNomPro(sc.next());
        System.out.println("\nEntrer la description");
        p.setDescription(sc.nextLine());sc.nextLine();
        System.out.println("\nEntrer le prix de vente");
        p.setPrixVente(sc.nextFloat());sc.nextLine();
        System.out.println("\nEntrer le prix d'achat");
        p.setPrixAchat(sc.nextFloat());sc.nextLine();
        System.out.println("\nEntrer le fournisseur");
        for(Fournisseur ff : Fournisseur.getAll())
            System.out.println("\t"+ff.getIdFour()+") "+ff.getNomFour()+" ==> "+ff.getTelFour());
        Fournisseur f = new Fournisseur(sc.nextInt());sc.nextLine();
        System.out.println("\nEntrer la categorie");
        for(Categorie ff : Categorie.getAll())
            System.out.println("\t"+ff.getIdCa()+") "+ff.getNomCa());
        Categorie c = new Categorie(sc.nextInt());sc.nextLine();
        
        p.setSonFournisseur(f);
        p.setSaCategorie(c);
        
        try {
            p.save();
            
            System.out.println("code inserer ===> "+Utilities.idToStr(p.getCodePro())+"\n");
            
            System.out.printf("\n=> Code produit => Nom produit => Prix achat => Date de creation => Quantite\n");
            
            for(Produit pr : Produit.all()){
                //System.out.println(pr.getCodePro()+" ===> "+pr.getNomPro()+" ===> "+pr.getSaCategorie().getNomCa()+" ===> "+pr.getPrixVente());
                System.out.printf("=> %12s => %11s => %10s => %16s => %3d\n", Utilities.idToStr(pr.getCodePro()), pr.getNomPro(), Utilities.formatPrix(pr.getPrixAchat()), pr.getDateCreation(), pr.getQuantite());
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void modifierprod() {
    }

    private static void listercategorie() {
        for(Categorie b : Categorie.getAll()){
            System.out.println("=> "+b.getNomCa());
            for(Produit l : b.getAllProd())
                System.out.println("\t===> "+l.getNomPro()+" ===> "+Utilities.idToStr(l.getCodePro()));
        }
    }

    private static void listerfourni() {
        for(Fournisseur b : Fournisseur.getAll()){
            System.out.println("=> "+b.getNomFour()+" => "+b.getSiteWeb());
            for(Produit l : b.getAllProd())
                System.out.println("\t===> "+l.getNomPro()+" ===> "+Utilities.idToStr(l.getCodePro()));
        }
    }

    private static void rechercherfourni() {
        System.out.print("Entrer un chaine a rechercher : ");
        String patt = sc.next();
        System.out.println("=> Nom fournisseur => Site Web => Adresse");
        for(Fournisseur f : Fournisseur.find(patt))
            System.out.println("=> "+Utilities.colorie(patt, f.getNomFour(), "rouge")+" => "+Utilities.colorie(patt, f.getSiteWeb(), "rouge")+" => "+f.getAdresse());
        System.out.println("====================");
    }

    private static void recherchercategorie() {
        System.out.print("Entrer un chaine a rechercher : ");
        String patt = sc.next();
        System.out.println("=> Nom Categorie");
        for(Categorie f : Categorie.find(patt))
            System.out.println("=> "+Utilities.colorie(patt, f.getNomCa(), "rouge"));
        System.out.println("====================");
    }

    private static void recherherprod() {
        
        System.out.print("Entrer votre methode de recherche 0 pour recherche par nom et 1 pour recherche par code : ");
        int tp = sc.nextInt();
        if(tp == 0){
            System.out.print("Entrer une chaine a rechercher : ");
        }else{
            System.out.print("Entrer une partie du code a rechercher : ");
        }
            
                
        String patt = sc.next();
        System.out.printf("\n=> Code produit => Nom produit => Prix achat => Date de creation => Quantite\n");
        for(Produit f : Produit.find(patt,tp))
            System.out.printf("=> %12s => %11s => %10s => %16s => %3d\n", Utilities.idToStr(f.getCodePro()), Utilities.colorie(patt, f.getNomPro(), "rouge"), Utilities.formatPrix(f.getPrixAchat()), f.getDateCreation(), f.getQuantite());
        System.out.println("====================");
    }

    private static void ajouterphoto() {
        System.out.println("Vous allez rechercher le produit sur lequel vous voulez ajouter la photo :");
        recherherprod();
        System.out.println("Entrer le code du produit : ");
        
        String code = sc.next();
        Produit p = new Produit( Utilities.strToId(code) );
        
        Photo photo = new Photo();
        System.out.println(" Lien de la photo ?  ");
        String lien = sc.next();sc.nextLine();
                
        System.out.println("Couleur ?  ");
        String couleur = sc.next();sc.nextLine();
        if(p.getAllPhoto().isEmpty()){ // si le produit n'a aucune photo on met la photo par defaut
            photo.setPhotoDefaut(1);
        }else{ // sionon on demande si la photo doit etre par defaut ou pas
            System.out.println("photo par defaut ? (o/n) ");
            String def  = sc.next();sc.nextLine();
            if(def.equals("o")){
                photo.setPhotoDefaut(1);
                for(Photo t : p.getAllPhoto()){
                    if(!t.getCouleur().equals(photo.getCouleur()) && !t.getLienPhoto().equals(photo.getLienPhoto())){
                        t.setPhotoDefaut(0);
                        t.update();
                    }
                }
            }else{
                photo.setPhotoDefaut(0);
            }
        }
        
        if(p.getAllPhoto().isEmpty())
            photo.setPhotoDefaut(1);
        
        photo.setLienPhoto(lien);
        photo.setCouleur(couleur);
        photo.setIdProduit(p.getIdPro());
        photo.save();
       
    }
    
}
