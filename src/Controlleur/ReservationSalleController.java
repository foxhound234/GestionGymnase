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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author morga
 */
public class ReservationSalleController implements Initializable {
    Gestionsql sql=new Gestionsql();
            @FXML
        ComboBox cmb_choixAssociation;
             @FXML
        ComboBox cmb_choixSport;
             @FXML
        ComboBox cmb_choixSalle;
             @FXML
         DatePicker   DateReservation;
               @FXML
         GridPane TabReservation;
         ObservableList<String> lesHoraires=FXCollections.observableArrayList();
        
         
         
         
    /**
     * Initializes the controller class.
     * @param rb
     */
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    {
       ObservableList<Association>  lesAssociations= Gestionsql.getLesAssociations();
       
       cmb_choixAssociation.setItems(lesAssociations);
        
                cmb_choixAssociation.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Association>()
                 {
            @Override
            public void changed(ObservableValue<? extends Association> observable, Association oldValue, Association newValue)
            {
                // Si une ligne sélectionnée alors
                if (newValue == null)
                {
                     cmb_choixSport.setVisible(false);
                }
                else
                {
                   cmb_choixSport.setVisible(true);
                           Association uneAsso=(Association)cmb_choixAssociation.getSelectionModel().getSelectedItem();
                     ObservableList<Sport>  LesSports= Gestionsql.GetLesSports(uneAsso);
                         cmb_choixSport.setItems(LesSports); 
                }
            
            }
         });  


                cmb_choixSport.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Sport>()
                 {
            @Override
            public void changed(ObservableValue<? extends Sport> observable, Sport oldValue,Sport newValue)
            {
                // Si une ligne sélectionnée alors
                if (newValue == null)
                {
                     cmb_choixSalle.setVisible(false);
                }
                else
                {
                  cmb_choixSalle.setVisible(true);
                           Sport unSport=(Sport)cmb_choixSport.getSelectionModel().getSelectedItem();
                     ObservableList<Salle>  LesSalles= Gestionsql.getLesSalles(unSport);
                     
                    cmb_choixSalle.setItems(LesSalles);
                }
            
            }
         });  
                
                
    }
    }
  }




