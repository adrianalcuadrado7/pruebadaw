/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.ApplicationErrorException;
import Modelo.Candidatos;
import Modelo.Electos;
import Modelo.Escaños;
import Modelo.Informacion;
import Modelo.Partido;
import Modelo.Votante;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import static jdk.nashorn.internal.objects.Global.undefined;

/**
 *
 * @author addaw19
 */
public class Operaciones {
    
    public void altaVotante(Votante _objVotante,Connection _Conexion) throws ApplicationErrorException{
        try{
            
        String ordenSQL="INSERT INTO votante VALUES(null,?,AES_ENCRYPT(?,'adrian'),?,?,?,?,?,?);";
        PreparedStatement PrepStm =_Conexion.prepareStatement(ordenSQL);
        PrepStm.setString(1,_objVotante.getNif());
        PrepStm.setString(2,_objVotante.getPassword());
        PrepStm.setString(3,_objVotante.getNombre());
        PrepStm.setString(4,_objVotante.getApellidos());
        PrepStm.setString(5,_objVotante.getDomicilio());
        PrepStm.setDate(6,java.sql.Date.valueOf(_objVotante.getFecha_nac()));
        PrepStm.setString(7,_objVotante.getVotado());
        PrepStm.setString(8,_objVotante.getRol());
        int filas=PrepStm.executeUpdate();
        
        if(filas!=1){
            throw new ApplicationErrorException(0,"Votante no insertado","Error en la inserccion en altaVotante()");
        }
        }catch(SQLException ex){
            int codigo= ex.getErrorCode();
            String mensaje= ex.getMessage();
            String lugar="Error SQL en altaVotante()";
            throw new ApplicationErrorException(codigo,mensaje,lugar);
        }
    }
    
    public ArrayList<Votante> listadoCenso(Connection _Conexion) throws SQLException, ApplicationErrorException{
        try{
        ArrayList<Votante> Votantes= new ArrayList<Votante>();
        String ordenSQL="SELECT * FROM votante";
        Statement s = _Conexion.createStatement();
        ResultSet rs = s.executeQuery(ordenSQL);
        
        while(rs.next()){
            Votante v= new Votante(rs.getString("nif"),rs.getString("password"),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("domicilio"),rs.getDate("fecha_nac").toLocalDate(),rs.getString("votado"),rs.getString("rol"));
            Votantes.add(v);
        }
        return Votantes;
        }catch(SQLException ex){
            int codigo= ex.getErrorCode();
            String mensaje= ex.getMessage();
            String lugar="Error SQL en altaVotante()";
            throw new ApplicationErrorException(codigo,mensaje,lugar);
        }
    }
    
    public Votante login(Connection _Conexion, Votante v) throws SQLException, ApplicationErrorException{
        try{
            String ordenSQL="SELECT * FROM votante WHERE nif=? AND AES_DECRYPT(password,'adrian')=?";
            PreparedStatement PrepStm =_Conexion.prepareStatement(ordenSQL);
            PrepStm.setString(1,v.getNif());
            PrepStm.setString(2,v.getPassword());
            ResultSet rs= PrepStm.executeQuery();
        
            if(rs!=undefined){  
                rs.next();
                Votante votante= new Votante(rs.getString("nif"),v.getPassword(),rs.getString("nombre"),rs.getString("apellidos"),rs.getString("domicilio"),rs.getDate("fecha_nac").toLocalDate(),rs.getString("votado"),rs.getString("rol"));
                return votante;
            }
            else{
                throw new ApplicationErrorException(0,"No se ha podido conectar","Error en la conexion en login()");
            }
        }catch(SQLException ex){
            int codigo= ex.getErrorCode();
            String mensaje= ex.getMessage();
            String lugar="Error SQL en login()";
            throw new ApplicationErrorException(codigo,mensaje,lugar);
        }
    }
    
    public Informacion informacion(Connection _Conexion) throws SQLException, ApplicationErrorException{
        try{
            String ordenSQL="SELECT * FROM informacion";
            Statement s = _Conexion.createStatement();
            ResultSet rs = s.executeQuery(ordenSQL);
            rs.next();
            Informacion info= new Informacion(rs.getString("circunscripcion"),rs.getInt("candidato_elegir"),rs.getString("tipo_consulta"),rs.getDate("fecha_consulta").toLocalDate(),rs.getString("estado_escrutinio"));
            return info;
        }catch(SQLException ex){
            int codigo= ex.getErrorCode();
            String mensaje= ex.getMessage();
            String lugar="Error SQL en informacion()";
            throw new ApplicationErrorException(codigo,mensaje,lugar);
        }
    }
    
