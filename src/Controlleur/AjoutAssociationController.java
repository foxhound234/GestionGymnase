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
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author morga
 */
public class AjoutAssociationController implements Initializable {
        @FXML
    private TextField refAsso;
          @FXML
    private TextField Ville;
         @FXML
    private TextField Adresse;
         @FXML
    private TextField nomresponsable;
           @FXML 
    private javafx.scene.control.Button ButtonAjout;
     private Gestionsql sql=new Gestionsql();
       private Association UneAssociation;
  private boolean okClick=false;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
      @FXML  public void handleOk()
    {
      if(isInputValid())
      {
          UneAssociation=new Association(refAsso.getText(), Ville.getText(), Adresse.getText(), nomresponsable.getText());
          okClick=true;
          sql.insererAssociation(UneAssociation);
          Stage stage = (Stage) ButtonAjout.getScene().getWindow();
          stage.close();
      }
    }
    private boolean isInputValid() {
        String messageErreur="";
        boolean retour=true;
    if(refAsso.getText()==null || refAsso.getText().length()== 0)
    {
        messageErreur="ref Asso invalide";
    }
    
     if(Ville.getText()==null || Ville.getText().length()== 0)
    {
        messageErreur="Ville invalide";
    }
      if(Adresse.getText()==null || Adresse.getText().length()== 0)
    {
        messageErreur="Adresse invalide";
    }
       if(nomresponsable.getText()==null || nomresponsable.getText().length()== 0)
    {
        messageErreur="Nomresponsable invalide";
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
