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
public class Reste {
    int id_ingredient;
    int reste;

    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public int getReste() {
        return reste;
    }

    public void setReste(int reste) {
        this.reste = reste;
    }

    public Reste() {
    }

    public Reste(int id_ingredient, int reste) {
        this.id_ingredient = id_ingredient;
        this.reste = reste;
    }
    
    public Reste[] getRestes() throws Exception {
        Reste[] listeReste = new Reste[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from Reste";
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                int id_ingredient = resultats.getInt("id_ingredient");
                int reste = resultats.getInt("reste");
                Reste r = new Reste(id_ingredient, reste);
                v.add(r);
            }
            listeReste = new Reste[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeReste[i] = (Reste)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeReste;
    }
}
