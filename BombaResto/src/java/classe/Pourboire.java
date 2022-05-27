/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.util.Date;

/**
 *
 * @author jayks
 */
public class Pourboire {
    int id_commande;
    Date date;
    double pourboire;

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPourboire() {
        return pourboire;
    }

    public void setPourboire(double pourboire) {
        this.pourboire = pourboire;
    }

    public Pourboire(int id_commande, Date date, double pourboire) {
        this.id_commande = id_commande;
        this.date = date;
        this.pourboire = pourboire;
    }

    public Pourboire() {
    }
    
}
