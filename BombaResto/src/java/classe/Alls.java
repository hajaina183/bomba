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
public class Alls {
    int id_commande;
    int id_detailsCommande;
    int id_produit;
    int id_table;
    String nom_produit;
    int quantite;
    double prix_produit;
    int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_detailsCommande() {
        return id_detailsCommande;
    }

    public void setId_detailsCommande(int id_detailsCommande) {
        this.id_detailsCommande = id_detailsCommande;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_table() {
        return id_table;
    }

    public void setId_table(int id_table) {
        this.id_table = id_table;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix_produit() {
        return prix_produit;
    }

    public void setPrix_produit(double prix_produit) {
        this.prix_produit = prix_produit;
    }

    public Alls() {
    }

    public Alls(int id_commande, int id_detailsCommande, int id_produit, int id_table, String nom_produit, int quantite, double prix_produit, int status) {
        this.id_commande = id_commande;
        this.id_detailsCommande = id_detailsCommande;
        this.id_produit = id_produit;
        this.id_table = id_table;
        this.nom_produit = nom_produit;
        this.quantite = quantite;
        this.prix_produit = prix_produit;
        this.status = status;
    }

    
    public Alls[] getAllsCommande() throws Exception {
        Alls[] listeAlls = new Alls[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from Alls where id_commande = "+this.getId_commande();
             System.out.println(requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Marge m = new Marge();
            Vector v = new Vector();
            while(resultats.next()){
                int id_commande = resultats.getInt("id_commande");
                int id_detailsCommande = resultats.getInt("id_detailsCommande");
                int id_produit = resultats.getInt("id_produit");
                int id_table = resultats.getInt("id_table");
                String nom_produit = resultats.getString("nom_produit");
                int quantite = resultats.getInt("quantite");
                double prix_produit = resultats.getDouble("prix_produit");
                int status = resultats.getInt("status");
                Alls a = new Alls(id_commande, id_detailsCommande, id_produit, id_table, nom_produit, quantite, prix_produit, status);
                v.add(a);
            }
            listeAlls= new Alls[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeAlls[i] = (Alls)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeAlls;
    }
    
    public Alls[] getAlls() throws Exception {
        Alls[] listeAlls = new Alls[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from Alls";
             System.out.println(requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Marge m = new Marge();
            Vector v = new Vector();
            while(resultats.next()){
                int id_commande = resultats.getInt("id_commande");
                int id_detailsCommande = resultats.getInt("id_detailsCommande");
                int id_produit = resultats.getInt("id_produit");
                int id_table = resultats.getInt("id_table");
                String nom_produit = resultats.getString("nom_produit");
                int quantite = resultats.getInt("quantite");
                double prix_produit = resultats.getDouble("prix_produit");
                int status = resultats.getInt("status");
                Alls a = new Alls(id_commande, id_detailsCommande, id_produit, id_table, nom_produit, quantite, prix_produit, status);
                v.add(a);
            }
            listeAlls= new Alls[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeAlls[i] = (Alls)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeAlls;
    }
}
