/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBD;

import Controladora.Main;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class ZCABBDD {
    
    public void comprobar() throws Exception{
        
        try {
            ZConexion con;
            con = new ZConexion();
            Statement sentencia;
            sentencia = con.getConnection().createStatement();    
            
            cEmpresa(sentencia);
            cPersona(sentencia);
            cEvento(sentencia);
            cAsistencia(sentencia);
            
            sentencia.close();
            con.desconectar();
            
        } catch (SQLException e) {
            throw new Exception("Ha habido problemas al consultar las tablas existentes.");
        }
        
    }
    
    public void cEvento(Statement sentencia) throws Exception{
        try{
            sentencia.executeQuery(Main.st("tevento"));
        } 
        catch (SQLException e) {
            if(JOptionPane.showConfirmDialog(null, "La tabla EVENTO no existe.\n¿Desea crearla ahora?")==0){
                crEvento(sentencia);
            }
        }
    }
    
    public void cPersona(Statement sentencia) throws Exception{
        
        try{
            sentencia.executeQuery(Main.st("tpersona"));
        } 
        catch (SQLException e) {
            if(JOptionPane.showConfirmDialog(null, "La tabla PERSONA no existe.\n¿Desea crearla ahora?")==0){
                crPersona(sentencia);
            }
        }
        
    }
    
    public void cEmpresa(Statement sentencia) throws Exception{
        
        try{
            sentencia.executeQuery(Main.st("tempresa"));
        } 
        catch (SQLException e) {
            if(JOptionPane.showConfirmDialog(null, "La tabla EMPRESA no existe.\n¿Desea crearla ahora?")==0){
                crEmpresa(sentencia);
            }
        }
        
    }
    
    public void cAsistencia(Statement sentencia) throws Exception{
        
        try{
            sentencia.executeQuery(Main.st("tasistencia"));
        } 
        catch (SQLException e) {
            if(JOptionPane.showConfirmDialog(null, "La tabla ASISTENCIA no existe.\n¿Desea crearla ahora?")==0){
                crAsistencia(sentencia);
            }
        }
        
    }
    
    public void crEvento(Statement sentencia) throws Exception{
        
        try{
            sentencia.executeUpdate(Main.st("crevento"));
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha creado la tabla.");
        }
    }
    
        
    public void crEmpresa(Statement sentencia) throws Exception{
        
        try{
            sentencia.executeUpdate(Main.st("crempresa"));
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha creado la tabla.");
        }
    }
    public void crPersona(Statement sentencia) throws Exception{
        
        try{
            sentencia.executeUpdate(Main.st("crpersona"));
            sentencia.executeUpdate(Main.st("crpersonar"));
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha creado la tabla.");
        }
    }
        
    public void crAsistencia(Statement sentencia) throws Exception{
        
        try{
            sentencia.executeUpdate(Main.st("crasistencia"));
            sentencia.executeUpdate(Main.st("crasistenciar"));
            sentencia.executeUpdate(Main.st("crasistenciarr"));
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha creado la relación.");
        }
    }
    
}
