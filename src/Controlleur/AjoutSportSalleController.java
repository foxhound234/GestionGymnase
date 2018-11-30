/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Modele.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 * FXML Controller class
 *
 * @author Rabelais
 */
public class AjoutSportSalleController implements Initializable {

    /**
     * Initializes the controller class.
     */
        @FXML
    ComboBox cmb_ChoixSalle;
                @FXML
    ComboBox cmb_ChoixSport;
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<Sport> lesSports = Gestionsql.getLesSports();
          ObservableList<Salle> lesSalles= Gestionsql.getLesSalles();
        cmb_ChoixSport.setItems(lesSports);
        
        cmb_ChoixSalle.setItems(lesSalles);
        
        
    }    
    
}
