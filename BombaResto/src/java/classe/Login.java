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
public class Login {
    int id_login;
    String nom_utilisateur;
    String mdp;
    int grade;

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }

    public String getNom_utilisateur() {
        return nom_utilisateur;
    }

    public void setNom_utilisateur(String nom_utilisateur) {
        this.nom_utilisateur = nom_utilisateur;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Login(int id_login, String nom_utilisateur, String mdp, int grade) {
        this.id_login = id_login;
        this.nom_utilisateur = nom_utilisateur;
        this.mdp = mdp;
        this.grade = grade;
    }

    public Login() {
    }
    public int estConnecter(String nom, String mdp) throws Exception {
        int rep = 0;
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select count(*) isa from login where nom_utilisateur = '"+nom+"' and mdp = '"+mdp+"'";
            System.out.println(requete);
            ResultSet resultats = stmt.executeQuery(requete);
            while(resultats.next()){
                rep = resultats.getInt("isa");
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return rep;
    }
    
    public Login getLogin(String nom, String mdp) throws Exception {
        Login log = new Login();
        Connection con = null;
        try {
            con = Connexion.getConnexion();
            java.sql.Statement stmt = con.createStatement();
            String requete = "Select * from login where nom_utilisateur = '"+nom+"' and mdp = '"+mdp+"'";
            ResultSet resultats = stmt.executeQuery(requete);
            while(resultats.next()){
                int id_login = resultats.getInt("id_login");
                String nom_utilisateur = resultats.getString("nom_utilisateur");
                String motdepasse = resultats.getString("mdp");
                int grade = resultats.getInt("grade");
                log = new Login(id_login, nom_utilisateur, motdepasse,grade);
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            con.close();
        }
        return log;
    }
}
