/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBD;

import Controladora.Main;
import UML.Evento;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author Jon
 */
public class EventoBBDD {
    
    public Evento consultar(String nombreE) throws Exception{
        
        Evento ev = new Evento();
        ZConexion con = new ZConexion();

        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement(Main.st("cevento"));
        sentencia.setString(1, nombreE);
        ResultSet rs;
        rs = sentencia.executeQuery();
       
        if(rs.next()){
            ev.setNombre(rs.getString(1));
            ev.setLugar(rs.getString(2));
            ev.setnPersonas(Integer.parseInt(rs.getString(3)));
            ev.setFecha(rs.getString(4));
            ev.sethEntrada(String.valueOf(rs.getTime(5)));
            ev.sethSalida(String.valueOf(rs.getTime(6)));
            ev.setCodEvento(Integer.parseInt(rs.getString(7)));
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        return ev;
    }
    
    public ArrayList listar() throws Exception{
        
        ArrayList <Evento> listado = new ArrayList();
        ZConexion con = new ZConexion();
        Statement sentencia;
        sentencia = con.getConnection().createStatement();
        ResultSet rs;
        rs = sentencia.executeQuery(Main.st("tevento"));

        while(rs.next()){
            Evento ev = new Evento();
            ev.setNombre(rs.getString(1));
            ev.setLugar(rs.getString(2));
            ev.setnPersonas(Integer.parseInt(rs.getString(3)));
            ev.setFecha(rs.getString(4));
            ev.sethEntrada(String.valueOf(rs.getTime(5)));
            ev.sethSalida(String.valueOf(rs.getTime(6)));
            ev.setCodEvento(Integer.parseInt(rs.getString(7)));
            listado.add(ev);
        }
        
        rs.close();
        sentencia.close();
        con.desconectar();
        
        return listado;
    }
    
    public void añadir(Evento ev) throws Exception{
        ZConexion con = new ZConexion();        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement(Main.st("aevento"));
        sentencia.setString(1, ev.getNombre());
        sentencia.setString(2, ev.getLugar());
        sentencia.setInt(3, ev.getnPersonas());
        sentencia.setDate(4, Date.valueOf(ev.getFecha()));
        sentencia.setTime(5, Time.valueOf(ev.gethEntrada()));
        sentencia.setTime(6, Time.valueOf(ev.gethSalida()));
        
        sentencia.executeUpdate();

        sentencia.close();
        con.desconectar();
    }
    
    public void modificar(Evento ev) throws Exception{
        
        ZConexion con = new ZConexion();        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement(Main.st("mevento"));
        
        sentencia.setString(1, ev.getLugar());
        sentencia.setInt(2, ev.getnPersonas());
        sentencia.setDate(3, Date.valueOf(ev.getFecha()));
        sentencia.setTime(4, Time.valueOf(ev.gethEntrada()));
        sentencia.setTime(5, Time.valueOf(ev.gethSalida()));
        sentencia.setString(6, ev.getNombre());
        
        sentencia.executeUpdate();

        sentencia.close();
        con.desconectar();
    }
    
    public void eliminar(String ev) throws Exception{
        ZConexion con = new ZConexion();        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement(Main.st("eevento"));
        
        sentencia.setString(1, ev);
        
        sentencia.executeUpdate();

        sentencia.close();
        con.desconectar();
    }

}
