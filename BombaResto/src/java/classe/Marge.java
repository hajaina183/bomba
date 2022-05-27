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
public class Marge {
    int id_marge;
    double montant_min;
    double montant_max;
    int marge;

    public int getId_marge() {
        return id_marge;
    }

    public void setId_marge(int id_marge) {
        this.id_marge = id_marge;
    }

    public double getMontant_min() {
        return montant_min;
    }

    public void setMontant_min(double montant_min) {
        this.montant_min = montant_min;
    }

    public double getMontant_max() {
        return montant_max;
    }

    public void setMontant_max(double montant_max) {
        this.montant_max = montant_max;
    }

    public int getMarge() {
        return marge;
    }

    public void setMarge(int marge) {
        this.marge = marge;
    }

    public Marge() {
    }

    public Marge(int id_marge, double montant_min, double montant_max, int marge) {
        this.id_marge = id_marge;
        this.montant_min = montant_min;
        this.montant_max = montant_max;
        this.marge = marge;
    }
    public Marge[] getMarges() throws Exception {
        Marge[] listeMarge = new Marge[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from marge";
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                int id_marge = resultats.getInt("id_marge");
                double montant_min = resultats.getDouble("montant_min");
                double montant_max = resultats.getDouble("montant_max");
                int marge = resultats.getInt("marge");
                Marge m = new Marge(id_marge, montant_min, montant_max, marge);
                v.add(m);
            }
            listeMarge = new Marge[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeMarge[i] = (Marge)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeMarge;
    }
}