    public ArrayList<Electos> calcularElectos(int numescaños,Connection _Conexion) throws SQLException, ApplicationErrorException{
        try{
            String ordenSQL="SELECT * FROM partidos";
            Statement s = _Conexion.createStatement();
            ResultSet rs = s.executeQuery(ordenSQL);
            ArrayList<Electos> electos= new ArrayList<Electos>();
            ArrayList<Partido> partidos= new ArrayList<Partido>();
            ArrayList<Escaños> escaños= new ArrayList<Escaños>();
            
            while(rs.next()){
                partidos.add(new Partido(rs.getInt("id_partidos"),rs.getString("denominacion"),rs.getString("siglas"),rs.getString("logo"),rs.getInt("votos")));
            }
            
            partidos.sort(Collections.reverseOrder());
            for(int i=0; i<numescaños; i++){
                int id= partidos.get(0).getId_partido();
                String denominacion= partidos.get(0).getDenominacion();
                String siglas= partidos.get(0).getSiglas();
                String logo= partidos.get(0).getLogo();
                int es= 1;
                Escaños objetoE= new Escaños(id,denominacion,siglas,logo,es);
                int indice=escaños.indexOf(objetoE);
                if(indice==-1){
                    escaños.add(objetoE);
                }
                else{
                    int e= escaños.get(indice).getEscaños();
                    escaños.get(indice).setEscaños(e+1);
                }
                partidos.get(0).setVotos((partidos.get(0).getVotos()/2));
                partidos.sort(Collections.reverseOrder());
            }
            
            for(int i=0; i<escaños.size(); i++){
                int id= escaños.get(i).getId_partido();
                int o= escaños.get(i).getEscaños();
                String orden="SELECT nombre_apellidos FROM candidatos WHERE id_partido=? and orden<=? ORDER BY orden";
                PreparedStatement PrepStm =_Conexion.prepareStatement(orden);
                PrepStm.setInt(1,id);
                PrepStm.setInt(2,o);
                ResultSet rs1= PrepStm.executeQuery();
                while(rs1.next()){
                    electos.add(new Electos(escaños.get(i).getLogo(),escaños.get(i).getDenominacion(),rs1.getString("nombre_apellidos")));
                }
                
            }
            
            return electos;
        }catch(SQLException ex){
            int codigo= ex.getErrorCode();
            String mensaje= ex.getMessage();
            String lugar="Error SQL en calcularElectos()";
            throw new ApplicationErrorException(codigo,mensaje,lugar);
        }
    }
    
    public void modificarEscrutinio(Connection Conexion,String opcion) throws ApplicationErrorException{
        try{
            String ordenSQL="UPDATE informacion SET estado_escrutinio='"+opcion+"'";
            Statement s = Conexion.createStatement();
            int filas = s.executeUpdate(ordenSQL);
            
            if(filas!=1){
               throw new ApplicationErrorException(0,"No se ha podido realizar el update","Error en el update en modificarEscrutinio()"); 
            }
        }catch(SQLException ex){
            int codigo= ex.getErrorCode();
            String mensaje= ex.getMessage();
            String lugar="Error SQL en modificarEscrutinio()";
            throw new ApplicationErrorException(codigo,mensaje,lugar);
        }
    }
    
    public ArrayList<Partido> resultadosVotaciones(Connection Conexion) throws ApplicationErrorException{
        try{
            String ordenSQL="SELECT * FROM partidos";
            Statement s = Conexion.createStatement();
            ResultSet rs = s.executeQuery(ordenSQL);
            ArrayList<Partido> partidos= new ArrayList<Partido>();
            while(rs.next()){
                partidos.add(new Partido(rs.getInt("id_partidos"),rs.getString("denominacion"),rs.getString("siglas"),rs.getString("logo"),rs.getInt("votos")));
            }
            return partidos;
        }catch(SQLException ex){
            int codigo= ex.getErrorCode();
            String mensaje= ex.getMessage();
            String lugar="Error SQL en resultadosVotaciones()";
            throw new ApplicationErrorException(codigo,mensaje,lugar);
        }
    }
    
    public void bajaVotantes(Connection Conexion,Votante votante) throws ApplicationErrorException{
        try{
            String ordenSQL="Delete FROM votante WHERE nif=? AND AES_DECRYPT(password,'adrian')=?";
            PreparedStatement PrepStm =Conexion.prepareStatement(ordenSQL);
            PrepStm.setString(1,votante.getNif());
            PrepStm.setString(2,votante.getPassword());
            int filas= PrepStm.executeUpdate();
            
            if(filas!=1){
                throw new ApplicationErrorException(0,"Votante no dado de baja","Error en la baja en bajaVotantes()");
            }
        }catch(SQLException ex){
            int codigo= ex.getErrorCode();
            String mensaje= ex.getMessage();
            String lugar="Error SQL en bajaVotantes()";
            throw new ApplicationErrorException(codigo,mensaje,lugar);
        }
    }
    
