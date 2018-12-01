/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author Rabelais
 */
public class Association {
    private String refAsso,ville,adresse,nomResponsable;

    public Association() {
    }

    public Association(String refAsso, String ville, String adresse, String nomResponsable) {
        this.refAsso = refAsso;
        this.ville = ville;
        this.adresse = adresse;
        this.nomResponsable = nomResponsable;
    }

    public String getRefAsso() {
        return refAsso;
    }

    public void setRefAsso(String refAsso) {
        this.refAsso = refAsso;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNomResponsable() {
        return nomResponsable;
    }

    public void setNomResponsable(String nomResponsable) {
        this.nomResponsable = nomResponsable;
    }
    
}
