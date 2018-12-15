/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;
import java.sql.Connection;
import java.sql.Date;
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
    public void insererAccueilir(String nomSport,String refSalle)
    {
        try
        {
            // On prévoit 2 connexions à la base
              stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "gymnase","localhost", "root","");
                String req="INSERT INTO accueillir(refSalle,nomSportAutorise) VALUES ('"+refSalle+"','"+nomSport+"')";
                int nb1 = GestionBdd.envoiRequeteLID(stmt1, req);
        }
        catch(Exception e)
        {
            System.out.println("Erreur requete3 " + e.getMessage());
        }   
    }
        public void insererPratique(String nomSport,String refAsso)
    {
        try
        {
            // On prévoit 2 connexions à la base
              stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "gymnase","localhost", "root","");
                String req="INSERT INTO pratiquer(refAsso, nomSport) VALUES ('"+refAsso+"','"+nomSport+"')";
                int nb1 = GestionBdd.envoiRequeteLID(stmt1, req);
        }
        catch(Exception e)
        {
            System.out.println("Erreur" + e.getMessage());
        }   
    }
    
      public void insererAssociation(Association uneAssociation)
    {
        try
        {
            // On prévoit 2 connexions à la base
              stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "gymnase","localhost", "root","");
                String req="INSERT INTO association(refAsso, ville, adresse, nomResponsable) VALUES ('"+uneAssociation.getRefAsso()+"','"+uneAssociation.getVille()+"','"+uneAssociation.getAdresse()+"','"+uneAssociation.getNomResponsable()+"')";
                int nb1 = GestionBdd.envoiRequeteLID(stmt1, req);
        }
        catch(Exception e)
        {
            System.out.println("Erreur requete3 " + e.getMessage());
        }   
    }
            public void insererSalle(Salle uneSalle)
    {
        try
        {
            // On prévoit 2 connexions à la base
              stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "gymnase","localhost", "root","");
                String req="INSERT INTO salle(refSalle,surface,typeRevetement) VALUES ('"+uneSalle.getRefsalle()+"','"+uneSalle.getSurface()+"','"+uneSalle.getTyperevement()+"')";
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
     public static ObservableList<Sport>GetLesSports(Association uneAssociation)
     {
          Connection conn;
        Statement stmt1;
        Sport sport;
        ObservableList<Sport> lesSports = FXCollections.observableArrayList();
        try
        {

           stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "gymnase","localhost", "root","");
            
            // Liste des clients qui "ont un plan de formation"
            String req = "select s.nomsport\n" +
                        "from  sport s,pratiquer p\n" +
                        "where p.nomsport=s.nomsport\n" +
                        "and refAsso='"+uneAssociation.getRefAsso()+"'";
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
       public static ObservableList<Salle> getLesSalles(Sport UnSport)
    {
        Connection conn;
        Statement stmt1;
        Salle salle;
        ObservableList<Salle> lesSalles = FXCollections.observableArrayList();
        try
        {

           stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "gymnase","localhost", "root","");
            
            // Liste des clients qui "ont un plan de formation"
            String req = "select s.refSalle,surface,typeRevetement\n" +
                          "from salle s,accueillir a\n" +
                        "where s.refSalle=a.refSalle\n" +
                        "and nomSportAutorise='"+UnSport.getNomSport()+"'";
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
      
        public static ObservableList<Association> getLesAssociations()
    {
        Connection conn;
        Statement stmt1;
        Association  uneAssociation;
        ObservableList<Association> lesAssociations = FXCollections.observableArrayList();
        try
        {

           stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "gymnase","localhost", "root","");
            
            // Liste des clients qui "ont un plan de formation"
            String req = "select * from association";
            ResultSet rs = GestionBdd.envoiRequeteLMD(stmt1,req);
            while (rs.next())
            {
                uneAssociation= new Association(rs.getString("refAsso"),rs.getString("ville"),rs.getString("adresse"),rs.getString("nomResponsable"));
               lesAssociations.add(uneAssociation);
            }
        }
        catch (SQLException se)
        {
            System.out.println("Erreur SQL requete getLesClients : " + se.getMessage());
        }
        return lesAssociations;
    }
          public static ObservableList<reservation> getLesReservation(Date  Unedate,String  Refsalle)
          {
              Connection conn;
        Statement stmt1;
        reservation  uneReservation;
        ObservableList<reservation> lesReservations = FXCollections.observableArrayList();
        try
        {

           stmt1 = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "gymnase","localhost", "root","");
            
            // Liste des clients qui "ont un plan de formation"
            String req = "SELECT * \n" +
                        "FROM reservation \n" +
                        "WHERE \n" +
                        "refSalle='"+ Refsalle+"'\n" +
                        "and date='"+Unedate+"'";
            
            ResultSet rs = GestionBdd.envoiRequeteLMD(stmt1,req);
            while (rs.next())
            {
               uneReservation= new reservation(rs.getString("refSalle"),rs.getDate("date"),rs.getString("heure"),rs.getString("refAsso"));
               lesReservations.add(uneReservation);
            }
        }
        catch (SQLException se)
        {
            System.out.println("Erreur SQL requete getLesClients : " + se.getMessage());
        }
              return lesReservations;
          }
        
    }

