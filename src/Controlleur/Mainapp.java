/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Rabelais
 */
public class Mainapp extends Application {
         private Stage primaryStage;
 
                 private AnchorPane rootLayout;
     @Override
     
    public void start(Stage primaryStage) {
         this.primaryStage=primaryStage;
        this.primaryStage.setTitle("Accueil");
        try
        {
           FXMLLoader loader=new
                FXMLLoader(Mainapp.class.getResource("/vue/Accueil.fxml"));
                rootLayout=(AnchorPane) loader.load();
                Scene scene=new Scene(rootLayout);
                primaryStage.setScene(scene);
                primaryStage.show();
         
        }
        catch(IOException e)
        {
            System.out.println("ERREUR ACCUEIL : " + e.getMessage());  
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