    public void comprobarVotante(Connection Conexion,Votante v) throws ApplicationErrorException{
        try{
            String ordenSQL="UPDATE votante SET nombre=nombre WHERE nif=? AND AES_DECRYPT(password,'adrian')=?";
            PreparedStatement PrepStm =Conexion.prepareStatement(ordenSQL);
            PrepStm.setString(1,v.getNif());
            PrepStm.setString(2,v.getPassword());
            int filas= PrepStm.executeUpdate();
            if(filas!=1){
                throw new ApplicationErrorException(0,"Usuario erroneo","Usuario erroneo en comprobarVotante()");
            }
        }catch(SQLException ex){
            int codigo= ex.getErrorCode();
            String mensaje= ex.getMessage();
            String lugar="Error SQL en comprobarVotante()";
            throw new ApplicationErrorException(codigo,mensaje,lugar);
        }
    }
    
    public void modificarVotante(Connection Conexion,Votante votante) throws ApplicationErrorException{
        try{
            
        String ordenSQL="UPDATE votante SET password=AES_ENCRYPT(?,'adrian'),nombre=?,apellidos=?,domicilio=?,fecha_nac=? WHERE nif=?;";
        PreparedStatement PrepStm =Conexion.prepareStatement(ordenSQL);
        PrepStm.setString(1,votante.getPassword());
        PrepStm.setString(2,votante.getNombre());
        PrepStm.setString(3,votante.getApellidos());
        PrepStm.setString(4,votante.getDomicilio());
        PrepStm.setDate(5,java.sql.Date.valueOf(votante.getFecha_nac()));
        PrepStm.setString(6,votante.getNif());
        PrepStm.setString(7,votante.getPassword());
        int filas=PrepStm.executeUpdate();
        
        if(filas!=1){
            throw new ApplicationErrorException(0,"Votante no actualizado","Error en la actualizacion en modificarVotante()");
        }
        }catch(SQLException ex){
            int codigo= ex.getErrorCode();
            String mensaje= ex.getMessage();
            String lugar="Error SQL en modificarVotante()";
            throw new ApplicationErrorException(codigo,mensaje,lugar);
        }
    }
    
    public void votar(Connection Conexion,Votante votante,int idpartido) throws ApplicationErrorException{
        try{
            if(votante.getVotado().equals("N")){
            String ordenSQL="UPDATE votante SET votado='S' WHERE nif=?";
            PreparedStatement PrepStm =Conexion.prepareStatement(ordenSQL);
            PrepStm.setString(1,votante.getNif());
            int filas= PrepStm.executeUpdate();
            
            String orden="UPDATE partidos SET votos=votos+1 WHERE id_partidos=?";
            PreparedStatement PrepStm2 =Conexion.prepareStatement(orden);
            PrepStm2.setInt(1,idpartido);
            int filas2= PrepStm2.executeUpdate();
            }
            else{
                throw new ApplicationErrorException(0,"Ya has votado","Este usuario ya ha votado en votar()");
            } 
        }catch(SQLException ex){
            int codigo= ex.getErrorCode();
            String mensaje= ex.getMessage();
            String lugar="Error SQL en votar()";
            throw new ApplicationErrorException(codigo,mensaje,lugar);
        }
    }
    
    public ArrayList<Partido> partidos(Connection Conexion) throws ApplicationErrorException{
        try{
            String ordenSQL="SELECT * FROM partidos";
            Statement s = Conexion.createStatement();
            ResultSet rs = s.executeQuery(ordenSQL);
            ArrayList<Partido> partidos= new ArrayList<Partido>();
            while(rs.next()){
                partidos.add(new Partido(rs.getInt("id_partidos"),rs.getString("denominacion"),rs.getString("siglas"),rs.getString("logo"),rs.getInt("votos")));
            }
            return partidos;
        }catch(SQLException ex){
            int codigo= ex.getErrorCode();
            String mensaje= ex.getMessage();
            String lugar="Error SQL en partidos()";
            throw new ApplicationErrorException(codigo,mensaje,lugar);
        }
    }
    
    public void WenoDia(){
        System.out.println("Weno' dia' Españita");
    }
}
