/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;
import  Modele.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author morga
 */
public class AjoutSalleController implements Initializable {
    @FXML
    private TextField refSalle;
          @FXML
    private TextField surface;
         @FXML
    private TextField typeRevetement;
           @FXML 
    private javafx.scene.control.Button ButtonAjout;
     private  Gestionsql sql=new Gestionsql();
     private  Salle uneSalle;
       private boolean okClick=false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
      public boolean isOkclick()
    {
       return  okClick;
    }
     @FXML  public void handleOk()
    {
      if(isInputValid())
      {
          int unesurface=Integer.parseInt(surface.getText());
          uneSalle=new Salle(refSalle.getText(),typeRevetement.getText(),unesurface);
          okClick=true;
          Stage stage = (Stage) ButtonAjout.getScene().getWindow();
          Alert ale = new Alert(Alert.AlertType.INFORMATION);
          ale.setTitle("insertions");
          ale.setHeaderText("insertions");
          ale.setContentText("insertion reussi");
          ale.showAndWait();
          sql.insererSalle(uneSalle);
          stage.close();
      }
    }
    
      private boolean isInputValid() {
        String messageErreur="";
        boolean retour=true;
    if(refSalle.getText()==null || refSalle.getText().length()== 0)
    {
        messageErreur="ref salle invalide";
    }
    
     if(surface.getText()==null || surface.getText().length()== 0)
    {
        messageErreur="surface invalide";
    }
      if(typeRevetement.getText()==null || typeRevetement.getText().length()== 0)
    {
        messageErreur="typeRevetement invalide";
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
