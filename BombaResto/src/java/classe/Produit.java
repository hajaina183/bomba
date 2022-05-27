/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import bdd.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

/**
 *
 * @author jayks
 */
public class Produit {
    int id_produit;
    String nom_produit;
    double prix_produit;
    String images;
    int id_categorie;

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

    public double getPrix_produit() {
        return prix_produit;
    }

    public void setPrix_produit(double prix_produit) {
        this.prix_produit = prix_produit;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public Produit(int id_produit, String nom_produit, double prix_produit, String images, int id_categorie) {
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.prix_produit = prix_produit;
        this.images = images;
        this.id_categorie = id_categorie;
    }

    public Produit() {
    }
    
    public Produit[] getProduits() throws Exception {
        Produit[] listeProduit = new Produit[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from produit";
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                int id_produit = resultats.getInt("id_produit");
                String nom_produit = resultats.getString("nom_produit");
                double prix_produit = resultats.getDouble("prix_produit");
                String images = resultats.getString("images");
                int id_categorie = resultats.getInt("id_categorie");
                Produit p = new Produit(id_produit, nom_produit, prix_produit, images, id_categorie);
                v.add(p);
            }
            listeProduit = new Produit[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeProduit[i] = (Produit)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeProduit;
    }
    
    public Produit[] getProduitsCatgorie(int id_categorie) throws Exception {
        Produit[] listeProduit = new Produit[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from produit where id_categorie = "+id_categorie;
             System.out.println(requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Marge m = new Marge();
            Vector v = new Vector();
            while(resultats.next()){
                int id_produit = resultats.getInt("id_produit");
                String nom_produit = resultats.getString("nom_produit");
                double prix_produit = resultats.getDouble("prix_produit");
                String images = resultats.getString("images");
                int idC = resultats.getInt("id_categorie");
                Produit p = new Produit(id_produit, nom_produit, prix_produit, images, idC);
                v.add(p);
            }
            listeProduit = new Produit[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeProduit[i] = (Produit)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeProduit;
    }
    
    public double[] getPrixRevient(Produit[] listeProduit) throws Exception {
        Vector<Double> v = new Vector<Double>();
        for (int i = 0; i < listeProduit.length; i++) {
            Produit produit = listeProduit[i];
            Recette r = new Recette();
            double prixRecette = r.getPrixTotalRecette(produit.getId_produit());
            System.out.println("prixRecette : "+prixRecette);
            double prixRevient = prixRecette;
            System.out.println("prixRevient : "+prixRevient);
            System.out.println("prix : "+produit.getPrix_produit());
            v.add(prixRevient);
        }
        double[] result = new double[v.size()];
        for (int i = 0; i < v.size(); i++) {
            Double elementAt = v.elementAt(i);
            result[i] = elementAt;
        }
        return result;
    }
  
}
