/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBD;

import Controladora.Main;
import UML.Empresa;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Jon
 */
public class EmpresaBBDD {
    
    public Empresa consultar(String cif) throws Exception{
        
        Empresa em = new Empresa();
        ZConexion con = new ZConexion();

        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement(Main.st("cempresa"));
        sentencia.setString(1, cif);
        ResultSet rs;
        rs = sentencia.executeQuery();
       
        if(rs.next()){
            em.setCif(rs.getString(1));
            em.setNombre(rs.getString(2));
            em.setDireccion(rs.getString(3));
            em.setTelefono(rs.getString(4));
        }
        rs.close();
        sentencia.close();
        con.desconectar();
        return em;
    }
    
    public void añadir(Empresa em) throws Exception{
        ZConexion con = new ZConexion();        
        PreparedStatement sentencia;
        sentencia = con.getConnection().prepareStatement(Main.st("aempresa"));
        
        sentencia.setString(1, em.getCif());
        sentencia.setString(2, em.getNombre());
        sentencia.setString(3, em.getDireccion());
        sentencia.setString(4, em.getTelefono());
        
        sentencia.executeUpdate();

        sentencia.close();
        con.desconectar();
    }
}
