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
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author morga
 */
public class AjoutSportAssoController implements Initializable {
        @FXML
    ComboBox cmb_ChoixAssociation;
                @FXML
    ComboBox cmb_ChoixSport;
    Association UneAssocation;
    Sport UnSport;
    Gestionsql sql=new Gestionsql();
      private boolean okClick=false;
     @FXML private javafx.scene.control.Button ButtonAjout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<Sport> lesSports = Gestionsql.getLesSports();
          ObservableList<Association>  lesAssociations= Gestionsql.getLesAssociations();
        cmb_ChoixSport.setItems(lesSports);
        
        cmb_ChoixAssociation.setItems(lesAssociations);
       
    }    
       public boolean isOkclick()
    {
       return  okClick;
    }
    public void handleOk()
    {
      if(isInputValid())
      {
          UneAssocation =(Association) cmb_ChoixAssociation.getSelectionModel().getSelectedItem();
          UnSport=(Sport) cmb_ChoixSport.getSelectionModel().getSelectedItem();
          sql.insererAccueilir(UnSport.getNomSport(),UneAssocation.getRefAsso());
          okClick=true;
             Stage stage = (Stage) ButtonAjout.getScene().getWindow();
          sql.insererPratique(UnSport.getNomSport(),UneAssocation.getRefAsso());
            Alert ale = new Alert(Alert.AlertType.INFORMATION);
        ale.setTitle("insertions");
        ale.setHeaderText("insertions");
        ale.setContentText("insertion reussi");
        ale.showAndWait();
        stage.close();
      }
    }
     private boolean isInputValid() {
        String messageErreur="";
        boolean retour=true;
    if(cmb_ChoixAssociation.getSelectionModel().getSelectedItem()==null)
    {
        messageErreur="Sport invalide";
    }
    if(cmb_ChoixSport.getSelectionModel().getSelectedItem()==null)
    {
        messageErreur="Salle invalide";
    }
    if(messageErreur.length()>0)
    {
          Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("erreur");
        al.setHeaderText("erreur");
        al.setContentText(messageErreur);
        al.showAndWait();
    retour=false;
    }
 return  retour;
    }
}
