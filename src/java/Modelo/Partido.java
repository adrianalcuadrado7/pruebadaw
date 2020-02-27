/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Bonnye
 */
public class Partido implements Comparable<Partido> {
    private int id_partido;
    private String denominacion;
    private String siglas;
    private String logo;
    private int votos;
    
    public Partido(){
        
    }
    
    public Partido(int id_partido, String denominacion, String siglas, String logo, int votos) {
        this.id_partido = id_partido;
        this.denominacion = denominacion;
        this.siglas = siglas;
        this.logo = logo;
        this.votos = votos;
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

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    @Override
    public int compareTo(Partido o) {
        if(this.votos<o.votos){
            return -1;
        }
        if(this.votos>o.votos){
            return 1;
        }
        return 0;
    }
    
    
}
