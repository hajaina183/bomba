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
public class PourboireServeur {
    double pourboire;
    int id_serveur;
    String nom;
    Date daty;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPourboire() {
        return pourboire;
    }

    public void setPourboire(double pourboire) {
        this.pourboire = pourboire;
    }

    public int getId_serveur() {
        return id_serveur;
    }

    public void setId_serveur(int id_serveur) {
        this.id_serveur = id_serveur;
    }

    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }

    public PourboireServeur(double pourboire, int id_serveur, String nom, Date daty) {
        this.pourboire = pourboire;
        this.id_serveur = id_serveur;
        this.nom = nom;
        this.daty = daty;
    }

    

    public PourboireServeur() {
    }
    
    public PourboireServeur[] getPourboires(Date d1, Date d2) throws Exception {
        PourboireServeur[] listePourboireServeur = new PourboireServeur[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String requete = "select nom,prix pourboire,p.id_serveur,daty from prixTotalCommande p join serveur s on p.id_serveur = s.id_serveur join commande c on c.id_commande = p.id_commande where daty between '"+sdf.format(d1)+"' and '"+sdf.format(d2)+"' group by p.id_serveur,daty,s.nom,id_table,prix";
            System.out.println(requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Marge m = new Marge();
            Vector v = new Vector();
            while(resultats.next()){
                double pourboire = resultats.getDouble("pourboire");
                int id_serveur = resultats.getInt("id_serveur");
                String nom = resultats.getString("nom");
                Date daty = resultats.getDate("daty");
                PourboireServeur p = new PourboireServeur(pourboire, id_serveur, nom, daty);
                v.add(p);
            }
            listePourboireServeur = new PourboireServeur[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listePourboireServeur[i] = (PourboireServeur)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listePourboireServeur;
    }
    
    public PourboireServeur[] getPourboiresI() throws Exception {
        System.out.println("....");
        PourboireServeur[] listePourboireServeur = new PourboireServeur[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String requete = "select nom,prix pourboire,p.id_serveur,daty from prixTotalCommande p join serveur s on p.id_serveur = s.id_serveur join commande c on c.id_commande = p.id_commande";
            System.out.println(requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Marge m = new Marge();
            Vector v = new Vector();
            while(resultats.next()){
                double pourboire = resultats.getDouble("pourboire");
                int id_serveur = resultats.getInt("id_serveur");
                String nom = resultats.getString("nom");
                Date daty = resultats.getDate("daty");
                PourboireServeur p = new PourboireServeur(pourboire, id_serveur, nom, daty);
                v.add(p);
            }
            listePourboireServeur = new PourboireServeur[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listePourboireServeur[i] = (PourboireServeur)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listePourboireServeur;
    }
}
