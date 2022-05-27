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
public class Paiement {
    int id_paiement;
    int id_modePaiement;
    int id_detailsCommande;
    Date daty;
    double montant;

    public int getId_paiement() {
        return id_paiement;
    }

    public void setId_paiement(int id_paiement) {
        this.id_paiement = id_paiement;
    }

    public int getId_modePaiement() {
        return id_modePaiement;
    }

    public void setId_modePaiement(int id_modePaiement) {
        this.id_modePaiement = id_modePaiement;
    }

    public int getId_detailsCommande() {
        return id_detailsCommande;
    }

    public void setId_detailsCommande(int id_detailsCommande) {
        this.id_detailsCommande = id_detailsCommande;
    }

    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Paiement() {
    }

    public Paiement(int id_paiement, int id_modePaiement, int id_detailsCommande, Date daty, double montant) {
        this.id_paiement = id_paiement;
        this.id_modePaiement = id_modePaiement;
        this.id_detailsCommande = id_detailsCommande;
        this.daty = daty;
        this.montant = montant;
    }
    
    public void insertPaiement(int id_modePaiement, int id_detailsCommande, double montant) throws Exception {
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String requete = "INSERT INTO Paiement(id_modePaiment,id_detailsCommande,daty,montant) VALUES ("+id_modePaiement+","+id_detailsCommande+",'"+sdf.format(d)+"',"+montant+")";
            System.out.println(requete);
            int resultats = stmt.executeUpdate(requete);
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
    }
    
    public double[] getModePaiement(String d1, String d2) throws Exception {
        double[] resultat = new double[2];
        resultat[0] = 0;
        resultat[1] = 0;
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "select sum(montant) as montant,id_modepaiment from montantPai where daty between '"+d1+"' and '"+d2+"' group by id_modepaiment";
            System.out.println(requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Marge m = new Marge();
            while(resultats.next()){
                int id_modepaiment = resultats.getInt("id_modepaiment");
                double montant = resultats.getInt("montant");
                if(id_modepaiment == 1) {
                    resultat[0] = montant;
                } else if(id_modepaiment == 2) {
                    resultat[1] = montant;
                }
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return resultat;
    }
    
    public double[] getModePaiementII() throws Exception {
        double[] resultat = new double[2];
        resultat[0] = 0;
        resultat[1] = 0;
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "select sum(montant) as montant,id_modepaiment from montantPai group by id_modepaiment";
            System.out.println(requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Marge m = new Marge();
            while(resultats.next()){
                int id_modepaiment = resultats.getInt("id_modepaiment");
                double montant = resultats.getInt("montant");
                if(id_modepaiment == 1) {
                    resultat[0] = montant;
                } else if(id_modepaiment == 2) {
                    resultat[1] = montant;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        finally{
            con.close();
        }
        return resultat;
    }
    
    public double somme(double[] liste) {
        double sum = 0;
        for (int i = 0; i < liste.length; i++) {
            sum = sum + liste[i];
        }
        System.out.println(sum);
        return sum;
    }
}
