/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MBD;

import Controladora.Main;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author v6222
 */
public class ZConexion {
    
    String bd = Main.bd;
    String usuario = Main.usuario;
    String contraseña = Main.contraseña;
    String url = Main.url;
    
    Connection connection;
 
    /** Constructor de DbConnection
     * @throws java.lang.Exception */
    public ZConexion() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
		connection = DriverManager.getConnection(url+bd, usuario, contraseña);
                
		} catch (SQLException e) {
                    if(JOptionPane.showConfirmDialog(null, "Falta la BBDD.\n¿Desea crearla?", "Error BBDD",2 , 1) == 0){
                        crearBBDD();
                        Main.comprobarTablas();
                        throw new Exception("BBDD Creado Correctamente");
                    }else{
                        throw new Exception("Usted no está conectado a la BBDD");
                    }
		}
        } catch (ClassNotFoundException e) {
            throw new Exception("Ha habido un fallo con la conexión a la BBDD");
	}
   }
  
    public void crearBBDD() throws Exception{
        try {
            try {
		Connection con;
                con = DriverManager.getConnection(url, usuario, contraseña);
                Statement sentencia;
                sentencia = con.createStatement();
                sentencia.executeUpdate(Main.st("creartabla"));
                sentencia.close();
                con.close();
		} catch (SQLException e) {
                    throw new Exception("Ha habido un fallo con la creación de la BBDD");
		}
        } catch (ClassNotFoundException e) {
            throw new Exception("Ha habido un fallo con la conexión a la BBDD");
	}
    }
    
   public Connection getConnection(){
      return connection;
   }
 
   public void desconectar() throws Exception{
        connection.close();
   }
    
}
