/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBD;

import Controladora.Main;
import UML.Empresa;
import UML.Persona;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jon
 */
public class PersonaBBDD {
    
    public boolean consultar(String dni) throws Exception{
        boolean cont = false;
        Persona p = new Persona();
        Empresa e = new Empresa();
        ZConexion con = new ZConexion();

        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("SELECT * FROM persona where DNI = ?");
        sentencia.setString(1, dni);
        ResultSet rs;
        rs = sentencia.executeQuery();
       
        if(rs.next()){
            p.setDni(rs.getString("DNI"));
            p.setNombre(rs.getString("Nombre"));
            p.setApellidos(rs.getString("Apellidos"));
            p.setDireccion(rs.getString("Direccion"));
            p.setTelefono(rs.getString("Telefono"));
            p.setEdad(rs.getInt("Edad"));
            
            e = Main.consultarEmpresa(rs.getString("CIF"));
            
            cont = true;
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        
        Main.em = e;
        Main.p = p;
        return cont;
    }
    
    public void añadir(Persona p) throws Exception{
        ZConexion con = new ZConexion();
        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement("INSERT INTO persona VALUES ( ?, ?, ?, ?, ?, ?, ?)");
        
        sentencia.setString(1, p.getDni());
        sentencia.setString(2, p.getNombre());
        sentencia.setString(3, p.getApellidos());
        sentencia.setString(4, p.getDireccion());
        sentencia.setString(5, p.getTelefono());
        sentencia.setInt(6, p.getEdad());
        sentencia.setString(7, p.getEmpresa().getCif());
        
        sentencia.executeUpdate();

        sentencia.close();
        con.desconectar();
    }
}
