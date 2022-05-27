/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdd;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
public class Connexion {
    public static Connection getConnexion()
    {
        Connection con = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/restaurant","postgres","mdpprom13");
            System.out.println("hello world");
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
            System.out.println(e1.getMessage());
        }
        return con;
    }
}
