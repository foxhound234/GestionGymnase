/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Modele.*;
import java.net.URL;
import java.text.SimpleDateFormat;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;;
import java.util.*;
import java.sql.Date;
import java.util.logging.Logger;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author morga
 */
public class ReservationSalleController implements Initializable {
    @FXML private AnchorPane ap;
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
               
                   String date;
                   
               String[] str = {"8h-9h","9h-10h","11h-12h","13h-14h","14h-15h","16h-17h","18h-19h","19h-20h","21h-22h"};
               
          ArrayList PlageHoraires = new ArrayList<>(Arrays.asList(str));
          
         ObservableList<String> lesHoraires=FXCollections.observableArrayList(PlageHoraires);
   boolean test=false;
         
         
         
  public Label getNodeByRowColumnIndex( final int row, final int column, GridPane gridPane) 
{

   ObservableList<Node> childrens = gridPane.getChildren();
   Label result = (Label) childrens.get((row)+column);

   return result;
}
  public Date getdatevalue() throws ParseException
  {
      java.sql.Date sqlDate=null;
       if(DateReservation.getValue()==null)
       {
            sqlDate=null;  
       }
      else
       {
         sqlDate =java.sql.Date.valueOf(DateReservation.getValue());  
       }
      return sqlDate;
  }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
      
    @Override
    public void initialize(URL url, ResourceBundle rb) 
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
                        DateReservation.setVisible(false); 
                }
                else
                {
                 DateReservation.setVisible(true);
                }
            };        
            
         });  

         }
    @SuppressWarnings("StringEquality")
                 public void handledate()throws ParseException
               {  
                Date date1=getdatevalue();
               if(date1==null)
               {
                   
               }
               else
               {
                TabReservation.getChildren().clear();
                    for(int i=0;i<9;i++)
                {
                    Label lab = new Label(lesHoraires.get(i));
                         String test=String.valueOf(i);
                         lab.setId(test);
                         
                       TabReservation.add(lab, 0, i);
                }
                      
                                Salle uneSalle=(Salle) cmb_choixSalle.getSelectionModel().getSelectedItem();
                            
                     
                     ObservableList<reservation>  LesRevervations= Gestionsql.getLesReservation(date1,uneSalle.getRefsalle());
                      if(LesRevervations.isEmpty())
                      {
                         for(int i=0;i<9;i++)
                              {
                        String plageHoraire=getNodeByRowColumnIndex(0,i,TabReservation).getText();
                            Button b = new Button();
                                 b.setText("Reservé");
                                 b.setOnMouseClicked( event -> {
                                         handleReservation(plageHoraire,date1);});
                                TabReservation.add(b, 1, i);
                                
                             }   
                      }
                     else if(LesRevervations.size()==9)
                          {
                              
                              
                              
                          }
                      else{
                    for(int i=0;i<lesHoraires.size();i++)
                      {
                              
                       String montest="T";
                        String plageHoraire=lesHoraires.get(i);
                           int test1=0;
                        for(int j=0;j<LesRevervations.size();j++)
                        {     
                          String est=LesRevervations.get(j).getHeure();
                           System.out.println("est : " + est);
                            if(est == plageHoraire)
                            {
                            test1=1;
                            
                             System.out.println("test dans le if else : " + plageHoraire);
                         
                                break;
                            }  
                        }
                        
                        if(test1 == 0)
                        {
                             Button b = new Button();
                                 b.setText("Reservé");
                                 b.setOnMouseClicked( event -> {
                                         handleReservation(plageHoraire,date1);});
                                TabReservation.add(b, 1, i); 
            
                        }else
                        {
                       
                        }
                 
                                
                    }   
                                  
                         }    
               }
                 
                }
                 
            public void handleReservation(String heure,Date Date1) 
            {
               Salle uneSalle=(Salle) cmb_choixSalle.getSelectionModel().getSelectedItem();
               Association uneAsso=(Association) cmb_choixAssociation.getSelectionModel().getSelectedItem();
            Gestionsql.InsertLesReservation(uneSalle.getRefsalle(),Date1,heure,uneAsso.getRefAsso());
            
          Stage stage = (Stage) ap.getScene().getWindow();
                Alert ale = new Alert(Alert.AlertType.INFORMATION);
        ale.setTitle("insertions");
        ale.setHeaderText("insertions");
        ale.setContentText("insertion reussi");
        ale.showAndWait();
          stage.close();
            }
    }


    






