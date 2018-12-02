/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rabelais
 */
public class AccueilController implements Initializable {
 Stage StageSport;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    public void handleAjoutSport()
    {
        try
        {
            StageSport= new Stage();
            StageSport.setTitle("ajouter un sport");
            FXMLLoader loader = new FXMLLoader(Mainapp.class.getResource("/vue/AjoutSport.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
            StageSport.setScene(scene);
            StageSport.show();
        }
        catch (IOException e)
        {
            System.out.println("Erreur chargement seconde fenetre : " + e.getMessage());
        }
    }
    @FXML
        public void HandleAjouterSportSalle()
    {
        try
        {
            StageSport= new Stage();
            StageSport.setTitle(" Ajouter Un sport a une salle");
            FXMLLoader loader = new FXMLLoader(Mainapp.class.getResource("/vue/AjoutSportSalle.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
            StageSport.setScene(scene);
            StageSport.show();
        }
        catch (IOException e)
        {
            System.out.println("Erreur chargement seconde fenetre : " + e.getMessage());
        }
    }
      @FXML
        public void HandleAjouterAssociations()
    {
        try
        {
            StageSport= new Stage();
            StageSport.setTitle("Ajouter Une Associations");
            FXMLLoader loader = new FXMLLoader(Mainapp.class.getResource("/vue/AjoutAssociation.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
            StageSport.setScene(scene);
            StageSport.show();
        }
        catch (IOException e)
        {
            System.out.println("Erreur chargement seconde fenetre : " + e.getMessage());
        }
    }
          
        @FXML
        public void HandleAjouterSportAssociations()
    {
        try
        {
            StageSport= new Stage();
            StageSport.setTitle("Ajouter Un  sport a une associations");
            FXMLLoader loader = new FXMLLoader(Mainapp.class.getResource("/vue/AjoutSportAsso.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
            StageSport.setScene(scene);
            StageSport.show();
        }
        catch (IOException e)
        {
            System.out.println("Erreur chargement seconde fenetre : " + e.getMessage());
        }
    }
       
                @FXML
        public void HandleAjouterSalle()
    {
        try
        {
            StageSport= new Stage();
            StageSport.setTitle("Ajouter Une salle");
            FXMLLoader loader = new FXMLLoader(Mainapp.class.getResource("/vue/AjoutSalle.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
            StageSport.setScene(scene);
            StageSport.show();
        }
        catch (IOException e)
        {
            System.out.println("Erreur chargement seconde fenetre : " + e.getMessage());
        }
    }
        
            
}
