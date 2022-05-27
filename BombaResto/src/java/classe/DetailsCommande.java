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
public class DetailsCommande {

    public int getId_detailsCommande() {
        return id_detailsCommande;
    }

    public void setId_detailsCommande(int id_detailsCommande) {
        this.id_detailsCommande = id_detailsCommande;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    int id_detailsCommande;
    int id_commande;
    int id_serveur;
    int id_produit;
    int quantite;
    String etat;
    int status;

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    

    public int getId_serveur() {
        return id_serveur;
    }

    public void setId_serveur(int id_serveur) {
        this.id_serveur = id_serveur;
    }

    public DetailsCommande() {
    }

    public DetailsCommande(int id_detailsCommande, int id_commande, int id_serveur, int id_produit, int quantite, String etat) {
        this.id_detailsCommande = id_detailsCommande;
        this.id_commande = id_commande;
        this.id_serveur = id_serveur;
        this.id_produit = id_produit;
        this.quantite = quantite;
        this.etat = etat;
    }

    public DetailsCommande(int id_detailsCommande, int id_commande, int id_serveur, int id_produit, int quantite) {
        this.id_detailsCommande = id_detailsCommande;
        this.id_commande = id_commande;
        this.id_serveur = id_serveur;
        this.id_produit = id_produit;
        this.quantite = quantite;
    }

    public DetailsCommande(int id_detailsCommande, int id_commande, int id_serveur, int id_produit, int quantite, String etat, int status) {
        this.id_detailsCommande = id_detailsCommande;
        this.id_commande = id_commande;
        this.id_serveur = id_serveur;
        this.id_produit = id_produit;
        this.quantite = quantite;
        this.etat = etat;
        this.status = status;
    }

  
    public DetailsCommande(int id_commande, int id_produit, int quantite) {
        this.id_commande = id_commande;
        this.id_produit = id_produit;
        this.quantite = quantite;
    }
    
    public DetailsCommande getDetailsCommande(int id_detailsCommande) throws Exception {
        DetailsCommande detailsCommande = new DetailsCommande();
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from detailsCommande where id_detailsCommande = "+id_detailsCommande;
            System.out.println("requete dc : "+requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Marge m = new Marge();
            while(resultats.next()){
                int idD = resultats.getInt("id_detailsCommande");
                int id_commande = resultats.getInt("id_commande");
                int id_serveur = resultats.getInt("id_serveur");
                int id_produit = resultats.getInt("id_produit");
                int quantite = resultats.getInt("quantite");
                String etat = resultats.getString("etat");
                int status = resultats.getInt("status");
                detailsCommande = new DetailsCommande(idD, id_commande, id_serveur, id_produit, quantite, etat, status);
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return detailsCommande;
    }
    
    public double getMontant(int id_detailsCommande) throws Exception {
        double montant = 0;
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select quantite * prix_produit as montant from detailsCommande dc join produit p on dc.id_produit = p.id_produit where id_detailsCommande = "+id_detailsCommande;
            System.out.println(requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Marge m = new Marge();
            while(resultats.next()){
                montant = resultats.getInt("montant");
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return montant;
    }
    
    public void insertDetailsCommande(int id_serveur,int id_produit,int quantite)throws Exception{
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            Commande d = new Commande();
            int id_commande = d.getMaxId();
            String requete = "INSERT INTO DetailsCommande(id_commande,id_serveur,id_produit,quantite,etat,status) VALUES ("+id_commande+","+id_serveur+","+id_produit+","+quantite+",'nonPayer',0)";
            System.out.println(requete);
            int resultats = stmt.executeUpdate(requete);
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
    }
    
    public void updateEtatValider() throws Exception {
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "UPDATE DetailsCommande Set status = 1 where id_commande = "+this.getId_commande();
            System.out.println(requete);
            int resultats = stmt.executeUpdate(requete);
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
    }
    
    public void updateEtatPret() throws Exception {
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "UPDATE DetailsCommande Set status = 2 where id_detailsCommande = "+this.getId_detailsCommande();
            System.out.println(requete);
            int resultats = stmt.executeUpdate(requete);
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
    }
    
    public void updateEtatLivrer() throws Exception {
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "UPDATE DetailsCommande Set status = 3 where id_detailsCommande = "+this.getId_detailsCommande();
            System.out.println(requete);
            int resultats = stmt.executeUpdate(requete);
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
    }
    
    public void updateEtatPayer() throws Exception {
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "UPDATE DetailsCommande Set status = 4 where id_detailsCommande = "+this.getId_detailsCommande();
            System.out.println(requete);
            int resultats = stmt.executeUpdate(requete);
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
    }
    
    public void annuler() throws Exception {
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Delete from detailsCommande where id_detailsCommande = "+this.getId_detailsCommande();
            System.out.println(requete);
            int resultats = stmt.executeUpdate(requete);
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
    }
}
