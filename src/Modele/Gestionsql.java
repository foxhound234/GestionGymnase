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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
                String req="INSERT INTO sport(nomSport) VALUES ('"+unsport.getNomSport()+"')";
                int nb1 = GestionBdd.envoiRequeteLID(stmt1, req);
        }
        catch(Exception e)
        {
            System.out.println("Erreur requete3 " + e.getMessage());
        }
    }
    
     public static ObservableList<Sport> getLesSports()
    {
        Connection conn;
        Statement stmt1;
        Sport sport;
        ObservableList<Sport> lesSports = FXCollections.observableArrayList();
        try
        {

           stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "gymnase","localhost", "root","");
            
            // Liste des clients qui "ont un plan de formation"
            String req = "select * from sport";
            ResultSet rs = GestionBdd.envoiRequeteLMD(stmt1,req);
            while (rs.next())
            {
                sport= new Sport(rs.getString("nomSport"));
               lesSports.add(sport);
            }
        }
        catch (SQLException se)
        {
            System.out.println("Erreur SQL requete getLesClients : " + se.getMessage());
        }
        return lesSports;
    }
      public static ObservableList<Salle> getLesSalles()
    {
        Connection conn;
        Statement stmt1;
        Salle salle;
        ObservableList<Salle> lesSalles = FXCollections.observableArrayList();
        try
        {

           stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "gymnase","localhost", "root","");
            
            // Liste des clients qui "ont un plan de formation"
            String req = "select * from salle";
            ResultSet rs = GestionBdd.envoiRequeteLMD(stmt1,req);
            while (rs.next())
            {
                salle= new Salle(rs.getString("refSalle"),rs.getString("typeRevetement"),rs.getInt("surface"));
               lesSalles.add(salle);
            }
        }
        catch (SQLException se)
        {
            System.out.println("Erreur SQL requete getLesClients : " + se.getMessage());
        }
        return lesSalles;
    }
    }

