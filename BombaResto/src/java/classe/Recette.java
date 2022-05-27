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
public class Recette {
    int id_recette;
    int dose_ingredient;
    int id_produit;
    int id_ingredient;

    public int getId_recette() {
        return id_recette;
    }

    public void setId_recette(int id_recette) {
        this.id_recette = id_recette;
    }

    public int getDose_ingredient() {
        return dose_ingredient;
    }

    public void setDose_ingredient(int dose_ingredient) {
        this.dose_ingredient = dose_ingredient;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public Recette() {
    }

    public Recette(int id_recette, int dose_ingredient, int id_produit, int id_ingredient) {
        this.id_recette = id_recette;
        this.dose_ingredient = dose_ingredient;
        this.id_produit = id_produit;
        this.id_ingredient = id_ingredient;
    }
    
    public Recette[] getRecette(int id_produit) throws Exception {
        Recette[] listerecette = new Recette[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from recette where id_produit = "+id_produit;
            ResultSet resultats = stmt.executeQuery(requete);
            System.out.println("recette requette : "+requete);
            Vector v = new Vector();
            while(resultats.next()){
                int id_recette = resultats.getInt("id_recette");
                int dose_ingredient = resultats.getInt("dose_ingredient");
                int idP = resultats.getInt("id_produit");
                int id_ingredient = resultats.getInt("id_ingredient");
                Recette r = new Recette(id_recette, dose_ingredient, id_produit, id_ingredient);
                v.add(r);
            }
            listerecette = new Recette[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listerecette[i] = (Recette)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listerecette;
    }
    
    public double getPrixRecette(Recette r) throws Exception {
        double prix = 0;
        try {
            AchatIngredient ac = new AchatIngredient();
            AchatIngredient achat = ac.getAchatIngredient(r.getId_ingredient());
            System.out.println("prix achat : "+achat.getPrix_unitaire());
            System.out.println("id ingredient : "+r.getId_ingredient());
            prix = (r.getDose_ingredient() * achat.getPrix_unitaire()) / achat.getQuantite();
        } catch (Exception e) {
            throw e;
        }
        return prix;
    }
    
    public double getPrixTotalRecette(int id_produit) throws Exception {
        double somme = 0;
        Recette[] listeRecette = getRecette(id_produit);
        for (int i = 0; i < listeRecette.length; i++) {
            Recette recette = listeRecette[i];
            double prixRecette = getPrixRecette(recette);
            somme = somme + prixRecette;
        }
        return somme;
    }
}
