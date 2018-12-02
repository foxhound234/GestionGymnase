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
import javafx.stage.Stage;

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
    Salle Unesalle;
    Sport UnSport;
    Gestionsql sql=new Gestionsql();
     private Stage dialogstage;
     private boolean okClick=false;
     @FXML private javafx.scene.control.Button ButtonAjout;
        
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ObservableList<Sport> lesSports = Gestionsql.getLesSports();
          ObservableList<Salle> lesSalles= Gestionsql.getLesSalles();
        cmb_ChoixSport.setItems(lesSports);
        
        cmb_ChoixSalle.setItems(lesSalles);
       
    }    
    
      public boolean isOkclick()
    {
       return  okClick;
    }
    public void handleOk()
    {
      if(isInputValid())
      {
          Unesalle =(Salle) cmb_ChoixSalle.getSelectionModel().getSelectedItem();
          UnSport=(Sport) cmb_ChoixSport.getSelectionModel().getSelectedItem();
          sql.insererAccueilir(UnSport.getNomSport(),Unesalle.getRefsalle());
          okClick=true;
             Stage stage = (Stage) ButtonAjout.getScene().getWindow();
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
    if(cmb_ChoixSport.getSelectionModel().getSelectedItem()==null)
    {
        messageErreur="Sport invalide";
    }
    if(cmb_ChoixSalle.getSelectionModel().getSelectedItem()==null)
    {
        messageErreur="Salle invalide";
    }
    if(messageErreur.length()>0)
    {
          Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setTitle("INSERTION REUSSIE");
        al.setHeaderText("une insertion et deux maj effectuées");
        al.setContentText(messageErreur);
        al.showAndWait();
    retour=false;
    }
 return  retour;
    }
}
