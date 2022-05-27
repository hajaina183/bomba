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
public class Seuil {
    int id;
    int idIngredient;
    int seuil;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public int getSeuil() {
        return seuil;
    }

    public void setSeuil(int seuil) {
        this.seuil = seuil;
    }

    public Seuil() {
    }

    public Seuil(int id, int idIngredient, int seuil) {
        this.id = id;
        this.idIngredient = idIngredient;
        this.seuil = seuil;
    }
    
    public Seuil[] getSeuils() throws Exception {
        Seuil[] listeSeuil = new Seuil[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from Seuil";
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                int id = resultats.getInt("id");;
                int idIngredient = resultats.getInt("idIngredient");
                int seuil = resultats.getInt("seuil");
                Seuil s = new Seuil(id, idIngredient, seuil);
                v.add(s);
            }
            listeSeuil = new Seuil[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeSeuil[i] = (Seuil)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeSeuil;
    }
    
    
}
