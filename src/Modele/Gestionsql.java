/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import sql.GestionBdd;

/**
 *
 * @author Rabelais
 */
public class Gestionsql {
     private Connection conn;
        private Statement stmt1;
    public void insererSport(Sport unsport)
    {
         try
        {
            // On prévoit 2 connexions à la base
            stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "gymnase","localhost", "root","");
  
            String req = "Insert into sport(`nomSport) values ("+unsport.getNomSport()+")";
  ResultSet rs = GestionBdd.envoiRequeteLMD(stmt1, req);
        }
        catch(Exception e)
        {
            System.out.println("Erreur requete3 " + e.getMessage());
        }
    }        
    }

