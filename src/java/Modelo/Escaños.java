/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author addaw19
 */
public class Escaños {
    private int id_partido;
    private String denominacion;
    private String siglas;
    private String logo;
    private int escaños;

    public Escaños() {
    }

    public Escaños(int id){
        this.id_partido=id;
    }
    
    public Escaños(int id_partido, String denominacion, String siglas, String logo, int escaños) {
        this.id_partido = id_partido;
        this.denominacion = denominacion;
        this.siglas = siglas;
        this.logo = logo;
        this.escaños = escaños;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getEscaños() {
        return escaños;
    }

    public void setEscaños(int escaños) {
        this.escaños = escaños;
    }

    @Override
    public boolean equals(Object obj) {
        if(this.id_partido==((Escaños)obj).id_partido){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
}
