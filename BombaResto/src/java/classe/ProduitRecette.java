/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import bdd.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author jayks
 */
public class ProduitRecette {
    int id_produit;
    int id_detailsCommande;
    String nom_produit;
    String nom_ingredient;
    int quantite;
    double prix;
    Date daty;

    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getNom_ingredient() {
        return nom_ingredient;
    }

    public void setNom_ingredient(String nom_ingredient) {
        this.nom_ingredient = nom_ingredient;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getId_detailsCommande() {
        return id_detailsCommande;
    }

    public void setId_detailsCommande(int id_detailsCommande) {
        this.id_detailsCommande = id_detailsCommande;
    }

    public ProduitRecette(String nom_ingredient, int quantite, double prix) {
        this.nom_ingredient = nom_ingredient;
        this.quantite = quantite;
        this.prix = prix;
    }

    public ProduitRecette(String nom_ingredient, int quantite, double prix, Date daty) {
        this.nom_ingredient = nom_ingredient;
        this.quantite = quantite;
        this.prix = prix;
        this.daty = daty;
    }

    public ProduitRecette(int id_produit, int id_detailsCommande, String nom_produit, String nom_ingredient, int quantite) {
        this.id_produit = id_produit;
        this.id_detailsCommande = id_detailsCommande;
        this.nom_produit = nom_produit;
        this.nom_ingredient = nom_ingredient;
        this.quantite = quantite;
    }

    public ProduitRecette(String nom_ingredient, int quantite) {
        this.nom_ingredient = nom_ingredient;
        this.quantite = quantite;
    }
    
    public ProduitRecette(int id_produit, String nom_produit, String nom_ingredient, int quantite) {
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.nom_ingredient = nom_ingredient;
        this.quantite = quantite;
    }

    public ProduitRecette() {
    }
    
    public ProduitRecette[] getProduitRecettes(int id_produit) throws Exception {
        ProduitRecette[] listeProduitRecette= new ProduitRecette[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from produitRecetteII where id_produit = "+id_produit;
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                int idP = resultats.getInt("id_produit");
                String nom_produit = resultats.getString("nom_produit");
                String nom_ingredient = resultats.getString("nom_ingredient");
                int quantite = resultats.getInt("quantite");
                ProduitRecette pr = new ProduitRecette(idP, nom_produit, nom_ingredient, quantite);
                v.add(pr);
            }
            listeProduitRecette = new ProduitRecette[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeProduitRecette[i] = (ProduitRecette)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeProduitRecette;
    }
    
    public ProduitRecette[] getProduitRecettesII(int id_produit, int id_detailsCommande) throws Exception {
        ProduitRecette[] listeProduitRecette= new ProduitRecette[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from produitRecette where id_produit = "+id_produit+" and id_detailsCommande = "+id_detailsCommande;
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                int idP = resultats.getInt("id_produit");
                int idD = resultats.getInt("id_detailsCommande");
                String nom_produit = resultats.getString("nom_produit");
                String nom_ingredient = resultats.getString("nom_ingredient");
                int quantite = resultats.getInt("quantite");
                ProduitRecette pr = new ProduitRecette(idP, idD, nom_produit, nom_ingredient, quantite);
                v.add(pr);
            }
            listeProduitRecette = new ProduitRecette[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeProduitRecette[i] = (ProduitRecette)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeProduitRecette;
    }
    
    public ProduitRecette[] getProduitRecettesIII() throws Exception {
        ProduitRecette[] listeProduitRecette= new ProduitRecette[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "select * from IngredientConsommer";
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                String nom_ingredient = resultats.getString("nom_ingredient");
                int quantite = resultats.getInt("quantite");
                double prix = resultats.getDouble("prix");
                Date daty = resultats.getDate("daty");
                ProduitRecette pr = new ProduitRecette(nom_ingredient, quantite, prix, daty);
                v.add(pr);
            }
            listeProduitRecette = new ProduitRecette[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeProduitRecette[i] = (ProduitRecette)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeProduitRecette;
    }
    
    public ProduitRecette[] getProduitRecettesDate(String date1, String date2) throws Exception {
        ProduitRecette[] listeProduitRecette= new ProduitRecette[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "select * from IngredientConsommer where daty between '"+date1+"' and '"+date2+"'";
            System.out.println("re : "+requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                String nom_ingredient = resultats.getString("nom_ingredient");
                int quantite = resultats.getInt("quantite");
                double prix = resultats.getDouble("prix");
                Date daty = resultats.getDate("daty");
                ProduitRecette pr = new ProduitRecette(nom_ingredient, quantite, prix, daty);
                v.add(pr);
            }
            listeProduitRecette = new ProduitRecette[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeProduitRecette[i] = (ProduitRecette)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeProduitRecette;
    }
    
    public double somme(ProduitRecette[] liste) {
        double sum = 0;
        for (int i = 0; i < liste.length; i++) {
            ProduitRecette p = liste[i];
            sum = sum + p.getPrix();
        }
        System.out.println(sum);
        return sum;
    }
    
}
