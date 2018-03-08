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
        int codEvento = Main.consultarCodEvento(ev.getNombre());
        ZConexion con = new ZConexion(); 
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM asistencia where idevento = ? and idpersona = ?");
        sentencia.setInt(1, codEvento);
        sentencia.setString(2, p.getDni());
        ResultSet rs;
        rs = sentencia.executeQuery();
       
        if(rs.next()){
            estado = "La persona ya está puntado a este evento.";
        }
        else{
            int disponible = plazas(codEvento, con, sentencia, rs);
            if(disponible >= ev.getAforo()){
                estado = "No quedan plazas para este evento.";
            }
            else{
                disponible = ev.getAforo() - disponible;
                estado = asignar(p.getDni(), codEvento, con, sentencia, disponible);
            }
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        
        return estado;
    }
    
    private int plazas(int codEvento, ZConexion con, PreparedStatement sentencia, ResultSet rs) throws Exception{
        int estado;
        sentencia = con.getConnection().prepareStatement("SELECT COUNT(idevento) as contador FROM asistencia where idevento = ?");
        sentencia.setInt(1, codEvento);
        rs = sentencia.executeQuery();
        if(rs.next()){
            estado = rs.getInt("contador");
        }
        else{
            estado = 0;
        }
        return estado;
    }
    
    private String asignar(String dni, int codEvento, ZConexion con, PreparedStatement sentencia, int disp)throws Exception{
        sentencia = con.getConnection().prepareStatement("INSERT INTO asistencia VALUES (?, ?)");
        sentencia.setInt(1, codEvento);
        sentencia.setString(2, dni);
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
        rs = sentencia.executeQuery("SELECT evento.nombre as evento, asistencia.idpersona as dni, persona.nombre " +
            "FROM asistencia " +
            "INNER JOIN persona on persona.dni = asistencia.idpersona " +
            "INNER JOIN evento on evento.cod = asistencia.idevento");

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
