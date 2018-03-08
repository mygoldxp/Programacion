/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBD;

import Controladora.Main;
import UML.Evento;
import UML.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Jon
 */
public class AsistirBBDD {
    
    public String añadir(Persona p, Evento ev) throws Exception{
        String estado;
        ZConexion con = new ZConexion(); 
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement(Main.st("apuntar"));
        sentencia.setInt(1, ev.getCodEvento());
        sentencia.setString(2, p.getDni());
        ResultSet rs;
        rs = sentencia.executeQuery();
       
        if(rs.next()){
            estado = "La persona ya está puntado a este evento.";
        }
        else{
            int disponible = plazas(ev, con, sentencia, rs);
            if(disponible >= ev.getnPersonas()){
                estado = "No quedan plazas para este evento.";
            }
            else{
                disponible = ev.getnPersonas() - disponible;
                estado = asignar(p, ev, con, sentencia, disponible);
            }
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        
        return estado;
    }
    
    private int plazas(Evento ev, ZConexion con, PreparedStatement sentencia, ResultSet rs) throws Exception{
        int estado;
        sentencia = con.getConnection().prepareStatement(Main.st("plazasevento"));
        sentencia.setInt(1, ev.getCodEvento());
        rs = sentencia.executeQuery();
        if(rs.next()){
            estado = rs.getInt("contador");
        }
        else{
            estado = 0;
        }
        return estado;
    }
    
    private String asignar(Persona p, Evento ev, ZConexion con, PreparedStatement sentencia, int disp)throws Exception{
        sentencia = con.getConnection().prepareStatement(Main.st("asignarevento"));
        sentencia.setInt(1, ev.getCodEvento());
        sentencia.setString(2, p.getDni());
        sentencia.executeUpdate();
        disp --;
        return "Asistencia Confirmada.\nPlazas disponibles: " + disp;
    }
    
    public String listado() throws Exception{
        String dato = "Los datos de los eventos y sus asistentes son";
        String evento = "";
        String asistentes = "";
        
        ZConexion con = new ZConexion();
        Statement sentencia;
        sentencia = con.getConnection().createStatement();
        ResultSet rs;
        rs = sentencia.executeQuery(Main.st("listado"));

        while(rs.next()){
            if(evento.equals(rs.getString(1))){
                asistentes += rs.getString(2) + ", ";
                asistentes += rs.getString(3) + "\n";
            }else{
                dato += evento + ":\n" + asistentes;
                asistentes = "";
                evento = rs.getString(1);
                asistentes += rs.getString(2) + ", ";
                asistentes += rs.getString(3) + "\n";
            }
        }
        dato += evento + ":\n" + asistentes;
        rs.close();
        sentencia.close();
        con.desconectar();
        return dato;
    }
}
