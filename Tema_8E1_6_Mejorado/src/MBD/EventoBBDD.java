/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBD;

import UML.Evento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Jon
 */
public class EventoBBDD {
    
    public int consultarCodEvento(String nombreE) throws Exception{
        int cod = -1;
        ZConexion con = new ZConexion();
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT cod FROM evento where nombre = ?");
        sentencia.setString(1, nombreE);
        ResultSet rs;
        rs = sentencia.executeQuery();
       
        if(rs.next()){
            cod = rs.getInt("cod");
        }
        
        rs.close();
        sentencia.close();
        con.desconectar();
        return cod;
    }
    
    public Evento consultar(String nombreE) throws Exception{
        
        Evento ev = new Evento();
        ZConexion con = new ZConexion();

        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM evento where nombre = ?");
        sentencia.setString(1, nombreE);
        ResultSet rs;
        rs = sentencia.executeQuery();
       
        if(rs.next()){
            ev.setNombre(rs.getString("Nombre"));
            ev.setLugar(rs.getString("Lugar"));
            ev.setAforo(rs.getInt("Aforo"));
            ev.setFecha(rs.getDate("Fecha"));
            ev.sethEntrada(rs.getTime("HoraI").toLocalTime());
            ev.sethSalida(rs.getTime("HoraF").toLocalTime());
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
        rs = sentencia.executeQuery("SELECT * FROM evento");

        while(rs.next()){
            Evento ev = new Evento();
            ev.setNombre(rs.getString("Nombre"));
            ev.setLugar(rs.getString("Lugar"));
            ev.setAforo(rs.getInt("Aforo"));
            ev.setFecha(rs.getDate("Fecha"));
            ev.sethEntrada(rs.getTime("HoraI").toLocalTime());
            ev.sethSalida(rs.getTime("HoraF").toLocalTime());
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
        sentencia = con.getConnection().prepareStatement("INSERT INTO evento VALUES (?, ?, ?, ?, ?, ?, NULL)");
        sentencia.setString(1, ev.getNombre());
        sentencia.setString(2, ev.getLugar());
        sentencia.setInt(3, ev.getAforo());
        sentencia.setDate(4, (Date) ev.getFecha());
        sentencia.setTime(5, Time.valueOf(ev.gethEntrada()));
        sentencia.setTime(6, Time.valueOf(ev.gethSalida()));
        
        sentencia.executeUpdate();

        sentencia.close();
        con.desconectar();
    }
    
    public void modificar(Evento ev) throws Exception{
        
        ZConexion con = new ZConexion();        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("UPDATE evento SET lugar = ?, aforo = ?, fecha = ?, horai = ?, horaf = ? WHERE nombre = ?");
        
        sentencia.setString(1, ev.getLugar());
        sentencia.setInt(2, ev.getAforo());
        sentencia.setDate(3, (Date) ev.getFecha());
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
        sentencia = con.getConnection().prepareStatement("DELETE FROM evento WHERE nombre = ?");
        
        sentencia.setString(1, ev);
        
        sentencia.executeUpdate();

        sentencia.close();
        con.desconectar();
    }

}
