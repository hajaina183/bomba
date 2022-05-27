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
public class Serveur {

    public int getId_serveur() {
        return id_serveur;
    }

    public void setId_serveur(int id_serveur) {
        this.id_serveur = id_serveur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    int id_serveur;
    String nom;

    public Serveur(int id_serveur, String nom) {
        this.id_serveur = id_serveur;
        this.nom = nom;
    }
    
     public Serveur() {
    }
    
    public Serveur[] getServeurs() throws Exception {
        Serveur[] listeServeur = new Serveur[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from Serveur";
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                int id_categorie = resultats.getInt("id_serveur");
                String nom_categorie = resultats.getString("nom");
                Serveur c = new Serveur(id_categorie, nom_categorie);
                v.add(c);
            }
            listeServeur = new Serveur[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeServeur[i] = (Serveur)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeServeur;
    }
            
    
}
