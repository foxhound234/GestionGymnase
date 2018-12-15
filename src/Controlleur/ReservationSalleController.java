/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Modele.*;
import java.net.URL;
import java.sql.Date;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.Node;
import javafx.scene.Parent;
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
               String[] str = {"8h-9h","9h-10h","11h-12h","13h-14h","14h-15h","16h-17h","18h-19h","19h-20h","21h-22h"};
          ArrayList PlageHoraires = new ArrayList<>(Arrays.asList(str));;
  
         ObservableList<String> lesHoraires=FXCollections.observableArrayList(PlageHoraires);
         
  public Label getNodeByRowColumnIndex( final int row, final int column, GridPane gridPane) 
{

   ObservableList<Node> childrens = gridPane.getChildren();
   Label result = (Label) childrens.get((row)+column);

   return result;
}
         
     private String zzzzz(final int row, final int column,GridPane gridPane) {
     String result="";
    ObservableList<javafx.scene.Node> children = gridPane.getChildren();

    for (javafx.scene.Node node : children) {
        if(gridPane.getRowIndex(node) == row && gridPane.getColumnIndex(node) == column) {
            result=String.valueOf(node);
            
            break;
        }
    }

    return result;
}
 
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
      
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
         for(int i=0;i<9;i++)
                {
                    Label lab = new Label(lesHoraires.get(i));
                         String test=String.valueOf(i);
                         lab.setId(test);
                         
                       TabReservation.add(lab, 0, i);
                }
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
                
               String stqt=getNodeByRowColumnIndex(0,0,TabReservation).getText();
                     Alert ale = new Alert(Alert.AlertType.INFORMATION);
                 ale.setTitle("insertions");
                 ale.setHeaderText(stqt);
             ale.setContentText(stqt);
                ale.showAndWait();
                }
             
            }
              });   

                
        cmb_choixSport.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Sport>()
                 {
            @Override
         
            public void changed(ObservableValue<? extends Sport> observable, Sport oldValue, Sport newValue)
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

      
      
      
      
             cmb_choixSalle.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Salle>()
                 {
            @Override
            public void changed(ObservableValue<? extends Salle> observable, Salle oldValue,Salle newValue)
            {
                // Si une ligne sélectionnée alors
                if (newValue == null)
                {
                     
                }
                else
                {
                    Salle uneSalle=(Salle)cmb_choixSalle.getSelectionModel().getSelectedItem();
                   LocalDate localDate = DateReservation.getValue();
                   Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
                      Date date = (Date) Date.from(instant);
                  ObservableList<reservation> lesRevervations=Gestionsql.getLesReservation(date,uneSalle.getRefsalle());
                         for(int i=0;i<9;i++)
                {
             
                          String stqt=getNodeByRowColumnIndex(0,i,TabReservation).getText();
                          
                          if(lesRevervations.get(i).getHeure()==stqt)
                          {
                              
                          }
                }
                        
                     
                }
            };       
                     
         });  
         
             
             
             
             
             
             
             
             
             
             
             
             
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}





