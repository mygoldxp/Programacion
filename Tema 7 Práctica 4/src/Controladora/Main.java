/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladora;

import GUI.Acceso;
import GUI.Principal;
import GUI.dEmpleado;
import GUI.dInforme;
import GUI.dNomina;
import UML.Departamento;
import UML.Contrato;
import UML.Empleado;
import UML.Nomina;
import UML.Usuario;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author Jon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    static int cod, codNomina;
    static Usuario[] listaUsuario;
    static Contrato[] listadoContrato;
    static Departamento[] listadoDepartamento;
    static ArrayList <Empleado> listadoEmpleado;
    public static Empleado empleado;
    static Nomina nomina;
    
    private static final double contingenciasComunes, eContingenciasComunes, desempleo, eDesempleo, fp, eFP, 
            horasExtras, eHorasExtras, extraFuerza, eExtraFuerza,atep, fogasa, irpf;
    
    public static void main(String[] args) {
        // TODO code application logic here
        generarDatos();
        Acceso acceso = new Acceso();
        acceso.setVisible(true);
    }
    
    public static void asignarEmpleado(JTextField empleado){
        if(listadoEmpleado.isEmpty()){
            cod = 1;
        }
        else
        {
            cod=0;
            listadoEmpleado.stream().filter((e) -> (e.getCod()>=cod)).forEachOrdered((e) -> {
                cod = e.getCod()+1;
            });
        }
        
        empleado.setText(String.valueOf(cod));
    }
    
    public static void generarDatos(){
        codNomina = 1;
           
        listadoContrato = new Contrato[2];
        listadoDepartamento = new Departamento[6];
        
        Contrato indefinido = new Contrato(1, "Indefinido", 800.00);
        Contrato temporal = new Contrato(2, "Temporal", 700.00);
        
        listadoContrato[0] = indefinido;
        listadoContrato[1] = temporal;
        
        Departamento programador = new Departamento(1, "Programación", 500.00);
        Departamento arquitecto = new Departamento(3, "Arquitectura", 600.00);
        Departamento jefeEquipo = new Departamento(5, "Coordinador", 750.00);
        Departamento directivo = new Departamento(6, "Dirección", 850.00);
        
        listadoDepartamento[0] = programador;
        listadoDepartamento[1] = arquitecto;
        listadoDepartamento[2] = jefeEquipo;
        listadoDepartamento[3] = directivo;
        
        listadoEmpleado = new ArrayList();
        
        //datos de muestra
        org.freixas.jcalendar.JCalendarCombo calendario = new org.freixas.jcalendar.JCalendarCombo();
        Empleado nuevoEmpleado = new Empleado(1,"11111111-A","88-88888888-88","Jon","Plas 15 5c","999999999",true, true,calendario.getDate() );
        nuevoEmpleado.setContrato(listadoContrato[1]);
        nuevoEmpleado.setDepartamento(listadoDepartamento[0]);
        listadoEmpleado.add(nuevoEmpleado);

        listaUsuario = new Usuario[2];
        listaUsuario[0]= new Usuario("Jon","111".toCharArray());
        listaUsuario[1]= new Usuario("Juan","222".toCharArray());
    }
    
    public static void jCombos(JComboBox departamento, JComboBox cContrato){
        for (Departamento listadoCargo1 : listadoDepartamento) {
            departamento.addItem(listadoCargo1.getNombre());
        }
        for (Contrato listadoContrato1 : listadoContrato) {
            cContrato.addItem(listadoContrato1.getContrato());
        }
    }
    
    public static boolean autenticar(JTextField usuario, JPasswordField contraseña){
        boolean existe = false;
        for(int x = 0; x<listaUsuario.length; x++){
            if(listaUsuario[x].getUsuario().equals(usuario.getText())){
                if(Arrays.equals(listaUsuario[x].getContraseña(), contraseña.getPassword())){
                    existe = true;
                }
                x = listaUsuario.length;
            }
        }
        return existe;
    }
    
    public static void acceder(JFrame ventana, JTextField usuario){
        ventana.dispose();
        Principal principal = new Principal(usuario.getText());
        principal.setVisible(true);
    }
    
    public static void ventana(int n, String titulo){
        switch(n){
            case 1:
                new dEmpleado(titulo);
                break;
                
            case 2:
                new dNomina(titulo);
                break;
                
            case 3:
                new dInforme(titulo);
                break;
        }
    }
    
    public static Empleado localizar(String codEmpleado){
        empleado = null;
        for(int x=0; x<listadoEmpleado.size(); x++){
            try{
                if(listadoEmpleado.get(x).getCod()== Integer.parseInt(codEmpleado)){
                empleado = listadoEmpleado.get(x);
                x = listadoEmpleado.size();
                }
            }
            catch(NumberFormatException e){
                if(listadoEmpleado.get(x).getDni().equals(codEmpleado)){
                empleado = listadoEmpleado.get(x);
                x = listadoEmpleado.size();
                }
            }
        }
        return empleado;
    }
    
    public static Nomina localizarNomina(int codNomina){
        nomina = null;
        for(int x=0; x<listadoEmpleado.size(); x++){
            Empleado emplea = listadoEmpleado.get(x);
            for(int y =0; y< emplea.getListadoNomina().size(); y++){
                Nomina nom = emplea.getListadoNomina().get(y);
                if(nom.getCod() == codNomina){
                    nomina = nom;
                    empleado = emplea;
                    y = emplea.getListadoNomina().size();
                    x = listadoEmpleado.size();
                }
            }
        }
        return nomina;
    }
    
    public static boolean comprobar(String dni, String nss){
        boolean estado = false;
        for(int x =0; x<listadoEmpleado.size();x++){
            if(listadoEmpleado.get(x).getDni().equals(dni) || listadoEmpleado.get(x).getNss().equals(nss)){
                estado = true;
                x = listadoEmpleado.size();
            }
            else{
                estado = false;
            }
        }
        return estado;
    }
    
    public static void agregar(String dni, String nss, String nombre, String direccion, String telefono, boolean sexo, boolean civil, Date fechas, Date fechae, String contrato, String cargo, String foto){
        try{
            Empleado nuevoEmpleado = new Empleado(cod,dni,nss,nombre,direccion,telefono,sexo, civil, fechae);
            //fechas, String foto, String contrato, String cargo
            for(int x=0; x<listadoContrato.length; x++){
                if(listadoContrato[x].getContrato().equals(contrato)){
                    if(listadoContrato[x].getContrato().equals("Temporal")){
                        nuevoEmpleado.setFechas(fechas);
                    }
                    nuevoEmpleado.setContrato(listadoContrato[x]);
                    x = listadoContrato.length;
                }
            }

            for(int x =0; x<listadoDepartamento.length; x++){
                String dato = listadoDepartamento[x].getNombre();
                if(dato.equals(cargo)){
                    nuevoEmpleado.setDepartamento(listadoDepartamento[x]);
                    x = listadoDepartamento.length;
                }
            }

            if(!foto.isEmpty()){
                Path FROM = Paths.get(foto);
                Path TO = Paths.get("src/FotosEmpleados/" + cod + ".jpg");
                CopyOption[] options = new CopyOption[]{
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES
                };
                try {
                    Files.copy(FROM, TO, options);
                } 
                catch (IOException error) {
                    JOptionPane.showMessageDialog(null, error.getClass());
                }
            }

            listadoEmpleado.add(nuevoEmpleado);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getClass());
        }
    }
    
    public static void modificar(String nss, String nombre, String direccion, String telefono, boolean sexo, boolean civil, Date fechas, Date fechae, int cod, String contrato, String cargo, String foto){
        try{
            empleado.setNss(nss);
            empleado.setNombre(nombre);
            empleado.setDireccion(direccion);
            empleado.setTelefono(telefono);
            empleado.setSexo(sexo);
            empleado.setCivil(civil);

            for(int x=0; x<listadoContrato.length; x++){
                if(listadoContrato[x].getContrato().equals(contrato)){
                    if(listadoContrato[x].getContrato().equals("Temporal")){
                        empleado.setFechas(fechas);
                    }
                    empleado.setContrato(listadoContrato[x]);
                    x = listadoContrato.length;
                }
            }

            for(int x =0; x<listadoDepartamento.length; x++){
                String dato = listadoDepartamento[x].getNombre();
                if(dato.equals(cargo)){
                    empleado.setDepartamento(listadoDepartamento[x]);
                    x = listadoDepartamento.length;
                }
            }
            if(!foto.isEmpty()){
                Path FROM = Paths.get(foto);
                Path TO = Paths.get("src/FotosEmpleados/" + cod + ".jpg");
                CopyOption[] options = new CopyOption[]{
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES
                };
                try {
                    Files.copy(FROM, TO, options);
                } 
                catch (IOException error) {
                    JOptionPane.showMessageDialog(null, error.getClass());
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getClass());
        }
    }
    
    public static boolean eliminar(String dni){
        boolean estado = false;
        for(int x=0;x<listadoEmpleado.size() ;x++){
            if(listadoEmpleado.get(x).equals(empleado)){
                listadoEmpleado.remove(x);
                new File("src/FotosEmpleados/" + empleado.getCod() + ".jpg").delete();
                x = listadoEmpleado.size();
                estado = true;
            }
        }
        return estado;
    }
    
    public static String informe(String titulo){
        String dato="";
        switch (titulo){
            case "Listado por Número de Empleado":
                dato = listaEmpleados();
                break;
            
            case "Listado por Contrato":
                dato = listaContratos();
                break;
                
            case "Listado por Departamento":
                dato = listaDepartamentos();
                break;
                
            case "Listado Nominas":
                dato = listadoNominas();
                break;
        }
        return dato;
    }
    
    public static String listaEmpleados(){
        String dato="Listado ordenados por Código de Empleado:\n";
        int lista[] = new int[listadoEmpleado.size()];
        for(int x=0; x<lista.length;x++){
            lista[x] = listadoEmpleado.get(x).getCod();
        }
        Arrays.sort(lista);
        for(int x=0;x<lista.length;x++){
            for(Empleado e:listadoEmpleado){
                if(lista[x] == e.getCod()){
                    dato += e.tipoEmpleado() + "\n";
                }
            }
        }
        return dato;
    }
    
    public static String listaContratos(){
        String dato;
        String indefinido ="", temporal ="";
        for(Empleado e : listadoEmpleado){
            if(e.getContrato().getContrato().equals("Indefinido")){
                indefinido += e.tipoContrato()+"\n";
            }
            else{
                temporal += e.tipoContrato()+"\n";
            }
        }
        dato = "Contratos Indefinidos:\n" + indefinido + "\nContratos Temporales:\n" + temporal;
        return dato;
    }
    
    public static String listaDepartamentos(){
        String dato ="Listado por Departamentos:\n";
        for (Departamento lista : listadoDepartamento) {
            String datoDepart = lista.getNombre() +"-"+ lista.getNombre()+ ":\n";
            for (Empleado e : listadoEmpleado) {
                if (e.getDepartamento().getCod() == lista.getCod()) {
                    datoDepart += e.tipoDepartamento()+ "\n";
                }
            }
            if(!datoDepart.equals(lista.getNombre() +"-"+ lista.getNombre()+ ":\n")){
                dato += datoDepart;
            }
        }
        return dato;
    }
    
    public static Nomina calcNomina(String t, int n, double base, double extra, double forzosa, double incentivo, double cuotaExtra, double cuotaForzosa, int mes, int dia){
        try{    
            nomina = null;
            if(t.equals("Confeccionar Nómina"))
            {
                nomina = new Nomina(codNomina, empleado.getContrato(), base, extra, forzosa, incentivo, cuotaExtra, cuotaForzosa, mes, dia);
            }
            else{
                nomina = new Nomina(n, empleado.getContrato(), base, extra, forzosa, incentivo, cuotaExtra, cuotaForzosa, mes, dia);
            }
            nomina.calcNomina();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        return nomina;
    }
    
    public static void agregarNomina(int n){
        try{
            if(n == 0){
                codNomina++;
            }            
            empleado.setListadoNomina(nomina);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getClass());
        }
    }
    
    public static void eliminarNomina(Nomina nomina){
        empleado.getListadoNomina().remove(nomina);
    }
    
    public static String listadoNominas(){
        String dato ="Listado de Nóminas por Número de Empleado:\n";
        int lista[] = new int[listadoEmpleado.size()];
        for(int x=0; x<lista.length;x++){
            lista[x] = listadoEmpleado.get(x).getCod();
        }
        Arrays.sort(lista);
        for(int x=0;x<lista.length;x++){
            for(Empleado e:listadoEmpleado){
                if(lista[x] == e.getCod()){
                    dato += e.getCod() + ", "+ e.getNombre() + ", DNI " + e.getDni() + ": " + "\n";
                    for(Nomina n : e.getListadoNomina()){
                        dato += n.datoBasicoNomina();
                    }
                }
            }
        }
        return dato;
    }
    
    public static void reabrir(int n, String titulo, JDialog dialogo){
        dialogo.dispose();
        JOptionPane.showMessageDialog(null, "Operación realizada Correctamente.");
        ventana(n , titulo);
    }
    public static void cerrar(JDialog dialogo){
        dialogo.dispose();
    }
    
    public static void salir(JFrame ventana){
        ventana.dispose();
        System.exit(0);
    }
}
