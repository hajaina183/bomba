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
 * @author Rado
 */
public class NTable {
    int id_table;

    public int getId_table() {
        return id_table;
    }

    public void setId_table(int id_table) {
        this.id_table = id_table;
    }

    public NTable() {
    }

    public NTable(int id_table) {
        this.id_table = id_table;
    }
    
    
    public NTable[] getTables() throws Exception {
        NTable[] listeTable = new NTable[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from NTable";
             System.out.println(requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                int id_t = resultats.getInt("id_table");
                NTable d = new NTable(id_t);
                v.add(d);
            }
            listeTable = new NTable[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeTable[i] = (NTable)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeTable;
    }
}
