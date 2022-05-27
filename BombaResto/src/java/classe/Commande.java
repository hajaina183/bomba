/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import bdd.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author jayks
 */
public class Commande {

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_table() {
        return id_table;
    }

    public void setId_table(int id_table) {
        this.id_table = id_table;
    }

    public Commande(int id_commande, Date date, int id_table) {
        this.id_commande = id_commande;
        this.date = date;
        this.id_table = id_table;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    int id_commande;
    Date date;
    int id_table;

    public Commande() {
    }

    
    
    public DetailsCommande[] getDetailsCommandes() throws Exception {
        DetailsCommande[] listeDetailsCommande = new DetailsCommande[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from detailsCommande where id_commande = "+this.getId_commande()+" and date = "+this.getDate();
             System.out.println(requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Marge m = new Marge();
            Vector v = new Vector();
            while(resultats.next()){
                int id_detailsCommande = resultats.getInt("id_detailsCommande");
                int id_commande = resultats.getInt("id_commande");
                int id_serveur = resultats.getInt("id_serveur");
                int id_produit = resultats.getInt("id_produit");
                int quantite = resultats.getInt("quantite");
                DetailsCommande d = new DetailsCommande(id_detailsCommande, id_commande, id_serveur, id_produit, quantite);
                v.add(d);
            }
            listeDetailsCommande = new DetailsCommande[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeDetailsCommande[i] = (DetailsCommande)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeDetailsCommande;
    }
     
    public void insertCommandes(int id_table) throws Exception {
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String requete = "INSERT INTO Commande(daty,id_table) VALUES ('"+sdf.format(d)+"',"+id_table+")";
            System.out.println(requete);
            int resultats = stmt.executeUpdate(requete);
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
    }
     public int getMaxId() throws Exception {
        int id = 0;
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "SELECT id_commande FROM Commande ORDER BY id_commande DESC LIMIT 1";
            ResultSet resultats = stmt.executeQuery(requete);
            while(resultats.next()){
                id = resultats.getInt("id_commande");
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return id;
    }
}
