/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abogados;

import javax.persistence.Persistence;
import UBD.*;

/**
 *
 * @author v6222
 */
public class Abogados {

    /**
     * @param args the command line arguments
     */
    
    public static AbogadosJpaController abogadoBD;
    public static CasosJpaController casoBD;
    public static ClientesJpaController clienteBD;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        abogadoBD = new AbogadosJpaController(Persistence.createEntityManagerFactory("AbogadosPU"));
        casoBD = new CasosJpaController(Persistence.createEntityManagerFactory("AbogadosPU"));
        clienteBD = new ClientesJpaController(Persistence.createEntityManagerFactory("AbogadosPU"));
        
                
    }
    
}
