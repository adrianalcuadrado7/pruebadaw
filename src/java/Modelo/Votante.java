/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author addaw19
 */
public class Votante {
    private int id;
    private String nif;
    private String password;
    private String nombre;
    private String apellidos;
    private String domicilio;
    private LocalDate fecha_nac;
    private String votado;
    private String rol;
    
    public Votante(){
        
    }
    
    public Votante(String nif,String password,String nombre,String apellidos,String domicilio,LocalDate fecha_nac,String votado, String rol){
        this.nif=nif;
        this.password=password;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.domicilio=domicilio;
        this.fecha_nac=fecha_nac;
        this.votado=votado;
        this.rol=rol;
    }
    
    public Votante(Votante x){
        x.id=this.id;
        x.nif=this.nif;
        x.password=this.password;
        x.nombre=this.nombre;
        x.apellidos=this.apellidos;
        x.domicilio=this.domicilio;
        x.fecha_nac=this.fecha_nac;
        x.votado=this.votado;
        x.rol=this.rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    
    public String getFecha_nacString(){
        DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha= fecha_nac.format(formato);
        return fecha;
    }
    
    public LocalDate getFecha_nac() {
        DateTimeFormatter formato= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha=fecha_nac.format(formato);
        LocalDate FechaFormateada= LocalDate.parse(fecha,formato);
        return FechaFormateada;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getVotado() {
        return votado;
    }

    public void setVotado(String votado) {
        this.votado = votado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Votante{" + "id=" + id + ", nif=" + nif + ", password=" + password + ", nombre=" + nombre + ", apellidos=" + apellidos + ", domicilio=" + domicilio + ", fecha_nac=" + fecha_nac + ", votado=" + votado + ", rol=" + rol + '}';
    }
    
    
}
