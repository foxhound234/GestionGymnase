/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Modele.Gestionsql;
import Modele.Sport;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Dialogs;
/**
 * FXML Controller class
 *
 * @author Rabelais
 */
public class AjoutSportController implements Initializable {
     private Stage dialogstage;
            @FXML
    private TextField txtSport;
    private   Sport sport=new Sport();
    private  Gestionsql gestions=new Gestionsql();
    
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
    private void handleOk()
    {
      if(isInputValid())
      {
          sport.setNomSport(txtSport.getText());
          
          okClick=true;
          dialogstage.close();
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
      Dialogs.showErrorDialog(dialogstage,messageErreur,"SVP corrigez le champ invalide","champ invalide");
    retour=false;
    }
 return  retour;
    }
}
