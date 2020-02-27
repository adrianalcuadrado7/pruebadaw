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
public class ApplicationErrorException extends Exception {
    private int codigo;
    private String mensaje;
    private String lugar;
    
    public ApplicationErrorException(int c, String m, String l){
        this.codigo=c;
        this.mensaje=m;
        this.lugar=l;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }
    
    @Override
    public String toString(){
        return this.codigo+", "+this.mensaje+", "+this.lugar;
    }
}
