/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.sql.Date;


/**
 *
 * @author morga
 */
public class reservation {
    private  String  Refsalle,refAsso;
    private Date  date;
    private Integer heure;

    public reservation(String Refsalle, String refAsso, Date date, Integer heure) {
        this.Refsalle = Refsalle;
        this.refAsso = refAsso;
        this.date = date;
        this.heure = heure;
    }

    public String getRefsalle() {
        return Refsalle;
    }

    public void setRefsalle(String Refsalle) {
        this.Refsalle = Refsalle;
    }

    public String getRefAsso() {
        return refAsso;
    }

    public void setRefAsso(String refAsso) {
        this.refAsso = refAsso;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getHeure() {
        return heure;
    }

    public void setHeure(Integer heure) {
        this.heure = heure;
    }
    
    
}
