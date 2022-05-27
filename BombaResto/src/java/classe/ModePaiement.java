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
public class ModePaiement {
    int id_modePaiment;
    String intitule;

    public int getId_modePaiment() {
        return id_modePaiment;
    }

    public void setId_modePaiment(int id_modePaiment) {
        this.id_modePaiment = id_modePaiment;
    }

    

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public ModePaiement() {
    }

    public ModePaiement(int id_modePaiment, String intitule) {
        this.id_modePaiment = id_modePaiment;
        this.intitule = intitule;
    }

    
    public ModePaiement[] getModePaiements() throws Exception {
        ModePaiement[] listeModePaiement= new ModePaiement[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "select * from modePaiement";
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                int id_modePaiment = resultats.getInt("id_modePaiment");
                String intitule = resultats.getString("intitule");
                ModePaiement m = new ModePaiement(id_modePaiment, intitule);
                v.add(m);
            }
            listeModePaiement = new ModePaiement[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeModePaiement[i] = (ModePaiement)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeModePaiement;
    }
}
