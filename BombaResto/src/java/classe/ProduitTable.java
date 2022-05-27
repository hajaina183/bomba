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
public class ProduitTable {
    int id_table;
    int id_produit;
    String nom_produit;
    int quantite;
    double prix_produit;
    int id_detailsCommande;

    public int getId_detailsCommande() {
        return id_detailsCommande;
    }

    public void setId_detailsCommande(int id_detailsCommande) {
        this.id_detailsCommande = id_detailsCommande;
    }

    public int getId_table() {
        return id_table;
    }

    public void setId_table(int id_table) {
        this.id_table = id_table;
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

    public ProduitTable(int id_table, int id_produit, String nom_produit, int quantite, double prix_produit) {
        this.id_table = id_table;
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.quantite = quantite;
        this.prix_produit = prix_produit;
    }

    public ProduitTable(int id_table, int id_produit, String nom_produit, int quantite, double prix_produit, int id_detailsCommande) {
        this.id_table = id_table;
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.quantite = quantite;
        this.prix_produit = prix_produit;
        this.id_detailsCommande = id_detailsCommande;
    }

    public ProduitTable() {
    }
    public ProduitTable[] getProduitTables(int id_table) throws Exception {
        ProduitTable[] listeProduitTable= new ProduitTable[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from produitTable where id_table = "+id_table;
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                int idT = resultats.getInt("id_table");
                int id_produit = resultats.getInt("id_produit");
                String nom_produit = resultats.getString("nom_produit");
                int quantite = resultats.getInt("quantite");
                double prix_produit = resultats.getDouble("prix_produit");
                int id_detailsCommande = resultats.getInt("id_detailsCommande");
                System.out.println("id_detailsCommande : "+id_detailsCommande);
                ProduitTable p = new ProduitTable(idT, id_produit, nom_produit, quantite, prix_produit,id_detailsCommande);
                v.add(p);
            }
            listeProduitTable = new ProduitTable[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeProduitTable[i] = (ProduitTable)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeProduitTable;
    }
    
    public double somme(ProduitTable[] liste) {
        double sum = 0;
        for (int i = 0; i < liste.length; i++) {
            ProduitTable produitTable = liste[i];
            double d = produitTable.getPrix_produit() * produitTable.getQuantite();
            sum = sum + d;
        }
        System.out.println(sum);
        return sum;
    }
}
