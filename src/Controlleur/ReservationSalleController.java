/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Modele.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author morga
 */
public class ReservationSalleController implements Initializable {
    Gestionsql sql=new Gestionsql();
        ComboBox cmb_choixAssociation;
        ComboBox cmb_choixSport;
        ComboBox cmb_choixSalle;
        
    /**
     * Initializes the controller class.
     * @param rb
     */
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    {
        ObservableList<Association> lesAsssociations = Gestionsql.getLesAssociations();
        cmb_choixAssociation.setItems(lesAsssociations);
        
        
       cmb_choixAssociation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Association>()
        {
            @Override
            public void changed(ObservableValue<? extends Association> observable, Association oldValue,Association newValue)
            {
                // Si une ligne sélectionnée alors
                if (newValue == null)
                {
                    cmb_choixSport.setVisible(false);
                }
                else
                {
                    cmb_choixSport.setVisible(true);
                }
            }
        });
        
    }
    }
  }




