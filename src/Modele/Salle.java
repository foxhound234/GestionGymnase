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
public class Salle {
      private String refsalle,typerevement;
        private int surface;
    public String getRefsalle() {
        return refsalle;
    }

    public void setRefsalle(String refsalle) {
        this.refsalle = refsalle;
    }

    public int getSurface() {
        return surface;
    }

    public void setSurface(int surface) {
        this.surface = surface;
    }
    
    public String getTyperevement() {
        return typerevement;
    }

    public void setTyperevement(String typerevement) {
        this.typerevement = typerevement;
    }

    public Salle(String refsalle, String typerevement, int surface) {
        this.refsalle = refsalle;
        this.typerevement = typerevement;
        this.surface = surface;
    }
    
    public Salle() {
    }
      
}
