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
public class ZConexionBBDD {
    String usuario = Main.usuario;
    String contraseña = Main.contraseña;
    String url = Main.url;
    
    Connection connection;
 
    /** Constructor de DbConnection
     * @throws java.lang.Exception */
    public ZConexionBBDD() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
		connection = DriverManager.getConnection(url, usuario, contraseña);
                
		} catch (SQLException e) {
                    if(JOptionPane.showConfirmDialog(null, "Ha habido un fallo con la conexión.\n¿Desea Reintentar?", "Error conexión",2 , 1) == 0){
                        new ZConexionBBDD();
                        Main.comprobarTablas();
                        throw new Exception("Conectado Correctamente");
                    }else{
                        throw new Exception("Usted no está conectado a la BBDD");
                    }
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
