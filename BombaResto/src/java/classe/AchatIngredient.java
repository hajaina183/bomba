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
public class AchatIngredient {
    int id_achat;
    double prix_unitaire;
    Date dateAchat;
    int id_ingredient;
    int quantite;

    public int getId_achat() {
        return id_achat;
    }

    public void setId_achat(int id_achat) {
        this.id_achat = id_achat;
    }

    public double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public Date getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public AchatIngredient(int id_achat, double prix_unitaire, Date dateAchat, int id_ingredient, int quantite) {
        this.id_achat = id_achat;
        this.prix_unitaire = prix_unitaire;
        this.dateAchat = dateAchat;
        this.id_ingredient = id_ingredient;
        this.quantite = quantite;
    }

    public AchatIngredient() {
    }
    
    public AchatIngredient getAchatIngredient(int id_ingredient) throws Exception {
        AchatIngredient ac = new AchatIngredient();
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from achatIngredient where id_ingredient = "+id_ingredient;
            ResultSet resultats = stmt.executeQuery(requete);
            while(resultats.next()){
                int id_achat = resultats.getInt("id_achat");
                double prix = resultats.getDouble("prix_unitaire");
                System.out.println("prix..... "+prix);
                Date dateAchat = resultats.getDate("dateAchat");
                int idI = resultats.getInt("id_ingredient");
                int quantite = resultats.getInt("quantite");
                ac = new AchatIngredient(id_achat, prix, dateAchat, idI, quantite);
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return ac;
    }
}
