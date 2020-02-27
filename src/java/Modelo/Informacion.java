/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Informacion {
    private String circunscripcion;
    private int candidatos;
    private String tipo_consulta;
    private LocalDate fecha;
    private String escrutinio;
    
    public Informacion(){
        
    }

    public Informacion(String circunscripcion, int candidatos, String tipo_consulta, LocalDate fecha, String escrutinio) {
        this.circunscripcion = circunscripcion;
        this.candidatos = candidatos;
        this.tipo_consulta = tipo_consulta;
        this.fecha = fecha;
        this.escrutinio = escrutinio;
    }
    
    public String getCircunscripcion() {
        return circunscripcion;
    }

    public void setCircunscripcion(String circunscripcion) {
        this.circunscripcion = circunscripcion;
    }

    public int getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(int candidatos) {
        this.candidatos = candidatos;
    }

    public String getTipo_consulta() {
        return tipo_consulta;
    }

    public void setTipo_consulta(String tipo_consulta) {
        this.tipo_consulta = tipo_consulta;
    }

    public String getFechaString(){
        DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String f= fecha.format(formato);
        return f;
    }
    
    public LocalDate getFecha() {
        DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String f=fecha.format(formato);
        LocalDate FechaFormateada= LocalDate.parse(f,formato);
        return FechaFormateada;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEscrutinio() {
        return escrutinio;
    }

    public void setEscrutinio(String escrutinio) {
        this.escrutinio = escrutinio;
    }
    
    
}
