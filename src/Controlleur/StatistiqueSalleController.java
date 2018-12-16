/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Modele.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author morga
 */
public class StatistiqueSalleController implements Initializable {
            @FXML
        ComboBox cmb_choixSalle;
             @FXML
          PieChart Statisques; 
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
         
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
          ObservableList<Salle> lesSalles= Gestionsql.getLesSalles();
        cmb_choixSalle.setItems(lesSalles);
        
    }    
    public ObservableList<Data> Remplirpiechart(ObservableList<Statistique> lesReservations)
    {
        ObservableList<Data> answer = FXCollections.observableArrayList();
                for (int i=0;i<lesReservations.size();i++) {
                          
                     answer.add(new PieChart.Data(lesReservations.get(i).getPlageHoraire(),lesReservations.get(i).getNombreReservation())); 
                }  
            return answer;     
    }
    public void handleSalle()
    {
         Salle uneSalle=(Salle)cmb_choixSalle.getSelectionModel().getSelectedItem();
        ObservableList<Statistique> lesReservations= Gestionsql.LesReservationstat(uneSalle.getRefsalle());
             ObservableList<Data> pieChartData = Remplirpiechart(lesReservations);
        Statisques.setData(pieChartData);
    }
}
