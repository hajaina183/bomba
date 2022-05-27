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
public class Ingredient {
    int id_ingredient;
    String nom;

    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Ingredient(int id_ingredient, String nom) {
        this.id_ingredient = id_ingredient;
        this.nom = nom;
    }

    public Ingredient() {
    }
    
}
