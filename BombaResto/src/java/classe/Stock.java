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
public class Stock {
    int id_stock;
    int id_ingredient;
    Date date;
    int entree;
    int sortie;
    String nom_ingredient;
    int reste;

    public int getReste() {
        return reste;
    }

    public void setReste(int reste) {
        this.reste = reste;
    }

    public String getNom_ingredient() {
        return nom_ingredient;
    }

    public void setNom_ingredient(String nom_ingredient) {
        this.nom_ingredient = nom_ingredient;
    }

    public int getId_stock() {
        return id_stock;
    }

    public void setId_stock(int id_stock) {
        this.id_stock = id_stock;
    }

    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getEntree() {
        return entree;
    }

    public void setEntree(int entree) {
        this.entree = entree;
    }

    public int getSortie() {
        return sortie;
    }

    public void setSortie(int sortie) {
        this.sortie = sortie;
    }

    public Stock() {
    }

    public Stock(int id_stock, int id_ingredient, Date date, int entree, int sortie) {
        this.id_stock = id_stock;
        this.id_ingredient = id_ingredient;
        this.date = date;
        this.entree = entree;
        this.sortie = sortie;
    }

    public Stock(int id_stock, int id_ingredient, Date date, int entree, int sortie, String nom_ingredient) {
        this.id_stock = id_stock;
        this.id_ingredient = id_ingredient;
        this.date = date;
        this.entree = entree;
        this.sortie = sortie;
        this.nom_ingredient = nom_ingredient;
    }

    public Stock(String nom_ingredient, int reste) {
        this.nom_ingredient = nom_ingredient;
        this.reste = reste;
    }
    
    public Stock[] getStockDate(String date1, String date2) throws Exception {
        Stock[] listeStock= new Stock[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "select nom, sum(entree) - sum(sortie) as reste from Stock_Ingredient s join ingredient i on s.id_ingredient = i.id_ingredient where daty between '"+date1+"' and '"+date2+"' group by nom ";
            System.out.println("re : "+requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                String nom_ingredient = resultats.getString("nom");
                int reste = resultats.getInt("reste");
                Stock s = new Stock(nom_ingredient, reste);
                v.add(s);
            }
            listeStock = new Stock[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeStock[i] = (Stock)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeStock;
    }
    
    public Stock[] getStock() throws Exception {
        Stock[] listeStock= new Stock[0];
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "select nom, sum(entree) - sum(sortie) as reste from Stock_Ingredient s join ingredient i on s.id_ingredient = i.id_ingredient group by nom ";
            System.out.println("re : "+requete);
            ResultSet resultats = stmt.executeQuery(requete);
            Vector v = new Vector();
            while(resultats.next()){
                String nom_ingredient = resultats.getString("nom");
                int reste = resultats.getInt("reste");
                Stock s = new Stock(nom_ingredient, reste);
                v.add(s);
            }
            listeStock = new Stock[v.size()];
            for (int i = 0; i < v.size(); i++) {
                Object elementAt = v.elementAt(i);
                listeStock[i] = (Stock)elementAt;
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return listeStock;
    }
    
    public void insertStock(int id_ingredient,int entree,int sortie)throws Exception{
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            Commande d = new Commande();
            Date dt = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            int id_commande = d.getMaxId();
            String requete = "insert into Stock_Ingredient(id_ingredient,daty,entree,sortie) values ("+id_ingredient+",'"+sdf.format(dt)+"',"+entree+","+sortie+");";
            System.out.println("insert stock : "+requete);
            int resultats = stmt.executeUpdate(requete);
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
    }
    
}
