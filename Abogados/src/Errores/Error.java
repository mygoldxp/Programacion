/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

/**
 *
 * @author v6222
 */
public class Error extends Exception{
    int cod;

    public Error() {
    }

    public Error(int cod) {
        this.cod = cod;
    }
    
    @Override
    public String getMessage(){
        
        String dato = "";
        switch(cod){
            case 1: dato = "El Campo en Rojo es Obligatorio y tiene un formato: Alfanumérico, Ejemplo: 00000000-A";
                break;
            
            case 2: dato = "El Campo en Rojo es Obligatorio y tiene un formato: Letras(N): Nnn ";
                break;
            
            case 3: dato = "El Campo en Rojo es Obligatorio y tiene un formato: Alfanumérico, Ejemplo: Plaza De España 1 5b";
                break;
            
            case 4: dato = "El Campo en Rojo es Obligatorio y tiene un formato: Numérico[N]: NNNNNNNNN";
                break;
            
            case 6: dato = "El Campo en Rojo es Obligatorio y tiene un formato: Es Obligatorio seleccionar un tipo de Contrato";
                break;
                
            case 7: dato = "El Campo en Rojo es Obligatorio y tiene un formato: Es Obligatorio seleccionar un tipo de Departamento";
                break;
                
            case 8: dato = "El Campo en Rojo es Obligatorio y tiene un formato: La fecha no puede ser Inferior a la actual";
                break;
               
            case 9: dato = "El Empleado YA EXISTE, DNI o NSS repetido.";
                break;
            
            case 10: dato = "El empleado NO EXISTE o NO SE HA CARGADO SUS DATOS.";
                break;
                
            case 11: dato = "El empleado NO EXISTE, búsque en el Listado de Empleados para introducir uno existente.";
                break;
                
            case 12: dato = "La Nómina NO EXISTE, búsque en el Listado de Nóminas para introducir uno existente.";
                break;
        }
        
        return dato;
    }
}
