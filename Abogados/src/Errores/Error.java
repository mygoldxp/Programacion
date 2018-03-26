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
            
            case 5: dato = "El Campo en Rojo es Obligatorio y tiene un formato: N, Es Obligatorio escriber una letra en mayúscula.";
                break;
                
            case 6: dato = "El cliente no existe.";
                break;
                
            case 7: dato = "El Abogado no existe.";
                break;
               
            case 8: dato = "El abogado no está en esta lista.";
                break;
            
            case 9: dato = "La fecha Inicial no puede ser anterior a la fecha Final";
                break;
                
            case 10: dato = "El caso NO EXISTE, búsque en el Listado de Casos para introducir uno existente.";
                break;
                
            case 11: dato = "No Hay datos.";
                break;
                
            case 12: dato = "El Abogado NO EXISTE, búsque en el Listado de Abogados para introducir uno existente.";
                break;
                
            case 13: dato = "El Caso no existe.";
                break;
                
            case 14: dato = "El abogado no está en esta lista.";
                break;
            
        }
        
        return dato;
    }
}
