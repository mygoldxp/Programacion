/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author v6222
 */
public class Empleado{
    int cod;
    String dni, nss, nombre, direccion, telefono;
    Date fechae, fechas;
    boolean sexo, civil;
    Contrato contrato;
    Departamento departamento;
    ArrayList <Nomina> listadoNomina;
    public Empleado() {
    }

    public Empleado(int cod, String dni, String nss, String nombre, String direccion, String telefono, boolean sexo, boolean civil, Date fechae) {
        this.cod = cod;
        this.dni = dni;
        this.nss = nss;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechae = fechae;
        this.sexo = sexo;
        this.civil = civil;
        listadoNomina = new ArrayList();
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechae() {
        return fechae;
    }

    public void setFechae(Date fechae) {
        this.fechae = fechae;
    }
    
    public Date getFechas() {
        return fechas;
    }

    public void setFechas(Date fechas) {
        this.fechas = fechas;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public boolean isCivil() {
        return civil;
    }

    public void setCivil(boolean civil) {
        this.civil = civil;
    }  

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public ArrayList<Nomina> getListadoNomina() {
        return listadoNomina;
    }

    public void setListadoNomina(Nomina nomina) {
        listadoNomina.add(nomina);
    }

    public String estadoCivil(){
        String eCivil;
        if(this.civil = true){
            eCivil="Casado";
        }
        else{
            eCivil = "Soltero";
        }
        return eCivil;
    }
    
    public String estadoVaron(){
        String eSexo;
        if(this.sexo = true){
            eSexo ="Hombre";
        }
        else{
            eSexo = "Mujer";
        }
        return eSexo;
    }
    
    public String tipoEmpleado() {
         return cod + ", DNI " + dni + ", NSS " + nss + ", Nombre " + nombre + ", Direccion " + direccion + ", Telefono " + telefono + ", Fecha Alta " + fechae + ", Fecha Baja " + fechas + ", Género " + estadoVaron() + ", Estado Civil " + estadoCivil() + ", Tipo de Contrato " + contrato.getContrato() + ", Cargo " + departamento.getNombre()+"-"+departamento.getNombre() ;
    }
    
    public String tipoContrato() {
        return cod + ", DNI " + dni + ", NSS " + nss + ", Nombre " + nombre + ", Direccion " + direccion + ", Telefono " + telefono + ", Fecha Alta " + fechae + ", Fecha Baja " + fechas + ", Género " + estadoVaron() + ", Estado Civil " + estadoCivil() + ", Cargo " + departamento.getNombre()+"-"+departamento.getNombre();
    }
    
    public String tipoDepartamento() {
        return cod + ", DNI " + dni + ", NSS " + nss + ", Nombre " + nombre + ", Direccion " + direccion + ", Telefono " + telefono + ", Fecha Alta " + fechae + ", Fecha Baja " + fechas + ", Género " + estadoVaron() + ", Estado Civil " + estadoCivil() + ", Tipo de Contrato " + contrato.getContrato();
    }

    public void eliminarNomina(Nomina nomina){
        this.listadoNomina.remove(nomina);
    }
}
