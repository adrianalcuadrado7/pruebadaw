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
public class Electos {
    private String logo;
    private String denominacion;
    private String nombreyapellidos;

    public Electos() {
    }

    public Electos(String logo, String denominacion, String nombreyapellidos) {
        this.logo = logo;
        this.denominacion = denominacion;
        this.nombreyapellidos = nombreyapellidos;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getNombreyapellidos() {
        return nombreyapellidos;
    }

    public void setNombreyapellidos(String nombreyapellidos) {
        this.nombreyapellidos = nombreyapellidos;
    }
    
    
}
