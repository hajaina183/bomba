/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

/**
 *
 * @author jayks
 */
import bdd.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class Seuille {
    int idIngredient;
    String nomIngredient;

    public int getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(int idIngredient) {
        this.idIngredient = idIngredient;
    }

    public String getNomIngredient() {
        return nomIngredient;
    }

    public void setNomIngredient(String nomIngredient) {
        this.nomIngredient = nomIngredient;
    }

    public Seuille(int idIngredient, String nomIngredient) {
        this.idIngredient = idIngredient;
        this.nomIngredient = nomIngredient;
    }

    public Seuille() {
    }
    
    public Seuille[] getSeuille() throws Exception {
        Seuille[] seuil = new Seuille[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "select * from seuille";
            System.out.println(requete);
            System.out.println("je suis la ");
            ResultSet resultats = stmt.executeQuery(requete);
            //System.out.println("je suis la ");
            Vector v = new Vector();
            
            while(resultats.next()){
                System.out.println("");
                int id_ingredient = resultats.getInt("id_ingredient");
                String nom = resultats.getString("nom");
                Seuille c = new Seuille(id_ingredient, nom);
                v.add(c);
            }
            System.out.println("sizeee"+v.size());
            seuil = new Seuille[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                seuil[i] = (Seuille)elementAt;
            }
        } catch (Exception e) {
            //throw e;
            e.printStackTrace();
        }
        finally{
            con.close();
        }
        return seuil;
    }
}
