/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Modele.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.InputEvent;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author Rabelais
 */
public class AjoutSportController implements Initializable {
            @FXML
    private TextField txtSport;
         @FXML 
    private final   Sport sport=new Sport();
    private final  Gestionsql gestions=new Gestionsql();
    private boolean okClick=false;
     @FXML private javafx.scene.control.Button ButtonAjout;
     
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
        public boolean isOkclick()
    {
       return  okClick;
    }
        
  @FXML  public void handleOk()
    {
      if(isInputValid())
      {
          sport.setNomSport(txtSport.getText());
          gestions.insererSport(sport);
          okClick=true;
            Stage stage = (Stage) ButtonAjout.getScene().getWindow();
    // do what you have to do
    stage.close();
      }
    }
 

    private boolean isInputValid() {
        String messageErreur="";
        boolean retour=true;
    if(txtSport.getText()==null || txtSport.getText().length()== 0)
    {
        messageErreur="Sport invalide";
    }
    if(messageErreur.length()>0)
    {
          Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("Erreur");
        al.setHeaderText("Erreur");
        al.setContentText(messageErreur);
        al.showAndWait();
    retour=false;
    }
 return  retour;
    }
}
