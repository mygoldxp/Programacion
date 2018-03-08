/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBD;

import Controladora.Main;
import UML.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jon
 */
public class PersonaBBDD {
    
    public Persona consultar(String dni) throws Exception{
        
        Persona p = new Persona();
        ZConexion con = new ZConexion();

        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement(Main.st("cpdni"));
        sentencia.setString(1, dni);
        ResultSet rs;
        rs = sentencia.executeQuery();
       
        if(rs.next()){
            p.setDni(rs.getString(1));
            p.setNombre(rs.getString(2));
            p.setApellidos(rs.getString(3));
            p.setDireccion(rs.getString(4));
            p.setTelefono(rs.getString(5));
            p.setEdad(Integer.parseInt(rs.getString(6)));
            p.setCifEmpresa(rs.getString(7));
            
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        return p;
    }
    
    public void añadir(Persona p) throws Exception{
        ZConexion con = new ZConexion();
        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement(Main.st("apersona"));
        
        sentencia.setString(1, p.getDni());
        sentencia.setString(2, p.getNombre());
        sentencia.setString(3, p.getApellidos());
        sentencia.setString(4, p.getDireccion());
        sentencia.setString(5, p.getTelefono());
        sentencia.setInt(6, p.getEdad());
        sentencia.setString(7, p.getCifEmpresa());
        
        sentencia.executeUpdate();

        sentencia.close();
        con.desconectar();
    }
}
