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
public class Candidatos {
    private int id_candidato;
    private String nombreyapellidos;
    private int orden;
    private int id_partido;

    public Candidatos() {
    }

    public Candidatos(String nom){
        this.nombreyapellidos=nom;
    }
    
    public Candidatos(int id_candidato, String nombreyapellidos, int orden, int id_partido) {
        this.id_candidato = id_candidato;
        this.nombreyapellidos = nombreyapellidos;
        this.orden = orden;
        this.id_partido = id_partido;
    }

    public int getId_candidato() {
        return id_candidato;
    }

    public void setId_candidato(int id_candidato) {
        this.id_candidato = id_candidato;
    }

    public String getNombreyapellidos() {
        return nombreyapellidos;
    }

    public void setNombreyapellidos(String nombreyapellidos) {
        this.nombreyapellidos = nombreyapellidos;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getId_partido() {
        return id_partido;
    }

    public void setId_partido(int id_partido) {
        this.id_partido = id_partido;
    }
    
    
}
