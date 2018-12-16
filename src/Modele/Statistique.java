/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author morga
 */
public class Statistique {
    private String plageHoraire;
    private  int NombreReservation;

    public Statistique(String plageHoraire, int NombreReservation) {
        this.plageHoraire = plageHoraire;
        this.NombreReservation = NombreReservation;
    }

    
    public String getPlageHoraire() {
        return plageHoraire;
    }

    public void setPlageHoraire(String plageHoraire) {
        this.plageHoraire = plageHoraire;
    }

    public int getNombreReservation() {
        return NombreReservation;
    }

    public void setNombreReservation(int NombreReservation) {
        this.NombreReservation = NombreReservation;
    }
    
    
}
