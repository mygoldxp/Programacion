/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UBD;

import Controladora.Main;
import UML.Casos;
import UML.Abogados;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author v6222
 */
public class Llevar implements Serializable{
    
    public Llevar(EntityManagerFactory emf) {
        this.emf = emf;
        
    }
    
    private EntityManagerFactory emf = null;
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    public void annadirAbogado(Abogados abogado, Casos caso) {
        EntityManager em = getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            
            String query = "INSERT INTO abogado_lleva_casos ( Abogado_dni, Caso_expediente) VALUES ( ?,?)";
            et.begin();
            em.createNativeQuery(query)
            .setParameter(1, abogado.getDni())
            .setParameter(2, caso.getNumExp())
            .executeUpdate();
            et.commit();
        }
        catch (javax.persistence.PersistenceException ex) {
            JOptionPane.showMessageDialog(null, "El Abogado ya está en el caso.");
         
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getClass());
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    
    public void quitarAbogado(Abogados abogado, Casos caso){
        EntityManager em = getEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            
            String query = "delete FROM abogado_lleva_casos where Caso_expediente = ? and Abogado_dni = ?";
            et.begin();
            em.createNativeQuery(query)
            .setParameter(2, abogado.getDni())
            .setParameter(1, caso.getNumExp())
            .executeUpdate();
            et.commit();
            
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public ArrayList<Abogados> buscarListaAbogados(Casos caso) throws Exception {

        EntityManager em = getEntityManager();
        ArrayList <Abogados> listaAbo = new ArrayList(); 
        try {
            Query q = em.createNativeQuery("SELECT a.Abogado_dni FROM abogado_lleva_casos a WHERE a.Caso_expediente = ?");
            q.setParameter(1, caso.getNumExp());

            List <String> results = q.getResultList();
            
            for(int x = 0; x< results.size(); x++){                
                listaAbo.add(Main.consultarAbogado(results.get(x)));
            }
            
            return listaAbo;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    // EMPLEAR JOIN PARA JUNTAS 2 TABLAS Y NO CONSULTAR POR ABOGADOSLLEVACASOS

}
