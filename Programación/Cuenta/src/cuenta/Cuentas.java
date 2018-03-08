/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuenta;

import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class Cuentas {
    public Personas titular;
    public float cantidad;

    public Cuentas(Personas Cnombre){
        titular= Cnombre;
        
    }
    
    public Cuentas( Personas Cnombre, float Ccantidad){
        titular = Cnombre;
        cantidad=Ccantidad;        
    }
  
    public void Obtener(){
        String mayor = "";
        if(titular.getEdad()>=18){
            mayor = "mayor de edad";
        }
        else{
            mayor = "menor de edad";
        }
        JOptionPane.showMessageDialog(null, "El titular " + titular.getNombre() + ", " +titular.getApellidos() + "\ntiene el color del pelo " + titular.getColor_Pelo()
            + ", con los ojos " + titular.getColor_Ojo() + ", mide " + titular.getAltura() + ", pesa " + titular.getPeso() + " y es " + mayor + "\ntiene en su cuenta " + cantidad);
    }

    public void Ingresar(){
        float Icantidad = Float.parseFloat(JOptionPane.showInputDialog("¿Qué cantidad quieres ingresar?\nCuenta de " + titular.getNombre()));
        if(Icantidad>0){
            cantidad = cantidad + Icantidad;
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente.");
        }
        else{
            JOptionPane.showMessageDialog(null, "El valor introducido no es válido, no se ha realizado la operación.");
        }
        Obtener();
    }
    
    public void Extraer(){
        float Eextraer = Float.parseFloat(JOptionPane.showInputDialog("¿Qué cantidad quieres extraer?\nCuenta de " + titular.getNombre()));
        if(Eextraer >= cantidad){
            JOptionPane.showMessageDialog(null, "Se ha extraido " + cantidad);
            cantidad=0;
        }
        else{
            JOptionPane.showMessageDialog(null, "Se ha extraido " + Eextraer);
            cantidad = cantidad - Eextraer;
        }
        Obtener();
    }
    
    public float TransferenciaO(Personas Ttitulard){
        float Ttransferencia = Float.parseFloat(JOptionPane.showInputDialog("¿Qué cantidad quieres transferir?\ncuenta de "+ titular.getNombre() + " a la cuenta de " + Ttitulard.getNombre()));
        if(Ttransferencia >= cantidad){
            JOptionPane.showMessageDialog(null, "Excede de lo que tiene en su cuenta.");
        return 0;
        }
        else{
            cantidad = cantidad - Ttransferencia;
        return Ttransferencia;
        }
        
    }
    public void TransferenciaD(float destino){
        if(destino == 0){
            Obtener();
        }
        else{
            cantidad = cantidad + destino;
            JOptionPane.showMessageDialog(null, "Transferencia realizada correctamente.\nOrigen descontado: "+destino + " nuevo total destino: " + titular.getNombre() + ", " + cantidad);
        }
    }

    public Personas getTitular() {
        return titular;
    }

    public void setTitular(Personas titular) {
        this.titular = titular;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }
    
}
